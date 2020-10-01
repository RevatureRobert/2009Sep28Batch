package com.inter.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedCharacterStream {

	public static void main(String[] args) {
		String filename = "stringFile.txt";
		writeBuffCharStream(filename);
		readBuffCharStream(filename);
		
		
	}
	static void writeBuffCharStream(String filename)  {
		try(BufferedWriter bf = new BufferedWriter(new FileWriter(filename))){
			bf.write("hello file\n");
			bf.write("tucker\n");
			bf.write("dawit\n");
			bf.write("kyle\n");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	static void readBuffCharStream(String filename) {
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			String line = "";
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
