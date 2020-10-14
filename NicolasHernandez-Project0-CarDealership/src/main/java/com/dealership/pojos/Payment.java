package com.dealership.pojos;

import java.sql.Timestamp;

public class Payment {
	private int carId;
	private String ownerId;
	private Timestamp payDate;
	private float payAmount;
	private boolean isDownPayment;
	
	
	public Payment(int carId, String ownerId, Timestamp payDate, float payAmount, boolean isDownPayment) {
		super();
		this.carId = carId;
		this.ownerId = ownerId;
		this.payDate = payDate;
		this.payAmount = payAmount;
		this.isDownPayment = isDownPayment;
	}


	
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public Timestamp getPayDate() {
		return payDate;
	}
	public void setPayDate(Timestamp payDate) {
		this.payDate = payDate;
	}
	public float getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(float payAmount) {
		this.payAmount = payAmount;
	}
	public boolean isDownPayment() {
		return isDownPayment;
	}
	public void setDownPayment(boolean isDownPayment) {
		this.isDownPayment = isDownPayment;
	}
}
