package com.example.datatypes;

public class Constructors extends Object{ //extends Object is optional, every class in Java automatically extends Object
		//DO NOT NAME ANYTHING OBJECT. EVER.  EVEN IF YOU CAN.  DO NOT.
		//objects are a set of states and behaviors. we determine states in the class
		// 		and initialize them inside the constructors.
	
		int age;
		String name;
		
	
		/*
		 * by default, java gives you a constructor
		 * 		it takes no arguments
		 * 
		 * you can also create custom no arg constructors
		 * 		and args constructors
		 */
	
	Constructors(int x, String na){
		//this is the only type of (){} that doesn't need a return type
		age = x;
		name = na;
	}
	
	Constructors(){
		System.out.println("This is the constructors class.");
		
	}
	
	
	//type main, ctrl space to auto get this method
	public static void main(String[] args) {
	/*	Constructors c = new Constructors(9, "Bill");     //default constructor
		System.out.println(c.age); */
		
		C2 c = new C2();
		System.out.println(c.age); //this should hold 0 if we printed it now
		
		
		//void, doesnt return anything
		//every event has to have a return type, except for constructors
		//String[] args is a parameter, information that gets passed in to the event
		//can't activate an event without matching the parameters
	}
	
}
