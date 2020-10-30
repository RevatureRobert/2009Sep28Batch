package com.reimbursement.backend;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.reimbursement.dao.UserDAO;
import com.reimbursement.model.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoTest {
	
	UserDAO dao;
	
	@Before
	public void init() {
		dao = new UserDAO();
	}
	
	@Test
	public void A_readsAllRecords() { // FINDALL
		List<User> users = dao.findAll();
		
		assertEquals(users.get(0).getUserId(), 0);
	}
	
	@Test
	public void B_findsRecordById() { // FINDBYID
		User testUser = dao.findById(1);
		
		assertEquals(testUser.getUsername(), "manager");
	}
	
	@Test
	public void C_crudOps() { // CREATE, FINDBYUSERINPUT, FINDBYID, UPDATEBYID, DELETEBYID
		int userCount = dao.findAll().size();
		
		User user = new User("TEST_USER_12345", "TEST_PASSWORD!", "FIRSTNAME", "LASTNAME", "EMAIL", 0);
		dao.create(user);
		User userFromDB = dao.findByUserInput("TEST_USER_12345");
		assertEquals(userFromDB.getEmail(), user.getEmail()); // TESTS CREATE, FINDBYUSERINPUT
		
		user.setPassword(userFromDB.getPassword());
		user.setUserId(userFromDB.getUserId());
		userFromDB = dao.findById(user.getUserId());
		assertEquals(userFromDB.getPassword(), user.getPassword()); // TESTS FINDBYID
		
		user.setEmail("OTHER_EMAIL");
		dao.updateById(user);
		userFromDB = dao.findById(userFromDB.getUserId());
		assertEquals(user.getFirstName(), userFromDB.getFirstName()); // TESTS UPDATEBYID
		
		dao.deleteById(user.getUserId());
		assertEquals(userCount, dao.findAll().size()); // TESTS DELETE
	}
	
	@Test
	public void D_findsRecordState() { // RECORDSTATEOF
		User dummyUser = new User();
		
		dummyUser.setUsername("employee");
		dummyUser.setPassword("pass2d");
		
		assertEquals(dao.recordStateOf(dummyUser), "VALID");
	}
	
	@Test
	public void E_filtersByItem() { // FILTERBYITEM
		assertEquals(dao.filterByItem("").size(), 0);
	}
}
