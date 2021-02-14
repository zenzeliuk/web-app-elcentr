package com.elcentr.dao;

import com.elcentr.model.Customer;
import com.elcentr.model.Order;
import com.elcentr.model.Product;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OrderDAOTest {

    @Test
    void save() {

        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = Customer.builder()
                .name("test-name")
                .build();
        Customer savedCustomer = customerDAO.save(customer);
        assertNotNull(savedCustomer.getId());

        ProductDAO productDAO = new ProductDAO();
        Product product = Product.builder()
                .amount(1)
                .code("21021002")
                .name("test-name")
                .timeRegistration(new Date().getTime())
                .build();
        Product savedProduct = productDAO.save(product);
        assertNotNull(savedProduct.getId());

        OrderDAO orderDAO = new OrderDAO();
        Order order = Order.builder()
                .customer(savedCustomer)
                .product(savedProduct)
                .build();
        Order savedOrder = orderDAO.save(order);
        assertNotNull(savedOrder.getId());

    }

    @Test
    void findById() {

        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = Customer.builder()
                .name("test-name")
                .build();
        Customer savedCustomer = customerDAO.save(customer);
        assertNotNull(savedCustomer.getId());

        ProductDAO productDAO = new ProductDAO();
        Product product = Product.builder()
                .amount(1)
                .code("21021002")
                .name("test-name")
                .timeRegistration(new Date().getTime())
                .build();
        Product savedProduct = productDAO.save(product);
        assertNotNull(savedProduct.getId());

        OrderDAO orderDAO = new OrderDAO();
        Order order = Order.builder()
                .customer(savedCustomer)
                .product(savedProduct)
                .build();
        Order savedOrder = orderDAO.save(order);
        assertNotNull(savedOrder.getId());

        Order foundOrder = orderDAO.findById(savedOrder.getId());
        assertNotNull(foundOrder);

    }


    @Test
    void delete() {

        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = Customer.builder()
                .name("test-name")
                .build();
        Customer savedCustomer = customerDAO.save(customer);
        assertNotNull(savedCustomer.getId());

        ProductDAO productDAO = new ProductDAO();
        Product product = Product.builder()
                .amount(1)
                .code("21021002")
                .name("test-name")
                .timeRegistration(new Date().getTime())
                .build();
        Product savedProduct = productDAO.save(product);
        assertNotNull(savedProduct.getId());

        OrderDAO orderDAO = new OrderDAO();
        Order order = Order.builder()
                .customer(savedCustomer)
                .product(savedProduct)
                .build();
        Order savedOrder = orderDAO.save(order);
        assertNotNull(savedOrder.getId());

        orderDAO.delete(savedOrder);
        Order afterDelete = orderDAO.findById(savedOrder.getId());
        assertNull(afterDelete);

    }

    @Test
    void update() {

        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = Customer.builder()
                .name("test-name")
                .build();
        Customer savedCustomer = customerDAO.save(customer);
        assertNotNull(savedCustomer.getId());

        ProductDAO productDAO = new ProductDAO();
        Product product = Product.builder()
                .amount(1)
                .code("21021002")
                .name("test-name")
                .timeRegistration(new Date().getTime())
                .build();
        Product savedProduct = productDAO.save(product);
        assertNotNull(savedProduct.getId());

        OrderDAO orderDAO = new OrderDAO();
        Order order = Order.builder()
                .customer(savedCustomer)
                .product(savedProduct)
                .build();
        Order savedOrder = orderDAO.save(order);
        assertNotNull(savedOrder.getId());

        Customer customer2 = Customer.builder()
                .name("test-name-2")
                .build();
        Customer savedCustomer2 = customerDAO.save(customer2);
        assertNotNull(savedCustomer2.getId());

        Integer idCustomerBeforeUpdate = savedOrder.getCustomer().getId();

        savedOrder.setCustomer(savedCustomer2);
        orderDAO.update(savedOrder);

        Integer idCustomerAfterUpdate = savedOrder.getCustomer().getId();

        assertFalse(idCustomerBeforeUpdate.equals(idCustomerAfterUpdate));
        assertFalse(savedOrder.getCustomer().getId().equals(customer.getId()));

    }

}