package com.inter.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationExample {
	
	public static void main(String[] args) {
		Person p = new Person("paul bunyan", 110,0000000001);
		String filename = "object.txt";
		savePerson(filename,p);
		System.out.println(getPerson(filename));
	}
	
	static void savePerson(String filename, Person p) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject((Object)p);
		}catch(IOException e) { 
			e.printStackTrace();
		}
	}
	
	static Person getPerson(String fileName) {
		try(ObjectInputStream ios = new ObjectInputStream(new FileInputStream(fileName))){
			return (Person)ios.readObject();
			
		}catch(ClassNotFoundException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
