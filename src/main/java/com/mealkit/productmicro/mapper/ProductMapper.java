package com.mealkit.productmicro.mapper;

import com.mealkit.productmicro.dao.entity.ProductEntity;
import com.mealkit.productmicro.dao.entity.ProductIngredientEntity;
import com.mealkit.productmicro.domain.dto.ProductDto;
import com.mealkit.productmicro.domain.dto.ProductIngredientDto;
import com.mealkit.productmicro.web.request.ProductApiInput;
import com.mealkit.productmicro.web.response.ProductApiOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProductMapper {








    ProductDto productApiInputToDto(ProductApiInput productApiInput);

    List<ProductApiOutput> productDtoToApiOutputList(List<ProductDto> productDtoList);

    ProductApiOutput productDtoToApiOutput(ProductDto productDto);
}
