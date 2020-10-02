package com.inter.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {
	

	public static void main(String[] args) {
		
		String filename = "byteFile.txt";
	//			writeByteStream(filename);
				readByteStream(filename);
		
	}
	
	
	static void writeByteStream(String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename); // goes to file. 
			fos.write(73);
			fos.write(33);
			fos.write(12);
			
			
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	static void readByteStream(String filename) {
		try(FileInputStream fis = new FileInputStream(filename)) { // try with resources block, this will automatically close any resource within it. 
			int i;
			while((i = fis.read()) != -1){
				System.out.println(i);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
