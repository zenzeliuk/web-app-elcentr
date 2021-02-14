package com.elcentr.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@Entity
public class Product extends BaseEntity {

    @Column(name = "time_registration", nullable = false)
    private Long timeRegistration;

    @Column(name = "time_end")
    private Long timeEnd;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private String name;

    private String passport;

    private String photo;

    @Column(name = "nominal_current")
    private Integer nominalCurrent;

    @Column(name = "index_protection_product")
    private Integer indexProtectionProduct;

    @Column(name = "decimal_number")
    private String decimalNumber;

    private Integer height;

    private Integer width;

    private Integer depth;

    public Product(Integer id, Long timeRegistration, Long timeEnd, String code, Integer amount, String name, String passport, String photo, Integer nominalCurrent, Integer indexProtectionProduct, String decimalNumber, Integer height, Integer width, Integer depth) {
        super.setId(id);
        this.timeRegistration = timeRegistration;
        this.timeEnd = timeEnd;
        this.code = code;
        this.amount = amount;
        this.name = name;
        this.passport = passport;
        this.photo = photo;
        this.nominalCurrent = nominalCurrent;
        this.indexProtectionProduct = indexProtectionProduct;
        this.decimalNumber = decimalNumber;
        this.height = height;
        this.width = width;
        this.depth = depth;
    }
}
