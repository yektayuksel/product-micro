package com.mealkit.productmicro.dao.entity;

import jakarta.persistence.*;


import java.util.Set;

@Entity
@Table(name = "ingredient")
public abstract class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Long id;

    public IngredientEntity(Long id, String name, Double amount, Set<ProductIngredientEntity> productIngredientEntities) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.productIngredientEntities = productIngredientEntities;
    }

    public IngredientEntity() {

    }

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Set<ProductIngredientEntity> getProductIngredientEntities() {
        return productIngredientEntities;
    }

    public void setProductIngredientEntities(Set<ProductIngredientEntity> productIngredientEntities) {
        this.productIngredientEntities = productIngredientEntities;
    }

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private Double amount;

    @OneToMany(mappedBy = "ingredientEntity")
    Set<ProductIngredientEntity> productIngredientEntities;

}