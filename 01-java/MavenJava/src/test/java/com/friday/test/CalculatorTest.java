package com.friday.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

/*
 * JUNIT
 * 
 * 		Unit testing is meant to test your code as independently as possible.
 * 
 * 		There are other independent units of code that require other units,
 * 			they can cause the entire group to fail. So you want to test them
 * 			as independently as possible.
 * 
 * 		TDD
 * 			Test-driven development is the art of writing code to follow a testing procedure.
 * 			WRITE THE TEST FIRST
 * 				Only write code to make that unit test pass, THEN make it better (refactor)
 * 			Phases:
 * 				red - test not passed
 * 				green
 * 				refactor
 * 
 * MOCKITO
 * 
 * 	Used for mocking dependencies that out classes have on another.
 * 
 * 	For instance, Mockito can force a method to return an expected output value.
 * 		Mockito.when(obj.method()).thenReturn(EXPECTED_VALUE);
 */

public class CalculatorTest {
	private Calculator cal;
	
	private Converter con;
	
	@BeforeClass
	public static void beforeAll() {
		System.out.println("Before anything gets run");
	}
	
	@Before
	public void setup() {
		System.out.println("Run before any test");
		con = Mockito.mock(Converter.class);
		cal = new Calculator(con);
	}
	
	@After
	public void after() {
		System.out.println("Run after every test");
	}
	
	@AfterClass
	public static void afterAll() {
		System.out.println("Run after everything");
	}
	
	
	
	
	
	@Test
	public void sumTest() {
		int sum = cal.sum(4,  3);
		assertEquals(7, sum);
	}
	
	@Test
	public void divTest() {
		double div = cal.div(3, 2);
		assertTrue(1.5 == div);
	}
	
	@Test
	public void convert() {
		Mockito.when(con.milesToFeet(4)).thenReturn(21120L);
		double km = cal.milesToFeet(4);
		assertTrue(21120 == km);
	}
}
