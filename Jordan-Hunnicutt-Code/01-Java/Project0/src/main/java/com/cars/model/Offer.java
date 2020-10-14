package com.cars.model;

import java.sql.Date;

public class Offer {

	private int amount;
	private int carId;
	private int userId;
	private String status;
	private Date addDate;
	private Date appOrRejDate;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public Date getAppOrRejDate() {
		return appOrRejDate;
	}
	public void setAppOrRejDate(Date appOrRejDate) {
		this.appOrRejDate = appOrRejDate;
	}
	
	public Offer() {
		super();
	}
	
	public Offer(int amount, int carId, int userId, String status, Date addDate, Date appOrRejDate) {
		this.amount = amount;
		this.carId = carId;
		this.userId = userId;
		this.status = status;
		this.addDate = addDate;
		this.appOrRejDate = appOrRejDate;
	}
	
	
	
	
}
