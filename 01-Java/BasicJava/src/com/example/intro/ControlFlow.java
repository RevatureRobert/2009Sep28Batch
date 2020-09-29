package com.example.intro;

public class ControlFlow {
	public static void main(String[] args) {
		boolean test = true;
		boolean another = false;
		String something = "else";
		
		if(test) {
			System.out.println("True");
		}
		if (test) {
			System.out.println(true);
		}else {
			System.out.println(false);
		
		}
		
		if(test) {
			System.out.println(true);
		} else if(another) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
		switch(something) {
		case "something":
			System.out.println("it was something");
			break;
		default:
			System.out.println("It wasn't any of them");
		case "else":
			System.out.println("it was actually else");
		}
		
	}
	
}
