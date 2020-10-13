package com.carsales.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.carsales.dao.UserDao;
import com.carsales.model.User;

public class UserController {
	
	private UserDao ud;
	private static final Logger log = Logger.getLogger(UserController.class);
	
	public UserController() {
		this(new UserDao());
	}
	
	public UserController(UserDao us) {
		super();
		this.ud = us;
	}
	
	public int addUser(User use) {
		
		log.info("New User Created: " + use.getUserName());
		return ud.addUser(use);
		
	}
	
	public User checkUser(User use) {
		return ud.LoginCheck(use);
	}
	
	public User permissionCheck(User use) {
		return ud.PermissionCheck(use);
	}
	
	public List<User> getEmployeebyRole(String role) {
		return ud.getAllbyRole(role);
	}
	
	public int removeUser(int id) {
		return ud.removeUser(id);
	}

}
