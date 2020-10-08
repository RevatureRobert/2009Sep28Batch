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
		String filename = "charFile.txt";
		writeCharStream(filename);
		readCharStream(filename);
	}

	static void writeCharStream(String filename) {
		try(FileWriter fos = new FileWriter(filename)) {
			for (int i = 62; i < 74; i++) {
				fos.write(i);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void readCharStream(String filename) {
		try (FileReader is = new FileReader(filename)) { // try with resources block. this will automatically
														 // close any resource within it.
			int i;
			while ((i = is.read()) != -1) {
				System.out.println((char)i);
			}
		}  catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


}
