//package com.revature.repo;
//
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.dealership.repo.ManagerDaoImpl;
//
//public class ManagerDaoTest {
//
//private ManagerDaoImpl md;
//	
//	@Before
//	public void setup() {
//		md = new ManagerDaoImpl();
//	}
//	
//	@Test
//	public void validLoginTest() {
//		assertTrue(md.login("manager", "manager").getId() == 1);
//	}
//	
//	@Test
//	public void createEmployeeTest() {
//		assertTrue(md.createEmployeeAccount("junit", "junit") == 1);
//	}
//	
//	@Test
//	public void viewEmployeesTest() {
//		assertTrue(md.viewEmployees().size() > 0);
//	}
//	
//}
