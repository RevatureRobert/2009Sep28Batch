package com.example.oop.abstraction;


/*
 * An abstract class is meant to be the beginning of the inheritance tree for your classes.
 * It lays out the minimum that your classes need and what they will all share. Doing this allows for abstraction
 * because by looking at the class, we can't tell how the method is being implemented, especially if it's begin
 * casted to the abstract class. 
 * 
 * we can have fields, normal methods, abstract methods, and constructors inside the abstract class.
 * 
 * 
 */
public abstract class FirstAbstract {

	protected int age;
	
	
	protected abstract void screamInRampage();
	
	protected void print() {
		System.out.println("im painting");
	}
	
	protected FirstAbstract() {
		super();
	}
}
