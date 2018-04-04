package com.webhook.app.controller;

import org.springframework.data.annotation.Id;

public class PaymentNotificationEvent {
	
	     @Id
	    private String id;
	     private String event_type;
		
		 private String created;
		
		 private String account_id;
		
		 private String app_id;
		 
		 private PaymentNotificationResource resource;

		public PaymentNotificationResource getResource() {
			return resource;
		}

		public void setResource(PaymentNotificationResource resource) {
			this.resource = resource;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getEvent_type() {
			return event_type;
		}

		public void setEvent_type(String event_type) {
			this.event_type = event_type;
		}

		public String getCreated() {
			return created;
		}

		public void setCreated(String created) {
			this.created = created;
		}

		public String getAccount_id() {
			return account_id;
		}

		public void setAccount_id(String account_id) {
			this.account_id = account_id;
		}

		public String getApp_id() {
			return app_id;
		}

		public void setApp_id(String app_id) {
			this.app_id = app_id;
		}

		@Override
		public String toString() {
			return "PaymentNotificationEvent [id=" + id + ", event_type=" + event_type + ", created=" + created
					+ ", account_id=" + account_id + ", app_id=" + app_id + ", resource=" + resource + "]";
		}
		
	 

}
