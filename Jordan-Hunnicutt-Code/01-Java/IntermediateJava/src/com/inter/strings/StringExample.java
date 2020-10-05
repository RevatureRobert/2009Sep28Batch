package com.inter.strings;
/*
 * 
 * Strings are immutable
 * 		(unchangable)
 * 
 * There is a String pool in the heap that keeps track of the Strings
 * 
 * Under the hood, Strings are final char arrays
 * 
 * Because String is a final class, you can't extend it
 */
public class StringExample {

	public static void main(String[] args) {
		String happy = "happy";
		String happy2 = new String("happy");
		boolean equal = happy == happy2;			//not equal, different memory addresses, different references
		boolean equalMethod = happy.equals(happy2); //equal, value is the same
		
		System.out.println(happy.substring(3));		//returns the substring between the given indices. Beginning (inclusive), ending (exclusive).
		System.out.println(happy);
		
		System.out.println(happy.length());
		System.out.println(happy.toUpperCase());
		System.out.println(happy.toLowerCase());
		System.out.println(happy.charAt(2));
		System.out.println(happy.indexOf('p'));
		
		
		//what if strings were mutable?
		
		// stringBuilder and stringBuffer
		StringBuilder sb = new StringBuilder(happy);	//faster, but not thread safe
		StringBuffer sbf = new StringBuffer(happy);		//slower but thread safe
		
		sb.append("wow");
		System.out.println(sb);
		System.out.println(sb.substring(3));
		sb.append(false);
		System.out.println(sb);
		
		String s = sb.toString(); //cant convert sb to string implicitly, but can use toString()
	}
	
}
