package com.lvin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lvin.backend.model.IngredientItem;

@Repository
public interface ItemRepository extends JpaRepository<IngredientItem, Integer> {


}
