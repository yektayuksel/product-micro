package com.mealkit.productmicro.dao.entity;

import jakarta.persistence.*;


import java.util.Set;

@Entity
@Table(name = "tag")

public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductEntity> getProductEntities() {
        return productEntities;
    }

    public void setProductEntities(Set<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "tagEntities")
    Set<ProductEntity> productEntities;

}