package com.inter.garbage;

public class RandomObject {

	final private double id = Math.random()*1000;
	
	//it is no longer customary to use this for the end of an object's life, now it's suggested to use a finally block
	//there's no guarantee this will run before the program ends
	@Override
	protected void finalize() throws Throwable { //this will be the last method that runs on an object
		System.out.println("The id of this instance is: " + this.id);
	}
	
}
