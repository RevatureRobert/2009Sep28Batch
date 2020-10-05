package com.inter.garbage;

public class RandomObject {
	final private double id = Math.random() * 1000;
	
	
	// finalize() can be overridden, and the code within will execute when the garbage collector takes it
	// This is atypical; there is no guarantee that this will be called while the program is actually still running
	// The custom today is to place finalization code in a finally block
	@Override
	protected void finalize() throws Throwable {
		System.out.println("the id of this instance is " + this.id);
	}
}
