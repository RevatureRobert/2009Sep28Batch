package com.car_dealership_cli.user_interface;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.car_dealership_cli.controller.UserController;
import com.car_dealership_cli.dao.CarDAO;
import com.car_dealership_cli.dao.OfferDAO;
import com.car_dealership_cli.model.Offer;
import com.car_dealership_cli.model.User;
import com.car_dealership_cli.user_interface.interfaces.Menu;

public class OfferMenu implements Menu {
	Scanner input;
	User user;
	boolean cont = false;
	@Override
	public void open(Scanner a) {
		this.input = a;
		this.user = UserController.getUser();
		do {
			display();
			select(input.next());
			exit();
		}while(!cont);

	}

	@Override
	public void display() {
		Menu vI = new ViewInventory();
		vI.open(input);
		System.out.println("If you would like to make an offer on a car, please select the car's number. If not enter 'n'.");

	}

	@Override
	public boolean select(String in) {
		// TODO Auto-generated method stub
		//System.out.println(in);
		Pattern r = Pattern.compile("[^0-9]");
		Matcher m = r.matcher(in);
		if(m.find()) {
			System.out.println("Thank you for viewing the cars on the lot");
		}
		else {
			System.out.println("Plese enter the ammount of money you wish to offer in exchange for the vehicle selected. (XXXXX.XX)");
			CarDAO cd = new CarDAO();
			Offer offer = new Offer(cd.findById(Integer.parseInt(in)), input.nextDouble(), user);
			OfferDAO od = new OfferDAO();
			od.create(offer);
			System.out.println("\nOffer submitted.");
		}
		return false;
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		cont = true;

	}

}
