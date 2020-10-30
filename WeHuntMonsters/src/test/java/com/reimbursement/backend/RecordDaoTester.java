package com.reimbursement.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.reimbursement.dao.RecordDAO;
import com.reimbursement.dao.UserDAO;
import com.reimbursement.model.User;

public class RecordDaoTester {
	
	@Test
	public void testRecordsForUser() {
		RecordDAO dao = new RecordDAO();
		UserDAO udao = new UserDAO();
		User manager = udao.findById(1);
		User manager2 = udao.findById(10);
		User employee = udao.findById(4);
		User employee2 = udao.findById(9);
		
		assertEquals(dao.recordsForUser(manager).get(0).getId(),
				dao.recordsForUser(manager2).get(0).getId());
		
		assertNotEquals(dao.recordsForUser(employee).get(0).getId(),
				dao.recordsForUser(employee2).get(0).getId());
	}
}
