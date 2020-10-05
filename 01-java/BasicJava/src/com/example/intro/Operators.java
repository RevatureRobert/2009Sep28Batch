package com.example.intro;

public class Operators {

	public static void main(String[] args) {
		/*
		 * unary
		 * 		++	post-incrementer	(N++)
		 * 		++	pre-incrementer		(++N)
		 * 		--	post-decrementer	(N--)
		 * 		--	pre-decrementer		(--N)
		 * 		!	not operator
		 * 		~	bitwise not
		 * 
		 * binary
		 * 		+	addition
		 * 		-	subtraction
		 * 		*	multiplication
		 * 		/	division
		 * 		%	modulus
		 * 		&&	logical AND	(short circuiting operator because if first operand is false, second operand is dead code)
		 * 		||	logical OR	(short-circuiting operator because if first operand is true, second operand is dead code)
		 * 		&	bitwise AND	(not short-circuiting)
		 * 		|	bitwise OR	(not short-circuiting)
		 * 		^	exclusive OR
		 * 		=	assignment operator
		 * 		==	equals logical operator
		 * 		!=	does not equal logical operator
		 * 		>	greater than
		 * 		<	less than
		 * 		>=	greater than or equal to
		 * 		<=	less than or equal to
		 * 		+=	addition assignment
		 * 		-=	subtraction assignment
		 * 		/=	division assignment
		 * 		%=	modulus assignment
		 * 	instanceof		logical operator; checks whether an object is an instance of a given class
		 * 
		 * ternary
		 * 		condition ? if true operation : if false operation
		 */
		
		double start = 5.5;
		int mod = 3;
		System.out.println(start%mod);
		System.out.println(returnTrue()||returnFalse()); // demonstrates short-circuiting; returnFalse() doesn't run
		
		System.out.println(start);
		System.out.println(++start); // pre-increment increments then performs operations on the result
		System.out.println(start++); // post-increment performs operations then increments the value
		System.out.println(!true);
		
//		if(returnTrue()) {
//			mod = 2;
//		}
//		else {
//			mod = 3;
//		}
		mod = returnTrue() ? 2 : 3; // ternary statement is equivalent to the above if-else logic
		System.out.println(mod);
		
		mod = returnTrue() ? (returnFalse() ? 4 : 3) : 2; // will work, but is unwieldy; avoid nesting ternaries
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
