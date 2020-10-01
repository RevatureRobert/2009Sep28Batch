package com.example.into;

public class Operators {
	
	public static void main(String[] args) {
		/*
		 * 		unary
		 * 		x++		post increment
		 * 		++x		pre increment
		 * 		x--		post decrement
		 * 		--x		pre decrement
		 * 		!		not operator
		 * 		~		bitwise not
		 *  
		 * 
		 * 
		 * 		binary
		 * 			+		addition
		 * 			-		subtraction
		 * 			*		multiplication
		 * 			/		division
		 * 			%		modulus (remainder of the division of the two integers)
		 * 			&&		logical AND	(short circuiting operator)
		 * 			||		logical OR	(short circuiting operator)
		 * 			&		bitwise AND
		 * 			|		bitwise OR
		 * 			^		exclusive OR
		 * 			=		assignment operator
		 * 			==		comparison operator
		 * 			!=		not equal to
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
		 * 		ternary
		 * 			condition ? ifTrue : ifFalse;
		 * 
		 */
		
		double start = 5.5;
		int mod =3;
//		System.out.println(start%mod);
		System.out.println(returnFalse()^returnTrue());
//		start = start+1;
//		start += 1;
//		start++;
//		++start;
//		start--;
//		--start;
//		System.out.println(--start);
//		System.out.println(start);
//		System.out.println(!true);
		mod = returnFalse() ? 2 : 3;
		System.out.println(start%mod);
		
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
