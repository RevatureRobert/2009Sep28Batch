package com.friday.singleton;
/*
 *  SINGLETON DESIGN PATTERN
 * 
 * 		The singleton makes a class only able to be instantiated ONCE.
 * 
 * 		three things you need to make a singleton
 * 			1) private static instance
 * 			2) private constructor
 * 			3) public static getter
 * 
 * 
 * 		we'll be using this type of framework to connect to a database
 */
public class SingletonExample {
	
	volatile private static SingletonExample instance /* = new SingletonExample() */; //by making this volatile, java will know that this instance is at risk of having threading issues
	
	private SingletonExample() { //by making this constructor private, now only the Singleton class can instantiate itself
		
	}
	
	/*synchronized*/ public static SingletonExample getInstance() { //make this synchronized, that way only one thread can access this at a time, but it's slow
		if(instance == null) {
			instance = new SingletonExample();
		}
		
		return instance;
	}
	
}
