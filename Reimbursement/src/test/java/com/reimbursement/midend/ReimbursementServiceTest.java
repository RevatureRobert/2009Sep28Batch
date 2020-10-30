package com.reimbursement.midend;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.reimbursement.dao.UserDAO;
import com.reimbursement.model.User;
import com.reimbursement.service.ReimbursementService;

public class ReimbursementServiceTest {
	
	ReimbursementService reimbsvc;
	User user;
	
	@Before
	public void init() {
		reimbsvc = new ReimbursementService();
		user = new UserDAO().findById(1);
	}
	
	@Test
	public void retrieval() {
		assertEquals("test entry", reimbsvc.retrieveReimbursements(user).get(0).getDescription());
	}
}
