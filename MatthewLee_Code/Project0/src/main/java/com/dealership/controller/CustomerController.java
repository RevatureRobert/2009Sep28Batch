package com.dealership.controller;

import java.util.List;

import com.dealership.model.Car;
import com.dealership.model.Customer;
import com.dealership.model.Offer;
import com.dealership.model.Payment;
import com.dealership.service.CustomerService;

public class CustomerController {

	private CustomerService cService;
	
	public CustomerController() {
		this(new CustomerService());
	}

	public CustomerController(CustomerService cService) {
		this.cService = cService;
	}
	
	public int register(String username, String password) {
		return cService.register(username, password);
	}
	
	public Customer login(String username, String password) {
		return cService.login(username, password);
	}
	
	public List<Car> viewCarLot() {
		return cService.viewCarLot();
	}
	
	public int makeOffer(Offer offer) {
		return cService.makeOffer(offer);
	}
	
	public List<Car> viewCustomerCars(int customerId) {
		return cService.viewCustomerCars(customerId);
	}
	
	public List<Payment> viewPayments(int customerId) {
		return cService.viewPayments(customerId);
	}
	
	public int makePayment(Payment payment) {
		return cService.makePayment(payment);
	}
	
}
