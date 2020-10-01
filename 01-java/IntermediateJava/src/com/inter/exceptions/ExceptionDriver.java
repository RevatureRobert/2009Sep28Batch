package com.inter.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class ExceptionDriver {

	public static void main(String[] args) {
		int[] arr = null;//new int[4];
//		System.out.println();
//		
//		try {
//		method(true);
//		
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			throw new IOException();
//		} catch (FileNotFoundException e) {
//			System.out.println("First");
//		}catch (IOException e) {
//			System.out.println("Second");
//		}catch (SQLException e) {
//			System.out.println("Third");
//		}catch ( RuntimeException e) {
//			System.out.println("caught you");
//		}
	}
	static void method(boolean b) throws Exception {
		if(b) {
			throw new Exception("How dare you cause an exception");
			
		}else {
			System.out.println("b was false");
		}
	}
}
