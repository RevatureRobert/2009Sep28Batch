package com.project0.models;

/*
 * This abstract class shows what every kind of user(employee or customer) should have as its traits and behavior
 * Have a user table in the database with user name, password, and then the user object. If the user name and password match, retrieve the user object. 
 */

public abstract class User {
	private String username;
	private int id;
	public char type; //if a employee, e, if a customer, c
	
	public User(int id,String username,char type) {
		this.id = id;
		this.username=username;
		this.type = type;
	}
	
	public String getUser() {
		return username;
	}
	
	public char getType() {
		return type;
	}
	
	public int getId() {
		return id;
	}
}
