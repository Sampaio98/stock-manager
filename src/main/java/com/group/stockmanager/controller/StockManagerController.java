package com.group.stockmanager.controller;

import com.group.stockmanager.model.Stock;
import com.group.stockmanager.repository.StockManagerRepository;
import com.group.stockmanager.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/stock")
public class StockManagerController {

    @Autowired
    private StockManagerRepository repository;

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<Stock>> findAllStock() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Stock> createStock(@Valid @RequestBody Stock stock) {
        Stock stockSaved = repository.save(stock);
        notificationService.sendNotification();
        return ResponseEntity.status(CREATED).body(stockSaved);
    }

}
