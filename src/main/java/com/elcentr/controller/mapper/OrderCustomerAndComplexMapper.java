package com.elcentr.controller.mapper;

import com.elcentr.controller.dto.OrderCustomerAndComplexDTO;
import com.elcentr.model.Customer;
import com.elcentr.model.Order;
import com.elcentr.model.ResidentialComplex;

public class OrderCustomerAndComplexMapper {

    public static OrderCustomerAndComplexDTO toOrderCustomerAndComplexDTO(Order order) {
        String customerId = null;
        String customerName = null;
        String complexId = null;
        String complexName = null;
        String complexAddress = null;

        Customer customer = order.getCustomer();
        if (customer != null) {
            customerId = customer.getId().toString();
            customerName = customer.getName();
        }

        ResidentialComplex complex = order.getResidentialComplex();
        if (complex != null) {
            complexId = complex.getId().toString();
            complexName = complex.getName();
            complexAddress = complex.getAddress();
        }

        return OrderCustomerAndComplexDTO.builder()
                .orderId(order.getId().toString())
                .customerId(customerId)
                .customerName(customerName)
                .complexId(complexId)
                .complexName(complexName)
                .complexAddress(complexAddress)
                .build();
    }
}
