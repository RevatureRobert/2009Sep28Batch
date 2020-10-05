package com.inter.garbage;

/*
 * Garbage collection
 * 
 * Garbage collector is in the background / Daemon thread, running outside of the program
 * 
 * When there are no more references for an object, it is eligible for garbage collection
 * 
 * The Garbage Collector will clean unreferenced objects out of the heap.
 * 
 * System.gc() will request the GC but gives no guarantee of its execution
 * 
 * The GC will call the finalize method of and object it is going to destroy
 * 
 * The purpose of the finalize method is to give last-minute instructions to the object.
 * 
 * If you need something done at the end of the program, do not rely on finalize();
 * 		it is better to put it in the finally block
 * 
 * If heap memory gets full enough, garbage collector will run, but it can still only
 * 		collect unreferenced objects in the heap
 */

public class GarbageExample {

	public static void main(String[] args) throws InterruptedException {
		Object o1 = new Object();
		Object o2 = o1;
		
		o1 = null; // Does not remove the object; just removes this reference to it
		
		o2 = null; // Object is now eligible for garbage collection; all references to it are gone
		
		System.gc(); // Requests the garbage collector but does not determine that it will run
		
		
		
		RandomObject r1 = new RandomObject();	// r1 -> object 1
		RandomObject r2 = new RandomObject();	// r2 -> object 2
		RandomObject r3 = new RandomObject();	// r3 -> object 3
		RandomObject r4 = r1;					// r4 -> object 1
		RandomObject r5 = r3;					// r5 -> object 3
		r2 = r3;								// r2 -> object 3 (no longer object 2)
		r3 = null;								// r3 -> no object (no longer object 3)
		System.gc();							// Only object 2 has no more references
		Thread.sleep(2000); // Gives the garbage collector a bit of time to run
							// If this is not present, the garbage collector may run after the program terminates
		
		r1 = null;
		r2 = null;
		r4 = null;
		r5 = null;
		System.gc();
		Thread.sleep(500);
	}

}
