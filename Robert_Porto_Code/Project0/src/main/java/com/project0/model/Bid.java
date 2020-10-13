package com.project0.model;

public class Bid {

	private int id;

	private int carId;
	private int customerId;
	private int amount;

	public int getId() {
		return id;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Bid(int carId, int customerId, int amount) {
		super();
		this.carId = carId;
		this.customerId = customerId;
		this.amount = amount;
	}

	public Bid(int id, int carId, int customerId, int amount) {
		super();
		this.id = id;
		this.carId = carId;
		this.customerId = customerId;
		this.amount = amount;
	}

}
