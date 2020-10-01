package com.inter.strings;
/*
 * Strings are immutable. There is a String pool in the heap that keeps track of the Strings.
 * 
 * 
 * Under the hood, Strings are a final char[]
 * */
public class StringExample {
	public static void main(String[] args) {
		String happy = "happy";
		String happy2 = new String("happy");
		boolean equal = happy == happy2;
		boolean equalMethod = happy.equals(happy2);
		
		System.out.println(happy.substring(3));
		System.out.println(happy);
		
		// what if Strings were mutable?
		//StringBuilder and StringBuffer
		
		StringBuilder strBuild = new StringBuilder(happy);
		StringBuffer strBuff = new StringBuffer(happy);
		
		strBuild.append("sdkjfhgdfkjh");
		System.out.println(strBuild);
		System.out.println(strBuild.substring(3));
		strBuild.append(false);
	}
}
