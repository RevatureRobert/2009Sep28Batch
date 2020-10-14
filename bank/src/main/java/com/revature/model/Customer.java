package com.revature.model;

public class Customer {
	
	private int CustomerID;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int customerID, String firstname, String lastname, String email, String password) {
		super();
		CustomerID = customerID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [CustomerID=" + CustomerID + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", password=" + password + "]";
	}
	
	

}
