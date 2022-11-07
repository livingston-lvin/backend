package com.lvin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lvin.backend.model.BillItem;

@Repository
public interface BillItemRepository extends JpaRepository<BillItem, Integer> {

}
