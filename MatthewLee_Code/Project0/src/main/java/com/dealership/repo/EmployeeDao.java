package com.dealership.repo;

import java.util.List;

import com.dealership.model.Car;
import com.dealership.model.Employee;
import com.dealership.model.Offer;
import com.dealership.model.Payment;

public interface EmployeeDao {
	 /**
	  * Login to employee account
	  * @param username
	  * @param password
	  * @return employee
	  */
	public Employee login(String username, String password);
	
	/**
	 * Get all the available cars on the lot
	 * @return list of available cars
	 */
	public List<Car> viewCars();
	
	/**
	 * Add a car to the lot
	 * @param car
	 * @return number of rows updated
	 */
	public int addCar(Car car);
	
	/**
	 * Edit an existing car on the lot
	 * @param car
	 * @return number of rows updated
	 */
	public int editCar(Car car);
	
	/**
	 * Remove a car from the lot
	 * @param carId
	 * @return number of rows updated
	 */
	public int removeCar(int carId);
	
	/**
	 * Get all customer offers
	 * @return list of offers
	 */
	public List<Offer> viewOffers();
	
	/**
	 * Accept an offer
	 * @param offerId
	 * @return number of rows updated
	 */
	public void acceptOffer(int offerId);

	/**
	 * Reject an offer
	 * @param offerId
	 * @return number of rows updated
	 */
	public int rejectOffer(int offerId);

	/**
	 * Get all customer payments
	 * @return list of payments
	 */
	public List<Payment> viewPayments();
	
}
