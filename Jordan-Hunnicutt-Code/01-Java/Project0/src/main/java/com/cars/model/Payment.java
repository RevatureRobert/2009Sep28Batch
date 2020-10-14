package com.cars.model;

import java.sql.Date;

public class Payment {

	private int amount;
	private int num_of;
	private int carId;
	private int userId;
	private Date purchaseDate;
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
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
	public int getNumOf() {
		return num_of;
	}
	public void setNumOf(int num_of) {
		this.num_of = num_of;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	public Payment() {
		super();
	}
	
	public Payment(int amount, int num_of, int carId, int userId, Date purchaseDate) {
		this.amount = amount;
		this.num_of = num_of;
		this.carId = carId;
		this.userId = userId;
		this.purchaseDate = purchaseDate;
	}
	
	
}
