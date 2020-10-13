package com.carsales.model;

public class Payment {
	int paymentid;
	int paymentnum;
	int car_id;
	int userid;
	String username;
	int amount;
	
	public Payment(int paymentnum, int car_id, int userid, String username, int amount) {
		super();
		this.paymentnum = paymentnum;
		this.car_id = car_id;
		this.userid = userid;
		this.username = username;
		this.amount = amount;
	}
	
	public Payment(int paymenti, int paymentnum, int car_id, int userid, String username, int amount) {
		super();
		paymentid = paymenti;
		this.paymentnum = paymentnum;
		this.car_id = car_id;
		this.userid = userid;
		this.username = username;
		this.amount = amount;
	}
	
	public Payment() {
		super();
	}
	
	
	
	public int getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}
	public int getPaymentnum() {
		return paymentnum;
	}
	public void setPaymentnum(int paymentnum) {
		this.paymentnum = paymentnum;
	}
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
