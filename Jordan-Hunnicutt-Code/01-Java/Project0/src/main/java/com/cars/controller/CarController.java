package com.cars.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cars.model.Car;
import com.cars.model.Offer;
import com.cars.service.CarService;
import com.cars.ui.TextEffects;

public class CarController {

	private CarService cs = new CarService();
	
	private List<Car> cars;
	private List<String> carStrings = new ArrayList<>();
	
	public List<String> lotController(Integer i) { //calls to the service class, puts car values into strings for ui
		
		cars = cs.lotService();
		
		if(cars.isEmpty()) {
			cars.add(new Car(1, "Buick", "Terraza", "Gold", 2005, 2400, 0));
			boolean b = cs.addCarService(cars.get(0));
			if(b == false) {
				System.out.println("Error occured while adding car to the database.");
			} else {				
			}
		}
		
		setupCarStrings();		
		
		return formatCarInfo(i);
	}
	
	private void setupCarStrings() {
		carStrings.clear();
		
		for (Car car : cars) {
			carStrings.add(car.getColor());
			carStrings.add(Integer.toString( car.getYear() ));
			carStrings.add(car.getMake());
			carStrings.add(car.getModel());
			carStrings.add(Integer.toString( car.getCarId() ));
			carStrings.add(Integer.toString( car.getListPrice() ));
			carStrings.add(Integer.toString( car.getListPrice() / 12 ));
			//7 long
		}
	}
	
	private List<String> formatCarInfo(Integer i) {
		
		i = i * 7;
		if(i > carStrings.size()) {
			i = i / 7;
			i--;
			i = i * 7;
			//goes to the last page if greater than size
		}
		try {
			String line1 = carStrings.get(i) + " " + carStrings.get(i+1) + " " + carStrings.get(i+2) + " " + carStrings.get(i+3);
			String line2 = "ID: " + carStrings.get(i+4);
			String line3 = "Price: $" + carStrings.get(i+5) + " or 12 monthly payments of $" + carStrings.get(i+6);
			String currentInt = i.toString();
			return Arrays.asList(line1, line2, line3, currentInt);
		} catch (IndexOutOfBoundsException e) {
			i = 0;
			String line1 = TextEffects.ANSI_RED+"There are no more cars in that direction. Returning to the first page\n"+TextEffects.ANSI_BLUE+carStrings.get(i) + " " + carStrings.get(i+1) + " " + carStrings.get(i+2) + " " + carStrings.get(i+3);
			String line2 = "ID: " + carStrings.get(i+4);
			String line3 = "Price: $" + carStrings.get(i+5) + " or 12 monthly payments of $" + carStrings.get(i+6);
			return Arrays.asList(line1, line2, line3, "0");
		}
		
	}
	
	public List<String> carOfferViewing(Integer i) {
		
		//i = i * 7;
		
		String line1 = carStrings.get(i) + " " + carStrings.get(i+1) + " " + carStrings.get(i+2) + " " + carStrings.get(i+3);
		String line2 = "ID: " + carStrings.get(i+4);
		String line3 = "Price: $" + carStrings.get(i+5) + " or 12 monthly payments of $" + carStrings.get(i+6);
		String currentInt = i.toString();
		
		int idToCheck = Integer.parseInt(carStrings.get(i+4));
		List<Offer> offers = cs.getOffers(idToCheck);
		String line4 = "";
		
		if(offers.isEmpty()) {
			line4 = "There are currently no offers on this vehicle.";
		} else {
			for (Offer o : offers) {
				line4 += "$" + o.getAmount() + " ";
			}
		}
		
		return Arrays.asList(line1, line2, line3, line4, currentInt);
	}
	
	public List<String> carOfferEmpViewing(Integer i){
		//this code is almost identical to carOfferViewing. The only difference is employees get to see who made what offers
		//i = i * 7;
		
		String line1 = carStrings.get(i) + " " + carStrings.get(i+1) + " " + carStrings.get(i+2) + " " + carStrings.get(i+3);
		String line2 = "ID: " + carStrings.get(i+4);
		String line3 = "Price: $" + carStrings.get(i+5) + " or 12 monthly payments of $" + carStrings.get(i+6);
		String currentInt = i.toString();
		
		int idToCheck = Integer.parseInt(carStrings.get(i+4));
		List<Offer> offers = cs.getOffers(idToCheck);
		String line4 = "";
		
		if(offers.isEmpty()) {
			line4 = "There are currently no offers on this vehicle.";
		} else {
			for (Offer o : offers) {
				line4 += "$" + o.getAmount() + " by user with ID: " + o.getUserId() + " ";
			}
		}
		
		return Arrays.asList(line1, line2, line3, line4, currentInt);
	}
	
	public String addCarController(String make, String model, String color, int year, int price){
		
		Car c = new Car(0, make, model, color, year, price, 0);
		boolean b = cs.addCarService(c);
		if(b) {
			return "Car successfully added to lot.";
		} else {
			return "Something went wrong, car was not successfully added.";
		}

	}
	
	public String removeCarController(int id) {
		
		boolean b1 = cs.findOwnedService(id);
		if(b1) {
			return "This car is already owned, and does not appear on the lot.";
		}		
		
		boolean b2 = cs.removeCarService(id);
		if(b2) {
			return "Car successfully removed from lot.";
		} else {
			return "Something went wrong, car was not successfully removed.";
		}
		
	}
	
	public boolean editCarCheckController(int id) {
		
		boolean b1 = cs.findOwnedService(id);
		if(b1) { //if the car is owned, return false, we can't edit this
			return false;
		}
		
		return true;
	}
	
	public String editCarController(int id, String make, String model, String color, int year, int price) {
		Car c = new Car(id, make, model, color, year, price, 0);
		boolean b = cs.editCarService(c);
		if(b) {
			return "Car successfully edited.";
		} else {
			return "Something went wrong, car was not successfully edited.";
		}
	}
	
	public List<String> ownedController(int userid){ //for ownedcarsui below
		
		cars = cs.ownedService(userid);
		
		setupCarStringsAbbreviated();		
		
		return formatCarInfoAbbreviated();
	}
	
	private void setupCarStringsAbbreviated() {
		carStrings.clear();
		
		for (Car car : cars) {
			carStrings.add(car.getColor());
			carStrings.add(Integer.toString( car.getYear() ));
			carStrings.add(car.getMake());
			carStrings.add(car.getModel());
			carStrings.add(Integer.toString( car.getCarId() ));
			//5 long
		}
	}
	
	private List<String> formatCarInfoAbbreviated() {
		
		List<String> allStrings = new ArrayList<>();
		
		try {
			for(int i = 0; i < cars.size(); i++) {
				i = i * 5;
				String line1 = carStrings.get(i) + " " + carStrings.get(i+1) + " " + carStrings.get(i+2) + " " + carStrings.get(i+3)+" ID: " + carStrings.get(i+4);
				i = i / 5;
				allStrings.add(line1);
			}
			
			return allStrings;
		} catch (IndexOutOfBoundsException e) {
			
		}
		
		if(allStrings.isEmpty()) {
			return Arrays.asList("You do not own any cars.");
		}
		
		return allStrings;
	}
}
