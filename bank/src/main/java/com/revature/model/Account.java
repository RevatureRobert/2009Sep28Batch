package com.revature.model;

public class Account {
	private int accountID;
	private String accountType;
	private float balance;
	private Customer customerID;
	
	public Account() {
		super();
	}
	
	public Account(int accountID, String accountType, float balance, Customer customerID) {
		super();
		this.accountID = accountID;
		this.accountType = accountType;
		this.balance = balance;
		this.customerID = customerID;
	}

	public int getAccountID() {
		return accountID;
	}
	
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public float getBalance() {
		return balance;
	}
	
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public Customer getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(Customer customerID) {
		this.customerID = customerID;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", accountType=" + accountType + ", balance=" + balance
				+ ", customerID=" + customerID + "]";
	}


	
}
