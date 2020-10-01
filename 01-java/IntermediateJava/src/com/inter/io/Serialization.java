package com.inter.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {
	
	public static void main(String[] args) {
		
		Person p = new Person("paul bunyan", 110, 000000001);
		String filename = "object.txt";
		savePerson(filename, p);
		System.out.println(filename);
		
	}
	
	static void savePerson(String filename, Person p) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			
			oos.writeObject((Object)p);			// Does not have generics, must cast around
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Person getPerson(String filename) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			return (Person)ois.readObject();
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
