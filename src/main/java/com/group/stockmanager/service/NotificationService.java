package com.group.stockmanager.service;

import com.group.stockmanager.model.Notification;
import com.group.stockmanager.properties.NotificationProperties;
import com.group.stockmanager.repository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.List;

@Slf4j
@Service
public class NotificationService {

    @Autowired
    private NotificationProperties properties;

    @Autowired
    private NotificationRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification() {
        List<Notification> notifications = repository.findAll();
        for (Notification notification : notifications) {
            String notificationUrlFormat = properties.getNotificationUrlFormat();
            String url = MessageFormat.format(notificationUrlFormat, notification.getHost(), notification.getPort());
            try {
                restTemplate.delete(url);
            } catch (Exception e) {
                log.info(e.getMessage());
            }
        }
    }
}
