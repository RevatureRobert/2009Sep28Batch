package com.cardealership.model;

public class User {
	private int userId;
	private String userUserName;
	private String userPassword;
	private UserType userType;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	
	
	public User(int userId, String userUserName, String userPassword, UserType userType, String userFirstName,
			String userLastName, String userEmail) {
		super();
		this.userId = userId;
		this.userUserName = userUserName;
		this.userPassword = userPassword;
		this.userType = userType;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
	}


	public int getUserId() {
		return userId;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userUserName=" + userUserName + ", userPassword=" + userPassword
				+ ", userType=" + userType + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userEmail=" + userEmail + "]";
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserUserName() {
		return userUserName;
	}


	public void setUserUserName(String userUserName) {
		this.userUserName = userUserName;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public UserType getUserType() {
		return userType;
	}


	public void setUserType(UserType userType) {
		this.userType = userType;
	}


	public String getUserFirstName() {
		return userFirstName;
	}


	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}


	public String getUserLastName() {
		return userLastName;
	}


	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
		
}
