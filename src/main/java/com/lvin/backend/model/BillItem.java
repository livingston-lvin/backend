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
public class BillItem {

	@Id
	@GeneratedValue
	private int id;
	private float price;
	private int quantity;
	private float amount;
	@OneToOne
	private Dish dish;

	public BillItem(float price, int quantity, float amount, Dish dish) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.amount = amount;
		this.dish = dish;
	}

}