package com.mealkit.productmicro.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductIngredientDto {
    private Long id;
    private Double count;
}
