package com.cars.model;

public class Payment {

	private double amount;
	private int payId;
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
	public double getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	
	public Payment() {
		super();
	}
	
	public Payment(double amount, int carId, int userId) {
		this.amount = amount;
		this.carId = carId;
		this.userId = userId;
	}
	
	
}
