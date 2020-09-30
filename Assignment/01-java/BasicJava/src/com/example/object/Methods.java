package com.example.object;

public class Methods {

	public static void main(String[] args) {
		Object o = new Object();
		o.equals(new Object());
		
		short x = 6;
		byte y = 6;
		System.out.println(x == y);
		//System.out.println(new String("hey") == "hey");// == checks memory location, .equals checks actual value
		
		System.out.println(o.getClass()); // gets the class of the object
		
		
		System.out.println("HEY".hashCode()); // hashcode takes the actual value and creates a code for it. 
		
		System.out.println(o.toString());// returns a string representation of the object, the memory address? 
	}
	
	public boolean equals(Object o) {
		return false;
		
	}

}
