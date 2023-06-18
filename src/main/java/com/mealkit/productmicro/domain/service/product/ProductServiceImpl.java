package com.mealkit.productmicro.domain.service.product;

import com.mealkit.productmicro.dao.entity.ProductEntity;
import com.mealkit.productmicro.dao.repository.ProductRepository;
import com.mealkit.productmicro.domain.dto.ProductDto;
import com.mealkit.productmicro.mapper.ProductMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;


    @Override
    public ProductDto getProductById(Long productId) throws Exception {

        Optional<ProductEntity> productEntity = productRepository.findById(productId);

        if(productEntity.isPresent()){
            return productMapper.productEntityToDto(productEntity.get());
        }else{
            throw new Exception("ProductNotFound");
        }

    }

    @Override
    public List<ProductDto> getProductsById(List<Long> productIdList) {

        List<ProductEntity> productEntityList = productRepository.findAllById(productIdList);
        return productMapper.productEntityListToDtoList(productEntityList);
    }

    @Override
    public List<ProductDto> getProductByTag(List<Long> tagIdList) {

        return productMapper.productEntityListToDtoList(productRepository.findByTagIdIn(tagIdList));
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public void updateProduct(ProductDto productDto) {

        Optional<ProductEntity> p = productRepository.findById(productDto.getId());


        if(p.isPresent()){
            ProductEntity productEntity = p.get();
            productEntity.setProductName(productDto.getProductName());
            productEntity.setDescription(productDto.getDescription());
            productEntity.setPrice(productDto.getPrice());
            productEntity.setRecipe(productDto.getRecipe());
            productEntity.setImage(productDto.getImage());
            productRepository.save(productEntity);
        }
    }

    @Override
    public void createProduct(ProductDto productDto) {

        ProductEntity productEntity = productMapper.productDtoToEntity(productDto);
        productRepository.save(productEntity);
    }
}
