package com.assign.pets;
public class Cat extends Animal{

	public Cat(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String makeSound() {
		
		return "The cat goes meow";
		
	}
	
}
