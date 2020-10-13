//package com.project0.models;
//
//import com.project0.enums.CarName;
//
//public class PurchasedCar extends Car{
//	private double pricePaid;
//	private Payment payments;
//
//	public PurchasedCar(CarName name, int carID, Payment p) {
//		super(name, carID);
//		this.payments = p;
//		
//	}
//	
//	public double getPricePaid() {
//		return pricePaid;
//	}
//	
//	public int getMonthsLeft() {
//		return this.payments.getMonthsLeft();
//	}
//	
//	public double getAmountLeft() {
//		return this.payments.amountLeft();
//	}
//	
//	public double getMonthlyPayment() {
//		return this.payments.perMonth();
//	}
//	//A string representation of payments left
//	public String getPayment() {
//		return payments.toString();
//	}
//	
//	//*************make a toString method here
//
//}
