package com.example.intro;

public class Operators {

	
	public static void main(String[] args) {
		/*
		 * 		unary
		 * 		x++			post increment
		 * 		++x			pre increment
		 * 		--x			pre decrement
		 * 		x--			post decrement
		 * 		!			not operator
		 * 		~			bitwise not
		 * 
		 * 		binary
		 * 			+		addition
		 * 			-		subtraction
		 * 			*		multiplication
		 * 			/		division
		 * 			%		modulus (remainder of the division of the two numbers)
		 * 			&&		logical AND		(short circuiting operator)
		 * 			|| 		logical OR		(short circuiting operator)
		 * 			&		bitwise AND
		 * 			|		bitwise OR
		 * 			^		exclusive OR
		 * 			=		assignment operator
		 * 			==		comparison operator
		 * 			!=		not equal to operator
		 * 			>		greater than
		 * 			<		less than
		 * 			>=		greater than or equal to
		 * 			<=		less than or equal to
		 * 			+=		addition assignment
		 * 			-=		subtraction assignment
		 * 			*=		multiplication assignment
		 * 			/=		division assignment
		 * 			%=		modulus assignment
		 * 		instanceof	returns a boolean if the object is an instance of a given class
		 * 
		 * 
		 * 
		 * 		ternary
		 * 			condition ? ifTrue : ifFalse;
		 */
		
		double start = 5.5;
		int mod = 3;
		System.out.println(start%mod);
		System.out.println(returnTrue()^returnTrue());
//		start = start+1;
//		start += 1;
//		start++;
//		++start;
//		start--;
//		--start;
//		System.out.println(--start);
//		System.out.println(start);
//		System.out.println(!true);

//============================================================================================================
		mod = returnTrue() ? 2 : 3;							// good time for a ternary
//		if(returnTrue()) {
//			mod = 2;
//		} else {					
//			mod = 3;
//		}
//=============================================================================================================
//		mod = returnTrue()? returnFalse() ? 4: 3: 2;		// bad time for a ternary
//		if(returnTrue()) {
//			if(returnFalse()) {
//				mod = 4;
//			} else {
//				mod = 3;
//			}
//		} else {
//			mod = 2;
//		}
	}
	
	static boolean returnTrue() {
		System.out.println("true method ran");
		return true;
	}
	
	static boolean returnFalse() {
		System.out.println("false method ran");
		return false;
	}
}
