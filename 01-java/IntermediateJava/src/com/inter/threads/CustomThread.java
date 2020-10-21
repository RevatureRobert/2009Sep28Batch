package com.inter.threads;

public class CustomThread extends Thread{
	
	public CustomThread(int priority) {
		this.setPriority(priority);
	}

	@Override
	public void run() {
		this.setPriority(5);
		for(int i =0; i<40; i++) {
			System.out.println(this.getName());
			System.out.println(this.getState());
		}
	
	}
}
