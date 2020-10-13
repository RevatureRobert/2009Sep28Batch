package com.bankapp.model;

import java.util.Set;

public class Users {
	private String username;
	private String user_password;
	private String email;
	private Set<UserType> usertype;

	public String getUserame() {
		return username;
	}

	public void setUsername(String user) {
		this.username = username;
	}

	public String getUserPassword() {
		return user_password;
	}

	public void setUserPassword(String user_password) {
		this.user_password = user_password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<UserType> getUserType() {
		return usertype;
	}

	public void setBears(Set<UserType> usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "Users [Username=" + username + ", Password=" + user_password + ", Email=" + email + ", User Type="
				+ usertype + "]";
	}

	public Users(String username, String user_password, String email, Set<UserType> usertype) {
		super();
		this.username = username;
		this.user_password = user_password;
		this.email = email;
		this.usertype = usertype;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

}

