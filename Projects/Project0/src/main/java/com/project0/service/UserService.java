package com.project0.service;

import com.project0.models.Customer;
import com.project0.repo.UserDao;

public class UserService {
	private UserDao repo;
	
	public UserService() {
		repo = new UserDao();
		
	}
	//check the user credentials
	public int checkLogin(String user,String password) {
		int code = 2;
		code = repo.checkLogin(user,password);
		return code;
	} //end of checkLogin method
	
	
	//check if its a unique/valid user name
	public boolean validUsername(String username) {
		//check if its null or empty
		if(username == null || username.isEmpty()) {
			return false;
		} else { //make sure there isn't someone with that username already
			return repo.checkUsername(username);
		}
	} //end of validUsername method
	
	
	//check if its a valid password
	public boolean validPassword(String password) {
		//check if its null or empty
		if(password == null || password.isEmpty()) {
			return false;
		} else {
			return true;
		}
	} //end of validPassword method
	
	//register the user name, password, and customer object
	public int register(String username, String password) {
		return repo.registerCustomer(username,password);
		//add to database. 
	} //end of register method
	
	
}
