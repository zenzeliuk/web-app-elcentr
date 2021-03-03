package com.elcentr.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEnclosureDTO {

    private String componentId;
    private String enclosureManufacturer;
    private String enclosureName;
    private String enclosureCode;
    private String enclosureAmount;

}
