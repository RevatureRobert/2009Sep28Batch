package com.dealership.pojos;

public class Offer {
	private int carId;
	private String customerId;
	private float offerAmount;
	private float downPayment;
	private int loanTermInMonths;
	private float yearlyInterest;
	
	public Offer(int carId, String customerId, float offerAmount, float downPayment, int loanTermInMonths, float yearlyInterest) {
		super();
		this.setCarId(carId);
		this.setCustomerId(customerId);
		this.setOfferAmount(offerAmount);
		this.setDownPayment(downPayment);
		this.setLoanTermInMonths(loanTermInMonths);
		this.setYearlyInterest(yearlyInterest);
	}
	
	
	
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public float getOfferAmount() {
		return offerAmount;
	}
	public void setOfferAmount(float offerAmount) {
		this.offerAmount = offerAmount;
	}
	public float getDownPayment() {
		return downPayment;
	}
	public void setDownPayment(float downPayment) {
		this.downPayment = downPayment;
	}
	public int getLoanTermInMonths() {
		return loanTermInMonths;
	}
	public void setLoanTermInMonths(int loanTerm) {
		this.loanTermInMonths = loanTerm;
	}
	public float getYearlyInterest() {
		return yearlyInterest;
	}
	public void setYearlyInterest(float yearlyInterest) {
		this.yearlyInterest = yearlyInterest;
	}
}
