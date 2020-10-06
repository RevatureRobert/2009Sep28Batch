package com.cars.model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String username;
	private String password;
	private String userType;
	private int userId;
	private List<Car> ownedCars = new ArrayList<>();
	
	public User(String username, String password, String userType) {
		this.username = username;
		this.password = password;
		this.userType = userType;
		userId = 0;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
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
