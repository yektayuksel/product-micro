package com.mealkit.productmicro.dao.repository;

import com.mealkit.productmicro.dao.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {


    @Query("SELECT p FROM ProductEntity p WHERE p.id IN :productIds")
    List<ProductEntity> findAllById(List<Long> productIds);

    @Query("SELECT p FROM ProductEntity p JOIN p.tagEntities t WHERE t.id IN :tagIds")
    List<ProductEntity> findByTagIdIn(List<Long> tagIds);

}