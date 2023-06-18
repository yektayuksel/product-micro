package com.mealkit.productmicro.web.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientApiOutput {

    private Long id;
    private String name;
    private String unitOfMeasure;


}
