package com.example.datatypes;

public class DataTypes {

	/*
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		//declaring a varible, datatype name = value;
		int x = 7;
		boolean b = true;
		char c = 'v';
		double d = 5.5;
		long l = 70;
		byte b1 = (byte)800;
		short s = (short)10000; // type casting
		
		System.out.println(b1); // shortcut: type "sysout" and use ctrl+space
		
		short s1 = 4;
		int i = 6;
		short answer = (short)(s1 + (short)i); // entire result must be cast to short even though both addends are shorts
		double dd = d + x; // casts to double
	}

}
