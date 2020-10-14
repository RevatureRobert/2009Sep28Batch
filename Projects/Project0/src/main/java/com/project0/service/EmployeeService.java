package com.project0.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.project0.enums.CarName;
import com.project0.models.Car;
import com.project0.models.Employee;
import com.project0.models.Offer;
import com.project0.models.Payment;
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
		return card.getCarLot();
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
		od.approveOffer(offer);
	}

	public void rejectOffer(Offer offer) {
		od.rejectOffer(offer);
	}

	public int addCar(CarName car) {
		// TODO Auto-generated method stub
		Car cc = new Car(car,0);
		cc= card.create(cc);
		return cc.getCarID();
	}

	public void deleteCar(int choice) {
		card.delete(choice);
		
	}
	
	public HashMap<Integer,ArrayList<Car>> getCarMap(){
		ArrayList<Car> cars = card.getOwnedCars();
		ArrayList<Integer> usersAndCars = pd.getAllUserCars();
		HashMap<Integer,ArrayList<Car>> carMap = new HashMap<Integer,ArrayList<Car>>();
		
		//this maps the user ids to the car ids. 
		for(int i = 0;i<usersAndCars.size();i+=2) {
			int user = usersAndCars.get(i);
			Car car = null;
			for(Car x:cars) {
				if(usersAndCars.get(i+1) == x.getCarID()) {
					car = x;
					cars.remove(x);
					break;
				}
			}
			if(carMap.containsKey(user)) {
				carMap.get(user).add(car);
			} else {
				carMap.put(user, new ArrayList<Car>(Arrays.asList(car)));
			}
		}
		return carMap;
	}

	public HashMap<Integer,ArrayList<Payment>> getPaymentMap() {
		ArrayList<Payment> payments = (ArrayList<Payment>) pd.findAll();
		HashMap<Integer,ArrayList<Payment>> ordered = new HashMap<Integer,ArrayList<Payment>>();
		for(Payment x:payments) {
			if(ordered.containsKey(x.getUserId())) {
				ordered.get(x.getUserId()).add(x);
			}else {
				ordered.put(x.getUserId(), new ArrayList<Payment>(Arrays.asList(x)));
			}
		}
		return ordered;
	}
	
}
