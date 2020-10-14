package com.cars.service;

import com.cars.model.User;
import com.cars.repository.UserDAO;

public class UserService {

	UserDAO ud = new UserDAO();
	
	public User registerService(User user) {
		
		User addedUser = ud.create(user);
		if(addedUser.equals(null)) {
			return null;
		} else {
			return addedUser;
		}
		
		
	}
	
	public boolean mngrService(User user) {
		User checkedUser = ud.findById(user.getUsername());
		if(checkedUser.getUserId() == 3) {
			user.setUserId(3);
			if(checkedUser.getPassword() == user.getPassword()) {
				//if the usernames and passwords match, as well as the userid, this is the manager
				return true;
			} else {
				return false;
			}
			
		} else {
			//the user isn't a manager
			return false;
		}
		
	}
	
	public boolean empService(String username) {
		User checkedUser = ud.findById(username);
		
		try {
			if(checkedUser.getUserType() >= 2 ) {
				//if the user is an employee or manager, return true
				return true;
			} else {
				return false;
			}
		} catch (NullPointerException e) {
			System.out.println("No user found");
			return false;
		}		
	}
	
	public User loginService(User user) {
		User checkedUser = ud.findById(user.getUsername());
		
		try {
			boolean b = checkedUser.equals(null);
		} catch (NullPointerException e) {
			return null;
		}
		
		
		if(checkedUser.getPassword().equals(user.getPassword())) {
			//if the password and username matches, allow the login
			return checkedUser;
		} else {
			System.out.println("Password didnt match");
			return null;
		}
	}
	
	public boolean checkMngrNoPassService(String username) {
		User checkedUser = ud.findById(username);
		
		try {
			if(checkedUser.getUserType() == 3 ) {
				//if the user is a manager, return true
				return true;
			} else {
				return false;
			}
		} catch (NullPointerException e) {
			System.out.println("No user found");
			return false;
		}
		
	}
	
	public User getUserIdService(String username) {
		User checkedUser = ud.findById(username);
		
		try {
			boolean b = checkedUser.equals(null);
			return checkedUser;
		} catch (NullPointerException e){
			return null;
		}

	}
	
	public boolean removeUserService(String username) {
		int deleted = ud.delete(username);
		if(deleted == 1) {
			return true; //user was removed
		} else {
			return false; //user was not removed
		}
		
	}
	
}
