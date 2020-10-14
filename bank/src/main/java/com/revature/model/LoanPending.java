package com.revature.model;

public class LoanPending {
	private int loanPendingID;
	private float principal;
	private float interest;
	private int termMonths;
	private int creditScore;
	private Customer customerID;
	public LoanPending() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoanPending(int loanPendingID, float principal, float interest, int termMonths, int creditScore,
			Customer customerID) {
		super();
		this.loanPendingID = loanPendingID;
		this.principal = principal;
		this.interest = interest;
		this.termMonths = termMonths;
		this.creditScore = creditScore;
		this.customerID = customerID;
	}
	public int getLoanPendingID() {
		return loanPendingID;
	}
	public void setLoanPendingID(int loanPendingID) {
		this.loanPendingID = loanPendingID;
	}
	public float getPrincipal() {
		return principal;
	}
	public void setPrincipal(float principal) {
		this.principal = principal;
	}
	public float getInterest() {
		return interest;
	}
	public void setInterest(float interest) {
		this.interest = interest;
	}
	public int getTermMonths() {
		return termMonths;
	}
	public void setTermMonths(int termMonths) {
		this.termMonths = termMonths;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	public Customer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Customer customerID) {
		this.customerID = customerID;
	}
	@Override
	public String toString() {
		return "LoanPending [loanPendingID=" + loanPendingID + ", principal=" + principal + ", interest=" + interest
				+ ", termMonths=" + termMonths + ", creditScore=" + creditScore + ", customerID=" + customerID + "]";
	}
	
	
}
