package com.elcentr.dao;


import com.elcentr.model.ProductEnclosure;
import com.elcentr.model.Enclosure;
import com.elcentr.model.Product;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductEnclosureDAOTest {

    @Test
    void save() {

        ProductDAO productDAO = new ProductDAO();
        Product product = Product.builder()
                .amount(1)
                .code("21021001")
                .name("test-name")
                .timeRegistration(new Date().getTime())
                .build();
        Product savedProduct = productDAO.save(product);
        assertNotNull(savedProduct.getId());

        EnclosureDAO enclosureDAO = new EnclosureDAO();
        Enclosure enclosure = Enclosure.builder()
                .name("test-name")
                .build();
        Enclosure savedEnclosure = enclosureDAO.save(enclosure);
        assertNotNull(savedEnclosure.getId());

        ProductEnclosureDAO productEnclosureDAO = new ProductEnclosureDAO();
        ProductEnclosure productEnclosure = ProductEnclosure.builder()
                .amountEnclosure(1)
                .enclosure(savedEnclosure)
                .product(savedProduct)
                .build();
        ProductEnclosure savedProductEnclosure = productEnclosureDAO.save(productEnclosure);
        assertNotNull(savedProductEnclosure.getId());
    }

    @Test
    void findById() {

        ProductDAO productDAO = new ProductDAO();
        Product product = Product.builder()
                .amount(1)
                .code("21021001")
                .name("test-name")
                .timeRegistration(new Date().getTime())
                .build();
        Product savedProduct = productDAO.save(product);
        assertNotNull(savedProduct.getId());

        EnclosureDAO enclosureDAO = new EnclosureDAO();
        Enclosure enclosure = Enclosure.builder()
                .name("test-name")
                .build();
        Enclosure savedEnclosure = enclosureDAO.save(enclosure);
        assertNotNull(savedEnclosure.getId());

        ProductEnclosureDAO productEnclosureDAO = new ProductEnclosureDAO();
        ProductEnclosure productEnclosure = ProductEnclosure.builder()
                .amountEnclosure(1)
                .enclosure(savedEnclosure)
                .product(savedProduct)
                .build();
        ProductEnclosure savedProductEnclosure = productEnclosureDAO.save(productEnclosure);
        assertNotNull(savedProductEnclosure.getId());

        ProductEnclosure foundProductEnclosure = productEnclosureDAO.findById(savedProductEnclosure.getId());
        assertNotNull(foundProductEnclosure);
    }

    @Test
    void delete() {

        ProductDAO productDAO = new ProductDAO();
        Product product = Product.builder()
                .amount(1)
                .code("21021001")
                .name("test-name")
                .timeRegistration(new Date().getTime())
                .build();
        Product savedProduct = productDAO.save(product);
        assertNotNull(savedProduct.getId());

        EnclosureDAO enclosureDAO = new EnclosureDAO();
        Enclosure enclosure = Enclosure.builder()
                .name("test-name")
                .build();
        Enclosure savedEnclosure = enclosureDAO.save(enclosure);
        assertNotNull(savedEnclosure.getId());

        ProductEnclosureDAO productEnclosureDAO = new ProductEnclosureDAO();
        ProductEnclosure productEnclosure = ProductEnclosure.builder()
                .amountEnclosure(1)
                .enclosure(savedEnclosure)
                .product(savedProduct)
                .build();
        ProductEnclosure savedProductEnclosure = productEnclosureDAO.save(productEnclosure);
        assertNotNull(savedProductEnclosure.getId());

        productEnclosureDAO.delete(savedProductEnclosure);
        ProductEnclosure afterDelete = productEnclosureDAO.findById(savedProductEnclosure.getId());
        assertNull(afterDelete);
    }

    @Test
    void update() {

        ProductDAO productDAO = new ProductDAO();
        Product product = Product.builder()
                .amount(1)
                .code("21021001")
                .name("test-name")
                .timeRegistration(new Date().getTime())
                .build();
        Product savedProduct = productDAO.save(product);
        assertNotNull(savedProduct.getId());

        EnclosureDAO enclosureDAO = new EnclosureDAO();
        Enclosure enclosure = Enclosure.builder()
                .name("test-name")
                .build();
        Enclosure savedEnclosure = enclosureDAO.save(enclosure);
        assertNotNull(savedEnclosure.getId());

        ProductEnclosureDAO productEnclosureDAO = new ProductEnclosureDAO();
        ProductEnclosure productEnclosure = ProductEnclosure.builder()
                .amountEnclosure(1)
                .enclosure(savedEnclosure)
                .product(savedProduct)
                .build();
        ProductEnclosure savedProductEnclosure = productEnclosureDAO.save(productEnclosure);
        assertNotNull(savedProductEnclosure.getId());


        Enclosure enclosure2 = Enclosure.builder()
                .name("test-name")
                .build();
        Enclosure savedEnclosure2 = enclosureDAO.save(enclosure2);
        assertNotNull(savedEnclosure2.getId());

        Integer idEnclosureBeforeUpdate = savedProductEnclosure.getEnclosure().getId();

        savedProductEnclosure.setEnclosure(savedEnclosure2);
        productEnclosureDAO.update(savedProductEnclosure);

        Integer idEnclosureAfterUpdate = savedProductEnclosure.getEnclosure().getId();

        assertFalse(idEnclosureBeforeUpdate.equals(idEnclosureAfterUpdate));
        assertFalse(savedProductEnclosure.getEnclosure().getId().equals(savedEnclosure.getId()));

    }

    @Test
    void findAllProductWhereEnclosureIs() {
        ProductDAO productDAO = new ProductDAO();
        Product product = Product.builder()
                .amount(1)
                .code("0236")
                .name("test-name")
                .timeRegistration(new Date().getTime())
                .build();
        Product savedProduct = productDAO.save(product);
        assertNotNull(savedProduct.getId());

        EnclosureDAO enclosureDAO = new EnclosureDAO();
        Enclosure enclosure = Enclosure.builder()
                .name("test-test")
                .build();
        Enclosure savedEnclosure = enclosureDAO.save(enclosure);
        assertNotNull(savedEnclosure.getId());

        ProductEnclosureDAO productEnclosureDAO = new ProductEnclosureDAO();
        ProductEnclosure productEnclosure = ProductEnclosure.builder()
                .amountEnclosure(1)
                .enclosure(savedEnclosure)
                .product(savedProduct)
                .build();
        ProductEnclosure savedProductEnclosure = productEnclosureDAO.save(productEnclosure);
        assertNotNull(savedProductEnclosure.getId());

        List<ProductEnclosure> result = productEnclosureDAO.findAllProductWhereEnclosureIs(enclosure);
        assertNotNull(result);
        assertFalse(result.isEmpty());

    }

}