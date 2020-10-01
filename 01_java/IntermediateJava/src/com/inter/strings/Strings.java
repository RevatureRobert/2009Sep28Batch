package com.inter.strings;
/*
 * Strings are immutable
 * 		immutable means it dcannot be changed
 * 
 * There is a String pool in the heap that keeps track of the Strings
 * 
 * Under the hood, Strings are final char arays
 * 
 * String is a final class
 */
public class Strings {

	public static void main(String[] args) {
		String happy = "happy";
		String happy2 = new String("happy");
		boolean equal = happy == happy2;				//not equal 
		boolean equalMethod = happy.equals(happy2); 	//equal
		
		System.out.println(happy.substring(3));			//returns the substring between the given indexes. beginning (inclusive) ending (exclusive)
		System.out.println(happy);
		
		System.out.println(happy.length());
		System.out.println(happy.toUpperCase());
		System.out.println(happy.toLowerCase());
		System.out.println(happy.charAt(2));
		System.out.println(happy.indexOf('p'));
		
//=======================================================================================================================================================		
		//what if strings were mutable?
		
		//StringBuilder and StringBuffer
		StringBuilder sb = new StringBuilder(happy);
		StringBuffer sb1 = new StringBuffer(happy);
		sb.append("dfhdajkl");
		System.out.println(sb);
		System.out.println(sb.substring(3));
		sb.append(false);
		System.out.println(sb);
		
		
	}
}
