package com.example.intro;

public class Operators {
	
	public static void main(String[] args) {
		/*
		 * 				unary
	 * 						x++		post incrementer
		 * 					++x		pre incrementer
		 * 					x--		post decrementer
		 * 					--x		pre decrementer
		 *
		 * 
		 * 				binary
		 * 					+		addition
		 * 					-		subtraction
		 * 					* 		multiplication
		 * 					/		division
		 * 					%		modulus (remainder of the division of two numbers)
		 * 					&& 		logical AND		(short circuiting operators)
		 * 					||		logical ORS		(short circuiting operators)
		 * 					&		bitwise AND
		 * 					|		bitwise OR
		 * 					^		exclusive OR (true if they're the same, false if they're different
		 * 					= 		assignment operator
		 * 					==		comparison operator
		 * 					!=		not equal to operator
		 * 					>		greater than
		 * 					<		less than
		 * 					>=		greater than or equal to
		 * 					<= 		less than or equal to
		 * 					+=		addition asignment
		 * 					-=		subtraction asignment
		 * 					*=		multiplication assignemtn
		 * 					/=		division assignment
		 * 					%= 		modulus assignment
		 * 				instanceof	returns boolean if the object is an instance of a given class
		 * 
		 * 
		 * 
		 * 				ternary
		 * 					condition ? ifTrue: ifFalse
		 * 
		 * 
		 * 
		 */
		
		int mod = returnTrue() ? 2:3;
		
	}
	
	public static boolean returnTrue() {
		return true;
	}

}
