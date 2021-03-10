package com.elcentr.controller.mapper;

import com.elcentr.controller.dto.OrderDTO;
import com.elcentr.model.Customer;
import com.elcentr.model.Order;
import com.elcentr.model.ResidentialComplex;

public class OrderMapper {

    public static OrderDTO toOrderDTO(Order order) {
        String orderId = null;
        String customerId = null;
        String complexId = null;
        String customerName = null;
        String complexName = null;
        String complexAddress = null;

        if (order != null) {
            orderId = String.valueOf(order.getId());
            if (order.getCustomer() != null) {
                Customer customer = order.getCustomer();
                customerId = String.valueOf(customer.getId());
                customerName = customer.getName();
            }
            if (order.getResidentialComplex() != null) {
                ResidentialComplex complex = order.getResidentialComplex();
                complexId = String.valueOf(complex.getId());
                complexName = complex.getName();
                complexAddress = complex.getAddress();
            }

        }

        return OrderDTO.builder()
                .orderId(orderId)
                .customerId(customerId)
                .complexId(complexId)
                .customerName(customerName)
                .complexName(complexName)
                .complexAddress(complexAddress)
                .build();

    }
}
