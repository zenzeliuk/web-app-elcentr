package com.elcentr.controller.mapper;

import com.elcentr.controller.dto.ComponentEnclosureDTO;
import com.elcentr.model.Component;

public class ComponentEnclosureMapper {

    public static ComponentEnclosureDTO toComponentEnclosureDTO(Component component) {
        return ComponentEnclosureDTO.builder()
                .componentId(component.getId().toString())
                .enclosureManufacturer(component.getEnclosure().getManufacturer())
                .enclosureCode(component.getEnclosure().getCode())
                .enclosureName(component.getEnclosure().getName())
                .enclosureAmount(component.getAmountEnclosure().toString())
                .build();
    }

}
