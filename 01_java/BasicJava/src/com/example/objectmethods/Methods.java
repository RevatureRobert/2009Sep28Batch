package com.example.objectmethods;

public class Methods {

		
	public static void main(String[] args) {
		Object o = new Object();
		o.equals(new Object());
		
//		System.out.println(5 == 5);
//		System.out.println("hey" == new String("hey")); // double equals looks for memory location
		System.out.println("hey".equals(new String("hey")));	// .equals is a custom implementation
		
//		System.out.println(o.getClass());	//gets the class of the object
		
//		System.out.println(o.hashCode());	//returns a hash of the object. override this method whenever the equals method is overwritten
		
//		System.out.println(o.toString());	//returns a string representation of the object
		
		
	}
	
	public boolean equals(Object o) {
		return false;
	}
}
