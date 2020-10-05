package com.assign.pets;
public abstract class Animal {

	private String name;
	private int age;
	
	public abstract String makeSound();

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

	public Animal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}
