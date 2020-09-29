package com.example.datatypes;

public class Constructors {
	
	int age;
	String name;
	
	Constructors(int x, String na){
		
	}
	
	Constructors(){
		System.out.println("this is the constructors class");
	}

	public static void main(String[] args) {
		// Constructors c = new Constructors(); // default constructor
		// System.out.println(c.age);
		
		Object o;
		
		C2 c = new C2();
		System.out.println(c.age);
	}

}
