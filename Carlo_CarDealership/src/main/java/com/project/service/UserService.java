package com.project.service;

import java.util.List;

import com.project.model.User;
import com.project.repository.UserDAO;

public class UserService {
	
	private UserDAO ud;

	public UserService() {
		this(new UserDAO());
	}

	public UserService(UserDAO cd) {
		this.ud = cd;
	}
	
	public List<User> findAll() {
		return ud.findAll();
	}
	
	public User findByNamePass(String name, String pass) {
		return ud.findByNamePass(name, pass);
	}
	
	public User create(User c) throws Exception {
		User result = ud.create(c);
		if(result == null) {
			throw new Exception("The customer was not created.");
		}
		return result;
	}
	
	public User createEmployee(User c) throws Exception {
		User result = ud.createEmployee(c);
		if(result == null) {
			throw new Exception("The employee was not created.");
		}
		return result;
	}
	
	public int delete(Integer i) {
		return ud.delete(i);
	}
	
}
