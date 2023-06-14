package com.mealkit.productmicro.dao.entity;

import jakarta.persistence.*;

@Entity
public class ProductIngredientEntity {
    @EmbeddedId
    ProductIngredientKey id;

    public ProductIngredientEntity(ProductIngredientKey id, ProductEntity productEntity, IngredientEntity ingredientEntity, Integer amount) {
        this.id = id;
        this.productEntity = productEntity;
        this.ingredientEntity = ingredientEntity;
        this.amount = amount;
    }

    public ProductIngredientEntity() {

    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    ProductEntity productEntity;

    public ProductIngredientKey getId() {
        return id;
    }

    public void setId(ProductIngredientKey id) {
        this.id = id;
    }

    public IngredientEntity getIngredientEntity() {
        return ingredientEntity;
    }

    public void setIngredientEntity(IngredientEntity ingredientEntity) {
        this.ingredientEntity = ingredientEntity;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    IngredientEntity ingredientEntity;

    Integer amount;
}