package com.qa.POJOclass;

import java.util.Arrays;

import org.apache.juneau.annotation.Beanc;

public class Product {
	
	private String name;
	private String color;
	private int price;
	private String [] sellerNames;
	
	/**
	 * @param name
	 * @param color
	 * @param price
	 * @param sellerNames
	 */
	//constructor
	//this annotaion will show how your json name look like
	@Beanc(properties = "name, color, price, sellerNames")
	public Product(String name, String color, int price, String[] sellerNames) {
		
		this.name = name;
		this.color = color;
		this.price = price;
		this.sellerNames = sellerNames;
	}
	
	
	//getters and setters 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String[] getSellerNames() {
		return sellerNames;
	}
	public void setSellerNames(String[] sellerNames) {
		this.sellerNames = sellerNames;
	}


	@Override
	public String toString() {
		return "Product [name=" + name + ", color=" + color + ", price=" + price + ", sellerNames="
				+ Arrays.toString(sellerNames) + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
