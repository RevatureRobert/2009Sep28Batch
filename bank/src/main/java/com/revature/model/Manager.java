package com.revature.model;

public class Manager {
	private Employee employee;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(Employee employee) {
		super();
		this.employee = employee;
	}


	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Manager [employee=" + employee + "]";
	}
	
}
