package com.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.*;

public class UserDAO {
	private String dbURL;
	private String dbName;
	private String username;
	private String password;
	private String url;
	private Connection con;
	private Statement stm;
	private ResultSet res;

	public UserDAO() {
		this.dbURL = "jdbc:mysql://127.0.0.1:3306/";
		this.dbName = "bankdb";
		this.username = "admin";
		this.password = "123456";
		this.url = this.dbURL + this.dbName;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection(this.url, this.username, this.password);
			this.stm = this.con.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found " + e);
		} catch (SQLException e) {
			System.out.println("Connect not possible" + e);
		}

	}

	public Customer getCustomer(String customerID, String password) {
		Customer cus = new Customer();
		try {
			String query = "Select * from customer Where customer_id='" + customerID + "' and customer_pwd='" + password
					+ "';";
			this.res = stm.executeQuery(query);
			if (!this.res.next()) {
				cus = null;
				System.out.println("not found db");
			} else {
				System.out.println("found db");
				cus.setCustomer_id(this.res.getString("customer_id"));
				cus.setCustomer_pwd(this.res.getString("customer_pwd"));
			}
			this.stm.close();
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return cus;
	}

	public void registAccount(String customer_id, String user_id, String user_password, String user_name,
			String address, String phone, String user_type, String user_number) {
		try {
			System.out.println("executing");
			String query = "insert into user_auth (user_id, customer_id, user_password, user_name, address, phone, account_number, account_type) value"
					+ "('" + user_id + "','" + customer_id + "','" + user_password + "','" + user_name + "','" + address
					+ "','" + phone + "','" + user_number + "','" + user_type + "');";
			stm.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void registSaving(String user_id, double balance, double rate, int duration) {
		try {
			String query = "insert into savings_acc (user_id, balance, duration, rate) value" + "('" + user_id + "','"
					+ balance + "','" + rate + "','" + duration + "');";
			stm.executeUpdate(query);
			this.stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void registCurrent(String user_id, double balance) {
		try {
			String query = "insert into current_acc (user_id, balance) value" + "('" + user_id + "','" + balance
					+ "');";
			stm.executeUpdate(query);
			this.stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public SavingAccount getSavingAccount(String u_name, String pwd) {
		try {
			String query = "select * from user_auth join savings_acc on user_auth.user_id = savings_acc.user_id where user_auth.user_name  = '"
					+ u_name + "' and user_auth.user_password ='" + pwd + "';";
			this.res = stm.executeQuery(query);

			if (!this.res.next()) {
				System.out.println("not found saving");
				this.stm.close();
				con.close();
				return null;
			} else {
				System.out.println("found saving");

				SavingAccount acc = new SavingAccount();
				acc.setUser_id(this.res.getString("user_id"));
				acc.setCustomer_id(this.res.getString("user_id"));
				acc.setUser_password(this.res.getString("user_password"));
				acc.setUser_name(this.res.getString("user_name"));
				acc.setAddress(this.res.getString("address"));
				acc.setPhone(this.res.getString("phone"));
				acc.setAccount_number(this.res.getString("account_number"));
				acc.setBalance(this.res.getDouble("balance"));
				acc.setDuration(this.res.getInt("duration"));
				acc.setRate(this.res.getDouble("rate"));

				query = "select * from transaction where sender = '" + acc.getUser_id() + "' or receiver = '"+ acc.getUser_id() + "' order by time desc limit 3;";
				System.out.println(query);
				this.res = stm.executeQuery(query);
				int i = 0;
				while (res.next()) {
					String receiver = this.res.getString("receiver");
					double amount = this.res.getDouble("amount");
					String transacDate = this.res.getString("time");
					
					acc.setTransaction("receiver: " +receiver + ", amount: " + amount + ", time: " + transacDate, i);
					i++;
				}

				this.stm.close();
				con.close();
				return acc;
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

	public CurrentAccount getCurrentAccount(String u_name, String pwd) {
		try {
			String query = "select * from user_auth join current_acc on user_auth.user_id = current_acc.user_id where user_auth.user_name = '"
					+ u_name + "' and user_auth.user_password ='" + pwd + "';";
			this.res = stm.executeQuery(query);

			if (!this.res.next()) {
				System.out.println("not found current");
				this.stm.close();
				con.close();
				return null;

			} else {
				System.out.println("found current");

				CurrentAccount acc = new CurrentAccount();
				acc.setUser_id(this.res.getString("user_id"));
				acc.setCustomer_id(this.res.getString("user_id"));
				acc.setUser_password(this.res.getString("user_password"));
				acc.setUser_name(this.res.getString("user_name"));
				acc.setAddress(this.res.getString("address"));
				acc.setPhone(this.res.getString("phone"));
				acc.setAccount_number(this.res.getString("account_number"));
				acc.setBalance(this.res.getDouble("balance"));

				query = "select * from transaction where sender = '" + acc.getUser_id() + "' or receiver = '"+ acc.getUser_id() + "' order by time desc limit 3;";
				System.out.println(query);
				this.res = stm.executeQuery(query);
				int i = 0;
				while (res.next()) {
					String receiver = this.res.getString("receiver");
					double amount = this.res.getDouble("amount");
					String transacDate = this.res.getString("time");
					
					acc.setTransaction("receiver: " +receiver + ", amount: " + amount + ", time: " + transacDate, i);
					i++;
				}
				this.stm.close();
				con.close();
				return acc;
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

	public void transferFromSaving(String sender, double senderBalance, String receiver, double receiverBalance,
			String r_type, double amount, String date) {

		String query = "update savings_acc" + " set balance =" + senderBalance + " where user_id = '" + sender
				+ "';";
		try {
			stm.executeUpdate(query);
			query = "update " + r_type + "_acc" + " set balance =" + receiverBalance + " where user_id = '"
					+ receiver + "';";
			stm.executeUpdate(query);
			query = "insert into `transaction` (sender, receiver, amount, time) value('" + sender + "','" + receiver
					+ "'," + amount + ", '" + date + "');";
			stm.executeUpdate(query);
			this.stm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void transferFromCurrent(String sender, double senderBalance, String receiver, double receiverBalance,
			String r_type, double amount, String date) {

		String query = "update current_acc" + " set balance =" + senderBalance + " where user_id = '" + sender
				+ "';";
		try {
			stm.executeUpdate(query);
			query = "update " + r_type + "_acc" + " set balance =" + receiverBalance + " where user_id = '"
					+ receiver + "';";
			stm.executeUpdate(query);
			query = "insert into `transaction` (sender, receiver, amount, time) value('" + sender + "','" + receiver
					+ "'," + amount + ", '" + date + "');";
			stm.executeUpdate(query);
			this.stm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public double checkSavingAccountBalance(String u_id) {
		try {
			String query = "select balance, duration, rate from savings_acc where savings_acc.user_id  = '" + u_id
					+ "';";
			this.res = stm.executeQuery(query);

			if (!this.res.next()) {
				System.out.println("not found saving");
				this.stm.close();
				con.close();
				return -1;
			} else {
				System.out.println("found saving");

				double balance = this.res.getDouble("balance");
				double duration = this.res.getInt("duration");
				double rate = this.res.getDouble("balance");
				balance = (balance * (1 - rate) * duration);

				this.stm.close();
				con.close();
				return balance;
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return -1;
	}

	public double checkCurrentAccountBalance(String u_id) {
		try {
			String query = "select balance from current_acc where current_acc.user_id  = '" + u_id + "';";
			this.res = stm.executeQuery(query);

			if (!this.res.next()) {
				System.out.println("not found current");
				this.stm.close();
				con.close();
				return -1;
			} else {
				System.out.println("found current");

				double balance = this.res.getDouble("balance");

				this.stm.close();
				con.close();
				return balance;
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return -1;
	}

}