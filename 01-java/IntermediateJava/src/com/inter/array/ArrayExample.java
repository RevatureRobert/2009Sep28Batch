package com.inter.array;

import java.util.Arrays;

/*
 * what is an array?
 * 		a collection of values of a certain datatype
 * 
 */
public class ArrayExample {

	// the main method can use var arg syntax for the parameters
	public static void main(String... args) {
		
		// different ways to create arrays
		
		// you can have the [] after the datatype or after the variable name, including spaces
		int[] arr = new int[5];
		arr[0]=5;
		// different ways to instantiate arrays, curly braces, array constructor for initial size, or all together.
		String[] s2 = new String[] {"ksjfgi","kdsghrui"};
		String[] s3 = {"jkhgfiu","iudfh"};
		
//		int [] arr;
//		int arr[];
//		
		
		String[] fargs = new String[10];
		
		// iterate and fill an array
		for(int i = 0; i < fargs.length; i++) {
			fargs[i] = "i is: "+i;
		}
		// enhanced for loop or a for each loop
		for(String s : fargs) {
			System.out.println(s);
		}
		
		// var args will treat arguments as an array
		String[] s = retArray(new String[]{"dsghdst","suiygfuia","oisuadhfiuwah"});
		System.out.println(s[0]);
		
		
		//Arrays
		//		a static utility class
		System.out.println(s);
		// toString 
		System.out.println(Arrays.toString(s));
		
		//sort
		Arrays.sort(s);
		System.out.println(Arrays.toString(s));
		
		// 2d arrays
		int [][] d2 = new int[3][3];
		d2[0][1]=4333;
		
		for(int[] a : d2) {
			for(int e : a) {
				System.out.println(e);
			}
		}
	}
	
	//this is know as var args
	static String[] retArray(String... arr) {
		return arr;
	}
	
	
}
