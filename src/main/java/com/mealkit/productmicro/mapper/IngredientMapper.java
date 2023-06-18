package com.mealkit.productmicro.mapper;

import com.mealkit.productmicro.dao.entity.IngredientEntity;
import com.mealkit.productmicro.domain.dto.IngredientDto;
import com.mealkit.productmicro.web.request.IngredientApiInput;
import com.mealkit.productmicro.web.response.IngredientApiOutput;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngredientMapper {

    IngredientDto ingredientApiInputToDto(IngredientApiInput ingredientApiInput);
    IngredientApiOutput ingredientDtoToApiOutput(IngredientDto ingredientDto);
    IngredientEntity ingredientDtoToEntity(IngredientDto ingredientDto);
    IngredientDto ingredientEntityToDto(IngredientEntity ingredientEntity);
}
