package com.car_dealership_cli.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private int customerId;
	private int userId;
	private String firstName;
	private	String lastName;
	private List<Offer> offers = new ArrayList<Offer>();
	private List<Car> ownedCars = new ArrayList<Car>();
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String name) {
		firstName = name;
	}
	public List<Offer> getOrderIds() {
		return offers;
	}
	public void setOrderIds(List<Offer> orderIds) {
		this.offers = orderIds;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<Car> getOwnedCars() {
		return ownedCars;
	}
	public void setOwnedCars(List<Car> ownedCars) {
		this.ownedCars = ownedCars;
	}
	
}
