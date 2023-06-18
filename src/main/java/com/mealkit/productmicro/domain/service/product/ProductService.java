package com.mealkit.productmicro.domain.service.product;

import com.mealkit.productmicro.domain.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto getProductById (Long productId) throws Exception;

    List<ProductDto> getProductsById(List<Long> productIdList);

    List<ProductDto> getProductByTag(List<Long> tagIdList);

    void deleteProduct(Long productId);

    void updateProduct(ProductDto productDto);

    void createProduct(ProductDto productDto);
}
