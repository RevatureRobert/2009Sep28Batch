package com.dealership.model;

public class Employee {

	private final int id;
	private final String username;

	public Employee(int id, String username) {
		this.id = id;
		this.username = username;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Employee ID: %d | Username: %s", id, username);
	}

}
