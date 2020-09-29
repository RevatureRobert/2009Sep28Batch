package com.example.object;

public class Methods {

	
	public static void main(String[] args) {
		Object o = new Object();
		o.equals(new Object());
		
//		System.out.println(5 == 5);
		System.out.println("hey".equals(new String("hey")));	// == checks memory location, .equals is a custom implementation
//		int x = 76;
//		x.equals(7);
//		boolean stringHeyEqualToObject = "hey" == new Object();
//		System.out.println(6==6.6f);
		
//		System.out.println(o.getClass());		// gets the class of the object
		
//		System.out.println("HEY".hashCode());
//		System.out.println(new String("HEY").hashCode());	//	returns a hash of the object. Override this method 
															//		whenever the equals method is overwritten
		
//		System.out.println(o.toString());			//	returns a string representation of the object
		
		
	
	}
	
	public boolean equals(Object o) {
		return false;
	}
}
