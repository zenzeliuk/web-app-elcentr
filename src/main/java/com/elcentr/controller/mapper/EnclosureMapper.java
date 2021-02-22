package com.elcentr.controller.mapper;

import com.elcentr.controller.dto.EnclosureDTO;
import com.elcentr.model.Enclosure;

public class EnclosureMapper {
    public static EnclosureDTO toEnclosureDTO(Enclosure enclosure) {
        return EnclosureDTO.builder()
                .id(enclosure.getId().toString())
                .manufacturer(enclosure.getManufacturer())
                .code(enclosure.getCode())
                .name(enclosure.getName())
                .typeOfInstallation(enclosure.getTypeOfInstallation())
                .category(enclosure.getCategory())
                .color(enclosure.getColor())
                .indexProtection(enclosure.getIndexProtection().toString())
                .material(enclosure.getMaterial())
                .depth(enclosure.getDepth().toString())
                .height(enclosure.getHeight().toString())
                .width(enclosure.getWidth().toString())
                .build();
    }
}
