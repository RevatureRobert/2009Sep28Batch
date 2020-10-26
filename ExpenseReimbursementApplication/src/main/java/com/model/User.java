package com.model;

public abstract class User 
{
	private int users_id;
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String email;
	private int user_role_id;
	
	public int getUserid() {
		return users_id;
	}
	public void setUserid(int userid) {
		this.users_id = userid;
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
	public String getFirstname() {
		return first_name;
	}
	public void setFirstname(String firstname) {
		this.first_name = firstname;
	}
	public String getLastname() {
		return last_name;
	}
	public void setLastname(String lastname) {
		this.last_name = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}
	public User(int userid, String username, String password, String firstname, String lastname, String email,
			int user_role_id) {
		super();
		this.users_id = userid;
		this.username = username;
		this.password = password;
		this.first_name = firstname;
		this.last_name = lastname;
		this.email = email;
		this.user_role_id = user_role_id;
	}
	@Override
	public String toString() {
		return "User [userid=" + users_id + ", username=" + username + ", password=" + password + ", firstname="
				+ first_name + ", lastname=" + last_name + ", email=" + email + ", user_role_id=" + user_role_id + "]";
	}
	
	
}
