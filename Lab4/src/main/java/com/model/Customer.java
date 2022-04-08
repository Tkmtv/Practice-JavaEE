package com.model;

public class Customer {
	private String customer_id;
	private String customer_pwd;
	
	public String getCustomer_id() {
		return customer_id;
	}
	
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	
	public String getCustomer_pwd() {
		return customer_pwd;
	}
	public void setCustomer_pwd(String customer_pwd) {
		this.customer_pwd = customer_pwd;
	}

	@Override
	public String toString() {
		return "customer [customerID=" + customer_id + ", customer_pwd=" + customer_pwd + "]";
	}
	
	
	
	
}
