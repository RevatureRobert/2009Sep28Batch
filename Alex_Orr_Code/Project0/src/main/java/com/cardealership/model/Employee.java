package com.cardealership.model;

public class Employee extends User {
	private int employeeId;
	private int dealershipId;
	public Employee( int employeeId, int dealershipId, int userId, String userUserName, String userPassword, UserType userType, String userFirstName,
			String userLastName, String userEmail) {
		super(userId, userUserName, userPassword, userType, userFirstName, userLastName, userEmail);
		this.employeeId = employeeId;
		this.dealershipId = dealershipId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getDealershipId() {
		return dealershipId;
	}
	public void setDealershipId(int dealershipId) {
		this.dealershipId = dealershipId;
	}
	@Override
	public String toString() {
		return super.toString()+" Employee [employeeId=" + employeeId + ", dealershipId=" + dealershipId + "]";
	}	
	
}
