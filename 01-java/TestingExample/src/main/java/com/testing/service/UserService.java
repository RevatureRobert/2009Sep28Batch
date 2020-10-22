package com.testing.service;

import com.testing.dao.DaoInstance;
import com.testing.model.User;

public class UserService {

	DaoInstance dao;

	public UserService(DaoInstance dao) {
		super();
		this.dao = dao;
	}

	public UserService() {
		this(new DaoInstance());
	}
	
	public boolean checkCreds(String username, String password) {
		User u = dao.findByUsername(username);
		return u.getPassword().equals(password);
	}
	
	
}
