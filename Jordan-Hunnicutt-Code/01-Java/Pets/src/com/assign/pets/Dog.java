package com.assign.pets;
public class Dog extends Animal{

	public Dog(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String makeSound(){
		
	return "The dog says woof!";
		
	}
	
}
