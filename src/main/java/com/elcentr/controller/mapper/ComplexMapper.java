package com.elcentr.controller.mapper;

import com.elcentr.controller.dto.ComplexDTO;
import com.elcentr.model.ResidentialComplex;

public class ComplexMapper {
    public static ComplexDTO toComplexDTO(ResidentialComplex complex) {
        return ComplexDTO.builder()
                .id(complex.getId().toString())
                .name(complex.getName())
                .address(complex.getAddress())
                .build();
    }
}