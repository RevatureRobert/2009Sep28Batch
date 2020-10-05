package com.example.oop.inheritance;

public class InheritanceParent {
	
	static {
		System.out.println("in the parent static block");
	}
	
	{
		// instance blocks and field assignments run before
		System.out.println("In the parent instance block");
	}
	
	private int age;
	private String firstName;
	private String lastName;
	private double height;
	
	public InheritanceParent(int age, String firstName, String lastName, double height) {
		super();
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.height = height;
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
}
