package com.example.datatypes;

public class Constructors {
	
	int age;
	String name;
	
	Constructors(int x, String na) {
		age = x;
		name = na;
	}
	
	Constructors() {
		System.out.println("This is the constructors class");
	} // Method overloading
	
	public static void main(String[] args) {
		Constructors c = new Constructors(10, "Fig");
		C2 c2 = new C2();
		System.out.println(c.age);
	}

}