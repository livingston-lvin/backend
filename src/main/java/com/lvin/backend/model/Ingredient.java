package com.lvin.backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	private Dish dish;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ingredient_id",referencedColumnName = "id")
	private List<IngredientItem> item = new ArrayList<>();

	public Ingredient(Dish dish, List<IngredientItem> item) {
		super();
		this.dish = dish;
		this.item = item;
	}

}
