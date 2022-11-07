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
public class Stock {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int quantity;
	
	public Stock(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}
	
	
}
