package com.revature.model;

public class Transaction {
	private int transactionID;
	private String transactionType;
	private int accountIDFrom;
	private int accountIDTo;
	private float amount;
	private Customer customerID;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int transactionID, String transactionType, int accountIDFrom, int accountIDTo, float amount, Customer customerID) {
		super();
		this.transactionID = transactionID;
		this.transactionType = transactionType;
		this.accountIDFrom = accountIDFrom;
		this.accountIDTo = accountIDTo;
		this.amount = amount;
		this.customerID = customerID;
	}
	//Constructor for transaction without id since database automatiaclly handles id on insertion
	public Transaction(String transactionType, int accountIDFrom, int accountIDTo, float amount, Customer customerID) {
		super();
		this.transactionType = transactionType;
		this.accountIDFrom = accountIDFrom;
		this.accountIDTo = accountIDTo;
		this.amount = amount;
		this.customerID = customerID;
	}
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransActionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getAccountIDFrom() {
		return accountIDFrom;
	}
	public void setAccountIDFrom(int accountIDFrom) {
		this.accountIDFrom = accountIDFrom;
	}
	public int getAccountIDTo() {
		return accountIDTo;
	}
	public void setAccountIDTo(int accountIDTo) {
		this.accountIDTo = accountIDTo;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Customer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Customer customerID) {
		this.customerID = customerID;
	}
	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", transactionType=" + transactionType
				+ ", accountIDFrom=" + accountIDFrom + ", accountIDTo=" + accountIDTo + ", amount=" + amount
				+ ", customerID=" + customerID + "]";
	}
	
}
