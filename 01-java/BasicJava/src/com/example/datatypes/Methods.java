package com.example.datatypes;

public class Methods {
	
	
	public static void main(String[] args) {
		Object o = new Object();
		o.equals(new Object());
		
		// System.out.println(5 == 5);
		// System.out.println("hey" == new String("hey")); // new String always creates a new object to reference in the heap
		System.out.println("hey".contentEquals(new String("hey")));
		// int x = 5;
		// x.equals(7); // does not work since x is a primitive
		// boolean stringHeyEqualToObject = "hey" == new Object(); // self-documenting variable name
		// System.out.println(6 == 6.6f);
		
		// System.out.println("HEY".hashCode());
		 System.out.println(new String("HEY").hashCode()); // returns a hash calculated from object contents
		
		System.out.println(o.toString());
	}
	
	public boolean equals(Object o) {
		return false;
	}
}
