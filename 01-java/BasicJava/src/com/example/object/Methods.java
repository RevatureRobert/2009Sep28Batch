package com.example.object;

public class Methods {
	
	public static void main(String[] args) {
		Object o = new Object();
		o.equals(new Object());
		
//		System.out.println(5 == 4);
//		System.out.println("hey" == "hey");
//		System.out.println("hey" == new String("hey")); // Will return false because they don't point to the same place in memory
		System.out.println("hey".equals(new String("hey"))); // .equals is a custom implementation
		
		System.out.println(o.getClass());
		System.out.println("HEY".hashCode());
		System.out.println(new String("HEY").hashCode());
		System.out.println(o.toString());
	}
	
	public boolean equals(Object o) {
		return false;
	}

}
