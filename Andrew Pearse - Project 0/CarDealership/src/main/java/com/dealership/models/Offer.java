package com.dealership.models;

public class Offer {

	private int offerID;
	private int downPayment;
	private int monthsLeft;
	private boolean accepted;
	private boolean rejected;
	private String username;
	private Car car;

	/**
	 * creates a new offer for a specific car
	 * @param downPayement
	 * @param monthsLeft
	 * @param accepted
	 * @param rejected
	 * @param username
	 * @param cid
	 */
	public Offer(int downPayement, int monthsLeft, String username, Car car) {
		super();
		this.monthsLeft = monthsLeft;
		this.downPayment = downPayement;
		this.accepted = false;
		this.rejected = false;
		this.username = username;
		this.car = car;
	}
	
	/**
	 * retrieves offer information from the database
	 * @param offerID
	 * @param downPayment
	 * @param monthsLeft
	 * @param accepted
	 * @param rejected
	 * @param username
	 */
	public Offer(int offerID, int downPayment, int monthsLeft, boolean accepted, boolean rejected, String username) {
		this.offerID = offerID;
		this.downPayment = downPayment;
		this.monthsLeft = monthsLeft;
		this.accepted = accepted;
		this.rejected = rejected;
		this.username = username;
	}
	
	/**
	 * retrieves offer with car information from the database
	 * @param offerID
	 * @param downPayment
	 * @param monthsLeft
	 * @param accepted
	 * @param rejected
	 * @param username
	 */
	public Offer(int offerID, int downPayment, int monthsLeft, boolean accepted, boolean rejected, String username, Car car) {
		this.offerID = offerID;
		this.downPayment = downPayment;
		this.monthsLeft = monthsLeft;
		this.accepted = accepted;
		this.rejected = rejected;
		this.username = username;
		this.car = car;
	}
	
	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public boolean isRejected() {
		return rejected;
	}

	public void setRejected(boolean rejected) {
		this.rejected = rejected;
	}

	public int getDownPayment() {
		return downPayment;
	}

	public void setDownPayment(int downPayment) {
		this.downPayment = downPayment;
	}

	public int getMonthsLeft() {
		return monthsLeft;
	}
	
	public void setMonthsLeft(int monthsLeft) {
		this.monthsLeft = monthsLeft;
	}

	public int getOfferID() {
		return offerID;
	}

	public void setOfferID(int offerID) {
		this.offerID = offerID;
	}

	public String getOfferer() {
		return username;
	}

	public void setOfferer(String username) {
		this.username = username;
	}

	public Car getOfferedFor() {
		return car;
	}

	public void setOfferedFor(Car car) {
		this.car = car;
	}
	

	@Override
	public String toString() {
		int amountLeft = car.getPrice() - getDownPayment();
		int monthlyPayments = amountLeft / getMonthsLeft();
		
		return car.getMake() + " " + car.getModel() + "\nAmount Left: $" + amountLeft 
				+ "\nMonths Left: " + getMonthsLeft() + "\nMonthly Payment: $" + monthlyPayments + "\n";
	}


	
}
