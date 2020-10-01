package com.example.oop.inheritance;

public class Parent {
	
	static {
		System.out.println("in the class block for the parent");
	}
	

	// instance block
	{
		System.out.println("in the instance block for the parent");
	}
	
	private int age = 30;
	private String firstName;
	private String lastName;
	private double height;
	
	
	
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
	public Parent(int age, String firstName, String lastName, double height) {
		super();
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.height = height;
	}
	public Parent() {
		super();
		System.out.println("in the parent constructor");
	}
	

}
