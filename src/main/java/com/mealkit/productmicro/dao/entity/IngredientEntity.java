package com.mealkit.productmicro.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;

@Entity
@Table(name = "ingredient")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "unitOfMeasure")
    private String unitOfMeasure;

    @OneToMany(mappedBy = "ingredientEntity")
    Set<ProductIngredientEntity> productIngredientEntities;

}