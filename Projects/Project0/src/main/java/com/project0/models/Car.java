package com.project0.models;
import com.project0.enums.CarName;
/*
 * This is the class that describes the Car object.
 */


public class Car {
	private CarName name;
	private int carID;
	
	public Car(CarName name, int carID) {
		super();
		this.name = name;
		this.carID = carID;
	}

	public CarName getName() {
		return name;
	}
	
	public int getCarID() {
		return carID;
	}
	
	@Override
	public String toString() {
		return name.readable();
	}
	
	public double getPrice() {
		return name.getPrice();
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	

}
