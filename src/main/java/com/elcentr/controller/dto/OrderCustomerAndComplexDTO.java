package com.elcentr.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCustomerAndComplexDTO {

    private String orderId;
    private String customerId;
    private String complexId;
    private String customerName;
    private String complexName;
    private String complexAddress;

}
