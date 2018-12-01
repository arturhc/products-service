package com.tecgurus.products_service.app.persistence.model;

import com.tecgurus.products_service.common.persistence.model.BaseEntity;

import javax.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "User")
@Table(name = "User", schema = "products")
public class Product extends BaseEntity {

    @Column(length = 50)
    private String code;

    @Column(length = 100)
    private String description;

    @Column(length = 100)
    private String name;

    @Column
    private double unitPrice;

    @Column(length = 50)
    private String brand;

    @Column
    private Integer reorderLevel;

    @Column
    private Integer unitsInStock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

}