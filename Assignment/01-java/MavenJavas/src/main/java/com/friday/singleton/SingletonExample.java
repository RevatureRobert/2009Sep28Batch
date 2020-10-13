package com.friday.singleton;

/*
 * 
 * Singleton Design Pattern
 * 
 * 		The singleton makes a class only able to be instantiated once.
 * 
 * three things you need to make a singleton
 * 			1. private static instance
 * 			2. private constructor
 * 			3. public static getter
 */

public class SingletonExample {
	//volatile tells java that at the beginning of the class, this class is at risk of having threading issues. 
	volatile private static SingletonExample instance /*= new SingletonExample()*/;
	
	private SingletonExample() {
		
	}
	
	//synchronized means only one thread can access this at a time.
	/*synchronized*/ public static SingletonExample getInstance() { 
		if(instance == null) {
			instance = new SingletonExample();
		}
		
		return instance;
	}

}
