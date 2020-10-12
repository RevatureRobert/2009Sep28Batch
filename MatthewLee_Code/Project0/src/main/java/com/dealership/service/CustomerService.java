package com.dealership.service;

import java.util.List;

import com.dealership.model.Car;
import com.dealership.model.Customer;
import com.dealership.model.Offer;
import com.dealership.model.Payment;
import com.dealership.repo.CustomerDaoImpl;

public class CustomerService {
	
	private CustomerDaoImpl cDAO;

	public CustomerService() {
		this(new CustomerDaoImpl());
	}
	
	public CustomerService(CustomerDaoImpl cDAO) {
		this.cDAO = cDAO;
	}
	
	public int register(String username, String password) {
		return cDAO.register(username, password);
	}
	
	public Customer login(String username, String password) {
		return cDAO.login(username, password);
	}
	
	public List<Car> viewCarLot() {
		return cDAO.viewCarLot();
	}
	
	public int makeOffer(Offer offer) {
		return cDAO.makeOffer(offer);
	}
	
	public List<Car> viewCustomerCars(int customerId) {
		return cDAO.viewCustomerCars(customerId);
	}
	
	public List<Payment> viewPayments(int customerId) {
		return cDAO.viewPayments(customerId);
	}
	
	public int makePayment(Payment payment) {
		return cDAO.makePayment(payment);
	}
	
}
