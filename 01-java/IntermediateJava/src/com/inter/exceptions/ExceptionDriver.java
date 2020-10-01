package com.inter.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class ExceptionDriver {
	
	public static void main(String[] args) {
		int[] arr = new int[3];
		try {
			System.out.println(arr[10]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				// array index out of bounds
		
//		try {
//			method(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		method(true);			// Throws an error if not handled
		
//		try {
//			throw new NullPointerException();
//		} catch(Exception e) {
//			System.out.println("first");
//		} catch(FileNotFoundException e) {
//			System.out.println("two");
//		} catch(NullPointerException e) {
//			System.out.println("three");
//		}
		
//		try {
//			throw new IOException();
//		} catch(FileNotFoundException e) {
//			System.out.println("Caught the file not found");
//		} catch(IOException e) {
//			System.out.println("caught the IO");
//			try {
//				throw new SQLException();
//			} catch(SQLException f) {
//				System.out.println("sql exception");
//			}
//		} catch(RuntimeException e) {
//			System.out.println("caught the runtime exception");
//		}
		
//		stackOverflow();		// results in stack overflow error
		
//		try {
//			throw new IOException();
//		} catch(FileNotFoundException e) {
//			System.out.println("file not found");
//		} catch(IOException e) {
//			System.out.println("IO Exception");
//			throw new RuntimeException("does this line run?");
//		} finally {
//			System.out.println("this line will always run");
//		}
		
		method3();
		
//		try {
//			System.out.println("doing something");
//		} finally {
//			System.out.println("all good");
//		}
		
		try {
			throw new CustomException();
		} catch (CustomException e) {
			e.printStackTrace();
		} finally {
			System.out.println("all good");
		}
		
	}
	
	static void method(boolean b) throws Exception {
		if(b) {
			throw new Exception("This was thrown intentionally");
		} else {
			System.out.println("b was false");
			System.out.println();
		}
	}
	
	static String stackOverflow() {
		System.out.println(stackOverflow());
		return "hey you";
	}
	
	static String method3() {
		try {
			throw new Exception();
		} catch(Exception e) {
			return "happy days";
		} finally {
			System.out.println("finally");
		}
	}

}
