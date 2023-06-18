package com.mealkit.productmicro.web.response;

import com.mealkit.productmicro.dao.entity.ProductIngredientEntity;
import com.mealkit.productmicro.domain.dto.TagDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductApiOutput {

    private String productName;
    private String description;
    private byte[] image;
    private String recipe;
    private Double price;

    private List<Long> ingredientIds;


}
