package com.project0.controller;

import java.util.List;

import com.project0.model.Car;
import com.project0.service.CarService;

public class CarController {
	private CarService cs;

	public CarController() {
		this(new CarService());
	}

	public CarController(CarService cs) {
		super();
		this.cs = cs;
	}

	public String insert(Car c) {
		try {
			Car result = cs.create(c);

			return result.toString();

		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public List<Car> findAll() {
		return cs.findAll();
	}

	public int delete(int deleteId) {
		return cs.delete(deleteId);
	}

	public List<Car> findAvailableCars() {
		return cs.findAvailableCars();
	}

	public List<Car> findCarsByOwnerId(Integer i) {
		return cs.findCarsByOwnerId(i);
	}

	public int addCusToCar(Integer cusId, Integer carId) {
		return cs.addCusToCar(cusId, carId);
	}

	public List<Car> findAllCarsWithBalance(int id) {
		return cs.findAllCarsWithBalance(id);
	}

	public List<Car> findAllCarsWithBalance() {
		return cs.findAllCarsWithBalance();
	}

	public Car findById(int carId) {
		return cs.findById(carId);
	}

	public int makePayment(Integer carId, Integer amount) {
		return cs.makePayment(carId, amount);
	}
}
