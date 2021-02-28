package com.elcentr.controller.mapper;

import com.elcentr.controller.dto.OrderCustomerAndComplexDTO;
import com.elcentr.model.Order;

public class OrderCustomerAndComplexMapper {

    public static OrderCustomerAndComplexDTO toOrderCustomerAndComplexDTO(Order order) {
        return OrderCustomerAndComplexDTO.builder()
                .orderId(order.getId().toString())
                .customerId(order.getCustomer().getId().toString())
                .complexId(order.getResidentialComplex().getId().toString())
                .customerName(order.getCustomer().getName())
                .complexName(order.getResidentialComplex().getName())
                .complexAddress(order.getResidentialComplex().getAddress())
                .build();

    }
}
