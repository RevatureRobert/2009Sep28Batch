package com.inter.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteStream {

	public static void main(String[] args) {
		String filename = "byteFile.txt";
		writeByteStream(filename);
	}

	static void writeByteStream(String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			fos.write(73);
			fos.write(25);
			fos.write(12);

			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void readByteStream(String filename) {
		try (InputStream is = new FileInputStream(filename)) { // try with resources block. this will automatically
																// close any resource within it.
			int i;
			while ((i = is.read()) != -1) {
				System.out.println(i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
