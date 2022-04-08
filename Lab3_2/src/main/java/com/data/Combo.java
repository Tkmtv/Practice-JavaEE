package com.data;

import java.util.*;

public class Combo {
	
	private String id;
	private String name;
	private double discount;
	private List<Item> items;
	private double calculatePrice = 0;
	
	public Combo(String id, String name, double discount, List<Item> items) {
		super();
		this.id = id;
		this.name = name;
		this.discount = discount;
		this.items = items;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(Item item, int amount) {
		this.items.add(item);
	}
	
	public double getCalculatePrice() {
		double price = 0;
		for (Item item : items) {
			price += item.getPrice();
		}
		return price * (1 - discount);
	}
}

