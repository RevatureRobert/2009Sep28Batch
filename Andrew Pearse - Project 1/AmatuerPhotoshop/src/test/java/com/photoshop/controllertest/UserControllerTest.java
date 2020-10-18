package com.photoshop.controllertest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;

import com.photoshop.controller.UserController;

public class UserControllerTest {

	UserController uc;
	
	@Before
	public void startup() {
		uc = new UserController();
	}
	
	@Test
	public void testVerifyUserWithEmployee() {
		HttpServletRequest req = mock(HttpServletRequest.class);
		//employee
		when(req.getAttribute("inputEmail")).thenReturn("andrew.roy.pearse@gmail.com");
		when(req.getAttribute("inputPassword")).thenReturn("password");
		
		assertEquals("html/employee.html", uc.verifyUser(req));
		
	}
	
	@Test
	public void testVerifyUserWithFinanceManager() {
		HttpServletRequest req = mock(HttpServletRequest.class);
		when(req.getAttribute("inputEmail")).thenReturn("jlawn@gmail.com");
		when(req.getAttribute("inputPassword")).thenReturn("longgone");
		
		assertEquals("html/finance manager.html", uc.verifyUser(req));
	}
	
	@Test
	public void testVerifyInvalidUser() {
		HttpServletRequest req = mock(HttpServletRequest.class);
		when(req.getAttribute("inputEmail")).thenReturn("andrew.roy.pearse@gmail.com");
		when(req.getAttribute("inputPassword")).thenReturn("bad password");
		
		assertEquals("html/login.html", uc.verifyUser(req));
	}
}
