package com.dealership.controller;

import com.dealership.models.User;
import com.dealership.service.UserService;

public class UserController {

	private UserService service;
	
	public UserController() {
		this(new UserService());
	}
	
	public UserController(UserService service) {
		super();
		this.service = service;
	}
	
	public User validateUser(User user) {
		return service.validateUser(user);
	}
	
	public boolean createCustomerAccount(User customer) {
		return service.createCustomerAccount(customer);
	}
	
	public boolean changePassword(User user) {
		return service.changePassword(user);
	}
	
	public User findByID(String username) {
		return service.findByID(username);
	}
}
