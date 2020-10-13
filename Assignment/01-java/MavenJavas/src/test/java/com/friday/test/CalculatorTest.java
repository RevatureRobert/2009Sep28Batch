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
 * 			Unit testing is meant to test your code as independently as possible
 * 
 * 	
 * 			There are other independent units of code that require other units,
 * 				they can use the entire group to fail. So you want to test them as
 * 				independently as possible.
 * 
 * 			TDD
 * 				Test Drive Development is the ART of writing code to follow
 * 					a testing procedure
 * 
 * 				phases
 * 					red, green, refactor
 * 
 * MOCKITO
 * 
 * 		Used for mocking dependencies that our classes have on another
 * 
 * 
 */

public class CalculatorTest {
	
	private Calculator cal;
	
	private Converter con;
	
	@BeforeClass
	public static void beforeAll() {
		System.out.println("before anything gets ran");
	}
	
	
	@Before
	public void setup() {
		System.out.println("this is run before every test");
		//cal = new Calculator();
		con = Mockito.mock(Converter.class);
		cal = new Calculator(con);
	}
	@After
	public void after() {
		System.out.println("this is ran after every test");
	}
	
	@AfterClass
	public static void afterALL() {
		System.out.println("this is ran after everything");
	}
	
	@Test
	public void sumTest() {
		int sum = cal.sum(4,3);
		assertEquals(7,sum);
	}
	
	
	@Test
	public void divTest() {
		double div = cal.div(3,2);
		assertTrue(1.5==div);
	}
	
	@Test
	public void convert() {
		Mockito.when(con.milesToFeet(4)).thenReturn(21120L);
		double km = cal.milesToFeet(4);
		assertTrue(km == 21120);
	}

}
