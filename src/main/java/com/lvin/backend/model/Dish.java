package com.lvin.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private float price;
	private String image;

	public Dish(String name, float price, String image) {
		this.name = name;
		this.price = price;
		this.image = image;
	}

}
