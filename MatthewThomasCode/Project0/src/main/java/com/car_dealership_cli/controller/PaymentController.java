package com.car_dealership_cli.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.car_dealership_cli.dao.CarDAO;
import com.car_dealership_cli.model.Car;

public class PaymentController {
	public static void view(String in) {
		Pattern p = Pattern.compile("[^0-9]");
		Matcher m = p.matcher(in);
		if(m.find()) {
			
			
		}else {
			CarDAO cd = new CarDAO();
			Car car = cd.findById(Integer.parseInt(in));
			int remainingPayments = (int)Math.round((car.getDebt() / car.getPayment()));
			System.out.println("There are "+remainingPayments + " payments of $"+ car.getPayment()+" left on this vehicle");
		
			
		}
	}
}
