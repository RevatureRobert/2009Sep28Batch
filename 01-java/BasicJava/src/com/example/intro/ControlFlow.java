package com.example.intro;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ControlFlow {
	
	public static void main(String[] args) {
		
		boolean test = false;
		int something = 3;
		
		// if statement
		if(test)
			System.out.println("word");
		
		// if-else statement
		if(test)
			System.out.println("word");
		else
			System.out.println("word2");
		
		// if-else if-else statement
		if(test)
			System.out.println("word");
		else if(test)
			System.out.println("middle word");
		else
			System.out.println("word2");
		
		// switch statement
		switch(something) {
		case 1:
			System.out.println("its one");
			break;
		case 2:
			System.out.println("its two");
		case 3:
			System.out.println("its three, unless 2 fell through");
			break;
		default:
			System.out.println("It's not 1,2,3");
			break;
		}
		
		// for loop
		for(int i=0; i<10; i++) {
			System.out.println(i);
			if(i==4) {
				break;		// Skips all iterations
//				continue;	// Skips current iteration
			}
		}
		
		// Also while and dowhile loops, already know how those work
		
	}

}
