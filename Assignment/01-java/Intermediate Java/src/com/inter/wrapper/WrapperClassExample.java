package com.inter.wrapper;

/*
 * wrapper classes are the object representation of primitive data types
 * 
 * 			int			->			Integer
 * 			char		->			Character
 * 			long		-> 			Long
 * 			short		-> 			Short
 * 			float 		-> 			Float
 * 			double		-> 			Double
 * 			boolean		->			Boolean
 * 			byte		-> 			Byte
 */

public class WrapperClassExample {

	public static void main(String[] args) {
		String input = "46";
		int age = Integer.parseInt(input);
		System.out.println(age);
		
		Integer i = new Integer(5);
		Integer i2 = 5;  // autoboxing
		int i3 = i; 	// unboxing
		
		System.out.println(Integer.MIN_VALUE);
		
		Boolean b = new Boolean(true);
		boolean b1 = b;
		boolean b2 = Boolean.TRUE;
		
	}
}
