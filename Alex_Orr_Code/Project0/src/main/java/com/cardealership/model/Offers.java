package com.cardealership.model;

public class Offers {
	private int carId;
	private int userId;
	private int offerAmount;
	public Offers(int carId, int userId, int offerAmount) {
		super();
		this.carId = carId;
		this.userId = userId;
		this.offerAmount = offerAmount;
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
	public int getOfferAmount() {
		return offerAmount;
	}
	public void setOfferAmount(int offerAmount) {
		this.offerAmount = offerAmount;
	}
	@Override
	public String toString() {
		return "Offers [carId=" + carId + ", userId=" + userId + ", offerAmount=" + offerAmount + "]";
	}
	
	
}
