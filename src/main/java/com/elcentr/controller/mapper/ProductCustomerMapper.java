package com.elcentr.controller.mapper;

import com.elcentr.controller.dto.ProductCustomerDTO;
import com.elcentr.model.Order;

public class ProductCustomerMapper {

    public static ProductCustomerDTO toProductCustomerDTO(Order order) {
        return ProductCustomerDTO.builder()
                .id(order.getCustomer().getId().toString())
                .name(order.getCustomer().getName())
                .notes(order.getCustomer().getNotes())
                .build();
    }
}
