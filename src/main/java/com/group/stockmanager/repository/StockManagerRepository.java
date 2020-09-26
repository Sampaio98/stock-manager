package com.group.stockmanager.repository;

import com.group.stockmanager.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockManagerRepository extends JpaRepository<Stock, String> {
}
