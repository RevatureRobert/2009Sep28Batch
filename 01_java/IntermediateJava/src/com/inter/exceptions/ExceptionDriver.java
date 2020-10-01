package com.inter.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/*
 * 
 * Exceptions
 * 
 * 			hierarchy of exceptions
 * 
 * 										throwable(C)
 * 							exception (C)			Error(C)
 * 						RuntimeException(C)
 * 
 * two types of exceptions
 * 		checked			requires you to handle the exception either through handling it directly or ducking responsibility
 * 		unchecked		does not require you to handle the exception
 * 
 * 		throws vs throw
 * 			throws			declares that a method can throw an exception
 * 			throw			how we can physically throw an exception
 * 
 * 		when are they thrown
 * 			exception		thrown at runtime
 * 		runtime exception	thrown at runtime
 * 			Error			can be thrown at compile time or runtime
 * 
 * 
 * 		Exceptions
 * 			FileNotFoundException
 * 			IOException
 * 			SQULException
 * 
 * 		Runtime Exceptions
 * 			IllegalArgumentException
 * 			ArrayIndexOutOfBounds
 * 			NullPointerException
 * 
 * 		Error
 * 			StackOverflowError
 * 			OutOfMemoryError
 * 			CompilationError
 */
public class ExceptionDriver {
	
	public static void main(String[] args) {
		int[] arr=null;// new int[3];
		
//		try {
//			System.out.println(arr[10]);		//array index out of bounds
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			method(true);						// to handle exceptions, sue a try catch block			
//		} catch (Exception e){
//			e.printStackTrace();
//		}
		
//		method(true);
		
//		System.out.println("does it reach");
		
//		try {
//			throw new NullPointerException();
//		} catch (Exception e) {
//			System.out.println("first");
//		} catch( FileNotFoundException e) {
//			System.out.println("second");
//		} catch (NullPointerException e) {
//			System.out.println("third");
//		}
		
//		try {
//			throw new IOException();
//			
//		} catch (FileNotFoundException e) {
//			System.out.println("caught the file not found");
//		} catch (IOException e) {
//			System.out.println("caught the io");
//			try{
//				throw new SQLException();
//			} catch (SQLException e2) {
//				System.out.println("caught it");
//			}
//		} catch (RuntimeException e) {
//			System.out.println("caught the runtime exception");
//		} catch (SQLException e) {
//			System.out.println("sql not found");
//		} catch (Exception e) {
//			System.out.println("exception caught");
//		}
//		method(true);		//throws an error if not handled
		
//		throw new Error();
		
//		stackOverflow();	//this results in stack overflow error
		
		try {
			throw new IOException();
		} catch(FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("io exception");
			throw new RuntimeException();
		} finally {
			System.out.println("does this run?");
		}
		
	}
	static void method(boolean b) throws Exception {
		if(b) {
			throw new Exception("this was thrown intentionally");
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
		} catch{
			
		}
	}
}
