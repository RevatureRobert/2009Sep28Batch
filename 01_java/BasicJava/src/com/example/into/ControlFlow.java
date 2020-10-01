package com.example.into;
/*
 * we can control our applications decision making during runtime
 * 		by using control flow statements
 */
public class ControlFlow {
	
	
	public static void main(String[] args) {
		boolean test = true;
		String something = "";
//		
//		//if statement
//		if(test) {
//			System.out.println("true");
//		}
//		
//		//if else statement
//		if(test) {
//			System.out.println(true);
//		} else {
//			System.out.println(false);
//		}
//		//if else if statement
//		if(test) {
//			System.out.println(true);
//		}else if(another) { 
//			System.out.println(true);
//		} else {
//			System.out.println(false);
//		}
		
		//switch statement
		switch(something) {
		case"something":
			System.out.println(" it was something after all");
			break;		//prevents fall throughs
		case"else":
			System.out.println(" it was actually else");
			break;
		default:
			System.out.println(" it wasnt any of them");
			break;
		}
		
		System.out.println("in the method");
		
		//loops
		
		//for loop
		//for(initialization; condition; iincrementation){body}
		for(int i = 0; i<10; i=i+1) {
			if(i==4) {
//				break;
				continue;
			}
			System.out.println(i);
		}
		
//		for(;;) {
//			System.out.println("infinite"); //infinite loop
//		}
		
		//while
		test = false;
		int x = 7;
		while(x<10) {
			System.out.println("here we go again");
			x=x+1;
		}
		
		//do while
		do {
			System.out.println("doing the thing");
			x=x+1;
		} while(false);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
