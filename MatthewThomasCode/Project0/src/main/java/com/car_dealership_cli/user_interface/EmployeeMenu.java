package com.car_dealership_cli.user_interface;

import java.util.Collection;

import java.util.Scanner;

import com.car_dealership_cli.controller.CarController;
import com.car_dealership_cli.controller.OfferController;
import com.car_dealership_cli.controller.PaymentController;
import com.car_dealership_cli.dao.CarDAO;
import com.car_dealership_cli.model.Car;
import com.car_dealership_cli.user_interface.interfaces.Menu;

public class EmployeeMenu implements Menu {
	Scanner input;
	boolean cont = false;
	@Override
	public void open(Scanner a) {
		this.input = a;
		do {
			display();
			select(input.next());
		
		
		}while(!cont);

	}

	@Override
	public void display() {
		System.out.println("\nPlease Select a Number\n");
		System.out.println("1. Add Car to the Lot");
		System.out.println("2. Remove Car from the Lot");
		System.out.println("3. View Active Offers");
		System.out.println("4. View Payments");
		System.out.println("5. Exit");

	}

	@Override
	public boolean select(String in) {
		switch(in) {
		case "1":
			CarController.add(input);
			break;
		case "2":
			CarController.remove(input);
			break;
		case "3":
			OfferController.view(input);
			break;
		case "4":
			CarDAO cd = new CarDAO();
			System.out.println("Vehicles with remaining payments:");
			//System.out.println(cd.findMapDebtors());
			Collection<Car> c = cd.findMapDebtors().values();
			Object[] c2 = c.toArray();
			for (int i=0;i<c2.length;i++) {
				System.out.println(((Car)c2[i]).getCarId() +": " + c2[i].toString());
			}
			System.out.println("If you would like to view the remaining payments on a vehicle, select the vehicle in question. Otherwise enter any other key.");
			PaymentController.view(input.next());
			System.out.println("Enter any key to continue.");
			input.next();
			break;
		case "5":
			exit();
			break;
		default:
			System.out.println("\n\n\n\nPlease Select a Valid Option");
		}
		return false;
	}

	@Override
	public void exit() {
		cont = true;

	}

}
