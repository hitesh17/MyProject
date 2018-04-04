package com.webhook.app.controller;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface NotificationRepository extends MongoRepository<PaymentNotificationEvent, String> {
	
	
	PaymentNotificationEvent save(PaymentNotificationEvent save); 
	
	 PaymentNotificationEvent findOne(String id);

}
