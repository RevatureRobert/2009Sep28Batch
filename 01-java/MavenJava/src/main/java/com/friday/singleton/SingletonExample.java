package com.friday.singleton;

/*
 * SINGLETON DESIGN PATTERN
 * 
 * 		Wherein there is only one instance of a class...
 * 
 * 		The singleton makes a class only able to be instantiated once
 * 
 * 	Three things you need to make a singleton
 * 		1. private static instance of itself
 * 		2. private constructor
 * 		3. public static getter
 * 
 * volatile
 * 		tracks the singleton shortly after its creation so multiple threads don't try to create
 * 			instances of the private instance simultaneously;
 * 		The getter only needs to be thread-safe when the Singleton is created
 */

public class SingletonExample {
	volatile private static SingletonExample instance /*= new SingletonExample()*/;
	
	private SingletonExample() {
		
	}
	
	public static /*synchronized*/ SingletonExample getInstance() {
		if(instance == null)
			instance = new SingletonExample();
		
		return instance;
	}
}
