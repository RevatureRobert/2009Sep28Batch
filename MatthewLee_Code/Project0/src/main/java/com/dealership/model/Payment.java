package com.dealership.model;

public class Payment {

	private int customerId;
	private int carId;
	private double paid;
	private double balance;
	private double monthlyPayment;
	
	public Payment(int customerId, int carId, double paid, double balance, double monthlyPayment) {
		this.customerId = customerId;
		this.carId = carId;
		this.paid = paid;
		this.balance = balance;
		this.monthlyPayment = monthlyPayment;
	}
	
	public Payment(int customerId, int carId, double monthlyPayment) {
		this.customerId = customerId;
		this.carId = carId;
		this.monthlyPayment = monthlyPayment;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public int getCarId() {
		return carId;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public String displayPaidBalance() {
		return String.format("Paid: $%.2f | Balance: $%.2f | Monthly Payment: $%.2f",
				paid, balance, monthlyPayment);
	}

	@Override
	public String toString() {
		return String.format("Customer ID: %d | Car ID: %d | Paid: $%.2f | Balance: $%.2f | Monthly Payment: $%.2f", 
				customerId, carId, paid, balance, monthlyPayment);
	}	
	
}
