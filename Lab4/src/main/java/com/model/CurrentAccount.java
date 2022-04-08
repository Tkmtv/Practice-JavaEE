package com.model;

public class CurrentAccount implements UserAccount {

	private String user_id;
	private String customer_id;
	private String user_password;
	private String user_name;
	private String address;
	private String phone;
	private String account_number;
	private Double balance;
	private String[] transactions = new String[3];
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getAccount_type() {
		return "current";
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void setTransaction(String transaction, int i) {
		this.transactions[i] = transaction;
	}


	@Override
	public String getTransaction(int i) {
		return transactions[i];
	}
	
	@Override
	public Double getCurrentBalance() {
		return this.balance;
	}
	
	@Override
	public String toString() {
		return "Current Account [id=" + user_id + ", customer_id=" + customer_id + ", user_password=" + user_password
				+ ", user_name=" + user_name + ", address=" + address + ", phone=" + phone + ", account_number="
				+ account_number + ", account_type= saving, balance=" + balance + "]";
	}


}
