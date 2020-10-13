package com.cardealership.model;

public class Customer extends User {
	private int customerId;
	private int balance = 0;
	private int monthlyPayment = 0;
	public Customer(int userId, String userUserName, String userPassword, UserType userType, String userFirstName,
			String userLastName, String userEmail, int customerId) {
		super(userId, userUserName, userPassword, userType, userFirstName, userLastName, userEmail);
		this.customerId = customerId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(int monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	@Override
	public String toString() {
		return super.toString() + "Customer [customerId=" + customerId + ", balance=" + balance + ", monthlyPayment=" + monthlyPayment
				+ "]";
	}
	
	
	
}
