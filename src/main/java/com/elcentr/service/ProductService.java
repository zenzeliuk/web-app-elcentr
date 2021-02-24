package com.elcentr.service;

import com.elcentr.dao.ProductDAO;
import com.elcentr.model.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ProductService {

    private static final Logger LOG = Logger.getLogger(ProductService.class.getName());

    public Optional<Product> save(Product product) {
        ProductDAO productDAO = new ProductDAO();
        if (nonNull(product.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        if (findAllByCode(product.getCode()).isEmpty()) {
            return Optional.of(productDAO.save(product));
        }
        return Optional.empty();
    }

    public Product update(Product product) {
        ProductDAO productDAO = new ProductDAO();
        if (isNull(product.getId())) {
            throw new RuntimeException("Update is failed!");
        }
        return productDAO.update(product);
    }

    public Product read(Product product) {
        ProductDAO productDAO = new ProductDAO();
        if (isNull(product)) {
            throw new RuntimeException("Search is failed!");
        }
        return productDAO.findById(product.getId());
    }

    public void delete(Product product) {
        ProductDAO productDAO = new ProductDAO();
        if (isNull(product.getId())) {
            throw new RuntimeException("Delete is failed!");
        }
        productDAO.delete(product);
    }

    public List<Product> findAll() {
        try {
            ProductDAO productDAO = new ProductDAO();
            return productDAO.findAll();
        } catch (Exception e) {
            LOG.severe("Any product was not found");
        }
        return new ArrayList<>();
    }

    public List<Product> findAllByCode(String code) {
        ProductDAO productDAO = new ProductDAO();
        try {
            return productDAO.findAllByCode(code);
        } catch (Exception e) {
            LOG.severe(String.format("Any product with code %s was not found", code));
        }
        return new ArrayList<>();
    }

    public String createCodeProduct() {
        return String.valueOf(new Date().getTime());
    }

}


