package com.inter.garbage;

/*
 * Garbage Collection: runs on a daemon thread
 * 
 * 		The Garbage Collecter(gc) will clean unreference objects out of the heap
 * 
 * 		when an object has not more references pointing to ti, it is then eligible
 * 			for garbage collection.
 * 
 * 		System.gc() will request the gc but it gives no guarantees whether it will actually come
 * 
 * 		the gc will call the finalize method on any object it is going to destroy. 
 * 
 * 		The purpose of the finalize method is to give last minute instructions to the object. 
 * 
 * 	 	If you need something done at the end of the program, don't rely on the finalize method,
 * 			it's better to use the finally block. 
 * 
 */

public class GarbageExample {
	public static void main(String[] args) throws InterruptedException {
		
//		Object o1 = new Object();
//		Object o2 = o1;
//		o1 = null;
//		o2 = null; 		// once the new Object() has no references to it, it is eligible for garbage collection
//		System.gc();	// this will request the garbage collector, but it does not determine when it will run.
//	
		
		RandomObject r1 = new RandomObject();
		RandomObject r2 = new RandomObject();
		RandomObject r3 = new RandomObject();
		RandomObject r4 = r1;
		RandomObject r5 = r3;
		r2 = r3;
		r3 = null;
//		r1 = null;
//		r2 = null;
//		r4 = null;
//		r5 = null;
//		System.gc();					// cannot force the gc, but we can request it. 
		Thread.sleep(2000);				// even if main thread sleeps for 0.5 secs (500) it'll clean and finalize will be called

		
				
		
		
	
	
	
	
	}

}
