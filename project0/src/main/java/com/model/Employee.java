package com.model;

public class Employee 
{

	private String firstName;
	private String lastName;
	private int userID;
	private String password;
	private String employeeLevel;
	
	
	//Constructor: Prompts new employee to provide account details
	
	public Employee(String firstName, String lastName, int userID, String password, String employeeLevel) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userID = userID;
		this.password = password;
		this.employeeLevel = employeeLevel;
		
		setUserID();
	}
	
	public Employee(int userID, String password)
	{
		this.userID = userID;
		this.password = password;
	}

	
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", employeeLevel=" + employeeLevel + "]";
	}
	
	public String toStringFirstName()
	{
		return "\nHello " + firstName + "!";
	}
	
	public String toStringUserID(int userID)
	{
		this.userID = userID;
		return "\nYour userid is " + userID;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String firstname)
	{
		this.firstName = firstname;
	}
	
	public Employee(int userID)
	{
		this.userID = userID;
	}

	// Generate getters and setters to update the employees fields 
	
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


	private void setUserID() {
		userID++;
		this.userID = userID;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmployeeLevel() {
		return employeeLevel;
	}


	public void setEmployeeLevel(String employeeLevel) {
		this.employeeLevel = employeeLevel;
	}
	
	
	// Employee can add cars to the lot
	
	public void addCarToLot(Car newCar)
	{
		String ncBrand;
		String ncColor;
		String ncYear;
		double ncPrice;
		String ncOwner = "Dawit";
		
		
	}
	
	
	
	// Employee can remove cars from the lot
	
	
	
	
	
	// Employee will verify login credentials
	
	
	
	
	
	
	
	
	

}
