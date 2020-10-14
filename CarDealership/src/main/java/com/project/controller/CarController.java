package com.project.controller;

import java.util.List;

import com.project.model.Car;
import com.project.service.CarService;

public class CarController {
	
	private CarService cs;
	
	public CarController() {
		this(new CarService());
	}
	
	public CarController(CarService cs) {
		this.cs = cs;
	}
	
	public List<Car> findAll() {
		return cs.findAll();
	}
	
	public List<Car> findAllOwned() {
		return cs.findAllOwned();
	}
	
	public List<Car> ownedCars(Integer i) {
		return cs.ownedCars(i);
	}
	
	public Car updateOwner(Car c) {
		return cs.updateOwner(c);
	}
	
	public String insert(Car c) {
		try {
			Car result = cs.create(c);
			return result.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public int remove(Integer i) {
		return cs.delete(i);
	}
	
	public int update(Car c) {
		return cs.update(c);
	}

}
