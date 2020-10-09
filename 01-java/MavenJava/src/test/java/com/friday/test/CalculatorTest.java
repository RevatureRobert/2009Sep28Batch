package com.friday.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mockitoSession;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class CalculatorTest {
	
	private Calculator cal;
	
	private Converter con;
	
	@BeforeClass
	public static void beforeAll() {
		System.out.println("Before anything runs.");
	}
	
	@Before
	public void setup() {
		System.out.println("Ran before every test");
		con = Mockito.mock(Converter.class);
		cal=new Calculator(con);
	}
	
	@After
	public void after() {
		System.out.println("Run after a test");
	}
	
	@AfterClass
	public static void afterAll() {
		System.out.println("Run after every test");
	}
	
	@Test
	public void sumTest() {
		int sum = cal.sum(4, 3);
		assertEquals(7,sum);
	}
	
	@Test
	public void divTest() {
		double div = cal.div(3,2);
		assertTrue(1.5==div);
	}
	
	@Test
	public void convert() {
		Mockito.when(con.milesToFeet(4)).thenReturn(21120L);	// This code is pretending to be the class as if it were returning the correct output
		double km = cal.milesToFeet(4);
		assertTrue(km==21120);
	}

	
}
