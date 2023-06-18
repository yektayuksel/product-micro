package com.mealkit.productmicro.domain.service.ingredient;

import com.mealkit.productmicro.dao.entity.IngredientEntity;
import com.mealkit.productmicro.dao.repository.IngredientRepository;
import com.mealkit.productmicro.domain.dto.IngredientDto;
import com.mealkit.productmicro.mapper.IngredientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {


    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

    @Override
    public void createIngredient(IngredientDto ingredientDto) {

        IngredientEntity ingredientEntity = ingredientMapper.ingredientDtoToEntity(ingredientDto);
        ingredientRepository.save(ingredientEntity);
    }

    @Override
    public void deleteIngredient(Long ingredientId) {

        ingredientRepository.deleteById(ingredientId);
    }

    @Override
    public void updateIngredient(IngredientDto ingredientDto, Long ingredientId) throws Exception {

        Optional<IngredientEntity> ing = ingredientRepository.findById(ingredientId);
        if(ing.isPresent()){
            IngredientEntity ingredientEntity = ing.get();
            ingredientEntity.setUnitOfMeasure(ingredientDto.getUnitOfMeasure());
            ingredientEntity.setName(ingredientDto.getName());
            ingredientRepository.save(ingredientEntity);
        }else {
            throw new Exception("Ingredient not found");
        }


    }
}
