package com.cardealership.service;

import java.util.List;

import com.cardealership.config.PlainTextConnectionUtil;
import com.cardealership.model.Admin;
import com.cardealership.model.Employee;
import com.cardealership.model.Offers;
import com.cardealership.model.Unsold_Car;
import com.cardealership.repo.DealershipDao;

public class DealershipService {
	
	DealershipDao dd = new DealershipDao();
	
	public void viewCars(Admin t) {
		dd.viewLot(t);
	}
	public void viewCars(Employee t) {
		dd.viewLot(t);
	}
	public void viewCars(int dealershipId) {
		dd.viewLot(dealershipId);
	}

	public boolean addCar(int dealershipId, String carName, int askingPrice) {
		if(dd.addCar(dealershipId, carName, askingPrice)) {
			return true;
		}
		return false;
	}
	public boolean removeCar(int carId) {
		if(dd.removeCar(carId)) {
			return true;
		}
		return false;
	}
	public boolean updateCar(int carId, String carName, int askingPrice) {
		if(dd.updateCar(carId, carName, askingPrice)) {
			return true;
		}
		return false;
	}
	public List<Offers> getOffers(int carId){
		List<Offers> offers = dd.getOffers(carId);
		if( offers != null) {
			return offers;
		}
		return null;
	}
	public boolean rejectOffer(int carId, int userId) {
		if(dd.rejectOffer(carId, userId)) {
			return true;
		}
		return false;
	}
	
}
