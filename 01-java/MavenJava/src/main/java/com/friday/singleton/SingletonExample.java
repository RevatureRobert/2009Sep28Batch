package com.friday.singleton;
/*
 * SINGLETON DESIGN PATTERN
 * 
 * 		The singleton makes a class only able to be instantiated once.
 * 
 * 		three things you need to make a singleton
 * 			1. private static instance
 * 			2. private constructor
 * 			3. public static getter
 */
public class SingletonExample {
	
	volatile private static SingletonExample instance /* = new SingletonExample() */;
	
	private SingletonExample() {}
	
	/* synchronized */ public static SingletonExample getInstance() {
		if(instance == null) {
			instance = new SingletonExample();
		}
		
		return instance;
	}

}
