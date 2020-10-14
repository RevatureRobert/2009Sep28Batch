package com.revature.model;

public class Loan {

	private int loanID;
	private float principal;
	private float interest;
	private float accruedInterest;
	private int termMonths;
	private int creditScore;
	private Customer customerID;
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Loan(int loanID, float principal, float interest, float accruedInterest, int termMonths, int creditScore,
			Customer customerID) {
		super();
		this.loanID = loanID;
		this.principal = principal;
		this.interest = interest;
		this.accruedInterest = accruedInterest;
		this.termMonths = termMonths;
		this.creditScore = creditScore;
		this.customerID = customerID;
	}
	public int getLoanID() {
		return loanID;
	}
	public void setLoanID(int loanID) {
		this.loanID = loanID;
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
	public float getAccruedInterest() {
		return accruedInterest;
	}
	public void setAccruedInterest(float accruedInterest) {
		this.accruedInterest = accruedInterest;
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
		return "Loan [loanID=" + loanID + ", principal=" + principal + ", interest=" + interest + ", accruedInterest="
				+ accruedInterest + ", termMonths=" + termMonths + ", creditScore=" + creditScore + ", customerID="
				+ customerID + "]";
	}
	
	
}
