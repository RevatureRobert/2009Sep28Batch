package com.inter.strings;

/*
 * Strings are immutable under the hood
 * 
 * There is a String pool in the heap that keeps track of Strings
 * 
 * Strings are fundamentally final char arrays
 * 
 * String is a final class; it cannot be extended
 */

public class StringExample {

	public static void main(String[] args) {
		String happy = "happy";
		String happy2 = new String("happy");
		
		String str1 = "happy";
		
		str1 = "happier";
		
		System.out.println(happy);
		
		boolean equal = happy == happy2;
		boolean equalMethod = happy.equals(happy2);
		
		System.out.println(happy.substring(1, 3));
		System.out.println(happy);
		
		happy.length();
		happy.toUpperCase();
		happy.toLowerCase();
		happy.charAt(2);
		happy.indexOf('p');
		
		
		// StringBuilder and StringBuffer for mutable Strings
		
		StringBuilder builder = new StringBuilder(); // faster but not thread-safe
		StringBuffer buffer = new StringBuffer(); // slower but safe for multithreading
		
		builder.append("aurfyb");
		System.out.println(builder);
		System.out.println(builder.substring(1, 3));
		builder.append(false); // StringBuilder explicitly defines this for booleans
	}

}
