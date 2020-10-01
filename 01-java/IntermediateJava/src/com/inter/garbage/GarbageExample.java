package com.inter.garbage;
/*
 * Garbage Collection
 * 		
 * 		The Garbage Collector will clean unreferenced objects out of the heam.
 * 
 * 		when an object has no more references pointing to it, it is then eligible
 * 			for garbage collection
 * 
 * 		System.gc() will request the GC, but it gives no guarantees whether it will actually come
 * 
 * 		The gc will call the finalize method on any object it is going to destroy
 * 
 * 		the purpose of the finalize method is to give last minute instructions to the object
 * 
 * 		if you need something done at the end of the program, do not rely on the finalize method
 * 			it is better put in the finally block
 */
public class GarbageExample {

	public static void main(String[] args) throws InterruptedException {

//		Object o1 = new Object();
//		Object o2 = o1;
//		o1 = null;
//		o2 = null;		//this object is now eligible for garbage collection
//		System.gc();	this will request the gc, but it does not determine when it will run
		
		RandomObject r1 = new RandomObject();
		RandomObject r2 = new RandomObject();
		RandomObject r3 = new RandomObject();
		RandomObject r4 = r1;
		RandomObject r5 = r3;
		r2 = r3;
		r3 = null;
		r1 = null;
		r2 = null;
		r4 = null;
		r5 = null;
		System.gc();
		Thread.sleep(500);			//cannot force gc, but can request it
		
	}
}
