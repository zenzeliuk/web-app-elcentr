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

    private String id;
    private String manufacturer;
    private String name;
    private String code;
    private String amount;

}
