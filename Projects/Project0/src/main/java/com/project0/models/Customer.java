package com.project0.models;

import java.util.ArrayList;

public class Customer extends User{
	
	private ArrayList<Car> ownedCars;

	
	public Customer(int id, String username) {
		super(id,username,'c');
		this.ownedCars = new ArrayList<Car>();
	}

	public ArrayList<Car> getOwnedCars() {
		return ownedCars;
	}

	public void setOwnedCars(ArrayList<Car> ownedCars) {
		this.ownedCars = ownedCars;
	}

	public void addToFleet(Car Car) {
		ownedCars.add(Car);	
	}
	
	
	
	
	
	/*
	 * Customer Methods
	 */
	//customer can see the cars on the lot
	
	
	//customer can make an offer for a car
	
	//customer can view the cars that they own
	
	//customer can view remaining payments for a car
}
