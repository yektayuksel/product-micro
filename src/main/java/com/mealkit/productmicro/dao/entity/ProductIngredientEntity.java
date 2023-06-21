package com.mealkit.productmicro.dao.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_ingredient")
public class ProductIngredientEntity {

    @EmbeddedId
    private ProductIngredientKey id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @MapsId("productId")
    private ProductEntity product;

    private Double count;
}
