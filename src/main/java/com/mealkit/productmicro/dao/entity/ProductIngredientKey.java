package com.mealkit.productmicro.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


import java.io.Serializable;

@Embeddable
public class ProductIngredientKey implements Serializable {
    public ProductIngredientKey(Long productId, Long ingredientId) {
        this.productId = productId;
        this.ingredientId = ingredientId;
    }

    public ProductIngredientKey() {

    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    @Column(name = "product_id")
    Long productId;

    @Column(name = "ingredient_id")
    Long ingredientId;


}