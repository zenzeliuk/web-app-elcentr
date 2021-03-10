package com.elcentr.controller.mapper;

import com.elcentr.controller.dto.ProductDTO;
import com.elcentr.model.Product;

public class ProductMapper {
    public static ProductDTO toProductDTO(Product product){
        return ProductDTO.builder()
                .id(product.getId().toString())
                .name(product.getName())
                .code(product.getCode())
                .build();
    }
}
