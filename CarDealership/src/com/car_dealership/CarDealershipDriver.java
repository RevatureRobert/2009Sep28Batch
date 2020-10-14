package com.car_dealership;

public class CarDealershipDriver {
	public static void main(String[] args) {
		//setup environment
		CarDealership cd = new CarDealership();
		//simple encrypt/decrypt test
		//com.car_dealership.util.Util.decrypt(com.car_dealership.util.Util.encrypt("Hello"));
		
		cd.visitorMenu();
	}
}
