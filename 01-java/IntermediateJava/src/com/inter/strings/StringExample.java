package com.inter.strings;

public class StringExample {
	
	public static void main(String[] args) {
		String happy = "happy";
		String happy2 = new String("happy");
		boolean equal = happy == happy2;	// Not equal
		boolean equalMethod = happy.equals(happy2);	// Equal
		
//		System.out.println(happy.substring(3));
//		System.out.println(happy);
		
//		System.out.println(happy.length());
//		System.out.println(happy.toUpperCase());
//		System.out.println(happy.toLowerCase());
//		System.out.println(happy.charAt(2));
//		System.out.println(happy.indexOf('p'));
		
		// What if strings were mutable?
		
		StringBuilder sb = new StringBuilder(happy);
		StringBuffer sb1 = new StringBuffer(happy);
		sb.append("wefewfwef");
		System.out.println(sb);
		System.out.println(sb.substring(3));
		sb.append(false);
		System.out.println(sb);
		System.out.println(sb.reverse());
		System.out.println(sb.reverse());
		String s = sb.toString();
	}
	
}
