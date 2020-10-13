package com.project0.service;

import java.util.List;

import com.project0.model.Car;
import com.project0.repo.CarDao;

public class CarService {
	private CarDao cd;

	public CarService() {
		this(new CarDao());
	}

	public CarService(CarDao cd) {
		super();
		this.cd = cd;

	}

	public List<Car> findAll() {
		return cd.findAll();
	}

	public Car create(Car c) throws Exception {
		Car result = cd.create(c);
		if (result == null) {
			throw new Exception("the car was not created");
		} else {
			System.out.println("Car created!");
		}
		return result;
	}

	public int delete(int deleteId) {
		return cd.delete(deleteId);
	}

	public List<Car> findAvailableCars() {
		return cd.findAvailableCars();
	}

	public List<Car> findCarsByOwnerId(Integer i) {
		return cd.findCarsByOwnerId(i);
	}

	public int addCusToCar(Integer cusId, Integer carId) {
		return cd.addCusToCar(cusId, carId);
	}

	public List<Car> findAllCarsWithBalance(int id) {
		return cd.findAllCarsWithBalance(id);
	}

	public List<Car> findAllCarsWithBalance() {
		return cd.findAllCarsWithBalance();
	}

	public Car findById(int carId) {
		return cd.findById(carId);
	}

	public int makePayment(Integer carId, Integer amount) {
		return cd.makePayment(carId, amount);
	}

}
