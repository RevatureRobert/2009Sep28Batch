package com.cardealer.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Owned {
	private String userID;
	private int carID;
	private int paymentLeft;
	private int paymentMonthly;
	private int months;
	
	public Owned(String userID, int carID, int total, int monthly) {
		this.userID = userID;
		this.carID = carID;
		this.paymentLeft = total;
		this.months =monthly;
		paymentMonthly = total/months;
	}
	
	public Owned(ResultSet result) throws SQLException {
		this.userID = (result.getString(1));
		this.carID = (result.getInt(2));
		this.paymentLeft = (result.getInt(3));
		this.months = (result.getInt(4));
		
		
	}
	

	@Override
	public String toString() {
		return "Owned [carID=" + carID + ", paymentLeft= $" + paymentLeft + ", paymentMonthly= $" + paymentMonthly + userID + "]";
	}
	
	

	
	public String toStringUser() {
		return "userID=" + userID + " [carID=" + carID + ", paymentLeft=" + paymentLeft + ", paymentMonthly="
				+ paymentMonthly + ", months=" + months + "]";
	}

	public int getPaymentLeft() {
		return paymentLeft;
	}

	public int getPaymentMonthly() {
		return paymentMonthly;
	}

	public int getCarID() {
		return carID;
	}

	public String getUserID() {
		return userID;
	}
}
