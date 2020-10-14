package com.model;

import java.util.ArrayList;

public class Customer 
{
	private String firstName;
	private String lastName;
	private int userID;
	private String password;
	private int debtBalance;
	
	
	//Constructor: Prompts new customer to provide account details
	
	public Customer(String firstName, String lastName, String password,
			 int debtBalance) 
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.debtBalance = debtBalance;
		
	}
	
	public Customer(int userID, String password)
	{
		this.userID = userID;
		this.password = password;
	}
	

	public String toStringFirstName()
	{
		return "\nHello " + firstName + "!";
	}
	
	public String toStringDebtBalance()
	{
		return "You have a debt balance of $" + this.getDebtBalance();
	}
	
	public String toStringUserID(int userID)
	{
		this.userID = userID;
		return "Your userID is " + userID + "\n\n";
	}
	
	public Customer(String firstName)
	{
		this.firstName = firstName;
	}
	
	public Customer(int userID)
	{
		this.userID = userID;
	}
	
	public Customer()
	{
		
	}
	
	public Customer(int userID, int debtBalance)
	{
		this.userID = userID;
		this.debtBalance = debtBalance;
	}


	public Customer(String string, String string2, String string3, int int1, String string4, int int2) {
		// TODO Auto-generated constructor stub
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


	public int getUserID() {
		return userID;
	}

	// Generate userID
	
	public void setUserID(int userID) {
		
		this.userID = userID;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	// Customer can view remaining debt balance 
	
	public int getDebtBalance() {
		return debtBalance;
	}


	public void setDebtBalance(int debtBalance) {
		this.debtBalance = debtBalance;
	}


	
	

	
	
	

	
	
	
	
	

	
	
	
	
	

	
	
	
	

	
	
	
	
	
}
