package com.car_dealership_cli.controller;

import com.car_dealership_cli.dao.UserDAO;
import com.car_dealership_cli.model.User;


public class UserLoginService {
	
	public static boolean login(User tempU, User checkU) {
	UserDAO ud = new UserDAO();
	checkU = ud.findByUsername(tempU.getUserName());
	
	if(checkU.getUserName() == null) {
		System.out.println("Error: User: "+tempU.getUserName()+" does not exist.");
	}else {
	if(checkU.getUserName().equals(tempU.getUserName()) && !checkU.getPassword().equals(tempU.getPassword())) {
		System.out.println("Error: Incorrect Password");
	}
	if(checkU.getUserName().equals(tempU.getUserName()) && checkU.getPassword().equals(tempU.getPassword())) {
		System.out.println("You are Logged in.");
		UserController.setUser(checkU);
		return true;
	}
	}
	return false;
	}
}
