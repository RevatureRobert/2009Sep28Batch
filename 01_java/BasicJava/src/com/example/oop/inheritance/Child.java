package com.example.oop.inheritance;

public class Child extends Parent{
	
	// instance block
	{
		System.out.println("in the instance block");
	}
	
	public Child() {
		super();		// this and super both have to be on the first line, and you cannot run both
//		this(15, "joe", "doe", 5.4);
		System.out.println("in the child constructor");
	}
	private int age = 12;		//fields can be shadowed by casting. we can get the parents value by upcasting
	private String firstName;
	private double height;
	public int getAge() {
		return age;
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
	public Child(int age, String firstName, String lastName, double height) {
		super(age, firstName, lastName, height);
	}


	public void setAge(int age) {
		this.age = age;
	}


	
}
