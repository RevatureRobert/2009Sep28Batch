package com.project.model;

public class Offer {
	
	private int offerId;
	private int customerId;
	private int carId;
	private int offerAmount;
	
	public Offer() {
		this.offerId=-1;
	}
	
	public Offer(int offerId, int customerId, int carId, int offerAmount) {
		this.offerId = offerId;
		this.customerId = customerId;
		this.carId = carId;
		this.offerAmount = offerAmount;
	}
	
	public Offer(int customerId, int carId, int offerAmount) {
		this.customerId = customerId;
		this.carId = carId;
		this.offerAmount = offerAmount;
	}
	
//	public Offer() {
//	}

	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getOfferAmount() {
		return offerAmount;
	}
	public void setOfferAmount(int offerAmount) {
		this.offerAmount = offerAmount;
	}
	
	@Override
	public String toString() {
		return ("Offer #"+this.offerId+" | Offer on car #"+this.carId+" | Offer amount: $"+this.offerAmount+" | Offered by customer #"+this.customerId);
	}

	
}
