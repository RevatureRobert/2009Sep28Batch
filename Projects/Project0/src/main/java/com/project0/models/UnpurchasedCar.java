//package com.project0.models;
//
//import java.text.NumberFormat;
//import java.util.HashMap;
//
//import com.project0.enums.CarName;
//
//public class UnpurchasedCar extends Car{
//	private double price;
//	//private HashMap<User,Offer> offerList;
//	
//	
////	//public UnpurchasedCar(CarName name, int carID) {
////		super(name, carID);
////		this.price = name.getPrice();
////		//
////	}
////	
////	public double getPrice() {
////		return price;
////	}
//
//	//when customer makes an offer on a car
////	public void addOffer(Customer c, double amount) {
////		//remove the previous offer if it exists
////		if(offerList.containsKey(c)) {
////			this.removeOffer(c);
////		}
////		offerList.put(c, new Offer(c.getId(),amount));
////	}
//	
////	//Either offer was rejected or customer made a new offer
////	public void removeOffer(Customer c) {
////		offerList.remove(c);
////	}
//		
//	//when purchased, set price to the price it was purchased for so you can calculate payments off of that.
//	public void purchase(Customer c) {
//		c.addToFleet(new PurchasedCar(super.getName(), price, super.getCarID()));
//	}
//	
//	//***** add carid to string
//	@Override
//	public String toString() {
//		String description = super.getName().toString() + " for "+ NumberFormat.getCurrencyInstance().format(this.price);
//		return description;
//	}
//	
//
//
//}
