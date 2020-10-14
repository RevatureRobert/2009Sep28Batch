package com.cardealership.repo;

import org.junit.Test;

import com.cardealership.model.Admin;
import com.cardealership.model.Customer;
import com.cardealership.model.Employee;

import org.junit.Before;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

public class EmployeeDaoTest {
	private EmployeeDao ed;
	private CustomerDao cd = new CustomerDao();
	@Before
	public void setup() {
		ed = new EmployeeDao();
	}
	
	@Test
	public void findAllTest() {
		List<Employee> employees = ed.findAll();
		System.out.println(employees.get(0).toString());
		assertFalse(employees.size()==0);
	}
	
	@Test
	public void findByIdTest() {
		Employee employee = ed.findById(4);
		System.out.println(employee.toString());
	}
	@Test
	public void createEmployeeTest() {
		Customer c = cd.findById(5);
		ed.create(c, 1);
	}
	@Test
	public void updateEmployeeTest() {
		int i = 4;
		Employee employee = ed.findById(i);
		employee.setUserLastName("Swindle");
		if(ed.update(employee) == null) {
			System.out.println("No changes made.");
		}
		System.out.println(ed.findById(i).toString());
	}
	@Test
	public void deleteTest() {
		int i = ed.delete(13);
		System.out.println(i);
	}
	@Test
	public void createCarTest() {
		Employee employee = ed.findById(1);
		boolean t = ed.createCar(employee, "Dodge Charger 2014", 38029, null);
		System.out.println(t);
	}
	@Test
	public void deleteCarTest() {
		Employee employee = ed.findById(1);
		boolean t = ed.deleteCar(9);
		System.out.println(t);
	}
}
