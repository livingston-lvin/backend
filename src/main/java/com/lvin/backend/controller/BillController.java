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

import com.lvin.backend.model.Bill;
import com.lvin.backend.model.BillItem;
import com.lvin.backend.repository.BillItemRepository;
import com.lvin.backend.repository.BillRepository;

@CrossOrigin
@RestController
@RequestMapping("bill")
public class BillController {

	@Autowired
	private BillRepository rep;

	@Autowired
	private BillItemRepository br;

	@GetMapping("all")
	public List<Bill> getAll() {
		List<Bill> bill = rep.findAll();
		return bill;
	}

	@PutMapping
	public ResponseEntity<Bill> update(@RequestBody Bill bill) {
		Bill updatedBill = rep.save(bill);
		return new ResponseEntity<Bill>(updatedBill, HttpStatus.OK);
	}

	@GetMapping("{billId}")
	public Bill getIngredient(@PathVariable int billId) {
		Optional<Bill> bill = rep.findById(billId);
		Bill i = bill.get();
		return i;
	}

	@DeleteMapping("{billId}")
	public HttpStatus delete(@PathVariable int billId) {
		Optional<Bill> bill = rep.findById(billId);
		if (bill.isEmpty()) {
			return HttpStatus.BAD_REQUEST;
		}
		rep.delete(bill.get());
		return HttpStatus.OK;
	}

	@PostMapping
	public Bill create(@RequestBody Bill bill) {
		List<BillItem> billItem = bill.getBillItem();
		br.saveAll(billItem);
		Bill bi = rep.save(bill);
		return bi;
	}

}
