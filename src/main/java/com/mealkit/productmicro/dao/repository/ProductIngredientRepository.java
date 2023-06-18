package com.mealkit.productmicro.dao.repository;

import com.mealkit.productmicro.dao.entity.ProductIngredientEntity;
import com.mealkit.productmicro.dao.entity.ProductIngredientKey;
import com.mealkit.productmicro.domain.dto.ProductIngredientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductIngredientRepository extends JpaRepository<ProductIngredientEntity, ProductIngredientKey> {


    @Query("SELECT p.id.ingredientId, p.amount FROM ProductIngredientEntity p WHERE p.id.productId = :productId")
    List<ProductIngredientDto> getByProductId(Long productId);
}
