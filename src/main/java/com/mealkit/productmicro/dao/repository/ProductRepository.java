package com.mealkit.productmicro.dao.repository;

import com.mealkit.productmicro.dao.entity.ProductEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Transactional
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {


    @Query("SELECT p FROM ProductEntity p WHERE p.id IN :productIds")
    List<ProductEntity> findAllById(List<Long> productIds);



    @Query("SELECT p FROM ProductEntity p WHERE :tagCount = (SELECT COUNT(t) FROM TagEntity t WHERE t IN elements(p.tags) AND t.id IN :tagIds)")
    List<ProductEntity> findByTagIdIn(List<Long> tagIds, long tagCount);

    @Query("SELECT t.id FROM ProductEntity p JOIN p.tags t WHERE p.id = :productId")
    List<Long> getProductTagsById(Long productId);

}