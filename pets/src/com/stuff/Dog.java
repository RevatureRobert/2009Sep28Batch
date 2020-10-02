package com.stuff;

public class Dog extends Animal {
	
	private String color;
	private String size;
	private int age;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String makeSound() {
		return "Bark!";
	}

	public Dog(String color, String size, int age) {
		super();
		this.color = color;
		this.size = size;
		this.age = age;
	}
	
}
