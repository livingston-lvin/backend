package com.lvin.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvin.backend.model.Dish;
import com.lvin.backend.repository.DishRepository;

@CrossOrigin
@RestController
@RequestMapping("dish")
public class DishController {

	@Autowired
	private DishRepository rep;

	@GetMapping("all")
	public List<Dish> getDishes() {
		List<Dish> dishes = rep.findAll();
		return dishes;
	}

	@PostMapping
	public Dish create(@RequestBody Dish dish) {
		Dish d = rep.save(dish);
		return d;
	}

	@PutMapping
	public ResponseEntity<Dish> update(@RequestBody Dish dish) {
		Dish updatedDish = rep.save(dish);
		return new ResponseEntity<Dish>(updatedDish, HttpStatus.OK);
	}

	@GetMapping("{dishId}")
	public Dish getDish(@PathVariable int dishId) {
		Optional<Dish> dish = rep.findById(dishId);
		Dish d = dish.get();
		return d;
	}

	@DeleteMapping("{dishId}")
	public HttpStatus deleteDish(@PathVariable int dishId) {
		try {
			rep.findById(dishId).get();
			rep.deleteById(dishId);
			return HttpStatus.OK;
		} catch (Exception e) {
			return HttpStatus.BAD_REQUEST;
		}
	}

	@GetMapping("filter/{search}")
	public List<Dish> getFilteredDish(@PathVariable String search) {
		List<Dish> dishes = rep.findByNameContaining(search);
		if (dishes.isEmpty())
			return new ArrayList<>();
		else
			return dishes;
	}
	
	@GetMapping("get/{offset}/{size}")
	public Page<Dish> getDishByNo(@PathVariable int offset,@PathVariable int size){
		Page<Dish> dishes = rep.findAll(PageRequest.of(offset, size));
		return dishes;
	}
}
