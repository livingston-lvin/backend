package com.lvin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lvin.backend.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {


}
