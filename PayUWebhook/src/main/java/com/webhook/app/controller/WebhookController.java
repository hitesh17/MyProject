package com.webhook.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@RestController
public class WebhookController {

	
	
	@Autowired
	private NotificationRepository repository;
	
	    @RequestMapping(value="/notify",method = RequestMethod.POST)
	    @ResponseStatus(HttpStatus.CREATED)
	    PaymentNotificationEvent create(@RequestBody  PaymentNotificationEvent event) {
	       
	       

	        PaymentNotificationEvent created = repository.save(event);
	        
	        System.out.println("Event created" + created.toString());
	   

	        return created;
	    }
	    
	    @RequestMapping(value = "{id}", method = RequestMethod.GET)
	    PaymentNotificationEvent findById(@PathVariable("id") String id) {
	        
	        System.out.println("Inside the  findById" + id);

	        PaymentNotificationEvent eventEntry = repository.findOne(id);
	        System.out.println("Event value" + eventEntry.toString());

	        return eventEntry;
	    }

}
