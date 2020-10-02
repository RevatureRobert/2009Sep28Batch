package com.stuff;

public abstract class Animal {
	
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

	public void setNumLegs(int numLegs) {
		this.age = numLegs;
	}

	public abstract String makeSound();

}
