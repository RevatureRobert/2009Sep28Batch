package com.project0.models;

public class Offer {
	
	private double amount;
	private int personID;
	private int carID;
	private int offerID;
	
	public Offer(int offerID, int personID, int carID, double amount) {
		this.offerID = offerID;
		this.personID = personID;
		this.carID = carID;
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}
	
	public int getPersonID() {
		return personID;
	}
	
	public int getCarID() {
		return carID;
	}
	
	public int getOfferID() {
		return offerID;
	}

}
