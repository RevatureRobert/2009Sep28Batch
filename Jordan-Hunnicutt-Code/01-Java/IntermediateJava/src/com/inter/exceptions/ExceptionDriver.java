package com.inter.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/*
 * 
 * 		Exceptions
 * 
 * 				hierarchy of exceptions
 * 
 * 											Throwable (C)
 * 								Exception (C)				Error (C)
 * 							RuntimeException (C)
 * 
 * Two types of exceptions
 * 		checked			requires you to handle the exception, either through handling it directly, or ducking responsibility
 * 		unchecked		does not require you to handle the exception
 * 
 * 		throws vs throw
 * 			throws			declares that a method can throw an exception
 * 			throw			how we can physically throw an exception
 * 
 * 		when are they thrown?
 * 			exception		thrown at runtime
 * 		runtimeException	thrown at runtime
 * 			Error			can be thrown at compile time or runtime
 * 
 * 
 * 		Exception
 * 			FileNotFoundException
 * 			IOException
 * 			SQLException
 * 
 * 		RuntimeException 		
 * 			IllegalArgumentException
 * 			ArrayIndexOutOfBounds
 * 			NullPointerException
 * 		Error
 * 			StackOverflowError
 * 			OutOfMemoryError
 * 			CompilationError
 * 			
 */

public class ExceptionDriver {

	public static void main(String[] args) throws CustomException{	//if you add throws to the main method, it propagates all the way up to the JVM
//		int[] arr = new int[3];
//		System.out.println(arr[10]);				//Array Index Out of Bounds		//You could throw try catch blocks everywhere, but it's better to not allow situations like these
		
//		try {
//			System.out.println(arr[10]);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
		
		
//		System.out.println(10/0);					//Arithmetic Exception
		
//		try {
//			method(true);							//to handle an exception, use a try catch block
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		method(true);
		
		
//		try {
//			throw new NullPointerException();
//		} catch (Exception e) { //note: everything is an object, but you can't throw an Object o, because throw can only throw subclasses
//			System.out.println("First");
//		} catch (FileNotFoundException e) {	//these will never be reached, because these are subclasses of exception
//			System.out.println("Second");
//		} catch (NullPointerException e) {  //this is called dead code
//			System.out.println("Third");
//		}
		
//		try {							//when getting exceptions, have to start with most specific, otherwise lower exceptions will never be caught
//		
//		//	throw new IOException();
//		//	throw new RuntimeException();
//			method(true);
//			
//		} catch(FileNotFoundException e) {
//			System.out.println("Caught the file not found");
//		} catch(IOException e) {
//			System.out.println("Caught the IO");
//			
//			try {
//				throw new SQLException();
//			} catch (SQLException e2) {
//				System.out.println("Caught it");
//			}
//			
//		} catch(RuntimeException e) {
//			System.out.println("Caught the runtime exception");
//		}// catch (SQLException e) {
//			//System.out.println("SQL not found");
//	//	}
//		  catch(Exception e) {
//			System.out.println("Exception caught");
//		}
		
//		method(true);					//throws an error if not handled
		
		
//		throw new Error();				//you can throw an error whenever you want, completely stops program
		
//		stackOverflow();				//causes infinite loop (recursion), a stack overflow error
		
		try {
			throw new IOException();
//			throw new RuntimeException("Does it run?");
		} catch(FileNotFoundException e) {
			System.out.println("File was not found");
		} catch (IOException e) {
			System.out.println("IO exception");
//			throw new RuntimeException();
		} finally {
			System.out.println("This will ALWAYS run"); //the finally block is always going to run unless the computer dies, or you use System.exit(0);
		}
		
		System.out.println(method3());	//if we catch exceptions, the rest of the file runs
		
		try {
			System.out.println("Do something");
			throw new CustomException();
		} finally {
			System.out.println("Did that something");
		}
		
//		try {
//			System.out.println("Cannot have a solo try block");
//		}
		
//		finally {
//			//also can't have a finally or catch block by themselves
//		}
		
	}
	
	static void method(boolean b) throws Exception{
		if(b) {
			throw new Exception("This was thrown intentionally");
		} else {
			System.out.println("b was false");
		}
	}
	
	static String stackOverflow() {
		System.out.println(stackOverflow());
		return "Hey there";
	}
	
	static String method3() {
		try {
			throw new Exception();
		} catch (Exception e) {
			return "happy days";
		} finally {
			System.out.println("Execute code after a return?");
		}
		
		
	}
	
}
