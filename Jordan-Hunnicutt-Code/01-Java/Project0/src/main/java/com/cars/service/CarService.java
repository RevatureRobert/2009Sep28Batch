package com.cars.service;

import java.util.ArrayList;
import java.util.List;

import com.cars.model.Car;
import com.cars.model.Offer;
import com.cars.repository.CarDAO;
import com.cars.repository.OfferDAO;

public class CarService {

	CarDAO cd = new CarDAO();
	OfferDAO od = new OfferDAO();
	
	public List<Car> lotService() { //calls to the repository class, gets values back from repo, assembles into car objects for controller
		List<Car> results = new ArrayList<>();
		
		results = cd.findSome(0);
		
		return results;
	}
	
	public boolean addCarService(Car car) {
		Car newCar = cd.create(car);
	
		try {
			boolean b = newCar.equals(null);
			return true;
		} catch(NullPointerException e){
			return false;
		}
		
	}
	
	public boolean removeCarService(int id) {
		int deleted = cd.delete(id);
		
		if(deleted == 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean findOwnedService(int id) {
		Car c = cd.findById(id);
		int userId = c.getUserId();
		if(userId <= 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public Car findCarService(int id) {
		Car c = cd.findById(id);
		return c;
	}
	
	public boolean editCarService(Car car) {
		Car editedCar = cd.update(car);
		
		try {
			boolean b = editedCar.equals(null);
			return true; //returns true if the car was edited
		} catch(NullPointerException e){
			return false;
		}
	}
	
	public List<Offer> getOffers(int i) {
		List<Offer> offers = od.findSome(i);
		
		return offers;
	}
	
	public List<Car> ownedService(int i){
		List<Car> results = new ArrayList<>();
		
		results = cd.findSome(i);
		
		return results;
	}
	
}
