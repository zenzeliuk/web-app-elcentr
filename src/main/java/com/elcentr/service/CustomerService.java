package com.elcentr.service;

import com.elcentr.dao.CustomerDAO;
import com.elcentr.model.Customer;
import lombok.RequiredArgsConstructor;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@RequiredArgsConstructor
public class CustomerService {

    private final CustomerDAO customerDAO;

    public Customer save(Customer customer) {
        if (nonNull(customer.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        return customerDAO.save(customer);
    }

    public Customer update(Customer customer) {
        if (isNull(customer.getId())) {
            throw new RuntimeException("Update is failed!");
        }
        return customerDAO.update(customer);
    }

    public Customer read(Customer customer) {
        if (isNull(customer)) {
            throw new RuntimeException("Search is failed!");
        }
        return customerDAO.findById(customer.getId());
    }

    public void delete(Customer customer) {
        if (isNull(customer.getId())) {
            throw new RuntimeException("Delete is failed!");
        }
        customerDAO.delete(customer);
    }

}
