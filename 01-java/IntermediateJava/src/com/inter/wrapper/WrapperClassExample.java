package com.inter.wrapper;

public class WrapperClassExample {
	
	public static void main(String[] args) {
		String input = "46";
		int age = Integer.parseInt(input);
		System.out.println(age+10);
		
		@SuppressWarnings("deprecation")
		Integer i = new Integer(5);
		Integer i2 = 5;	// auto-boxing
		int i3 = i;		// un-boxing
		
		System.out.println(Integer.MAX_VALUE);
		
		@SuppressWarnings("deprecation")
		Boolean b = new Boolean(true);
		boolean b1 = b;
		boolean b2 = Boolean.TRUE;
	}

}
