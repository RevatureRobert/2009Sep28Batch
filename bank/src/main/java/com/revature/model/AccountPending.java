package com.revature.model;

public class AccountPending {
	
	private int accountPendingID;
	private String accountType;
	private Customer customerID;
	
	
	public AccountPending() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountPending(String accountType, Customer customerID) {
		super();
		this.accountType = accountType;
		this.customerID = customerID;
	}
	
	public AccountPending(int accountPendingID, String accountType, Customer customerID) {
		super();
		this.accountPendingID = accountPendingID;
		this.accountType = accountType;
		this.customerID = customerID;
	}
	public int getAccountPendingID() {
		return accountPendingID;
	}
	public void setAccountPendingID(int accountPendingID) {
		this.accountPendingID = accountPendingID;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Customer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Customer customerID) {
		this.customerID = customerID;
	}
	
	@Override
	public String toString() {
		return "AccountPending [accountPendingID=" + accountPendingID + ", accountType=" + accountType + ", customerID="
				+ customerID + "]";
	}

	
}
