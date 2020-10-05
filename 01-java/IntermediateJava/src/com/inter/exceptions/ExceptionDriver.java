package com.inter.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/*
 * Exceptions
 * 
 * 		hierarchy of Exceptions:
 * 									Throwable
 * 			Exception (checked)					Error
 * 		RuntimeException (unchecked)			
 * 
 * Two types of exceptions
 * 	checked		requires you to handle the exception either through handling it directly or ducking responsibility
 * 	unchecked	does not require you to handle the exception; does not need to be explicitly declared as thrown
 * 
 * 	throws versus throw
 * 		throws			method postfix modifier to declare that a method can throw an exception
 * 		throw			make a method throw an exception
 * 
 * When are they thrown
 * 		Exception			Needs to be handled before compiling
 * 		RuntimeException	Does not need to be handled
 *		Error				Typically should not be handled within the program; this is a fatal problem
 *
 *	Exceptions
 *		FileNotFoundException
 *		IOException
 *		SQLException
 *	RuntimeExceptions
 *		IllegalArgumentException
 *		ArrayIndexOutOfBoundsException
 *		NullPointerException
 *	Errors
 *		StackOverflowError
 *		OutOfMemoryError
 *		CompilationError
 */

public class ExceptionDriver {

	public static void main(String[] args) throws CustomException {
		// ArrayIndexOutOfBoundsException - prints stack trace to the console when run
		int[]arr = new int[3];
//		System.out.println(arr[10]);
		
		
//		method(true); // Exception must be handled in order to compile, or main() must throw this exception (to the JVM)
		
		
		// Try/catch block to handle exceptions
		try {
			method(false);
		} catch(Exception e) { // Any Throwable-type object can be caught
			e.printStackTrace();
		}
		
		
		try {
			throw new NullPointerException();
		}
		catch(Exception e) {
			System.out.println("first");
		}
//		catch(FileNotFoundException e) {	// cannot compile this code since it's unreachable
//			System.out.println("second");
//			throw null; // technically can be done since an Exception can be the value null ...
//		}
//		catch(NullPointerException e) {
//			System.out.println("third");
//		}
		
		
		try {
			throw new IOException();
		}
		catch(FileNotFoundException e) {
			System.out.println("caught the file not found");
		}
		catch(IOException e) {
			System.out.println("caught the io");
			
			try {
				throw new SQLException();
			}
			catch(SQLException SQLe) {
				System.out.println("caught the inner SQL Exception");
			}
		}
		catch(RuntimeException e) {
			System.out.println("caught the runtime exception");
		}
		
		
		
//		throw new Error();
		
		
		
//		stackOverflow(); // results in a stack overflow error
		
		
		try {
			throw new IOException();
		}
		catch(FileNotFoundException e) {
			System.out.println("file not found");
		}
		catch(IOException e) {
			System.out.println("io exception");
//			throw new RuntimeException();
		}
		finally {
			System.out.println("\nALWAYS RUNS\n");
		}
		
		
		method3();
		
		
		try {
			System.out.println("doing something");
			throw new CustomException();
		}
		finally {
			System.out.println("Finally! Nothing caught.");
		}
	}
	
	
	
	
	static void method(boolean b) throws Exception {
		if(b) {
			throw new Exception("Intentionally thrown Exception!");
		}
		else {
			System.out.println("b was false");
		}
	}
	
	
	
	static String stackOverflow() {
		System.out.println(stackOverflow());
		return "hey you";
	}
	
	
	
	static String method3() {
		try {
			throw new Exception();
		}
		catch(Exception e) {
			return "happy days";
		}
		finally {
			System.out.println("\nRUNS EVER AFTER RETURNing\n");
		}
	}
}
