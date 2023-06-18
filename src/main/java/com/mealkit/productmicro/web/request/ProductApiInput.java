package com.mealkit.productmicro.web.request;

import com.mealkit.productmicro.domain.dto.ProductIngredientDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductApiInput {

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
