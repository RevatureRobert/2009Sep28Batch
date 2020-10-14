package com.car_dealership_cli.user_interface;

import java.util.Collection;
import java.util.Scanner;

import com.car_dealership_cli.dao.CarDAO;
import com.car_dealership_cli.model.Car;
import com.car_dealership_cli.user_interface.interfaces.Menu;

public class ViewInventory implements Menu {
	Scanner input;
	boolean cont = false;
	CarDAO cd = new CarDAO();
	@Override
	public void open(Scanner a) {
		this.input = a;
		do {
			display();
			select(input.next());
			exit();
		}while (!cont);
	}

	@Override
	public void display() {
		
		//System.out.println(cd.findMapAll().);
		System.out.println("\n\n\n   Cars on the Lot:");
		Collection<Car> c = cd.findMapAll().values();
		Object[] c2 =  c.toArray();
		for (int i=0;i<c2.length;i++) {
			System.out.println(((Car)c2[i]).getCarId() +": " + c2[i].toString());
		}
		System.out.println("Enter 'y' when you are done viewing the cars on the lot.");

	}

	@Override
	public boolean select(String in) {
		
		return false;
	}

	@Override
	public void exit() {
	cont = true;

	}

}
