package com.example.into;
/*
 * 
 * There are four scopes in java
 * 
 * 		static (class)
 * 		instance (object)
 * 		method 
 * 		block (local, loop)
 * 
 * where does the method die?
 * 
 * 
 */
public class Scopes {

	static String cat = "kitty";	//static scope
	String cat1 = "cat1";			//instance scope
	
	public static void main(String[] args) {
		boolean test = true;		//method scope
		
		if(test) {
			int x = 4;				//block scope
		}
		
		System.out.println(cat);
	}
}
