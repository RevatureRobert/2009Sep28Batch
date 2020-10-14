package com.cars.model;

import java.util.ArrayList;
import java.util.List;

public class Car {

	private String make;
	private String model;
	private String color;
	private int carYear;
	private int carId;
	private int listPrice;
	private int userId;
	
	
	public Car() {
		make = "Buick";
		model = "Terraza";
		color = "gold";
		carYear = 2005;
		carId = 0;
		listPrice = 2200;
	}
	
	public Car(int carId, String make, String model, String color, int year, int listPrice, int userId) {
		this.carId = carId;
		this.make = make;
		this.model = model;
		this.color = color;
		this.carYear = year;
		this.listPrice = listPrice;
		this.userId = userId;
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
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getYear() {
		return carYear;
	}

	public void setYear(int year) {
		if(year < 1885) {
			System.out.println("Please type in a valid year. (After 1885)");
			//according to Amazon Echo, the first "modern" motor car was invented in 1886
		} else {
			this.carYear = year;
		}
		
		
	}
	
	public int getCarId() {
		return carId;
	}
	
	public void setCarId(int carId) {
		if(carId < 0) {
			System.out.println("Please type in a valid ID (Non-negative)");
		} else {
			this.carId = carId;
		}
	}

	public int getListPrice() {
		return listPrice;
	}

	public void setListPrice(int listPrice) {
		this.listPrice = listPrice;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
}
