package com.mealkit.productmicro.web.controller;


import com.mealkit.productmicro.dao.entity.IngredientEntity;
import com.mealkit.productmicro.domain.dto.IngredientDto;
import com.mealkit.productmicro.domain.service.ingredient.IngredientService;
import com.mealkit.productmicro.mapper.IngredientMapper;
import com.mealkit.productmicro.web.request.IngredientApiInput;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ingredient")
@Tag(name= "Product Service")
public class IngredientController {

    public IngredientController(IngredientMapper ingredientMapper, IngredientService ingredientService) {
        this.ingredientMapper = ingredientMapper;
        this.ingredientService = ingredientService;
    }

    private final IngredientMapper ingredientMapper;
    private final IngredientService ingredientService;


    @PostMapping("/createIngredient")
    public ResponseEntity<Void> createIngredient(@RequestBody IngredientApiInput ingredientApiInput){

        IngredientDto ingredientDto = ingredientMapper.ingredientApiInputToDto(ingredientApiInput;
        ingredientService.createIngredient(ingredientDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteIngredient/{ingredientId}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long ingredientId){
        ingredientService.deleteIngredient(ingredientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateIngredient")
    public ResponseEntity<Void> updateIngredient(@RequestBody IngredientApiInput ingredientApiInput) throws Exception{
        IngredientDto ingredientDto = ingredientMapper.ingredientApiInputToDto(ingredientApiInput);
        ingredientService.updateIngredient(ingredientDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
