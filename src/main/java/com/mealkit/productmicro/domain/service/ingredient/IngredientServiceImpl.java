package com.mealkit.productmicro.domain.service.ingredient;

import com.mealkit.productmicro.dao.entity.IngredientEntity;
import com.mealkit.productmicro.dao.repository.IngredientRepository;
import com.mealkit.productmicro.domain.dto.IngredientDto;
import com.mealkit.productmicro.mapper.IngredientMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    public IngredientServiceImpl(IngredientRepository ingredientRepository, IngredientMapper ingredientMapper) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientMapper = ingredientMapper;
    }

    IngredientRepository ingredientRepository;
    IngredientMapper ingredientMapper;

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
    public void updateIngredient(IngredientDto ingredientDto) throws Exception {

        Optional<IngredientEntity> ing = ingredientRepository.findById(ingredientDto.getId());
        if(ing.isPresent()){
            IngredientEntity ingredientEntity = ing.get();
            ingredientEntity.setAmount(ingredientDto.getAmount());
            ingredientEntity.setName(ingredientDto.getName());
            ingredientRepository.save(ingredientEntity);
        }else {
            throw new Exception("Ingredient not found");
        }


    }
}
