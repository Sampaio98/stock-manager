package com.group.stockmanager.config;

import com.group.stockmanager.model.Stock;
import com.group.stockmanager.repository.StockManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class StockConfig {

    @Autowired
    private StockManagerRepository repository;

    @Bean
    public void populateData() {
        Stock stock = Stock.builder()
                .id("petr3")
                .description("petre3 stock")
                .build();

        Stock stock2 = Stock.builder()
                .id("vale5")
                .description("vale5 stock")
                .build();
        repository.saveAll(Arrays.asList(stock, stock2));
    }
}
