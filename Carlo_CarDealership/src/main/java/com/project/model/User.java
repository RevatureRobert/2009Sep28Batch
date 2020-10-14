package com.project.model;

import java.util.Set;

// Objects that contain details about the user
public class User {
	protected int ID;
	protected String email;
	protected String username;
	protected String password;
	protected int type;			// 0 is user, 1 is customer, 2 is employee
	private Set<Car> cars;
	
	public User(int ID, String email, String username, String password, int type) {
		this.ID = ID;
		this.email = email;
		this.username = username;
		this.password = password;
		this.type = type;
	}
	
	public User(String email, String username, String password) {
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	// This constructor is primarily used for comparing the dummy customer at login to existing customers
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User() {
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Set<Car> getCars() {
		return cars;
	}
	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
	public void addCar(Car car) {
		this.cars.add(car);
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [ID=" + ID + ", email=" + email + ", username=" + username + ", password=" + password + ", type="
				+ type + ", cars=" + cars + "]";
	}
	
	public String userInfo() {
		if(type==1) {
			return ("User #"+ID+" | Username: "+username+" | status: CUSTOMER");
		} else if(type==2) {
			return ("User #"+ID+" | Username: "+username+" | status: EMPLOYEE");
		} else if(type==3) {
			return ("User #"+ID+" | Username: "+username+" | status: MANAGER");
		}
		return "You should never see this message.";
	}

	public boolean simpleCompare(User C) {	// Compares two customers based on username and password
		if(this.password.equals(C.password)&&this.username.equals(C.username)) {
			return true;
		} else {
			return false;
		}
	}
	
}
