package com.example.oop.inheritance;

public class Parent {
	
	{
		System.out.println("in the instance block, parent");
	}
	
	private String name;
	private int age;
	private String lastname;
	private double height;
	
	public Parent(String name, int age, String lastname, double height) {
		super();
		this.name = name;
		this.age = age;
		this.lastname = lastname;
		this.height = height;
	}
	public Parent() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
}
