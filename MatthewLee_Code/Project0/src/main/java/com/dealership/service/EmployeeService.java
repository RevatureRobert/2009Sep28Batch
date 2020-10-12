package com.dealership.service;

import java.util.List;

import com.dealership.model.Car;
import com.dealership.model.Employee;
import com.dealership.model.Offer;
import com.dealership.model.Payment;
import com.dealership.repo.EmployeeDaoImpl;

public class EmployeeService {
	
	private EmployeeDaoImpl empDAO;
	
	public EmployeeService() {
		this(new EmployeeDaoImpl());
	}

	public EmployeeService(EmployeeDaoImpl empDAO) {
		this.empDAO = empDAO;
	}
	
	public Employee login(String username, String password) {
		return empDAO.login(username, password);
	}
	
	public List<Car> viewCars() {
		return empDAO.viewCars();
	}
	
	public int addCar(Car car) {
		return empDAO.addCar(car);
	}
	
	public int editCar(Car car) {
		return empDAO.editCar(car);
	}
	
	public int removeCar(int carId) {
		return empDAO.removeCar(carId);
	}
	
	public List<Offer> viewOffers() {
		return empDAO.viewOffers();
	}
	
	public void acceptOffer(int offerId) {
		empDAO.acceptOffer(offerId);
	}
	
	public int rejectOffer(int offerId) {
		return empDAO.rejectOffer(offerId);
	}
	
	public List<Payment> viewPayments() {
		return empDAO.viewPayments();
	}
	
}
