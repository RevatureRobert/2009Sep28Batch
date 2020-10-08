package com.inter.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedCharacterStream {
	public static void main(String[] args) {
		String filename = "stringFile.txt";
		writeBuffCharStream(filename);
		readBuffCharStream(filename);
	}
	static void writeBuffCharStream(String filename) {
		try(BufferedWriter bf = new BufferedWriter(new FileWriter(filename))){
			bf.write("hello file\n");
			bf.write("tucker\n");
			bf.write("dawit\n");
			bf.write("Kyle");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static void readBuffCharStream(String filename) {
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			String line = "";
			while((line = br.readLine()) !=null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
