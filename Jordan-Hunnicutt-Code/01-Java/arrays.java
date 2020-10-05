//package com.inter.array;

import java.util.Arrays;

/*
 * 
 * what is an array?
 * 		a collection of values of a certain datatype
 * 
 */

public class arrays {

	//the main method can use var arg syntax for parameters
	public static void main(String[] args) {//we can also put "String..." here
		
		System.out.println(args[0]);
		
		//different ways to create arrays
		
		//you can have the [] after the datatype or after the variable name, including spaces
		int[] arr = new int[5];
		arr[0]=5;
		//different ways to instantiate arrays, curly brackets, array constructor for initial size, or all together
		String[] s2 = new String[] {"oh", "hi"};
		String[] s3 = {"hey", "there"};
		
//		int [] arr2;
//		int arr3[];
		
		String[] args2 = new String[10];
		
		for(int i = 0; i < args2.length; i++) {
			args2[i] = "i is: " + i;
		}
		//enhanced for loop, or, a for each loop
		for(String s : args2) { //this gets the values of each index of the array
			System.out.println(s);
		}
		
		//var args will treat arguments as an array
		String[] s = retArray(new String[]{"one", "two", "three"});
		System.out.println(s[0]);
		
		//Arrays (Class)
		//		a static utility class
		//a class with several static methods used to interact with arrays
		System.out.println(s);
		//toString
		System.out.println(Arrays.toString(s));
		
		//sort
		Arrays.sort(s); //void method, this should have side effects and change things about the program
		System.out.println(Arrays.toString(s));
		
		// 2d arrays
		int [][] d2 = new int[3][3];
		d2[0][1]=4333;
		
		for(int[] a : d2) {
			for (int e : a) {
				System.out.println(e);
			}
		}
	}
	
	//this is known as var args
	public static String[] retArray(String... arr){
		return arr;
	}
	
}
