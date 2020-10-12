package com.dealership.model;

public class Car {
	private int id;
	private String make;
	private String model;
	private int year;
	private int mpg;
	private int price;
	
	public Car() {}
	
	public Car(int id, String make, String model, int year, int mpg, int price) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.mpg = mpg;
		this.price = price;
	}
	
	public Car(String make, String model, int year, int mpg, int price) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.mpg = mpg;
		this.price = price;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public int getYear() {
		return this.year;
	}

	public int getMpg() {
		return this.mpg;
	}
	
	public int getPrice() {
		return this.price;
	}

	@Override
	public String toString() {
		return String.format("Car ID: %d | Make: %s | Model: %s | Year: %s | MPG: %s | Price: $%s",
				id, make, model, year, mpg, price);
	}
}
