package com.carsales.model;

public class Auto {
	
	int car_id;
	int year;
	String make;
	String model;
	int mileage;
	int price;
	String owner;
	
	
	public Auto(int yea, String make, String model, int mileage, int price) {
		this.year = yea;
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.price = price;
	}
	public Auto(int id, int yea, String make, String model, int mileage, int price, String own) {
		this.car_id = id;
		this.year = yea;
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.price = price;
		this.owner = own;
	}
	
	public Auto() {
		super();
	}
	
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	

}
