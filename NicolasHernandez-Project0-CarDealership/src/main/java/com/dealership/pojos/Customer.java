package com.dealership.pojos;

public class Customer extends User{
	public Customer(String username, String passwordHash, String colloquialName) {
		super(username, passwordHash, colloquialName);
	}
	
//	private HashMap<UnsoldCar, Float> offers;
	
//	public void placeOrder(UnsoldCar listing, float offerValue) {
//		listing.addOffer(this, offerValue);
//		
//		if(offers == null) {
//			offers = new HashMap<>();
//		}
//		
//		offers.put(listing, offerValue);
//	}
//	public void makePayment(SoldCar car){
//		
//	}
//	public HashMap<UnsoldCar, Float> getOffers() {
//		return offers;
//	}
//	public void setOffers(HashMap<UnsoldCar, Float> offers) {
//		this.offers = offers;
//	}
}
