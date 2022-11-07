package com.lvin.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.lvin.backend.model.Ingredient;
import com.lvin.backend.model.Item;
import com.lvin.backend.repository.IngredientRepository;
import com.lvin.backend.repository.ItemRepository;

@CrossOrigin
@RestController
@RequestMapping("ingredient")
public class IngredientController {

	@Autowired
	private IngredientRepository rep;

	@Autowired
	private ItemRepository ir;

	@GetMapping("all")
	public List<Ingredient> getIngredients() {
		List<Ingredient> ingredients = rep.findAll();
		return ingredients;
	}

	@PutMapping
	public ResponseEntity<Ingredient> update(@RequestBody Ingredient ingredient) {
		Ingredient updatedIngredient = rep.save(ingredient);
		return new ResponseEntity<Ingredient>(updatedIngredient, HttpStatus.OK);
	}

	@GetMapping("{ingredientId}")
	public Ingredient getIngredient(@PathVariable int ingredientId) {
		Optional<Ingredient> ingredient = rep.findById(ingredientId);
		Ingredient i = ingredient.get();
		return i;
	}

	@DeleteMapping("{ingredientId}")
	public HttpStatus delete(@PathVariable int ingredientId) {
		Optional<Ingredient> ingredient = rep.findById(ingredientId);
		if (ingredient.isEmpty()) {
			return HttpStatus.BAD_REQUEST;
		}
		rep.delete(ingredient.get());
		return HttpStatus.OK;
	}

	@PostMapping
	public Ingredient create(@RequestBody Ingredient ingredient) {
		List<Item> items = ingredient.getItem();
		ir.saveAll(items);
		Ingredient ii = rep.save(ingredient);
		return ii;
	}

}
