package com.data;

public class Item {
	
	private String name;
	private long price;
	private String imageURL;
		
	public Item(String name, long price, String imageURL) {
		super();
		this.name = name;
		this.price = price;
		this.imageURL = imageURL;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	
	
}