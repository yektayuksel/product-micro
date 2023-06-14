package com.mealkit.productmicro.dao.repository;

import com.mealkit.productmicro.dao.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity, Long> {
}
