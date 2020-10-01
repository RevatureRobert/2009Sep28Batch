package com.examples.objectmethods;

public class Methods {
	public static void main(String[] args) {
		Object o = new Object();
		o.equals(new Object());
		
		String s1 = "new string";
		String s2 = "new string";
		
		//System.out.println(5 == 6);
		System.out.println("hey".equals(new String("hey"))); // == checks memory location, .equals is a custom implementation
		
		System.out.println(o.getClass());
	}
	
	public boolean equals(Object o) {
		return false;
	}
}
