package com.cars.model;

public class Offer {

	private double amount;
	private int offId;
	private int carId;
	private int userId;
	
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getOffId() {
		return offId;
	}
	public void setOffId(int offId) {
		this.offId = offId;
	}
	
	public Offer() {
		super();
	}
	
	public Offer(double amount, int carId, int userId) {
		this.amount = amount;
		this.carId = carId;
		this.userId = userId;
	}
	
	
	
	
}
