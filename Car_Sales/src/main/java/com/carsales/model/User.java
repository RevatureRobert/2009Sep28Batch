package com.carsales.model;

public class User {
	int userId;
	String userName;
	String passWord;
	String role;
	
	public User(String name, String pass, String rol) {
		userName = name;
		passWord = pass;
		role = rol;
	}
	
	public User(String name, String pass) {
		userName = name;
		passWord = pass;
	}
	
	public User() {
	}
	
	
	public User(int int1, String string, String string2, String string3) {
		userId = int1;
		userName = string;
		passWord = string2;
		role = string3;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
