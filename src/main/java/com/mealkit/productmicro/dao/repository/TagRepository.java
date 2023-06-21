package com.mealkit.productmicro.dao.repository;

import com.mealkit.productmicro.dao.entity.ProductIngredientEntity;
import com.mealkit.productmicro.dao.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepository extends JpaRepository<TagEntity, Long> {

}
