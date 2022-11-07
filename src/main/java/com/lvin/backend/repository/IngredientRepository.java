package com.lvin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lvin.backend.model.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

	@Query(value = "SELECT * FROM Ingredient i WHERE i.dish_id = ?1", nativeQuery = true)
	Ingredient findByDishId(int dishId);

}
