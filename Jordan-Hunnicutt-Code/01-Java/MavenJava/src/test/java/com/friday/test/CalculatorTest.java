package com.friday.test;

import static org.junit.Assert.assertEquals; //here we used a static import and only imported the method
//this makes it so that the method acts like it is in the current class
											 //prevents weight by only importing one method vs an entire class
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
 * 		Unit testing is mean to test your code as independently as possible.
 * 
 * 		There are other independent units of code that require other units
 * 				they can cause the entire group to fail.  So you want to test
 * 				them as independently as possible.
 * 
 * 		TDD
 * 			Test Driven Development is the ART of writing code to follow
 * 				a testing procedure.
 * 
 * 			phases
 * 				red, green, refactor
 * 
 */
public class CalculatorTest {
	
	private Calculator cal;
	private Converter con;
	
	@BeforeClass //this and afterClass have to be static methods
	public static void beforeAll() {
		System.out.println("Before anything gets ran");
	}
	
	@Before
	public void setup() {
		System.out.println("This is ran before every test");
		con = Mockito.mock(Converter.class); //this will interrupt whenever we try to depend on converter
		cal = new Calculator(con); //have to put mockito class in constructor to test this
		
	}

	@After
	public void after() {
		System.out.println("This is ran after every test");
	}
	
	@AfterClass
	public static void afterAll() {
		System.out.println("This is ran after everything");
	}
	
	@Test
	public void sumTest() {
		int sum = cal.sum(4, 3);
		assertEquals(7, sum);
	}
	
	@Test
	public void divTest() {
		double div = cal.div(3, 2);
		assertTrue(1.5==div);		//for some reason assert equals doesn't work, so we use assertTrue
	}
	
	@Test
	public void convert() {
		Mockito.when(con.milesToFeet(4)).thenReturn(21120L); //mockito lets you test your code individually. If you have a dependency on other code, mock the return and get the info you expect to get back
		double km = cal.milesToFeet(4);
		assertTrue(km == 21120);
	}
	
}
