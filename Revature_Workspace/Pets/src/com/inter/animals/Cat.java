package com.inter.animals;

public class Cat extends Animal{
	
	public Cat() {
		super.name = "Ellie";
	}
	public Cat(String name) {
		super.name = name;
	}
	@Override 
	public String makeSound() {
		return "Meow";
	}
}
