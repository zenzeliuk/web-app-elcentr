package com.elcentr.controller;

import com.elcentr.model.Customer;
import com.elcentr.service.CustomerService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    public Customer save(Customer customer) {
        return customerService.save(customer);
    }
}
