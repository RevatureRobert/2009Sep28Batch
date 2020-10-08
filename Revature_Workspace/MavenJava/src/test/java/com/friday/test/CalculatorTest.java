package com.friday.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/*
 * JUNIT
 * 	
 * 		Unit testing is meant to test your code as independently as possible.
 * 
 * 		There are other independent units of code that require other units,
 * 			They can cause the entire group to fail. So you want to test
 * 			them as independently as possible
 * 
 * 	Test Driven Development (TDD)
 * 		TDD is the art of writing code to follow a testing procedure
 * 			
 * 		Phases
 * 			Red, green, and refactor
 * 
 * 	MOCKITO
 * 		Used to mimic the functionality/returns of a dependency
 * 		
 * */
public class CalculatorTest {
	
	private Calculator cal;
	private Converter con;
	public static void beforeAll() {
		System.out.println("Before anything gets ran");
	}
	
	
	@Before
	public void setup() {
		System.out.println("This runs before the tests");
		con = Mockito.mock(Converter.class);
		cal = new Calculator(con);
	}
	
	public void after() {
		System.out.println("This is ran after every test");
	}
	public void afterAll() {
		System.out.println("this is run after everything");
	}
	
	@Test
	public void sumTest() {
		int sum = cal.sum(4,3);
		assertEquals(7,sum);
	}
	@Test
	public void divTest() {
		double div = cal.div(3,2);
		assertEquals(1.5, div);
	}
	@Test
	public void convert() {
		Mockito.when(con.milesToFeet(4)).thenReturn(21220L);
		double km  = cal.milesToFeet(4);
		System.out.println(km);
		assertTrue(km == 21120);
	}
}

