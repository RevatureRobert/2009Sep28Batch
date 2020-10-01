package com.example.oop.intro;

public class ControlFlow {
	public static void main(String[] args) {
		boolean test = true;
		boolean another = false;
		String something = "Something";

		if(test) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		if(test) {
			System.out.println("True");
		}
		else if(another) {
			System.out.println("false");
		}
		else {
			System.out.println("False");
		}

		switch(something) {
		case "Something":
			System.out.println("it was something after all");
			break;
		case "else":
			System.out.println("it was actually something else");
		default:
			System.out.println("It matched nothing");
		}
		
		for(int i = 0; i<10; i++) {
			if(i == 4)
				continue;
			System.out.println(i);
		}
		
	}
}
