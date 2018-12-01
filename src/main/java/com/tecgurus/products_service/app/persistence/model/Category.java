package com.tecgurus.products_service.app.persistence.model;

import com.tecgurus.products_service.common.persistence.model.BaseEntity;

import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "User")
@Table(name = "User", schema = "products")
public class Category extends BaseEntity {

    @Column
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

}
