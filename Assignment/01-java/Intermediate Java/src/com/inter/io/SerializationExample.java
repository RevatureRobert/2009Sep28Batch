package com.inter.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * 
 * Serializiation: 
 * 
 * 		We can serialize an object into a byte stream and write that stream into a file
 * 			we can then read the bytes from the file and turn it back into the original object
 * 
 * 
 * In order to serialize an object, it must first be marked as serializable. 
 * 
 * To do so, we implement the marker interface Serializable
 * 
 * Marker interface is an interface with no methods
 * 
 * 
 * 
 */

public class SerializationExample {
	
	public static void main(String[] args) {
		Person p = new Person("Paul Bunyan", 110,1000000);
		String filename = "object.txt";
		//savePerson(filename, p);
		System.out.println(getPerson(filename));
	}
	
	
	
	static void savePerson(String filename, Person p) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			
			oos.writeObject((Object)p);
			
		}  catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	static Person getPerson(String filename) {
		try(ObjectInputStream ios = new ObjectInputStream(new FileInputStream(filename))){
			
			return (Person)ios.readObject();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
