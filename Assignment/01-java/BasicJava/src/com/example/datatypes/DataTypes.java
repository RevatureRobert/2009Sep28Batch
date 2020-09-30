package com.example.datatypes;

public class DataTypes {
	
	/*
	 * java has two different types, primitive and reference
	 * 
	 * primitives:
	 * 		byte		  8 bits
	 * 		boolean       1 bit (but depends on the jvm as well)
	 * 		char          16 bits
	 * 		float		  32 bits	
	 * 		double        64 bits
	 * 		int           32 bits
	 * 		short		  16 bits	
	 * 		long		  64 bits
	 * 
	 * 
	 *       the min and max of a particular data type is:
	 *       - 2^(Number of Bits -1) to 2^(Number of Bits -1)-1
	 * 
	 */

	
	public static void main(String[] args) {
		//declaring a variable, datatype name == value;
		
		int x = 8;
		boolean b = true;
		char c = 'v';
		double d = 5.5;
		long l = 7000000000L;
		byte b1 = (byte)800;  //type casting to byte
		short s = 10;
		float f = (float)6.7; // or 6.7f; or 6.7F;
		
		
		System.out.println(b1);
		
		short s1 = 4;
		//int i = 6;
		//short i = 6;  When performing operations on two different size datatypes, java will bring up the smaller data type. 
		//              IF the datatypes are under 16 bits then Java will automatically bring them up to 32 bit. 
		//short answer = s1-i;
		
		
		
		/* reference data types: objects where the reference variable is held in the stack and the actual object
		   is in the heap.
		   The variable holds a reference to where the object is held. 
		   */
		
		Object o = new Object(); // o holds the reference for this new Object. 
	}
}
