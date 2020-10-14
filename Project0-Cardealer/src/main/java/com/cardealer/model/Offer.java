package com.cardealer.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Offer {
	private int offerID;
	private String userID;
	private int carID;
	private int offerTotal;
	private int offerMonths;
	
	public Offer(int offerID, String userID, int carID, int offerTotal, int offerMonths) {
		this.userID = userID;
		this.carID = carID;
		this.offerTotal = offerTotal;
		this.offerMonths =offerMonths;
	}
	
	public Offer(ResultSet result) throws SQLException {
		this.offerID = result.getInt(1);
		this.userID = (result.getString(2));
		this.carID = (result.getInt(3));
		this.offerTotal = (result.getInt(4));
		this.offerMonths = (result.getInt(5));
		
	}

	@Override
	public String toString() {
		return "Offer [offerID=" + offerID + ", userID=" + userID + ", carID=" + carID + ", offerTotal=" + offerTotal
				+ ", offerMonths=" + offerMonths + "]";
	}
	

	public int getOfferID() {
		return offerID;
	}

	public int getOfferTotal() {
		return offerTotal;
	}

	public int getOfferMonths() {
		return offerMonths;
	}

	public int getCarID() {
		return carID;
	}

	public String getUserID() {
		return userID;
	}
}
