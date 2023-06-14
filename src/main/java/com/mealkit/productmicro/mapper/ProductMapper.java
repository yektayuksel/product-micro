package com.mealkit.productmicro.mapper;

import com.mealkit.productmicro.dao.entity.ProductEntity;
import com.mealkit.productmicro.domain.dto.ProductDto;
import com.mealkit.productmicro.web.request.ProductApiInput;
import com.mealkit.productmicro.web.response.ProductApiOutput;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto productEntityToDto(ProductEntity productEntity);

    ProductEntity productDtoToEntity(ProductDto productDto);

    List<ProductDto> productEntityListToDtoList(List<ProductEntity> productEntityList);

    ProductDto productApiInputToDto(ProductApiInput productApiInput);

    List<ProductApiOutput> productDtoToApiOutputList(List<ProductDto> productDtoList);

    ProductApiOutput productDtoToApiOutput(ProductDto productDto);
}
