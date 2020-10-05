package com.friday.test;

public class Calculator {

	private Converter converter; //WHEN YOU HAVE A DEPENDENCY ON SOMETHING ELSE, CREATE AN INSTANCE FOR TESTING
	
	public Calculator() {
		super();
	}
	
	public Calculator(Converter converter) {
		super();
		this.converter = converter;
	}
	
	public int sum(int a, int b) {
		return a+b;
	}
	
	public double div(double a, double b) {
		return a/b;
	}
	
	public double milesToFeet(int miles) {
		return converter.milesToFeet(miles);
	}
	

}
