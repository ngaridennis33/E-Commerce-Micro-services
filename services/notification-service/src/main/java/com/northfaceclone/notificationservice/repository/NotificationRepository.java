package com.northfaceclone.notificationservice.repository;

import com.northfaceclone.notificationservice.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
