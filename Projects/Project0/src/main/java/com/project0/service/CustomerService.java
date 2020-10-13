package com.project0.service;

import java.util.ArrayList;
import java.util.List;

import com.project0.models.Car;
import com.project0.models.Customer;
import com.project0.models.Offer;
import com.project0.models.Payment;
import com.project0.repo.CarDao;
import com.project0.repo.CustomerDao;
import com.project0.repo.OfferDao;
import com.project0.repo.PaymentDao;

public class CustomerService {
	
	private CustomerDao cd;
	private CarDao card;
	private PaymentDao pd;
	private OfferDao od;
	
	public CustomerService() {
		cd = new CustomerDao();
		card = new CarDao();
		pd = new PaymentDao();
		od = new OfferDao();
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
	
	public boolean delete(int i) {
		int result = cd.delete(i);
		return result == 1;
	}
	
//	public List<Car> findMine(int userID){
//		return card.findMine(userID);
//	}
	
	public List<Car> findMyCars(int userID){
		List<Car> cars = new ArrayList<Car>();
		ArrayList<Integer> carids = pd.getUserCars(userID);
		for(Integer x :carids) {
			cars.add(card.findById(x));
		}
		return cars;
	}
	
	public int findId(String username) {
		return cd.findId(username);
	}

	public List<Car> getCarLot() {
		List<Car> cars = new ArrayList<Car>();
		ArrayList<Integer> ids = od.getCarIDs();
		for(Integer x:ids) {
			cars.add(card.findById(x));
		}
		return cars;
	}
	
	public List<Payment> findMyPayments(int userID){
		List<Payment> payments = pd.findByUser(userID);
		return payments;
	}

	public Payment makePayment(Payment pay, int months) {
		pay.pay(months);
		return pd.update(pay);
	}

	public List<Offer> getOffers() {
		ArrayList<Offer> offers = (ArrayList<Offer>) od.findAllCurrent();
		return offers;
	}

	public void makeNewOffer(Offer newO) {
		od.create(newO);
	}
	
	public void updateOffer(Offer offer) {
		od.update(offer);
	}
}
