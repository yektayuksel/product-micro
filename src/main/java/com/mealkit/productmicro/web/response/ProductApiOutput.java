package com.mealkit.productmicro.web.response;

import com.mealkit.productmicro.domain.dto.ProductIngredientDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductApiOutput {

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
