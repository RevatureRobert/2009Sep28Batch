package com.inter.array;

import java.util.Arrays;

/*
 * An array is a collection of values of a certain data type
 */

public class ArrayExample {

	public static void main(String[] args) {
		int[] arr = new int[5];
		arr[0] = 5;
		
		String[]ar = new String[10];
		for(int i = 0; i < ar.length; i++) {
			ar[i] = "o is: " + i;
		}
		
		// enhanced for loop, or a for-each loop
		for(String s: ar) {
			System.out.println(s);
		}
		
		int len = ar.length; // arrays have a length field; this is an immutable value
		
		String[] s = retArray(new String[]{"avt", "ar234", "ade"});
		System.out.println(s[0]);
		
		// 3 ways to instantiate arrays
		String[] s1 = new String[3];
		String[] s2 = new String[] {"", "", ""};
		String[] s3 = {"", "", ""};
		
		// Arrays
		// 		a static utility class
		System.out.println(s);
		// toString
		System.out.println(Arrays.toString(s));
		
		// sort
		Arrays.sort(s);
		System.out.println(Arrays.toString(s));
		
		// 2d arrays
		int[][] _2d = new int[3][3];
		_2d[0][1] = 4333;
		
		for(int[]a : _2d) {
			for(int e : a) {
				System.out.println(e);
			}
		}
	}
	
	static String[] retArray(String[]arr) {
		return arr;
	}

}
