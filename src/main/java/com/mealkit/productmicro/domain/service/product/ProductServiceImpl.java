package com.mealkit.productmicro.domain.service.product;

import com.mealkit.productmicro.dao.entity.ProductEntity;
import com.mealkit.productmicro.dao.entity.ProductIngredientEntity;
import com.mealkit.productmicro.dao.entity.ProductIngredientKey;
import com.mealkit.productmicro.dao.entity.TagEntity;
import com.mealkit.productmicro.dao.repository.ProductIngredientRepository;
import com.mealkit.productmicro.dao.repository.ProductRepository;
import com.mealkit.productmicro.dao.repository.TagRepository;
import com.mealkit.productmicro.domain.dto.ProductDto;
import com.mealkit.productmicro.domain.dto.ProductIngredientDto;
import com.mealkit.productmicro.mapper.ProductMapper;

import com.mealkit.productmicro.web.request.ProductApiInput;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductMapper productMapper;
    private final ProductIngredientRepository productIngredientRepository;
    private final ProductRepository productRepository;
    private final TagRepository tagRepository;

    @Override
    public ProductDto getProductById(Long productId) throws Exception {

        Optional<ProductEntity> productEntity = productRepository.findById(productId);

        if(productEntity.isPresent()){
            ProductEntity p = productEntity.get();
            return productEntityToDto(p);
        }else{
            throw new Exception("ProductNotFound");
        }

    }

    @Override
    @Transactional
    public List<ProductDto> getProductsById(List<Long> productIdList) {

        List<ProductEntity> productEntityList = productRepository.findAllById(productIdList);
        List<ProductDto> productDtoList = new ArrayList<>();
        for(ProductEntity productEntity : productEntityList){
            productDtoList.add(productEntityToDto(productEntity));
        }
        return productDtoList;
    }

    @Override
    @Transactional
    public List<ProductDto> getProductByTag(List<Long> tagIdList) {

        List<ProductEntity> productEntityList = productRepository.findByTagIdIn(tagIdList, tagIdList.size());
        List<ProductDto> productDtoList = new ArrayList<>();
        for(ProductEntity productEntity : productEntityList){
            productDtoList.add(productEntityToDto(productEntity));
        }
        return productDtoList;
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
            productEntity.setImageUrl(productDto.getImageUrl());
            productRepository.save(productEntity);
        }
    }

    @Override
    public void createProduct(ProductApiInput productApiInput) throws Exception {

        ProductEntity productEntity = new ProductEntity();
        productEntity = productRepository.save(productEntity);

        productEntity.setTags(new HashSet<>());
        productEntity.setIngredients(new HashSet<>());

        for(Long tagId : productApiInput.getTagIds()){
            Optional<TagEntity> tag = tagRepository.findById(tagId);
            if(tag.isPresent()){
                productEntity.getTags().add(tag.get());
            }else{
                throw new Exception("Tag with id " + tagId + " not found");
            }
        }

        for(ProductIngredientDto productIngredientDto : productApiInput.getIngredients()){
            ProductIngredientEntity productIngredientEntity = new ProductIngredientEntity();
            ProductIngredientKey productIngredientKey = new ProductIngredientKey();
            productIngredientKey.setProductId(productEntity.getId());
            productIngredientKey.setIngredientId(productIngredientDto.getId());
            productIngredientEntity.setCount(productIngredientDto.getCount());
            productIngredientEntity.setProduct(productEntity);
            productIngredientEntity.setId(productIngredientKey);
            productIngredientRepository.save(productIngredientEntity);
        }
        productEntity.setProductName(productApiInput.getProductName());
        productEntity.setDescription(productApiInput.getDescription());
        productEntity.setImageUrl(productApiInput.getImageUrl());
        productEntity.setPrice(productApiInput.getPrice());
        productEntity.setRecipe(productApiInput.getRecipe());
        productEntity.setCalories(productApiInput.getCalories());
        productEntity.setCookingTime(productApiInput.getCookingTime());
        productEntity.setDifficulty(productApiInput.getDifficulty());
        productRepository.save(productEntity);
    }

    private ProductDto productEntityToDto(ProductEntity p){

        ProductDto productDto = new ProductDto();
        productDto.setIngredients(new ArrayList<>());
        productDto.setTagIds(new ArrayList<>());
        productDto.setId(p.getId());
        productDto.setDifficulty(p.getDifficulty());
        productDto.setProductName(p.getProductName());
        productDto.setCalories(p.getCalories());
        productDto.setCookingTime(p.getCookingTime());
        productDto.setRecipe(p.getRecipe());
        productDto.setDescription(p.getDescription());
        productDto.setImageUrl(p.getImageUrl());
        productDto.setPrice(p.getPrice());

        List<ProductIngredientEntity> ingredients = productIngredientRepository.getByProductId(p.getId());

        for(ProductIngredientEntity ingredient : ingredients){
            productDto.getIngredients().add(new ProductIngredientDto(ingredient.getId().getIngredientId(), ingredient.getCount()));

        }

        List<Long> tagIds = productRepository.getProductTagsById(p.getId());
        for(Long id : tagIds){
            productDto.getTagIds().add(id);
        }

        return productDto;
    }
}
