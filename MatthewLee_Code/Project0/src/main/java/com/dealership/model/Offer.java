package com.dealership.model;

public class Offer {

	private int offerId;
	private int amount;
	private int months;
	private int accepted;
	private int customerId;
	private int carId;
	
	public Offer(int offerId, int amount, int months, int accepted, int customerId, int carId) {
		this.offerId = offerId;
		this.amount = amount;
		this.months = months;
		this.accepted = accepted;
		this.customerId = customerId;
		this.carId = carId;
	}
	
	public Offer(int amount, int months, int customerId, int carId) {
		this.amount = amount;
		this.months = months;
		this.customerId = customerId;
		this.carId = carId;
	}
	
	public int getOfferId() {
		return offerId;
	}

	public int getAmount() {
		return amount;
	}

	public int getMonths() {
		return months;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public int getCarId() {
		return carId;
	}
	
	public String printOfferStatus() {
		String status = "";
		switch (accepted) {
		case 0:
			status = "Pending";
			break;
		case 1:
			status = "Accepted";
			break;
		case -1:
			status = "Rejected";
			break;
		}
		
		return String.format("Offer ID: %d | Customer ID: %d | Car ID: %d | "
				+ "Monthly Payments: %d | Amount: $%d | Status: %s",
				offerId, customerId, carId, months, amount, status);
	}

	@Override
	public String toString() {
		return String.format("Offer ID: %d | Customer ID: %d | Car ID: %d | Monthly Payments: %d | Amount: $%d",
				offerId, customerId, carId, months, amount);
	}
	
}
