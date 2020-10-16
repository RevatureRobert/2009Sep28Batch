package com.exercises.petwalking;

import com.exercises.pets.*;

public class Person {

	public Animal pet;
	
	public static void main(String[] args) {
		Person catPerson = new Person();
		Person dogPerson = new Person();
		
		catPerson.setPet(new Cat());
		dogPerson.setPet(new Dog());
		
		System.out.println("Cat sound: ");
		catPerson.getPet().makeSound();
		
		System.out.println("\nDog sound: ");
		dogPerson.getPet().makeSound();
	}

	public Animal getPet() {
		return pet;
	}

	public void setPet(Animal pet) {
		this.pet = pet;
	}
}