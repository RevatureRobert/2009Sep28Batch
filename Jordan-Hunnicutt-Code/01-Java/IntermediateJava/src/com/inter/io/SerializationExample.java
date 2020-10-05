package com.inter.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/*
 * We can serialize an object into a byte stream and write that stream
 * 		into a file. We can then read the bytes from the file and turn
 * 		it back into the original object. * 
 * 
 * In order to serialize an object, it must first be serializable.
 * 
 * To make it so, we implement the marker interface Serializable
 * 
 * A marker interface is an interface without methods
 * 
 */
public class SerializationExample {

	
	public static void main(String[] args) {
		Person p = new Person("Abe Lincoln", 200, 000000002);
		String filename = "object.txt";
		savePerson(filename, p);
		System.out.println(getPerson(filename));
	}
	
	static void savePerson(String filename, Person p) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject((Object)p); //cannot do generics, have to upcast when saving and downcast when getting
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Person getPerson(String filename) {
		try(ObjectInputStream ios = new ObjectInputStream(new FileInputStream(filename))){
			
			return (Person)ios.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
