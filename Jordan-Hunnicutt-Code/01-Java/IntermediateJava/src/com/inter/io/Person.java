package com.inter.io;

import java.io.Serializable;

public class Person implements Serializable{//have to mark Person as serializable, otherwise we can't print them to a file
											//additionally, serializable is a marker interface, it has 0 methods

	private String name; //pseudo primitive
	private int age;
	transient private int ssn;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
	public Person(String name, int age, int ssn) {
		super();
		this.name = name;
		this.age = age;
		this.ssn = ssn;
	}
	
	@Override
	public String toString() {
		
		String retStr= "Person: [Name="+name+", Age="+age+", ssn="+ssn+"]";
		
		return retStr;
	}
}
