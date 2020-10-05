package com.inter.threads;

public class CustomThread extends Thread {
	
	public CustomThread() {
		super();
	}
	
	public CustomThread(int i) {
		super();
		setPriority(i);
	}
	
	@Override
	public void run() {
		this.setPriority(5);
		
		for(int i = 0; i < 40; i++)
			System.out.println(this.getName());
	}
}
