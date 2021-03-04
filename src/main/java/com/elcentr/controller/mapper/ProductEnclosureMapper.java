package com.elcentr.controller.mapper;

import com.elcentr.controller.dto.ProductEnclosureDTO;
import com.elcentr.model.ProductEnclosure;

public class ProductEnclosureMapper {

    public static ProductEnclosureDTO toProductEnclosureDTO(ProductEnclosure productEnclosure) {
        return ProductEnclosureDTO.builder()
                .id(productEnclosure.getId().toString())
                .manufacturer(productEnclosure.getEnclosure().getManufacturer())
                .code(productEnclosure.getEnclosure().getCode())
                .name(productEnclosure.getEnclosure().getName())
                .amount(productEnclosure.getAmountEnclosure().toString())
                .build();
    }

}
