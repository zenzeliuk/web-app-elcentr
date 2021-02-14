package com.elcentr.dao;

import com.elcentr.model.Product;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ProductDAOTest {
    @Test
    void save() {
        Product product = Product.builder()
                .amount(1)
                .code("21021001")
                .name("test-name")
                .timeRegistration(new Date().getTime())
                .build();
        Product savedProduct = new ProductDAO().save(product);
        assertNotNull(savedProduct);
    }

    @Test
    void findById() {
        Product product = Product.builder()
                .amount(1)
                .code("21021001")
                .name("test-name")
                .timeRegistration(new Date().getTime())
                .build();
        ProductDAO productDAO = new ProductDAO();
        Product savedProduct = productDAO.save(product);
        assertNotNull(savedProduct.getId());

        Product foundProduct = productDAO.findById(savedProduct.getId());
        assertNotNull(foundProduct);
    }

    @Test
    void delete() {
        Product product = Product.builder()
                .amount(1)
                .code("21021001")
                .name("test-name")
                .timeRegistration(new Date().getTime())
                .build();
        ProductDAO productDAO = new ProductDAO();
        Product savedProduct = productDAO.save(product);
        assertNotNull(savedProduct.getId());

        productDAO.delete(savedProduct);
        Product afterDelete = productDAO.findById(savedProduct.getId());
        assertNull(afterDelete);
    }

    @Test
    void update() {
        Product product = Product.builder()
                .amount(1)
                .code("21021001")
                .name("test-name")
                .timeRegistration(new Date().getTime())
                .build();
        ProductDAO productDAO = new ProductDAO();
        Product savedProduct = productDAO.save(product);
        assertNotNull(savedProduct.getId());
        String nameBeforeUpdate = savedProduct.getName();

        savedProduct.setName("new-test-name");
        productDAO.update(savedProduct);
        String nameAfterUpdate = savedProduct.getName();

        assertFalse(nameBeforeUpdate.equals(nameAfterUpdate));
    }

}