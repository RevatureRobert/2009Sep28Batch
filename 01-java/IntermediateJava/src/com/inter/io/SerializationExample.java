package com.inter.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/*
 * 
 * In order to serialize an object, it must first be serializable.
 * 
 * We need to "mark" it as serializable
 * 
 * To do so, we implement the marker interface Serializable.
 * 
 * A marker interface is an interface with no methods.
 */
public class SerializationExample {

	
	public static void main(String[] args) {
		Person p = new Person("paul bunyan", 110, 000000001);
		String filename = "object.txt";
		savePerson(filename, p);
		System.out.println(getPerson(filename));
		
	}
	
	
	static void savePerson(String filename, Person p) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			
			oos.writeObject((Object)p);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Person getPerson(String filename) {
		try(ObjectInputStream ios = new ObjectInputStream(new FileInputStream(filename))){
			
			return (Person)ios.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
