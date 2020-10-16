package com.friday.test;

public class Calculator {
	
	private Converter converter;
	
	public Calculator(Converter converter) {
		this.converter = converter;
	}
	
	public int sum(int a, int b) {
		return a + b;
	}
	
	public double div(double a, double b) {
		return a / b;
	}
	
	public double milesToFeet(int miles){
		Converter c = new Converter();
		return converter.milesToFeet(miles);
	}
}
