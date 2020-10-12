package com.dealership.controller;

import java.util.List;

import com.dealership.model.Car;
import com.dealership.model.Employee;
import com.dealership.model.Offer;
import com.dealership.model.Payment;
import com.dealership.service.EmployeeService;

public class EmployeeController {

	private EmployeeService empService;

	public EmployeeController() {
		this(new EmployeeService());
	}
	
	public EmployeeController(EmployeeService empService) {
		this.empService = empService;
	}
	
	public Employee login(String username, String password) {
		return empService.login(username, password);
	}
	
	public List<Car> viewCars() {
		return empService.viewCars();
	}
	
	public int addCar(Car car) {
		return empService.addCar(car);
	}
	
	public int editCar(Car car) {
		return empService.editCar(car);
	}
	
	public int removeCar(int carId) {
		return empService.removeCar(carId);
	}
	
	public List<Offer> viewOffers() {
		return empService.viewOffers();
	}
	
	public void acceptOffer(int offerId) {
		empService.acceptOffer(offerId);
	}
	
	public int rejectOffer(int offerId) {
		return empService.rejectOffer(offerId);
	}
	
	public List<Payment> viewPayments() {
		return empService.viewPayments();
	}
	
}
