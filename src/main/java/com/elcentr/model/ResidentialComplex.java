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
@Table(name = "residential_complexes")
@Entity
public class ResidentialComplex extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private String address;

    public ResidentialComplex(Integer id,String name, String address) {
        super.setId(id);
        this.name = name;
        this.address = address;
    }
}
