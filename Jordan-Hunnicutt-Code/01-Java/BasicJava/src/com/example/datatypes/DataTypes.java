package com.example.datatypes;

public class DataTypes {

	/*
	 * java has 2 types of data types, primitive and reference
	 * 
	 * primitives:
	 * 		byte			8 bits of memory
	 * 		boolean			1 bit (you would think, but it depends on jvm)
	 * 		char			16 bits of memory
	 * 		float			32 bits of memory
	 * 		double			64 bits of memory
	 * 		int				32 bits of memory
	 * 		short			16 bits of memory
	 * 		long			64 bits of memory
	 * 
	 * 
	 * min and max of particular data type is this equation
	 * 			-2^(numBits-1) to 2^(numBits-1)-1
	*/
	
	public static void main(String[] args) {
		//declaring a var, datatype name = value;
		int x = 7;
		boolean b = true;
		char c = 'v';
		double d = 5.5;
		long l = 70;
		byte b1 = (byte)800; //vals between -128 and 127, 800 is out of scope, causes an overflow, using (byte) explicitly tells java to use that var type
		short s = (short)100000;  //putting values in parenthesis like this is called "type casting"
		float f = 6.7f; //putting the f is the same as type casting, can also use capital F, or (float) in front
		
		System.out.println(b1);
		
		//What happens if we add different data types, like a short and int, for instance?
		short s1 = 4;
		int i = 6;
		short j = 6;
		int k = 6;
		short newShort = (short)(s1 + j);
		//normally, java brings shorter bit var to larger.  short to int could work, but int to short does not implictly convert
		//short to short also does not work, because it still tries to cast to higher.
		
		int newInt = i + k; //this works because casting values HAVE to be at least 32 bit. int is already 32 bit, so this doesn't need to upcast
		
		/*
		 * Reference Data Types
		 * 	objects where the reference variable is held in the stack and the actual object is stored in the heap
		 * 	var holds a reference to where object is held
		 * 
		 */
		
		//this is instantiating or constructing an object.  Creating prim vars like above is initianting a variable
		Object o = new Object(); //variable o is in the stack, the physical object is in the heap, o holds the memory address of the object
		
	}
	
}
