package com.example.oop.inheritance;

/*
 * Polymorphism is the ability to use an object as an instance of one of its supertypes
 * 		OR for a method to serve different functions according to its inputs
 * 
 * Compile-time polymorphism
 * 		method overloading
 * 			3 typical ways to overload a method
 * 				1. change parameter count
 * 				2. change parameter type(s)
 * 				3. change order of parameter types
 * Runtime polymorphism
 * 		method overriding
 * 			certain rules of overriding...
 * 				1. cannot reduce the visibility of an overridden method
 * 				2. return type must be able to upcast to the parent method's return type
 * 				3. thrown exceptions must be able to upcast to the parent method's thrown exceptions
 * 
 */

public class InheritanceChild extends InheritanceParent {
	
	// annotation is metadata that tells the compiler and the developer the purpose of something
	// 		we can create custom annotations that perform some kind of action
	// Common annotation is @Override
	
	static {
		System.out.println("In the child static block"); // runs as class is loaded into the runtime, before an object is created
	}
	
	{
		System.out.println("In the child instance block");
	}
	
	private int age;
	private String firstName;
	private double height;
	
	public InheritanceChild(int age, String firstName, String lastName, double height) {
		super(age, firstName, lastName, height);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}
