package com.example.intro;


/*
 * There are four scopes in Java
 * 
 * 		static (class)		- note, variables can only be static within a class, not within a method or any flow statements
 * 		instance (object)
 * 		method
 * 		block (local, loop)
 * 
 * To determine scope, figure out, "Where will the variable die?"
 */


public class Scopes {

	static String cat = "kitten";		//static scope (class)		-	since this value is shared by multiple instances, this is static as opposed to instance.
	String cat1 = "cat1";				//instance scope			-	since this value is not shared by multiple instances, this is instance scope
	
	public static void main(String[] args) {
		boolean test = true;	//method scope (main method)
		
		if(test) {
			int x = 4;		//block scope (local)
		}
		
//		System.out.println(x);		//x is inaccessible here, it went out of scope
		
	}
	
	
}
