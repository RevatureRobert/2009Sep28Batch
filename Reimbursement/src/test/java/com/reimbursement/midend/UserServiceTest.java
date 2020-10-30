package com.reimbursement.midend;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.reimbursement.service.UserService;

public class UserServiceTest {
	
	UserService usvc;
	
	@Before
	public void init() {
		usvc = new UserService();
	}
	
	@Test
	public void validateLogin() {
		assertEquals("VALID", usvc.verifyLoginCredentials("nietzsche", "hasay"));
	}
	
	@Test
	public void tryLoggingIn() {
		assertEquals(4, usvc.login("employee").getUserId());
	}
	
	@Test
	public void tryGettingUsers() {
		assertEquals("UNRESOLVED", usvc.retrieveUsers().get(0).getUsername());
	}
}
