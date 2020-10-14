package com.dealership.pojos;

import java.sql.Date;

public class SoldCar extends Car {
	private String ownerId;
	
	private Date loanStartDate;
	private Date loanEndDate;
	
	private float totalDue;
	private float yearlyInterestRate;
	private float monthlyPayment;
	private float remainingBalance;

	public SoldCar(int carId, String ownerId, String color, int year, String make,
			String model, Date loanStartDate, Date loanEndDate, float totalDue,
			float yearlyInterestRate, float remainingBalance, float monthlyPayment){
		super(carId, color, year, make, model);
		this.ownerId = ownerId;
		this.loanStartDate = loanStartDate;
		this.loanEndDate = loanEndDate;
		this.totalDue = totalDue;
		this.yearlyInterestRate = yearlyInterestRate;
		this.remainingBalance = remainingBalance;
		this.monthlyPayment = monthlyPayment;
	}

	public String getOwner_id() {
		return ownerId;
	}

	public void setOwner_id(String ownerId) {
		this.ownerId = ownerId;
	}

	public Date getLoanStartDate() {
		return loanStartDate;
	}

	public void setLoanStartDate(Date loanStartDate) {
		this.loanStartDate = loanStartDate;
	}

	public Date getLoanEndDate() {
		return loanEndDate;
	}

	public void setLoanEndDate(Date loanEndDate) {
		this.loanEndDate = loanEndDate;
	}

	public float getTotalDue() {
		return totalDue;
	}

	public void setTotalDue(float totalDue) {
		this.totalDue = totalDue;
	}

	public float getYearlyInterestRate() {
		return yearlyInterestRate;
	}

	public void setYearlyInterestRate(float yearlyInterestRate) {
		this.yearlyInterestRate = yearlyInterestRate;
	}

	public float getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(float monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public float getRemainingBalance() {
		return remainingBalance;
	}

	public void setRemainingBalance(float remainingBalance) {
		this.remainingBalance = remainingBalance;
	}
}