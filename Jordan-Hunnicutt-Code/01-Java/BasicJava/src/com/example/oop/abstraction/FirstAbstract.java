package com.example.oop.abstraction;

/*
 * An abstract class is meant to be the beginning of a hierarchy for your classes
 * 		It lays out the minimum that a class will need, and what will be shared.
 * 		This allows for abstraction, because just looking at this class does not
 * 		tell how a method will be implemented, especially if the method is upcasted
 * 		to this abstract class.
 * 
 * Abstract classes can contain fields, normal methods, abstract methods, and constructors.
 * 
 */


public abstract class FirstAbstract implements Readable{
	
	protected int age;
	
	protected abstract void screamInRampage(); //adding this keyword means we dont need {}
											   //we can add a ; instead
	
	protected void print() { //we can still have concrete methods in abstract classes
							 //these don't have to be overriden in a child class
		System.out.println("I am painting.");
	}
	
	protected FirstAbstract() {
		super();
		//we can't instantiate an abstract class, but we still need a constructor
		//Java still needs a way to get from a child class up to the Object class
	}
	
}
