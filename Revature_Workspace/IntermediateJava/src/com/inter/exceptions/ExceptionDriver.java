package com.inter.exceptions;
/*
 * 
 * Exceptions 
 * 
 * 			hierarchy of exceptions
 * 									Throwable(C)
 * 							Exception(C)		Error(C)
 * 						RunTimeException(C)
 * 
 * Two types of exceptions
 * 		Checked - Requires you to handle the exception either through handling it 
 * 				  directly or ducking responsibility. We have to declare Checked Exceptions
 * 		Unchecked - Does not require you to handle the exception. Can happen at anytime during runtime.
 * 
 * Throws vs Throw
 * 		Throws - Declares that a method can throw an exception
 * 		Throw -  How we can physically through an exception
 * 
 * When are they thrown
 * 		Exception - thrown at runtime
 * 		RuntimeException - thrown at runtime
 * 		Unchecked - Can be thrown at compile time or runtime		
 * 
 * 		Exception (Checked)
 * 			FileNotFoundException
 * 			IOException
 * 			SQLException
 * 
 * 		RuntimeException
 * 			IllegalArgumentException
 * 			ArrayIndexOutofBounds
 * 			NullPointerException
 * 
 * 		Error
 * 			StackOverflowError
 * 			OutOfMemoryError
 * 			CompilationError
 * 			
 * */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class ExceptionDriver {
	public static void main(String[] args) throws Exception {
//		int[] arr = new int[3];
//		System.out.println(arr[10]);  //Array index out of bounds
//		try {
//			method(true);			  //To handles exceptions, use a try catch block
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			throw new NullPointerException();
//		} catch (Exception e) {
//			System.out.println("first");
//		} catch (NullPointerException e) {
//			System.out.println("second");
//		} catch (NullPointerException e) {
//			System.out.println("Third");
//		}
		
		
		//Try catch block need to go from most specific to most generic
//		try {
//			throw new IOException();
//		} catch (FileNotFoundException e) {
//			System.out.println("caught the file not found");
//		}catch (IOException e) {
//			System.out.println("caught the io");
//			try {
//				throw new SQLException();
//			} catch (SQLException e2) {
//				System.out.println("caught it");
//			}
//		}catch (RuntimeException e) {
//			System.out.println("caught the runtime exception");
//		}
//		method(true); 		//Throws an error if not handled
		
		//stackOverFlow();
//		 try {
//			throw new IOException();
//		} catch (FileNotFoundException e) {
//			System.out.println("FNF Exception");
//		} catch (IOException e) {
//			System.out.println("IO Exception");
//		}finally {
//			 System.out.println("does this run"); // always runs
//		}
//		 
//		 try {
//			System.out.println("do something");
//		} finally {
//			System.out.println("you finally made it");
//		}
		try {
			throw new CustomException();
		}finally {
			System.out.println("all good");
		}
	}
	
	static void method(boolean b) throws Exception {
		if(b) {
			throw new Exception("thrown intentionally");
		}
		else
			System.out.println("b false");
	}
	static String stackOverFlow() {
		System.out.println(stackOverFlow());
		return "hey you";
	}
}
