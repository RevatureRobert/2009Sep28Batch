package com.model;

public class Payment 
{
	private int payment;
	private String firstName;
	private String lastName;
	private String userid;
	private int paymentid;
	
	public Payment(int payment, String firstName, String lastName, String userid, int paymentid) {
		super();
		this.payment = payment;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userid = userid;
		this.paymentid = paymentid;
	}

	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(int payment, String firstname, String lastname, String userid) 
	{
			this.payment = payment;
			this.firstName = firstName;
			this.lastName = lastName;
			this.userid = userid;
	}


	public Payment(int paymentID) 
	{
		this.paymentid = paymentID;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}

	@Override
	public String toString() 
	{
		
		return "Details of Payments: payment: " + payment + " FirstName: " + firstName + " LastName: " + lastName + " UserID: " + userid + " PaymentID: " + paymentid + "\n\n";
	}
	
	
	
	public String toSttringPayments(int p)
	{
		this.paymentid = p;
		
		return "Details of Payments: payment: " + payment + " FirstName: " + firstName + " LastName: " + lastName + " UserID: " + userid + " PaymentID: " + paymentid + "\n\n";
	}
	
	public String viewPayments()
	{
		return "Payment = " + payment + " FirstName = " + firstName + " LastName = " + lastName + " UserID = " + userid + "\n\n";
	}
	
}
