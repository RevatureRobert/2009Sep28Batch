package com.friday.singleton;

public class SingletonExample {
	
	volatile private static SingletonExample instance/* = new SingletonExample() */;
	
	private SingletonExample() {}
	
	/* synchronized */ public static SingletonExample getInstance() {
		if(instance == null) {
			instance = new SingletonExample();
		}
		
		return instance;
	}

}
