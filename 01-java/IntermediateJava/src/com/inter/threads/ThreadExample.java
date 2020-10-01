package com.inter.threads;

public class ThreadExample {
	
	public static void main(String[] args) {
		
		CustomThread t = new CustomThread(1);
		CustomThread t2 = new CustomThread(10);
		System.out.println(t.getState());
		t.start();
		t2.start();
		System.out.println(t.getState());
		System.out.println(t2.getState());
//		System.out.println(t.getPriority());
//		System.out.println(t.getName());
//		System.out.println(t.toString());
		t.notify();
		
//		Thread t3 = new Thread(new CustomRunnable);
//		t3.start();

	}

}
