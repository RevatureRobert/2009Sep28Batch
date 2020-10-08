package com.inter.people;

import com.inter.animals.*;

public class Person<T> {
	private String name;
	private T pet;
	private boolean walk;
	
	public Person() {
		this.name = "Alex";
		this.pet = (T) new Dog();
	}
	public Person(String name, T pet) {
		this.name = name;
		this.pet = pet;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public T getPet() {
		return pet;
	}
	public void setPet(T pet) {
		this.pet = pet;
	}
	public void setWalk(boolean walk) {
		this.walk = walk;
	}
	public boolean getWalk() {
		return walk;
	}
}
