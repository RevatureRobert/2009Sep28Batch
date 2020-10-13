package com.cardealership.model;

public class Dealership {
	private int dealershipId;
	private String dealershipName;
	public Dealership(int dealershipId, String dealershipName) {
		super();
		this.dealershipId = dealershipId;
		this.dealershipName = dealershipName;
	}
	public int getDealershipId() {
		return dealershipId;
	}
	public void setDealershipId(int dealershipId) {
		this.dealershipId = dealershipId;
	}
	public String getDealershipName() {
		return dealershipName;
	}
	public void setDealershipName(String dealershipName) {
		this.dealershipName = dealershipName;
	}
	
	
}
