package com.example.oop.inheritance;

public class Child extends Parent {
	
	{
		System.out.println("in the instance block for the child");
	}
	
	static {
		System.out.println("in the static instance block of the child class");
	}
	
	public int age = 12; // Fields can be shadowed by casting. We can get the parent's value by upcasting (shadowing)
	private String firstName;
	private double height;
	
//	public int getAge() {
//		return age;
//	}
	public void setAge(int age) { // we cannot get the parents implementation by upcasting (overridden methods cannot be shadowed)
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
	
	public Child(int age, String firstName, String lastName, double height, int age2, String firstName2,
			double height2) {
		super(age, firstName, lastName, height);
		age = age2;
		firstName = firstName2;
		height = height2;
	}
	
	public Child() {
		super();	// Cannot run super() and this() at the same time because they both call the parent and child constructor.
					// They must be on the first line of the constructor and cannot both be in the same one.
//		this(15,"joe","dirt",5.4);
		System.out.println("In the child constructor");
	}
	
	public Child(int age, String firstName, String lastName, double height) {
		super(age, firstName, lastName, height);
	}
	
	{
		System.out.println("Under child constructor, age is now "+age);
	}
	
}
