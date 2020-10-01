package com.inter.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteStream {
	
	public static void main(String[] args) {
		String filename = "bytefile.txt";
		writeByteStream(filename);
		readByteStream(filename);
	}
	
	
	
	static void writeByteStream(String filename) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(filename);
			fos.write(73);
			fos.write(123);
			fos.write(88);
			fos.write(-1);
			fos.write(76);
			
			
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void readByteStream(String filename) {
		try(InputStream is = new FileInputStream(filename)) {	// try with resource block. This will automatically close any resource within it
			int i;
			while((i = is.read()) != -1) {
				System.out.println(i);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
