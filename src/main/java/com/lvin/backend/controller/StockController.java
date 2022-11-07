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

import com.lvin.backend.model.Stock;
import com.lvin.backend.repository.StockRepository;

@CrossOrigin
@RestController
@RequestMapping("stock")
public class StockController {

	@Autowired
	private StockRepository rep;

	@GetMapping("all")
	public List<Stock> getStocks() {
		List<Stock> stocks = rep.findAll();
		return stocks;
	}

	@PostMapping
	public Stock create(@RequestBody Stock stock) {
		System.out.println(stock.toString());
		Stock s = rep.save(stock);
		return s;
	}

	@PutMapping
	public ResponseEntity<Stock> update(@RequestBody Stock stock) {
		Stock updatedStock = rep.save(stock);
		return new ResponseEntity<Stock>(updatedStock, HttpStatus.OK);
	}

	@GetMapping("{stockId}")
	public Stock getDish(@PathVariable int stockId) {
		Optional<Stock> stock = rep.findById(stockId);
		Stock s = stock.get();
		return s;
	}

	@DeleteMapping("{stockId}")
	public HttpStatus deleteDish(@PathVariable int stockId) {
		try {
			rep.findById(stockId).get();
			rep.deleteById(stockId);
			return HttpStatus.OK;
		} catch (Exception e) {
			return HttpStatus.BAD_REQUEST;
		}
	}
	
	@GetMapping("filter/{search}")
	public List<Stock> getFilteredStock(@PathVariable String search) {
		List<Stock> stocks = rep.findByNameContaining(search);
		if (stocks.isEmpty())
			return new ArrayList<>();
		else
			return stocks;
	}
	
	@GetMapping("get/{offset}/{size}")
	public Page<Stock> getStockByNo(@PathVariable int offset,@PathVariable int size){
		Page<Stock> stocks = rep.findAll(PageRequest.of(offset, size));
		return stocks;
	}
}
