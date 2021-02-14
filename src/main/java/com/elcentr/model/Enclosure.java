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
@Table(name = "enclosures")
@Entity
public class Enclosure extends BaseEntity {

    private String manufacturer;

    private String code;

    private String category;

    @Column(nullable = false)
    private String name;

    @Column(name = "type_of_installation")
    private String typeOfInstallation;

    private String color;

    private String material;

    private Integer height;

    private Integer width;

    private Integer depth;

    @Column(name = "index_protection")
    private Integer indexProtection;

    private String url;

    @Column(name = "image_url")
    private String imageUrl;

    public Enclosure(Integer id, String manufacturer, String code, String category, String name, String typeOfInstallation, String color, String material, Integer height, Integer width, Integer depth, Integer indexProtection, String url, String imageUrl) {
        super.setId(id);
        this.manufacturer = manufacturer;
        this.code = code;
        this.category = category;
        this.name = name;
        this.typeOfInstallation = typeOfInstallation;
        this.color = color;
        this.material = material;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.indexProtection = indexProtection;
        this.url = url;
        this.imageUrl = imageUrl;
    }
}
