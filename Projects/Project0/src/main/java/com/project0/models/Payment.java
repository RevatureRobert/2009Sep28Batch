package com.project0.models;

import java.text.NumberFormat;

public class Payment {
	private int monthsLeft;
	private double amountLeft;
	private double perMonth;
	private double original;
	private int userId;
	private int carId;
	
	
	public Payment(double amountToPay,int userId, int carId) {
		super();
		this.userId = userId;
		this.carId = carId;
		this.monthsLeft = 63;
		this.amountLeft = amountToPay;
		this.original = amountToPay;
		this.perMonth = (Math.ceil((amountToPay/63)*100))/100;
	}
	
	public Payment(int userId, int carId, double amountToPay, int monthsLeft, double original, double perMonth) {
		this.userId = userId;
		this.carId = carId;
		this.monthsLeft = monthsLeft;
		this.amountLeft = amountToPay;
		this.original = original;
		this.perMonth = perMonth;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public int getCarId() {
		return carId;
	}
	public int getMonthsLeft() {
		return monthsLeft;
	}
	
	public double amountLeft() {
		return amountLeft;
	}
	
	public double perMonth() {
		return perMonth;
	}
	public double getOriginal() {
		return original;
	}
	
	//making a payment by number of months 
	public void pay(int months) {
		if(monthsLeft ==0) {
			System.out.println("This car is already paid off!");
		} else {
			double paying = months * perMonth;
			this.amountLeft -= paying;
			this.monthsLeft -= months;
			if(this.monthsLeft <= 0) {
				this.monthsLeft = 0;
				this.amountLeft = 0;
				System.out.println("Congrats, this car is now paid off!");
			} else {
				System.out.println("The original amount was "+ NumberFormat.getCurrencyInstance().format(this.original) + ". You now have " + monthsLeft + " payments of " + NumberFormat.getCurrencyInstance().format(this.perMonth) + " left!");
			}
		}
		
	}
	
	@Override
	public String toString() {
		return "You have " + monthsLeft + " monthly payments of " + NumberFormat.getCurrencyInstance().format(this.perMonth) + " left. Your original loan amount was " + NumberFormat.getCurrencyInstance().format(this.original) + ".";
	}
	
	public String forEmployee() {
		return "There are " + monthsLeft + " monthly payments of " + NumberFormat.getCurrencyInstance().format(this.perMonth) + " left. The original loan amount was " + NumberFormat.getCurrencyInstance().format(this.original) + ".";

	}


}
