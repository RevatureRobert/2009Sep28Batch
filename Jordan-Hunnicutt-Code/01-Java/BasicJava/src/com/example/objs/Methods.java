package com.example.objs;


public class Methods {
	
	public static void main(String[] args) {
		
		Object o = new Object();  //note, outside of parenthesis, this called a method
		o.equals(new Object()); //every object can use these arguments, inside of parenthesis is called an argument
		//this checks to see if the object is the same
		
		
	//	System.out.println(5 == 5); // "=" is assign, "==" is compare
		System.out.println("hey" == new String("hey")); //this checks to see if the objects are the same in memory.  Making a new string means we have two separate objects, so this will be false
		System.out.println("hey".equals(new String("hey"))); //this checks to see if the values of the string are equal.  This should return true. Also, can't use .equals on a primitive var type
	
		System.out.println(o.getClass()); //gets the class of an object.  This is useful because in a few days, we'll change the classes of objects
	
		System.out.println(o.hashCode()); //hash codes returns a 'random' id number.  If you overwrite equals, you must overwrite this too.
		//YOU. NEED. TO. WRITE. COMMENTS.
		
		System.out.println("HEY".hashCode());
		System.out.println(new String("HEY").hashCode());
		
		System.out.println(o.toString()); //returns a string representation of the object. This is the most common method we will override.
	}
	
	
	public boolean equals(Object o) { //you can overwrite methods
		return false;
	}
	
}
