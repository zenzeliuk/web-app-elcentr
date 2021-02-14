package com.elcentr.dao;

import com.elcentr.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDAOTest {

    @Test
    void save() {
        Customer customer = Customer.builder()
                .name("test-name")
                .build();
        Customer savedCustomer = new CustomerDAO().save(customer);
        assertNotNull(savedCustomer.getId());
    }

    @Test
    void findById() {
        Customer customer = Customer.builder()
                .name("test-name")
                .build();
        CustomerDAO customerDAO = new CustomerDAO();
        Customer savedCustomer = customerDAO.save(customer);
        assertNotNull(savedCustomer.getId());

        Customer foundCustomer = customerDAO.findById(savedCustomer.getId());
        assertNotNull(foundCustomer);
    }

    @Test
    void delete() {
        Customer customer = Customer.builder()
                .name("test-name")
                .build();
        CustomerDAO customerDAO = new CustomerDAO();
        Customer savedCustomer = customerDAO.save(customer);
        assertNotNull(savedCustomer.getId());

        customerDAO.delete(savedCustomer);
        Customer afterDelete = customerDAO.findById(savedCustomer.getId());
        assertNull(afterDelete);
    }

    @Test
    void update() {
        Customer customer = Customer.builder()
                .name("test-name")
                .build();
        CustomerDAO customerDAO = new CustomerDAO();
        Customer savedCustomer = customerDAO.save(customer);
        assertNotNull(savedCustomer.getId());
        String nameBeforeUpdate = savedCustomer.getName();

        savedCustomer.setName("new-test-name");
        customerDAO.update(savedCustomer);
        String nameAfterUpdate = savedCustomer.getName();

        assertFalse(nameBeforeUpdate.equals(nameAfterUpdate));
    }
}