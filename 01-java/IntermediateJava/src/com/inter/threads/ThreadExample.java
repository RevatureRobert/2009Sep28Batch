package com.inter.threads;

/**
 * @author irvin
 *
 */
public class ThreadExample {
	public static void main(String[] args) {
		CustomThread t1 = new CustomThread(10);
		CustomThread t2 = new CustomThread(1);
		System.out.println("t1's name is: " + t1.getName());
		System.out.println("t2's name is: " + t2.getName() );
		System.out.println(t1.getState());
		t1.start();
		t2.start();
		System.out.println(t1.getState());
		System.out.println(t2.getState());
		//System.out.println(t.getName());
		//System.out.println(t.toString());
		
//		try {
//			
//			t.wait();
//			System.out.println(t.getState());
//			t.notify();
//			System.out.println(t.getState());
//		}catch(InterruptedException e) {
//			e.printStackTrace();
//		}
	}
}
