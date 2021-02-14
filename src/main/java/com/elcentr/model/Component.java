package com.elcentr.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Builder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "components")
@Entity
public class Component extends BaseEntity {

    @ManyToOne(targetEntity = Product.class)
    private Product product;

    @ManyToOne(targetEntity = Enclosure.class)
    private Enclosure enclosure;

    @Column(name = "amount_enclosure", nullable = false)
    private Integer amountEnclosure;

    public Component(Integer id, Product product, Enclosure enclosure, Integer amountEnclosure) {
        super.setId(id);
        this.product = product;
        this.enclosure = enclosure;
        this.amountEnclosure = amountEnclosure;
    }

}
