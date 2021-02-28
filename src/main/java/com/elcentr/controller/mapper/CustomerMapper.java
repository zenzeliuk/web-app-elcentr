package com.elcentr.controller.mapper;

import com.elcentr.controller.dto.CustomerDTO;
import com.elcentr.model.Customer;

public class CustomerMapper {
    public static CustomerDTO toCustomerDTO(Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getId().toString())
                .name(customer.getName())
                .notes(customer.getNotes())
                .build();
    }
}