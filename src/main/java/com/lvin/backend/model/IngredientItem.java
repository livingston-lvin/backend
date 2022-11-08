package com.lvin.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class IngredientItem {

	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	private Stock stock;
	private int quantityUsed;
	public IngredientItem(Stock stock, int quantityUsed) {
		super();
		this.stock = stock;
		this.quantityUsed = quantityUsed;
	}
	
	

}
