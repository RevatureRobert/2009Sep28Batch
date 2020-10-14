package com.dealership.pojos;

public abstract class Car {
	private int carId;
	
	private String color;
	private int year;
	private String make;
	private String model;
	
	public Car() {
		
	}
	
	public Car(int carId, String color, int year, String make, String model) {
		super();
		this.carId = carId;
		this.setColor(color);
		this.make = make;
		this.model = model;
		this.year = year;
	}
	
	
		
	public int getCarId() {
		return carId;
	}
	
	public void setCarId(int carId) {
		this.carId = carId;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
