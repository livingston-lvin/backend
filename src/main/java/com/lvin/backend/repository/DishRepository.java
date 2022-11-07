package com.lvin.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lvin.backend.model.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {

	List<Dish> findByNameContaining(String search);

}
