package com.cars.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cars.model.Car;
import com.cars.model.User;
import com.cars.service.UserService;
import com.cars.ui.RegisterAndLoginUI;

public class UserController {
	
	private UserService serv = new UserService();
	
	private User currentUser = null;
	
	private static UserController instance;
	
	private UserController() {
		
	}

	public static UserController getInstance() {
		if(instance == null) {
			instance = new UserController();
		}
		return instance;
	}
	
	public String registerControl(String uName, String uPass, int uType) {
		User added = serv.registerService(new User(0, uName, uPass, uType));
		if(added.equals(null)) {
			return "Something went wrong while adding user to the database.";
		} else {
			currentUser = added;
			return "User was successfully added.";
		}
	}
	
	public boolean checkMngr(String eName, String ePass, int uType) {
		//if database contains employee, return true
		boolean isValid = serv.mngrService(new User(0, eName, ePass, uType));
		
		return true;
	}
	
	public boolean checkEmp() {
		
		String s;
		
		try {
			s = currentUser.getUsername();
		} catch (NullPointerException e) {
			return false;
		}		
		
		if(s.isEmpty()) {
			return false;
		}
		
		boolean isValid = serv.empService(s);
		
		return isValid;
	}
	
	public String loginControl(String uName, String uPass) {
		User checked = serv.loginService(new User(0, uName, uPass, 1));
		
		try {
			boolean b = checked.equals(null);
			currentUser = checked;
			return "User successfully logged in.";
		} catch (NullPointerException e) {
			return "Something went wrong while finding the user.";
		}
		
	}
	
	public String getCurrentUsername() {
		
		try{
			return "The current user is: "+currentUser.getUsername();
		}catch (NullPointerException e){
			//do nothing
			return "";
		}
	}
	
	public void logOut() {
		currentUser = null;
	}
	
	public boolean checkManagerNoPassController() {
		String s;
		
		try {
			s = currentUser.getUsername();
		} catch (NullPointerException e) {
			return false;
		}		
		
		if(s.isEmpty()) {
			return false;
		}
		
		boolean isValid = serv.checkMngrNoPassService(s);
		
		return isValid;
	}
	
	public int getUserIdController(String username) {
		User u = serv.getUserIdService(username);
		
		try {
			int id = u.getUserId();
			return id;
		} catch (NullPointerException e) {
			return -1;
		}

	}
	
	public String removeUserController(String username) {
		boolean b = serv.removeUserService(username);
		if(b) {
			return "User removed successfully.";
		} else {
			return "Something went wrong, user was not removed.";
		}
	}
	
	public boolean checkEmpAsManager(String username) {
		
		boolean isEmployee = serv.empService(username);
		
		return isEmployee;
		
	}
	
}
