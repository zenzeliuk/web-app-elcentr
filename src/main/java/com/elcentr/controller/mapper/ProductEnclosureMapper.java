package com.elcentr.controller.mapper;

import com.elcentr.controller.dto.ProductEnclosureDTO;
import com.elcentr.model.ProductEnclosure;

public class ProductEnclosureMapper {

    public static ProductEnclosureDTO toProductEnclosureDTO(ProductEnclosure productEnclosure) {
        return ProductEnclosureDTO.builder()
                .componentId(productEnclosure.getId().toString())
                .enclosureManufacturer(productEnclosure.getEnclosure().getManufacturer())
                .enclosureCode(productEnclosure.getEnclosure().getCode())
                .enclosureName(productEnclosure.getEnclosure().getName())
                .enclosureAmount(productEnclosure.getAmountEnclosure().toString())
                .build();
    }

}
