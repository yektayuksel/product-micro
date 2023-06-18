package com.mealkit.productmicro.domain.service.ingredient;

import com.mealkit.productmicro.domain.dto.IngredientDto;

public interface IngredientService {

    void createIngredient(IngredientDto ingredientDto);
    void deleteIngredient(Long ingredientId);
    void updateIngredient(IngredientDto ingredientDto, Long ingredientId) throws Exception;


}
