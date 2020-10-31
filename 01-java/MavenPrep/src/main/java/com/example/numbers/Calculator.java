package com.example.numbers;

public class Calculator {
	Multiplier m;
	
	public int sum(int a, int b) {
		return a+b;
	}
	
	public int multiply(int a, int b) {
		return m.mult(a, b);
	}

	public Calculator(Multiplier m) {
		super();
		this.m = m;
	}
	
	public boolean checkBool(boolean b) {
		if(b) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
}
