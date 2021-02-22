package com.elcentr.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnclosureDTO {

    private String id;
    private String manufacturer;
    private String code;
    private String category;
    private String name;
    private String color;
    private String material;
    private String typeOfInstallation;
    private String indexProtection;
    private String height;
    private String width;
    private String depth;

}
