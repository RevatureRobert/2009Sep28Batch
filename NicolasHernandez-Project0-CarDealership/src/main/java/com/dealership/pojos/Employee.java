package com.dealership.pojos;

public class Employee extends User {
	private boolean isCustomer;
	private boolean isManager;
	
	public Employee(String username, String passwordHash, String colloquialName, boolean isCustomer, boolean isManager) {
		super(username, passwordHash, colloquialName);
		this.isCustomer = isCustomer;
		this.isManager = isManager;
	}
	
	
	
	public boolean isCustomer() {
		return isCustomer;
	}

	public void setCustomer(boolean isCustomer) {
		this.isCustomer = isCustomer;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
}
