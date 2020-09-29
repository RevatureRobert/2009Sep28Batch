package com.example.oop.inheritance;

public class Child extends Parent {
	
	{
		System.out.println("in the instance block for the child");
	}
	
	
	
	
	private int age = 12;
	private String firstName;
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
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public Child() {
		super();
		System.out.println("in the child constructor");
	}
	public Child(int age, String firstName, String lastName, double height) {
		super(age, firstName, lastName, height);
		// TODO Auto-generated constructor stub
	}
	
}
