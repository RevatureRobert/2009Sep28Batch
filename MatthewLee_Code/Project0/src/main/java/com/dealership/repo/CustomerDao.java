package com.dealership.repo;

import java.util.List;

import com.dealership.model.Car;
import com.dealership.model.Customer;
import com.dealership.model.Offer;
import com.dealership.model.Payment;

public interface CustomerDao {
	 /**
	  * Register a new customer account.
	  * @param username
	  * @param password
	  * @return number of rows updated
	  */
	public int register(String username, String password);
	
	/**
	 * Login to customer's account
	 * @param username
	 * @param password
	 * @return customer
	 */
	public Customer login(String username, String password);
	
	/**
	 * Get all the available cars on the lot
	 * @return list of available cars
	 */
	public List<Car> viewCarLot();
	
	/**
	 * Make an offer for a car
	 * @param offer
	 * @return number of rows updated
	 */
	public int makeOffer(Offer offer);
	
	/**
	 * Get all of customer's cars
	 * @param customerId
	 * @return list of customer's cars
	 */
	public List<Car> viewCustomerCars(int customerId);
	
	/**
	 * Get all of customer's payments
	 * @param customerId
	 * @return list of customer's payments
	 */
	public List<Payment> viewPayments(int customerId);
	
	/**
	 * Make a payment
	 * @param customerId
	 * @return number of rows updated
	 */
	public int makePayment(Payment payment);
		
}
