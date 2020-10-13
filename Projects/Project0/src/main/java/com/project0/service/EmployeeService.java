package com.project0.service;

import java.util.ArrayList;
import java.util.List;

import com.project0.models.Car;
import com.project0.models.Customer;
import com.project0.models.Employee;
import com.project0.models.Offer;
import com.project0.repo.CarDao;
import com.project0.repo.EmployeeDao;
import com.project0.repo.OfferDao;
import com.project0.repo.PaymentDao;

public class EmployeeService {
	
	private EmployeeDao ed;
	private CarDao card;
	private PaymentDao pd;
	private OfferDao od;
	
	
	public EmployeeService() {
		ed = new EmployeeDao();
		card = new CarDao();
		pd = new PaymentDao();
		od = new OfferDao();
	}
	
	public List<Employee> findAll(){
		return ed.findAll();
	}
	
	public Employee findById(Integer i) {
		return ed.findById(i);
	}
	
	public Employee update(Employee t) {
		return ed.update(t);
	}
	
	public boolean delete(int i) {
		int result = ed.delete(i);
		return result == 1;
	}
	
	public int findId(String username) {
		return ed.findId(username);
	}
	
	public List<Car> getCarLot() {
		List<Car> cars = new ArrayList<Car>();
		ArrayList<Integer> ids = od.getCarIDs();
		for(Integer x:ids) {
			cars.add(card.findById(x));
		}
		return cars;
	}
	
	public List<Offer> getOffers() {
		ArrayList<Offer> offers = (ArrayList<Offer>) od.findAllCurrent();
		return offers;
	}

	public void approveOffer(Offer offer) {
		//to approve an offer
		/* 1. Approve the offer
		 * 2. Reject all other offers
		 * 3. create a payment for the car 
		 */
		
		
	}

	public void rejectOffer(Offer offer) {
		
	}
	
}
