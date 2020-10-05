package com.example.intro;

public class Operators {

	
	public static void main(String[] args) {
		/*
		 * 		unary
		 * 			x++		post increment
		 * 			++x		pre increment
		 * 			x--		post decrement
		 * 			--x		pre decrement
		 * 			!		not operator
		 * 			~ 		bitwise not
		 * 
		 * 		binary
		 * 			+		addition
		 * 			-		subtraction
		 * 			*		multiplication
		 * 			/		division
		 * 			%		modulus (remainder of division of two numbers - not just ints)
		 * 			&&		logical AND		(short circuiting operator)
		 * 			||		logical OR		(short circuiting operator)		(also could be seen as AND/OR)
		 * 			& 		bitwise AND
		 * 			| 		bitwise OR
		 * 			^		exclusive OR	(returns true if only one is true)
		 * 			=		assignment operator
		 * 			==		comparison operator
		 * 			!= 		not equal to operator
		 * 			>		greater than
		 * 			< 		less than
		 * 			>=		greater than or equal to
		 * 			<= 		less than or equal to
		 * 			+= 		addition assignment
		 * 			-=		subtraction assignment
		 * 			*= 		multiplication assignment
		 * 			/= 		division assignment
		 * 			%=		modulus assignment
		 * 		instanceof	returns a boolean if the object is an instance of a given class
		 * 
		 * 		ternary
		 * 			condition ? ifTrue : ifFalse		like an if else statement.  if the condition is true, set the value to the one before :, if false, set the value to the one after :
		 * 
		 */
		
		double start = 5.5;
		int mod = 3;
		System.out.println(start%mod);
		System.out.println(returnFalse() && returnTrue());
//		start = start+1;
//		start += 1;
		start++;		//post incrementor- increments after using a value for the operation
		++start;		//pre incrementor - increments before using a value for the operation
		start--;
		--start;
//		System.out.println(start++);
//		System.out.println(!true);
//		-------------------
		mod = returnTrue() ? 2 : 3;		
//		if(returnTrue()) {
//			mod = 2;
//		} else {				//good time for  a ternary
//			mod = 3;
//		}
		System.out.println(start%mod);
//		------------------		
//		mod = returnTrue() ? returnFalse() ? 4: 3: 2;	//bad time for a ternary (looks like if{if{} else{}}else{})
		
	}
	
	static boolean returnTrue() { //this and returnFalse shoe off why && and || are called short circuiting operators.  If the first value is a certain way, it doesn't evaluate the other side.
		System.out.println("true method ran");
		return true;
	}
	
	static boolean returnFalse() {
		System.out.println("false method ran");
		return false;
	}
	
}
