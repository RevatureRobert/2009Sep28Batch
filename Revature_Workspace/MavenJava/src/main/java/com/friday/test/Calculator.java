package com.friday.test;

public class Calculator {

	private Converter converter;
	public Calculator() {
		super();
	}
	public Calculator(Converter con) {
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
