package com.project0.repo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.project0.model.Employee;

public class EmployeeDaoTest {
	private EmployeeDao ed;

	@Before
	public void setup() {
		ed = new EmployeeDao();
	}

	@Test
	public void findAllTest() {
		List<Employee> employees = ed.findAll();
		assertFalse(employees.size() == 0);
	}

	@Test
	public void findByIdTest() {
		Employee c = ed.findById(1);
		assertNotNull(c);
	}

}
