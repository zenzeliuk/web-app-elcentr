package com.elcentr.service;

import com.elcentr.dao.ProductEnclosureDAO;
import com.elcentr.model.ProductEnclosure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ProductEnclosureService {

    private static final Logger LOG = Logger.getLogger(ProductEnclosureService.class.getName());

    public ProductEnclosure save(ProductEnclosure productEnclosure) {
        ProductEnclosureDAO productEnclosureDAO = new ProductEnclosureDAO();
        if (nonNull(productEnclosure.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        return productEnclosureDAO.save(productEnclosure);
    }

    public ProductEnclosure update(ProductEnclosure productEnclosure) {
        ProductEnclosureDAO productEnclosureDAO = new ProductEnclosureDAO();
        if (isNull(productEnclosure.getId())) {
            throw new RuntimeException("Update is failed!");
        }
        return productEnclosureDAO.update(productEnclosure);
    }

    public ProductEnclosure read(ProductEnclosure productEnclosure) {
        ProductEnclosureDAO productEnclosureDAO = new ProductEnclosureDAO();
        if (isNull(productEnclosure)) {
            throw new RuntimeException("Search is failed!");
        }
        return productEnclosureDAO.findById(productEnclosure.getId());
    }

    public void delete(ProductEnclosure productEnclosure) {
        ProductEnclosureDAO productEnclosureDAO = new ProductEnclosureDAO();
        if (isNull(productEnclosure.getId())) {
            throw new RuntimeException("Delete is failed!");
        }
        productEnclosureDAO.delete(productEnclosure);
    }


    public List<ProductEnclosure> findAllByIdProduct(Integer id) {
        ProductEnclosureDAO productEnclosureDAO = new ProductEnclosureDAO();
        try {
            return productEnclosureDAO.findAllByIdProduct(id);
        } catch (Exception e) {
            LOG.severe(String.format("Any component with code %d was not found", id));
        }
        return new ArrayList<>();
    }

    public Optional<ProductEnclosure> findById(Integer id) {
        ProductEnclosureDAO productEnclosureDAO = new ProductEnclosureDAO();
        try {
            return Optional.of(productEnclosureDAO.findById(id));
        } catch (Exception e) {
            LOG.severe(String.format("Component with id %d was not found", id));
        }
        return Optional.empty();
    }
}
