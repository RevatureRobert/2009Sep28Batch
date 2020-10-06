package com.cars.model;

import java.util.ArrayList;
import java.util.List;

public class Car {

	private String make;
	private String model;
	private int year;
	private int carId;
	private List<Double> offerAmounts = new ArrayList<>();
	private List<Integer> offerIds = new ArrayList<>(); //foreign key to user
	private List<Double> paymentAmounts = new ArrayList<>();
	
	public Car() {
		make = "Buick";
		model = "Terraza";
		year = 2005;
		carId = 0;
	}
	
	public Car(String make, String model, int year) {
		this.make = make;
		this.model = model;
		setYear(year);
		carId = 0;
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
		if(year < 1885) {
			System.out.println("Please type in a valid year. (After 1885)");
			//according to Amazon Echo, the first "modern" motor car was invented in 1886
		} else {
			this.year = year;
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
	
}
