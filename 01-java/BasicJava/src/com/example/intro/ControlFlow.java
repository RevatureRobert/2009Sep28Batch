package com.example.intro;

/*
 * We can control out application's decision-making during runtime by using control flow statements
 */

public class ControlFlow {
	public static void main(String[] args) {
		//if statement
		boolean test = true;
		if(test) {
			System.out.println("true");
		}
		
		//if-else statement
		if(test) {
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}
		
		//if-else-if statement
		boolean test2 = false;
		if(test) {
			System.out.println(true);
		}
		else if(test2){
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}
		
		//switch case
		String something = "something";
		switch(something) {
			case "something":
				System.out.println("something after all");
				break;
			case "else":
				System.out.println("actually something else");
				break;
			default:
				System.out.println("it wasn't any of them");
		}
		
		// loops
		
		// for loop
		// for(initialization; break condition; incrementation){ body }
		for(int i = 0; i < 10; i = i + 1) {
			if(i == 4)
				continue; // breaks this iteration, goes to the next one after running the incrementation logic
			System.out.println(i);
		}
		
		// infinite loop until it hits break
		for(;;) {
			break;
		}
		
		// while loop
		int x = 7;
		while(x <= 10) {
			System.out.println("here we go again");
			x = x + 1;
		}
		
		// do while loop
		do {
			System.out.println("doing the thing");
			x = x + 1;
		}while(x < 15);
	}
}
