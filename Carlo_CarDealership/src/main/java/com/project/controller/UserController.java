package com.project.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.project.model.User;
import com.project.service.UserService;
import com.project.ui.Printers;

public class UserController {
	
	private UserService us;
	final static Logger logger = Logger.getLogger(UserController.class);

	public UserController() {
		this(new UserService());
	}

	public UserController(UserService cs) {
		this.us = cs;
	}
	
	public List<User> findAll() {
		return us.findAll();
	}
	
	public User findByNamePass(String name, String pass) {
		Printers.loading("search");
		return us.findByNamePass(name, pass);
	}
	
	public User insert(User c) {
		try {
			User result = us.create(c);
			logger.info("Customer successfully created: "+c.getUsername());
			Printers.loading("create");
			Printers.validInput();
			return result;
		} catch(Exception e) {
//			logger.error("Error creating user, likely duplicate");
//			Printers.duplicateInput();
			return null;
		}
	}
	
	public User insertEmployee(User c) {
		try {
			User result = us.createEmployee(c);
			logger.info("Employee successfully created: "+c.getUsername());
			Printers.loading("create");
			Printers.validInput();
			return result;
		} catch(Exception e) {
			return null;
		}
	}
	
	public int remove(Integer i) {
		return us.delete(i);
	}

}
