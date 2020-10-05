package com.inter.threads;

public class CustomThread extends Thread{

	public CustomThread(int priority) {
		this.setPriority(priority);
	}
	
	
	@Override
	public void run() { //whenever we extend Thread, we HAVE to override the run method
//		super.run();
//		System.out.println("Ran run()");
		this.setPriority(5);
		for(int i = 0; i < 40; i++) {
//			if(i > 25) {
//				this.setPriority(9); //this does work.  There isn't really an example of why you would do this right now though
//			}
			System.out.println(this.getName());
		}
	}
}
