package com.group.stockmanager.controller;

import com.group.stockmanager.model.Notification;
import com.group.stockmanager.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationRepository repository;

    @PostMapping
    public ResponseEntity<?> registerAPI(@Valid @RequestBody Notification notification) {
        Notification notificationSaved = repository.save(notification);
        return ResponseEntity.status(CREATED).body(notificationSaved);
    }
}
