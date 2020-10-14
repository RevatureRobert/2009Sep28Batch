package com.car_dealership_cli.model;

public class User {
	
	private int userId;
	
	private int userLevel = 1; //0: superUser, 1: customer, 2: employee, 3: manager
	private String email;
	private String userName;
	private String password;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.userName+": UserLevel "+userLevel+", Email "+email + "\n";
	}
	public User() {
		
	}
	
	public User(int userId, int userLevel, String email, String userName, String password) {
		super();
		this.userId = userId;
		this.userLevel = userLevel;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}
	public User (int userLevel, String email, String userName, String password) {
		this.userLevel = userLevel;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
