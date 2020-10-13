package com.carsales.model;

public class Offer {
	int offer_id;
	int car_id;
	int user_id;
	String username;
	int amount;
	
	public Offer(int carid, int userid, String user, int amot){
		super();
		car_id = carid;
		user_id = userid;
		username = user;
		amount = amot;
	}
	
	public Offer(){
		super();
	}
	
	public Offer(int int1, int int2, int int3, String string, int int4) {
		offer_id = int1;
		car_id = int2;
		user_id = int3;
		username = string;
		amount = int4;
	}

	public int getOffer_id() {
		return offer_id;
	}
	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
	}
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	

}
