package com.mealkit.productmicro.web.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientApiInput {

    private String name;
    private String unitOfMeasure;



}
