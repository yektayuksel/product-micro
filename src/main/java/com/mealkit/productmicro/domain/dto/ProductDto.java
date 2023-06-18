package com.mealkit.productmicro.domain.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String productName;
    private String description;
    private String imageUrl;
    private String recipe;
    private Double price;
    private Integer cookingTime;
    private Long calories;
    private String difficulty;
    private List<ProductIngredientDto> ingredients;
    private List<Long> tagIds;



}