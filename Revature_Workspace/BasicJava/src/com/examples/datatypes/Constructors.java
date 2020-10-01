package com.examples.datatypes;

public class Constructors {
	private int age;
	private String name;
	
	public Constructors(int x, String na) {
		age = x;
		name = na;
	}
	public Constructors() {
		System.out.println("You've reached the no args constructor class");
	}
	
	public static void main(String[] args) {
		C2 c = new C2();
		Object o = new Object();
	}
}