package com.inter.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteStream {
<<<<<<< HEAD

	public static void main(String[] args) {
	String filename = "bytefile.txt";
	writeByteStream(filename);
	readByteStream(filename);
	
	
	}
	static void writeByteStream(String filename) {
		try {
			FileOutputStream fos =new FileOutputStream(filename);
=======
	
	public static void main(String[] args) {
		String filename = "byteFile.txt";
		writeByteStream(filename);
		readByteStream(filename);
	}

	
	static void writeByteStream(String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
>>>>>>> master
			fos.write(73);
			fos.write(25);
			fos.write(12);
			fos.write(-1);
			fos.write(88);
<<<<<<< HEAD
			
=======
>>>>>>> master
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
<<<<<<< HEAD
	}
	static void readByteStream(String filename) {
		try(InputStream is = new FileInputStream(filename)){
=======
		
	}
	
	static void readByteStream(String filename) {
		try(InputStream is = new FileInputStream(filename)){ //try with resources block. This will automatically close any resource within it.
>>>>>>> master
			int i;
			while((i = is.read()) != -1) {
				System.out.println(i);
			}
<<<<<<< HEAD
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
=======
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
>>>>>>> master
		}
	}
}
