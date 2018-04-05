package com.webhook.app.controller;


/*Author : Hitesh Gupta
 * 
 */
public class PaymentNotificationResource {
	


	private String id;	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAction_id() {
		return action_id;
	}
	public void setAction_id(String action_id) {
		this.action_id = action_id;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	private String action_id;	
	private String href;

	@Override
	public String toString() {
		return "PaymentNotificationResource [id=" + id + ", action_id=" + action_id + ", href=" + href + "]";
	}
	

}
