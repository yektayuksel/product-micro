package com.mealkit.productmicro.dao.repository;

import com.mealkit.productmicro.dao.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {
}
