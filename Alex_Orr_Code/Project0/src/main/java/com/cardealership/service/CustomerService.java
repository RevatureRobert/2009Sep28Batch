package com.cardealership.service;

import java.util.List;

import com.cardealership.model.Customer;
import com.cardealership.model.Offers;
import com.cardealership.model.Sold_Car;
import com.cardealership.repo.CustomerDao;

public class CustomerService {
	private CustomerDao cd;
	
	public CustomerService() {
		this(new CustomerDao());
	}
	public CustomerService(CustomerDao cd) {
		super();
		this.cd = cd;
	}
	
	public List<Customer> findAll(){
		return cd.findAll();
	}
	public Customer findById(Integer i) {
		return cd.findById(i);
	}
	public Customer update(Customer t) {
		return cd.update(t);
	}
	public Customer create(Customer t) {
		return cd.create(t);
	}
	public Customer create(String userName, String password, String fname, String lname, String email) {
		return cd.create(userName, password, fname, lname, email);
	}
	public int delete(Integer i) {
		return cd.delete(i);
	}
	public List<Sold_Car> myCars(int userId){
		return cd.myCars(userId);
	}
	public boolean makeOffer(int carId, int offerAmount, Customer t) {
		if(cd.makeOffer(carId, offerAmount, t)) {
			return true;
		}
		return false;
	}
	public List<Offers> getOffers(Customer t){
		List<Offers> offers = cd.getOffers(t);
		if( offers != null) {
			return offers;
		}
			
		return null;
	}
	public boolean removeOffer(int carId, Customer t) {
		if(cd.removeOffer(carId, t)) {
			return true;
		}
		return false;
	}
	public int getBalance(Customer t) {
		return cd.getBalance(t);
	}
	public int makePayment(int amount, Customer t) {
		return cd.makePayment(amount, t);
	}
}
