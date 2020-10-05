package com.example.oop.abstraction;

/*
 * 
 * Abstract class is meant to be the root of a hierarchy, the beginning of the inheritance tree for your classes.
 * 		It lays out the minimum that your classes need and what they will all share. Doing
 * 		this allows for abstraction, because by simply looking at the class, we cannot tell
 * 		how the method is being implemented, especially if it is being upcast to the abstract class.
 * 
 * We can have fields, normal methods, abstract methods, and constructors inside the abstract class.
 */

public abstract class FirstAbstract {
	protected int age;
	
	protected abstract void screamInRampage();
	
	// abstract classes have default constructors even though they can't be instantiated in order to complete the lineage back to Object
	protected FirstAbstract() {
		super();
	}
}