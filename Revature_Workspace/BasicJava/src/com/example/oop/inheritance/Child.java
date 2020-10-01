package com.example.oop.inheritance;

public class Child extends Parent {
	private int age;
	
	{
		System.out.println("in the instance block, child");
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
	private String firstName;
	private double height;
	public Child(int age, String firstName,String lastName, double height) {
		super(firstName, age, lastName, height);
	}
	public Child() {
			super();
		}
}
