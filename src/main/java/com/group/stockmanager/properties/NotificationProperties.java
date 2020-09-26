package com.group.stockmanager.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class NotificationProperties {

    @Value("${notification.url.format}")
    public String notificationUrlFormat;
}
