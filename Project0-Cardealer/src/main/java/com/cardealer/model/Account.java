package com.cardealer.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {
	
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private boolean adminPrivilages = false;
	private boolean isManager = false;
	
	public Account(String userName,String password, String lastName, String firstName, boolean ad, boolean man) {
		this.userName= userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.isManager = man;
		this.adminPrivilages = ad;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public boolean isAdminPrivilages() {
		return adminPrivilages;
	}

	public boolean isManager() {
		return isManager;
	}
	public String getFullName() {
		return firstName + " " + lastName;
	}

	public Account(ResultSet result) throws SQLException {
		this.userName = (result.getString(1));
		this.password = (result.getString(2));
		this.lastName = (result.getString(3));
		this.firstName = (result.getString(4));
		this.adminPrivilages = (result.getBoolean(5));
		this.isManager = (result.getBoolean(6));
	}
}
