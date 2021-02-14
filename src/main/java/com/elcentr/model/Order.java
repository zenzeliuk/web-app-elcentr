package com.elcentr.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Builder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@Entity
public class Order extends BaseEntity {

    @ManyToOne(targetEntity = Product.class)
    private Product product;

    @OneToOne(targetEntity = Customer.class)
    private Customer customer;

    @OneToOne(targetEntity = ResidentialComplex.class)
    private ResidentialComplex residentialComplex;

    public Order(Integer id, Product product, Customer customer, ResidentialComplex residentialComplex) {
        super.setId(id);
        this.product = product;
        this.customer = customer;
        this.residentialComplex = residentialComplex;
    }
}
