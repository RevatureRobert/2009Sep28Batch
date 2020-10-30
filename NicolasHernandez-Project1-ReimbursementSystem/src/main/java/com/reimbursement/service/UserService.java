package com.reimbursement.service;

import com.reimbursement.dao.DBAccessor;
import com.reimbursement.dao.ReimbursementDAO;
import com.reimbursement.dao.UserDAO;
import com.reimbursement.dao.UserRoleDAO;
import com.reimbursement.model.Reimbursement;
import com.reimbursement.model.User;
import com.reimbursement.model.UserRole;

public class UserService {
	private DBAccessor<User, Integer> userDao;
	private DBAccessor<UserRole, Integer> userRoleDao;
	private DBAccessor<Reimbursement, Integer> reimbDao;
	
	public UserService() {
		this(new UserDAO(), new UserRoleDAO(), new ReimbursementDAO());
	}
	public UserService(DBAccessor<User, Integer> userDao, DBAccessor<UserRole, Integer> userRoleDao,
			DBAccessor<Reimbursement, Integer> reimbDao) {
		super();
		this.userDao = userDao;
		this.userRoleDao = userRoleDao;
		this.reimbDao = reimbDao;
	}
	
	public String verifyLoginCredentials(String username, String password) {
		User userHandle = new User();
		userHandle.setUsername(username);
		userHandle.setPassword(password);
		
		return userDao.recordStateOf(userHandle);
	}
	
	public boolean registerUser(User user) {
		return userDao.create(user) != 0;
	}
}
