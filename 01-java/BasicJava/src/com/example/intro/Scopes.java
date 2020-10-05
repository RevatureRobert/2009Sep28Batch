package com.example.intro;

/*
 * There are four scopes in Java, describing where variables can be accessed from
 * 
 * 		static		dies with the class
 * 		instance	dies with the object
 * 		method		dies with the method
 * 		block		dies with curly brackets; if blocks, loop blocks, instance blocks
 * 
 * Don't confuse scope with access modifiers; it's about where it dies, not where it can be accessed from
 */

public class Scopes {
	
	static String cat = "kitty";	// static scope
	String cat1 = "cat1";			// instance scope
	
	public static void main(String[] args) {
		boolean test = true; // method scope
		
		if(test) {
			int x = 4; // block scope
		}
	}
}
