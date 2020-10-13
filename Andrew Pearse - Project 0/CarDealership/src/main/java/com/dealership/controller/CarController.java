package com.dealership.controller;

import java.util.List;

import com.dealership.models.Car;
import com.dealership.service.CarService;

public class CarController {

private CarService cs;
	
	public CarController() {
		this(new CarService());
	}
	
	public CarController(CarService cs) {
		this.cs = cs;
	}
	
	public List<Car> findAllCarsOnLot(){
		return cs.findAllCarsOnLot();
	}
	
	public List<Car> findAllOwned(String username){
		return cs.findAllOwned(username);
	}
	
	public boolean addCarToTheLot(Car car) {
		return cs.addCarToTheLot(car);
	}
	
	public int removeCarFromLot(int cid) {
		return cs.removeCarFromLot(cid);
	}
}
