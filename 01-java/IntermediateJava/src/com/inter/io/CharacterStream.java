package com.inter.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class CharacterStream {
	public static void main(String[] args) {
		String filename = "byteFiile.txt";
		writeCharStream(filename);
		readCharStream(filename);
	}
	static void writeCharStream(String filename) {
		
		try(FileWriter fos = new FileWriter(filename)) {
			
			for(int i = 62; i < 104; i++) {
				fos.write(i);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	static void readCharStream(String fileName) {
		try(FileReader is = new FileReader(fileName)) {
			int i;
			while((i = is.read()) !=-1) {
				System.out.println((char)i);
			}
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
