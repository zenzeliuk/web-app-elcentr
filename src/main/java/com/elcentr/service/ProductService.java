package com.elcentr.service;

import com.elcentr.dao.ProductDAO;
import com.elcentr.model.Product;
import lombok.RequiredArgsConstructor;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@RequiredArgsConstructor
public class ProductService {

    private final ProductDAO productDAO;

    public Product save(Product product) {
        if (nonNull(product.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        return productDAO.save(product);
    }

    public Product update(Product product) {
        if (isNull(product.getId())) {
            throw new RuntimeException("Update is failed!");
        }
        return productDAO.update(product);
    }

    public Product read(Product product) {
        if (isNull(product)) {
            throw new RuntimeException("Search is failed!");
        }
        return productDAO.findById(product.getId());
    }

    public void delete(Product product) {
        if (isNull(product.getId())) {
            throw new RuntimeException("Delete is failed!");
        }
        productDAO.delete(product);
    }

}
