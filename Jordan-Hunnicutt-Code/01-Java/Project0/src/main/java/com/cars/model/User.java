package com.cars.model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String username;
	private String password;
	private int userType;
	private int userId;
	
	public User( int userId, String username, String password, int userType) {
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.userId = userId;
	}

	public User(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.userType = user.getUserType();
		this.userId = user.getUserId();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		if(userId < 0) {
			System.out.println("Please type in a valid ID (Non-negative)");
		} else {
			this.userId = userId;
		}
	}
	
	
	
	
}
