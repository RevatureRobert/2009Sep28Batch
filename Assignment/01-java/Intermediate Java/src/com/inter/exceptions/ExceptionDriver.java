package com.inter.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionDriver {

	/*
	 * Exceptions
	 * 
	 * 				hierarchy of exceptions
	 * 
	 * 										Throwable(class)
	 * 					Exception(class)							Error(class)
	 * 				RuntimeException(class)
	 * 
	 * 
	 * two types of exceptions: 
	 * 		checked			Something wrong outside of code(usually).requires you to handle the exception either 
	 * 						through handling it directly or ducking responsibility.
	 * 		unchecked		Something wrong with code(usually). does not require you to handle the exception
	 * 
	 * 		throws vs throw
	 * 			throws 		declares that a method can throw an exception
	 * 			throw		how we can physically throw an exception
	 * 
	 * 		when are they thrown
	 * 			exception			thrown at runtime
	 * 		Runtime exception		thrown at runtime
	 * 			Error				can be thrown at compile time or runtime
	 * 
	 * 
	 * 		Exceptions(checked)
	 * 			FileNotFoundException
	 * 			IOException
	 * 			SQLException
	 * 
	 * 		RuntimeException (unchecked)
	 * 			IllegalArgumentException
	 * 			ArrayIndexOutofBounds
	 * 			NullPointerException
	 * 
	 * 		Error
	 * 			StackOverflowError
	 * 			OutOfMemoryError
	 * 			CompilationError
	 * 			
	 * 
	 */
	public static void main(String[] args) {
//		int[] arr = new int[3];
//		System.out.println(arr[10]);		//array index out of bounds
//		try {
//			method(true);					// to handle exceptions, use a try catch block
//		} catch(Exception e) {
//			e.printStackTrace();
//			
//		}
//		throw null;							// can't do it
		
//		try {
//			throw new NullPointerException();
//		} catch(Exception e) {
//			System.out.println("first");
//		} catch(FileNotFoundException e) {
//			System.out.println("second");
//		} catch(NullPointerException e) {
//			System.out.println("third");
//		} catch(IllegalArgumentException e) {
//			
//		}
		
//		try {
//			throw new IOException();
//		} catch(SQLException e){
//			System.out.println("caught the file not found");
//		} catch(IOException e) {
//			System.out.println("caught the io");
//			try {
//				throw new SQLException();
//			} catch (SQLException e2) {
//				System.out.println("caught it");
//			}
//		} catch(RuntimeException e) {
//			System.out.println("caught the runtime exception");
//		} 
		
//		method(true);   throws an error if not handled
		
//		throw new Error();
		
//		stackOverflow();  // this results in stack overflow error
		
		
		try {
			throw new IOException();
		} catch(FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("io exception");
			//throw new RuntimeException();
		} finally {			 // this block always run. 
			System.out.println("does this run");  //this runs because the exceptions were caught in the try catch/
		}
		
		method3();
		
		try {										/// you can have a try-finally block. 
			System.out.println("doing something");
		} finally {
			System.out.println("it's all good");
		}
		
		//can't have try, finally, or catch blocks by themselves. 
		
		try {
			throw new CustomException();
		} catch(CustomException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}//end of main method
	
	static void method(boolean b) throws Exception{
		if(b) {
			throw new Exception();
		} else {
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
		} catch(Exception e){
			return "happy days";
		} finally {
			System.out.println("non happy days");
		}
	}

}
