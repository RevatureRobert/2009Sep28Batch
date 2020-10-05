package com.example.intro;

/*
 * We can control our application's decision making during runtime
 * 		by using control flow statements 
 * 
 */


public class ControlFlow {

	
	public static void main(String[] args) {
		
		boolean test = true;
		boolean another = false;
		String something = "else";
		
		//if statement
//		if(test) {
//			System.out.println("true");
//		}
		
		//if else statement
//		if(test) {
//			System.out.println(true);
//		} else {
//			System.out.println(false);
//		}
		
		//if else if statement
//		if(test) {
//			System.out.println(true);
//		} else if(another) {
//			System.out.println(true);
//		} else {
//			System.out.println(false);
//		}
		
		//switch statement
		//can be a string, number, enum, etc.
		//cannot be a boolean
		switch(something) {
		case "something":
			System.out.println("It was something after all!");
			break; //you have to end the switch somehow.  Without break, it will go through every option
		case "else":
			System.out.println("It was actually else");
			break; //in general, you should put a break on every case.
		default:
			System.out.println("It wasn't an option");
			break; //you don't necessarily have to put a break here, but you can put default anywhere
				   //if you moved default, you would have to have a break there
		}
		//you could also put return instead of break, and it would return the value, and break out of the switch
		//interestingly, if you put default in the middle with no break, but also match a case, it will only match the case
		//but if you don't match a case, it will go through the default, and all of the following cases without breaks
		//Something else to note: Break statements only break out of one level of statements, i.e. this break only breaks out of the switch statement
		
		
		
		//loops
		
		//for loop
		//for(initialization; condition; incrementation){body}
		for(int i=0; i<10; i++) {
			if(i==4) {
				//break;  //stops all iterations
				continue; //skips the current iteration, but continues the loop
			}			
			System.out.println(i);
		} //for loops are good when you know how long a loop will run
		
//		for(;;) { //WARNING: THIS IS AN INFINITE LOOP!  IT WILL NEVER STOP (unless you hit the red button)
//			System.out.println("Unlimited Power!");
//		}
		
		//while loop
		int x = 7;
		while(x <= 10) { //this may never execute, since the condition is at the beginning
			System.out.println("Here we go again");
			x = x + 1;
		}
		
		//do while loop
		do { //this will always execute at least once, since the condition is at the end
			System.out.println("Doing the thing");
			x = x + 1;
		} while (x < 15);
		
	}
	
}
