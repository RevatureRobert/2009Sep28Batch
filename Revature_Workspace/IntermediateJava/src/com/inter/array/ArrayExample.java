package com.inter.array;

public class ArrayExample {
	public static void main(String[] args) {
		int[] arr = new int[5];
		arr[0] = 5;
		
		String[] fargs = new String[10];
		
		String[] s = retArray(new String[]{"dfjhsbrd","hjdfbs","jsdfgs"});
		System.out.println(s[0]);
		
		int[][] d2 = new int[3][3];
	}
	static String[] retArray(String... arr) {
		return arr;
		
	}
	
}
