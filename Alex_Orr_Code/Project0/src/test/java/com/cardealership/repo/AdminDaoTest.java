package com.cardealership.repo;

import org.junit.Test;
import com.cardealership.model.Admin;
import com.cardealership.model.Employee;

import org.junit.Before;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

public class AdminDaoTest {
	private AdminDao ad;
	private EmployeeDao ed = new EmployeeDao();
	
	@Before
	public void setup() {
		ad = new AdminDao();
	}
	@Test
	public void findAllTest() {
		List<Admin> admins = ad.findAll();
		System.out.println(admins.get(0).toString());
		assertFalse(admins.size()==0);
	}
	@Test
	public void findByIdTest() {
		Admin admin = ad.findById(2);
		System.out.println(admin.toString());
	}
	@Test
	public void updateAdminTest() {
		Admin admin = ad.findById(2);
		System.out.println(admin.toString());
		admin.setUserLastName("Orr");
		if(ad.update(admin) == null) {
			System.out.println("No changes made.");
		}
		System.out.println(admin.toString());
	}
	@Test
	public void createAdmin() {
		Employee e = ed.findById(3);
		System.out.println(ad.create(e).toString());
	}
	@Test
	public void deleteAdminTest() {
		int i = ad.delete(5);
		System.out.println(i);
	}
	@Test
	public void getAdminTest() {
		Admin a = ad.getAdmin("Alex");
		System.out.println(a.toString());
	}
}
