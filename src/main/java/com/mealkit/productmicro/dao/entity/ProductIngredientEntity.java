package com.mealkit.productmicro.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductIngredientEntity {
    @EmbeddedId
    ProductIngredientKey id;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    ProductEntity productEntity;
    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    IngredientEntity ingredientEntity;

    Double amount;
}