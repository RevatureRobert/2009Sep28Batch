package com.example.datatypes;

public class Constructors {
	// objects are a set of states and behaviors. we determine the states in the class
	//		and initioalize them inside the constructors.
	int age;
	String name;
	
	
	/*
	 * by default, java gives you a constructor 
	 * 		it takes no arguments
	 * 
	 * then you have a custom no arg constructor
	 * 		and an args constructor
	 */
	
	Constructors(int x, String na){
		age = x;
		name = na;
	}
	
	Constructors() {
		System.out.println("this is the constructors class");
	}
	
	
	
	public static void main(String[] args) {
//		Constructors c = new Constructors(7, "go"); //default constructor
//		System.out.println(c.age);
		C2 c = new C2();
		System.out.println(c.age);
	}
}

