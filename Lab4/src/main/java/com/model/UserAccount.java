package com.model;

public interface UserAccount {

	public String getUser_id();

	public String getUser_name();
	
	public String getUser_password();

	public String getAddress();

	public String getPhone();

	public String getAccount_number();

	public String getAccount_type();

	public Double getCurrentBalance();

	public String getTransaction(int i);
}
