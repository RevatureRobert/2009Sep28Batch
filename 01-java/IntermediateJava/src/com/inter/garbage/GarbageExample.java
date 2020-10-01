package com.inter.garbage;

public class GarbageExample {
	
	public static void main(String[] args) throws InterruptedException {
		
//		Object o1 = new Object();
//		Object o2 = o1;
//		o1 = null;
//		o2 = null;			// object is now eligible for garbage collection
//		System.gc();		// This will request the gc, but it does not determine when it will run.
		
		RandomObject r1 = new RandomObject();
		RandomObject r2 = new RandomObject();
		RandomObject r3 = new RandomObject();
		RandomObject r4 = r1;
		RandomObject r5 = r3;
		r2 = r3;
//		r3 = null;
//		r1 = null;
//		r2 = null;
//		r4 = null;
//		r5 = null;
		System.gc();			// The garbage collector cannot be forced, only requested
		Thread.sleep(5);
	}

}
