package com.project.service;

import java.util.List;

import com.project.model.Car;
import com.project.repository.CarDAO;

public class CarService {
	
	private CarDAO cd;
	
	public CarService() {
		this(new CarDAO());
	}
	
	public CarService(CarDAO cd) {
		this.cd = cd;
	}
	
	public List<Car> findAll() {
		return cd.findAll();
	}
	
	public List<Car> findAllOwned() {
		return cd.findAllOwned();
	}
	
	public List<Car> ownedCars(Integer i) {
		return cd.ownedCars(i);
	}
	
	public Car create(Car c) throws Exception {
		Car result = cd.create(c);
		if(result==null) {
			throw new Exception("The car was not created.");
		}
		return result;
	}
	
	public Car updateOwner(Car c) {
		return cd.updateOwner(c);
	}
	
	public int delete(Integer i) {
		return cd.delete(i);
	}
	
	public int update(Car c) {
		return cd.update(c);
	}

}
