package com.inter.animals;

public class Dog extends Animal{
	
	public Dog() {
		super.name = "Hank";
	}
	public Dog(String name) {
		super.name = name;
	}
	@Override
	public String makeSound() {
		// TODO Auto-generated method stub
		return "Woof";
	}

}
