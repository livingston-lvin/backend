package com.lvin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lvin.backend.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

}
