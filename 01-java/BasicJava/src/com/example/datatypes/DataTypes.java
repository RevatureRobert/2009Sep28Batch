package com.example.datatypes;

public class DataTypes {

	/*
	 * 
	 * java has two different types, primitive and reference.
	 * 
	 * primitives:
	 * 		byte			8 bits
	 * 		boolean			1 bit (depends on the jvm)
	 * 		char			16 bits
	 * 		float			32 bits
	 * 		double			64 bits
	 * 		int				32 bits
	 * 		short			16 bits
	 * 		long			64 bits
	 * 
	 *  the min and max of a particular data type is like this:
	 *  		-2^(NumberOfBits-1) to 2^(NumberOfBits-1)-1
	*/
	
	public static void main(String[] args) {
		// declaring a variable, datatype name = value;
		int x = 7;
		boolean b = true;
		char c = 'v';
		double d = 5.5;
		long l = 70000000000000000L;
		byte b1 = (byte)800;
		short s = (short)100000;			//type casting
		float f = 6.7f;
		System.out.println(b1);
		
		short s1 = 4;
//		int i = 6;
		short i = 6;
		short answer = (short)(s1 + i);  //does not work
		float dd = f + x;
		/*
		 * when performing operations on two different sized data types, it will bring them up to the amount
		 * 		of the larger one, with 32 bit being the minimum.
		 */
		
		
		/*
		 * 
		 * reference data types
		 * 		objects where the reference variable is held in the stack and the actual object is stored in the heap.
		 * 		the variable holds a reference to where the object is held.
		*/
		
		Object o = new Object();
		
	}
}
