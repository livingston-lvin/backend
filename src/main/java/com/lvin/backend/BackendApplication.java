package com.lvin.backend;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lvin.backend.model.Dish;
import com.lvin.backend.model.Ingredient;
import com.lvin.backend.model.IngredientItem;
import com.lvin.backend.model.Stock;
import com.lvin.backend.repository.BillRepository;
import com.lvin.backend.repository.DishRepository;
import com.lvin.backend.repository.IngredientRepository;
import com.lvin.backend.repository.StockRepository;

@SpringBootApplication
public class BackendApplication {

	@Autowired
	private StockRepository sr;

	@Autowired
	private DishRepository dr;

	@Autowired
	private IngredientRepository ir;

	@Autowired
	private BillRepository br;

	@PostConstruct
	public void init() {
//		List<Stock> stocks = IntStream.rangeClosed(1, 5)
//				.mapToObj(obj -> new Stock("Stock " + obj, new Random().nextInt(50))).collect(Collectors.toList());
//
//		sr.saveAll(stocks);
//		List<Dish> dishes = IntStream.rangeClosed(1, 5)
//				.mapToObj(obj -> new Dish("Dish " + obj, new Random().nextInt(1000), "img_" + obj))
//				.collect(Collectors.toList());
//		dr.saveAll(dishes); 
//		List<Item> items = IntStream.rangeClosed(1, 10)
//				.mapToObj(i -> new Item(sr.findById(new Random().nextInt(50)).get(), new Random().nextInt(30)))
//				.collect(Collectors.toList());
//		List<Ingredient> ingredients = IntStream.rangeClosed(101, 200)
//				.mapToObj(obj -> new Ingredient(dr.findById(obj).get(), items.subList(new Random().nextInt(10), new Random().nextInt(20))))
//				.collect(Collectors.toList());
//		ir.saveAll(ingredients);
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
