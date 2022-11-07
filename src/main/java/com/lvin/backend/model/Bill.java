package com.lvin.backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

	@Id
	@GeneratedValue
	private int id;
	private int tableNo;
	private float totalAmount;
	@OneToMany
	private List<BillItem> billItem = new ArrayList<>();

}
