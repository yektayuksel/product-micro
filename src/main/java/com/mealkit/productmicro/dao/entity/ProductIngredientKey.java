package com.mealkit.productmicro.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductIngredientKey implements Serializable {


    @Column(name = "product_id")
    Long productId;

    @Column(name = "ingredient_id")
    Long ingredientId;


}