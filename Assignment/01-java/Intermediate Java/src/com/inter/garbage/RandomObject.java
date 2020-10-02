package com.inter.garbage;

public class RandomObject {
	
	final private double id = Math.random() * 1000;
	
	@Override
	protected void finalize() throws Throwable { // the last method that is called on the object before garbage collection
		System.out.println("the id of this instance is : " + this.id);
		
		// rather than using the finalize block, use the finally block instead, because there is no guarantee that
		// garbage collector will run while the main thread is running, because gc runs on a daemon thread. 
	}
	

}
