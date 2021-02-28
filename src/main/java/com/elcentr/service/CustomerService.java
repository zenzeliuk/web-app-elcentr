package com.elcentr.service;

import com.elcentr.dao.CustomerDAO;
import com.elcentr.dao.EnclosureDAO;
import com.elcentr.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class CustomerService {

    private static final Logger LOG = Logger.getLogger(CustomerService.class.getName());

    public Customer save(Customer customer) {
        CustomerDAO customerDAO = new CustomerDAO();
        if (nonNull(customer.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        return customerDAO.save(customer);
    }

    public Customer update(Customer customer) {
        CustomerDAO customerDAO = new CustomerDAO();
        if (isNull(customer.getId())) {
            throw new RuntimeException("Update is failed!");
        }
        return customerDAO.update(customer);
    }

    public Customer read(Customer customer) {
        CustomerDAO customerDAO = new CustomerDAO();
        if (isNull(customer)) {
            throw new RuntimeException("Search is failed!");
        }
        return customerDAO.findById(customer.getId());
    }

    public void delete(Customer customer) {
        CustomerDAO customerDAO = new CustomerDAO();
        if (isNull(customer.getId())) {
            throw new RuntimeException("Delete is failed!");
        }
        customerDAO.delete(customer);
    }

    public List<Customer> findAll() {
        try {
            CustomerDAO customerDAO = new CustomerDAO();
            return customerDAO.findAll();
        } catch (Exception e) {
            LOG.severe("Any customer was not found");
        }
        return new ArrayList<>();
    }
}
