package com.inter.array;

public class ArrayExample {

	public static void main(String[] args) {
		int[]arr = new int[5];
		arr[0]=5;
		
		
		
		String[] fargs = new String[10];
		
		for(int i =0; i< fargs.length; i++) {
			fargs[i] = "i is: " +i;
		}
		
		for(String s: fargs) {
			System.out.println(s);
		}
		
		String[] s = retArray("dsafsad","sasdfsa","sdfsafda");
		
	}

	private static String[] retArray(String... arr) {
		// TODO Auto-generated method stub
		return arr;
	}

}
