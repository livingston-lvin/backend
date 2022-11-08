package com.lvin.backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "bill_id", referencedColumnName = "id")
	private List<BillItem> billItem = new ArrayList<>();

	public Bill(int tableNo, float totalAmount, List<BillItem> billItem) {
		super();
		this.tableNo = tableNo;
		this.totalAmount = totalAmount;
		this.billItem = billItem;
	}

}
