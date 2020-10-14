package com.car_dealership_cli.controller;

import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.car_dealership_cli.dao.CarDAO;
import com.car_dealership_cli.model.Car;

public class CarController {
	public static void add(Scanner input) {
		Car car = new Car();
		System.out.println("\n\n\n\n\n");
		System.out.print("\nWhat is the make of the car?: ");
		car.setMake(input.next());
		System.out.print("\nWhat is the model of the car?: ");
		car.setModel(input.next());
		System.out.print("\nWhat is the year of the car?: ");
		car.setYear(input.nextInt());
		System.out.print("\nWhat is the MSRP of the car?: $");
		car.setMSRP(input.nextDouble());
		CarDAO cd = new CarDAO();
		cd.create(car);
		System.out.println("Car Added.");
	}

	public static void remove(Scanner input) {
		
		CarDAO cd = new CarDAO();
		System.out.println("Cars on the lot\n");
		Collection<Car> car = cd.findMapAll().values();
		Object[] c=car.toArray();
		for(int i = 0; i<c.length; i++) {
			System.out.println(((Car)c[i]).getCarId()+": "+c[i].toString());
		}
		System.out.println("Please select a car's id to remove the car, or enter any other key.");
		Pattern r = Pattern.compile("[^0-9]");
		String input2 = input.next();
		Matcher m  = r.matcher(input2);
		if(!m.find()) {
			switch(cd.delete(Integer.parseInt(input2))) {
			case 0:
				System.out.println("Car not found.");
				break;
			case 1:
				System.out.println("Car deleted.");
				break;
			default:
				System.out.println("What did you do? You killed it. You'll be fired for sure.");
			}
		}
			
	}
}
