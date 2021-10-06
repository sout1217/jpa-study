package com.relation.jpa.repository;

import com.relation.jpa.entity.FoodTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodTagRepository extends JpaRepository<FoodTag, Long> {
}