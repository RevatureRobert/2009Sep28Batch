package com.example.intro;

public class Scopes {

	static String cat = "kitty"; //static scope
	string cat1 = "cat1"; //instance scope
	public static void main(String[] args) {  
		boolean test = true; //method scope

		if(test) {
			int x = 4;   //block scope        
		}
		
		System.out.println(x);
	}

}
