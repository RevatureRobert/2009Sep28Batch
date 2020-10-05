package com.inter.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStream {

	public static void main(String[] args) {
		String filename = "charFile.txt";
		writeCharStream(filename);
		readCharStream(filename);
	}	
	
	//TIME TO READ AND WRITE TO FILES!!!
	static void writeCharStream(String filename) {
		try(FileWriter fos = new FileWriter(filename/*, false*/)){//file writer has 2 parameters, the filename whether to append or not
			for(int i = 62; i < 74; i++) {
				fos.write(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	static void readCharStream(String filename) {
		try(FileReader is = new FileReader(filename)){		//try with resources block.  This will automatically close any resource within it
			int i;
			while((i = is.read()) != -1) {
				System.out.println((char)i);
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	
}
