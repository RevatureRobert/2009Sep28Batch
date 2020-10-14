package com.model;

import java.util.ArrayList;

public class Car 
{
	private int carID;
	private String brand;
	private String color;
	private String year;
	private double price;
	private String owner;
	
	//Constructor: Provide details of the car when adding the car to the lot
	
	public Car(String brand, String color, String year, double price, String owner, int carID) {
		super();
		this.carID = carID;
		this.brand = brand;
		this.color = color;
		this.year = year;
		this.price = price;
		this.owner = owner;
	}

	// Generate getters and setters
	
	@Override
	public String toString() {
		return "Car Details: brand= " + brand + ", color= " + color + ", year= " + year + ", price= " + price + ", owner= " + owner + ", carID= " + carID + "\n\n";
	}
	
	public String toStringCarsOnLot()
	{
		return "Cars on Lot: \n" + "Brand = " + brand + ", color = " + color + ", year= " + year + ", price = " + price + ", owner = " + owner + ", carID= " + carID +"\n";
	}
	
	public String toString(Car t)
	{
		return "Car with identification number ";
	}

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
	
	
	
	
	
	
	
	
}
