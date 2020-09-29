package com.example.datatypes;

public class DataTypes {
	
	public static void main(String[] args) {
		int x = 7;
		boolean b = true;
		char c = 'v';
		double d = 5.5;
		long l = 70;
		byte b1 = (byte) 800;
		short s = (short) 100000;
		float f = 6.7f;
		System.out.println(b1 + " wow " + f);
		
		short s1 = 4;
		int i = 6;
		short answer = (short) (s1+i); // When performing operations on two different sized data types, it will bring them up to the largest, with 32 bit being the minimum
	
		Object o = new Object();
	}

}
