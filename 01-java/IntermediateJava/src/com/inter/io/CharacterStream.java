package com.inter.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class CharacterStream {
	
	public static void main(String[] args) {
		String filename = "charFile.txt";
		writeCharStream(filename);
		readCharStream(filename);
	}
	
	static void writeCharStream(String filename) {
		try(FileWriter fos = new FileWriter(filename)) {
			for(int i = 62; i < 74; i++) {
				fos.write(i);
			}
			
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void readCharStream(String filename) {
		try(FileReader is = new FileReader(filename)){ // try w/ resources block; automatically closes any resources in it
			int i;
			while((i = is.read()) != -1) { // When read hits the end of the file, it returns -1
				System.out.println((char)i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
