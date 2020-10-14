package com.revature.model;

public class Employee {
	private int employeeID;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int employeeID, String firstname, String lastname, String email, String password) {
		super();
		this.employeeID = employeeID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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
		return "Employee [employeeID=" + employeeID + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", password=" + password + "]";
	}
	
	
}
