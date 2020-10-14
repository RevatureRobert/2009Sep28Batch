package com.dealership.dao;

import java.util.ArrayList;

import com.dealership.pojos.Car;
import com.dealership.pojos.Employee;
import com.dealership.pojos.Offer;
import com.dealership.pojos.Payment;
import com.dealership.pojos.SoldCar;
import com.dealership.pojos.UnsoldCar;
import com.dealership.pojos.User;

public interface DealershipDAO {
//	public ArrayList<String> getAllUsernames();

	public void closeAllConnections();

	public String getPasswordHashForUser(String username);

	public User getUserData(String username);
	
	public boolean doesUsernameExist(String username);
	
	public boolean createUser(User user);
	
	public ArrayList<UnsoldCar> getUnsoldCars();
	
	public ArrayList<SoldCar> getSoldCars();

	public void createOffer(Offer offer);

	public ArrayList<Offer> getOffers(UnsoldCar car);

	public void addEmployeeToCustomerBase(Employee user);

	public String getNameForUser(String customerId);

	public boolean acceptOffer(Offer offer);

	public void rejectOffer(Offer offer);

	public void commitCarChanges(UnsoldCar car);

	public void removeCarListing(Car car);

	public int listNewCar(UnsoldCar car);

	public ArrayList<SoldCar> getSoldCars(User user);

	public ArrayList<Payment> getPayments(SoldCar car);

	public void makePayment(Payment payment);

	public ArrayList<Employee> getEmployees();

	public void registerUserAsEmployee(String username);

	public void promoteEmployee(Employee empl);

	public void removeEmployee(Employee empl);
}
