package com.inter.strings;
/*
 * Strings are immutable
 * 		immutable means it cannot be changed
 * 
 * There is a String pool in the heap that keeps track of the Strings
 * 
 * Under the hood, Strings are final char arrays
 * 
 * String is a final class
 */
public class StringExample {

	public static void main(String[] args) {
		String happy = "happy";
		String happy2 = new String("happy");
		boolean equal = happy == happy2;			// not equal
		boolean equalMethod = happy.equals(happy2);	// equal
		
		System.out.println(happy.substring(3));		// returns the substring between the given indexes. beginning (inclusive) ending (exclusive)
		System.out.println(happy);
		
		System.out.println(happy.length());
		System.out.println(happy.toUpperCase());
		System.out.println(happy.toLowerCase());
		System.out.println(happy.charAt(2));
		System.out.println(happy.indexOf('p'));
		
		
		// what if strings were mutable?
		
		// StringBuilder and StringBuffer
		StringBuilder sb = new StringBuilder(happy);
		StringBuffer sb1 = new StringBuffer(happy);
		sb.append("sdklnhvhilusdrthiuehgihih");
		System.out.println(sb);
		System.out.println(sb.substring(3));
		sb.append(false);
		System.out.println(sb);
		System.out.println(sb.charAt(0));
		String s = sb.toString();
		sb.reverse();
		System.out.println(sb);
		sb.toString().toCharArray();
	}
	
}
