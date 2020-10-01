package com.inter.threads;

public class CustomThread extends Thread {

	public CustomThread(int priority) {
		this.setPriority(priority);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public void run() {
		for (int i = 0; i < 40; i++) {
			System.out.println(this.getName());
		}
	}
}
