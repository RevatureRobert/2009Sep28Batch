package com.model;

public class Offer 
{
	private int offerid;
	private String carid;
	private String userid;
	private int downpayment;
	private String offerstatus;
	
	public Offer(int offerid, String carid, String userid, int downpayment, String offerstatus) {
		super();
		this.offerid = offerid;
		this.carid = carid;
		this.userid = userid;
		this.downpayment = downpayment;
		this.offerstatus = offerstatus;
	}

	public Offer() {
		// TODO Auto-generated constructor stub
	}
	
	public Offer(int offerID)
	{
		this.offerid = offerid;
	}

	public Offer(String carid, String userid, int downpayment, String offerstatus, int offerid) 
	{
		this.carid = carid;
		this.userid = userid;
		this.downpayment = downpayment;
		this.offerstatus = offerstatus;
		this.offerid = offerid;

	}
	
	/*
public Offer(String carid, String userid, int downpayment, String offerstatus, String offerid) 
{
	this.carid = carid;
	this.userid = userid;
	this.downpayment = downpayment;
	this.offerstatus = offerstatus;
	this.offerid = offerid;
	}
*/
	/*
	public Offer(String carid, String userid, int downpayment, String offerstatus, int offerid) 
	{
		this.carid = carid;
		this.userid = userid;
		this.downpayment = downpayment;
		this.offerstatus = offerstatus;
		this.offerid = offerid;
	}
*/
	@Override
	public String toString() {
		return "Details of offer: carid=" + carid + ", userid=" + userid + ", downpayment=" + downpayment + " offerid =" + offerid + "\n\n";
	}
	
	public String toString(String carid, String userid, int downpayment, int offerid)
	{
		this.offerid = offerid;
		this.carid = carid;
		this.userid = userid;
		this.downpayment = downpayment;
		
		return "Details of offer: carid=" + carid + ", userid=" + userid + ", downpayment=" + downpayment + " offerid =" + offerid + "\n\n";
	}

	public int getOfferid() {
		return offerid;
	}

	public void setOfferid(int offerid) {
		this.offerid = offerid;
	}

	public String getCarid() {
		return carid;
	}

	public void setCarid(String carid) {
		this.carid = carid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getDownpayment() {
		return downpayment;
	}

	public void setDownpayment(int downpayment) {
		this.downpayment = downpayment;
	}

	public String getOfferstatus() {
		return offerstatus;
	}

	public void setOfferstatus(String offerstatus) {
		this.offerstatus = offerstatus;
	}
	
	
	
	
}
