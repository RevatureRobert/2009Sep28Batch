package com.inter.io;

import java.io.Serializable;

public class Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	transient private int ssn;
	
	
	
	@Override
	public String toString() {
		return "name: "+ name + " age: " + age + " ssn: " + ssn;
	}
	public Person(String string, int i, int j) {
		this.name = string;
		this.age = i;
		this.ssn = j;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getSsn() {
		return ssn;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	} 

}
