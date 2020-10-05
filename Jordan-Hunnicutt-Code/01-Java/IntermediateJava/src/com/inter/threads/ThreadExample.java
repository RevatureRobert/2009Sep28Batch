package com.inter.threads;

public class ThreadExample {

	public static void main(String[] args) {
		CustomThread t = new CustomThread(1);
		CustomThread t2 = new CustomThread(10);
		System.out.println("t's name is: " + t.getName());
		System.out.println("t2's name is: " + t2.getName());
		System.out.println(t.getState()); //should return new
		t.start();
		t2.start();
		System.out.println(t.getState()); //should return runnable
		System.out.println(t2.getState());
//		System.out.println(t.getPriority());
//		System.out.println(t.getName());
//		System.out.println(t.toString());
//		t.notify();
		
//		try {	//this about trying to control when threads activate or not
//			
//			Thread.currentThread().wait();
////			t.wait();	//have to put t.wait in a try block
//			System.out.println(t.getState());
//			t.notifyAll();
//			System.out.println(t.getState());
//			
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		Thread t3 = new Thread(new CustomRunnable());
		t3.start();
		
	}
}
