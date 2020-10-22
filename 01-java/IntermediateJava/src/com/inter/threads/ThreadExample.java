package com.inter.threads;

public class ThreadExample {

	public static void main(String[] args) {
		CustomThread t = new CustomThread(10);
		CustomThread t2 = new CustomThread(1);
		System.out.println("t's name is: "+t.getName());
		System.out.println("t2's name is: " + t2.getName());
		System.out.println(t.getState());
		t.start();
		t2.start();
		System.out.println(t.getState());
		System.out.println(t2.getState());
//		System.out.println(t.getPriority());
//		System.out.println(t.getName());
//		System.out.println(t.toString());
//		t.notify();
		
		
		Thread t3 = new Thread(new CustomRunnable());
		t3.start();
		Thread t4 = new Thread(() -> System.out.println("instance of an anonymouse inner class implementing the runnable interface"));
		t4.start();
		
		Runnable r = () -> {};
	}
	
	static int run(Runnable r) {
		return 7;
	}

}
