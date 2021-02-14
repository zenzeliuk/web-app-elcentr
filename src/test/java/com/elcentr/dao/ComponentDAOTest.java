package com.elcentr.dao;


import com.elcentr.model.Component;
import com.elcentr.model.Enclosure;
import com.elcentr.model.Product;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComponentDAOTest {

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

        ComponentDAO componentDAO = new ComponentDAO();
        Component component = Component.builder()
                .amountEnclosure(1)
                .enclosure(savedEnclosure)
                .product(savedProduct)
                .build();
        Component savedComponent = componentDAO.save(component);
        assertNotNull(savedComponent.getId());
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

        ComponentDAO componentDAO = new ComponentDAO();
        Component component = Component.builder()
                .amountEnclosure(1)
                .enclosure(savedEnclosure)
                .product(savedProduct)
                .build();
        Component savedComponent = componentDAO.save(component);
        assertNotNull(savedComponent.getId());

        Component foundComponent = componentDAO.findById(savedComponent.getId());
        assertNotNull(foundComponent);
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

        ComponentDAO componentDAO = new ComponentDAO();
        Component component = Component.builder()
                .amountEnclosure(1)
                .enclosure(savedEnclosure)
                .product(savedProduct)
                .build();
        Component savedComponent = componentDAO.save(component);
        assertNotNull(savedComponent.getId());

        componentDAO.delete(savedComponent);
        Component afterDelete = componentDAO.findById(savedComponent.getId());
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

        ComponentDAO componentDAO = new ComponentDAO();
        Component component = Component.builder()
                .amountEnclosure(1)
                .enclosure(savedEnclosure)
                .product(savedProduct)
                .build();
        Component savedComponent = componentDAO.save(component);
        assertNotNull(savedComponent.getId());


        Enclosure enclosure2 = Enclosure.builder()
                .name("test-name")
                .build();
        Enclosure savedEnclosure2 = enclosureDAO.save(enclosure2);
        assertNotNull(savedEnclosure2.getId());

        Integer idEnclosureBeforeUpdate = savedComponent.getEnclosure().getId();

        savedComponent.setEnclosure(savedEnclosure2);
        componentDAO.update(savedComponent);

        Integer idEnclosureAfterUpdate = savedComponent.getEnclosure().getId();

        assertFalse(idEnclosureBeforeUpdate.equals(idEnclosureAfterUpdate));
        assertFalse(savedComponent.getEnclosure().getId().equals(savedEnclosure.getId()));

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

        ComponentDAO componentDAO = new ComponentDAO();
        Component component = Component.builder()
                .amountEnclosure(1)
                .enclosure(savedEnclosure)
                .product(savedProduct)
                .build();
        Component savedComponent = componentDAO.save(component);
        assertNotNull(savedComponent.getId());

        List<Component> result = componentDAO.findAllProductWhereEnclosureIs(enclosure);
        assertNotNull(result);
        assertFalse(result.isEmpty());

    }

}