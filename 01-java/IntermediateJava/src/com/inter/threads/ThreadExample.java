package com.inter.threads;

public class ThreadExample {
	public static void main(String[] args) {
		CustomThread t = new CustomThread(5);
		CustomThread t2 = new CustomThread(5);
		System.out.println("t's name is " + t.getName());
		System.out.println("t2's name is " + t2.getName());
		
		System.out.println(t.getState());
		t.start();
		t2.start();
		System.out.println(t.getState()); // NEW state
		System.out.println(t2.getState());
		System.out.println(t.getPriority());
		System.out.println(t.getName());
		System.out.println(t.toString());
		t.run();
		System.out.println(t.getState()); // RUNNABLE state
		
		try {
			Thread.currentThread().wait();
			System.out.println(t.getState());
			t.notifyAll();
			System.out.println(t.getState());
		}
		catch(InterruptedException e) {
			
		}
		
		
		Thread t3 = new Thread(new CustomRunnable());
		
		/*
		Object o = new Object();
		o.notify(); // releases any synchronized resources to the heap;
					// any blocked threads are always trying to access this resource and know when to continue by the notification
					// of that resource
		o.notifyAll(); // tells all threads that a resource is available
		
		try {
			o.wait(); // waits until a certain thread calls notify
			o.wait(1000); // waits a specified amount of time
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
	}
}
