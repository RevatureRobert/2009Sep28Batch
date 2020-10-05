package com.inter.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Serialization
 * 
 * We can serialize an object into a byte stream and write that stream into a file.
 * 	We can then read the bytes from the file and turn it back into the original object.
 * 
 * In order to serialize an object, it must first be marked as Serializable by implementing the Serializable interface.
 * 
 * The "marker" interface Serializable has no methods; only serves to communicate serializability
 * 
 * **********
 * 
 * animal abstract class + dog class + cat class in new Java project
 * 
 * Person class in Walking project
 * 
 * Create classes, manually compile Dog & Cat into class files,
 * put them into a jar file, go into Walking and add it to the Build Path
 * 
	1. create an abstract animal class, create a makeSound method and override it in the dog and cat sub classes
	2. manually compile those classes into a jar file.
	3. configure the build path on the other project to include the jar file from the first.
	4. create a person class that has a pet that is of type animal
 * 
 */

public class SerializationExample {

	public static void main(String[] args) {
		Person p = new Person("Newt Gingrich", 110, 2);
		String filename = "object.txt";
		
		savePerson(filename, p);
		
		System.out.println(getPerson(filename));
	}

	static void savePerson(String filename, Person p) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			
			
			oos.writeObject((Object)p);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	static Person getPerson(String filename) {
		try(ObjectInputStream ios = new ObjectInputStream(new FileInputStream(filename))){
			
			return (Person)ios.readObject();
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
