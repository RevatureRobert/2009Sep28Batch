package com.inter.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteStream {

	public static void main(String[] args) {
		String filename = "byteFiile.txt";
		//writeByteStream(filename);
		readByteStream(filename);
	}
	static void writeByteStream(String filename) {
		
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			fos.write(73);
			fos.write(25);
			fos.write(12);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	static void readByteStream(String fileName) {
		try(InputStream is = new FileInputStream(fileName)) {
			int i;
			while((i = is.read()) !=-1) {
				System.out.println(i);
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
