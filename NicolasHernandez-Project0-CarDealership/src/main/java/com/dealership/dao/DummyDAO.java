package com.dealership.dao;

import java.util.ArrayList;

import com.dealership.pojos.Car;
import com.dealership.pojos.Customer;
import com.dealership.pojos.Employee;
import com.dealership.pojos.Offer;
import com.dealership.pojos.Payment;
import com.dealership.pojos.SoldCar;
import com.dealership.pojos.UnsoldCar;
import com.dealership.pojos.User;

public class DummyDAO implements DealershipDAO {

//	@Override
	public ArrayList<String> getAllUsernames() {
		ArrayList<String> nameList = new ArrayList<>();
		
		nameList.add("rumbus");
		nameList.add("a plain ol moose");
		nameList.add("darn skippy");
		nameList.add("lord pringles can");
		nameList.add("lambchop the destroyer");
		
		nameList.add("customer");
		nameList.add("employee");
		nameList.add("manager");
		
		return nameList;
	}
	
	@Override
	public String getPasswordHashForUser(String username) {
		String passwordHash = "_MÌ;Z§eÖƒ'Þ¸‚Ï™";
		
		return passwordHash;
	}
	
	@Override
	public User getUserData(String username) {
		if(username.equals("employee"))
			return new Employee(username, "_MÌ;Z§eÖƒ'Þ¸‚Ï™", "A World Turner", false, false);
		else if(username.equals("manager"))
			return new Employee(username, "_MÌ;Z§eÖƒ'Þ¸‚Ï™", "The Director", false, true);
		
		return new Customer(username, "_MÌ;Z§eÖƒ'Þ¸‚Ï™", "Valued Customer");
	}

	@Override
	public void closeAllConnections() {
		
	}

	@Override
	public boolean doesUsernameExist(String s) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean createUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<UnsoldCar> getUnsoldCars() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SoldCar> getSoldCars() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOffer(Offer offer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Offer> getOffers(UnsoldCar car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEmployeeToCustomerBase(Employee user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNameForUser(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean acceptOffer(Offer offer) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejectOffer(Offer offer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commitCarChanges(UnsoldCar car) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCarListing(Car car) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int listNewCar(UnsoldCar car) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<SoldCar> getSoldCars(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Payment> getPayments(SoldCar car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makePayment(Payment payment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerUserAsEmployee(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void promoteEmployee(Employee empl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEmployee(Employee empl) {
		// TODO Auto-generated method stub
		
	}
}
