package com.reimbursement.service;

import java.util.List;

import com.reimbursement.dao.DBAccessor;
import com.reimbursement.dao.UserDAO;
import com.reimbursement.model.User;

public class UserService {
	private DBAccessor<User, Integer> userDao;
	
	public UserService() {
		this(new UserDAO());
	}
	public UserService(DBAccessor<User, Integer> userDao) {
		super();
		this.userDao = userDao;
	}
	
	public String verifyLoginCredentials(String username, String password) {
		User userHandle = new User();
		userHandle.setUsername(username);
		userHandle.setPassword(password);
		
		return userDao.recordStateOf(userHandle);
	}
	
	public User login(String username) {
		return userDao.findByUserInput(username);
	}
	
	public boolean registerUser(User user) {
		return userDao.create(user) != 0;
	}
	public List<User> retrieveUsers() {
		return userDao.findAll();
	}
}
