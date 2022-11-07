package com.lvin.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lvin.backend.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

	List<Stock> findByNameContaining(String search);
}
