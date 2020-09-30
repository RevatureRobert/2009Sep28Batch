package com.inter.collections;

public class Student  {
	
	private double gpa;
	private String name;
	private String majorString;
	
	
	public Student(double gpa, String name, String majorString) {
		super();
		this.gpa = gpa;
		this.name = name;
		this.majorString = majorString;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajorString() {
		return majorString;
	}
	public void setMajorString(String majorString) {
		this.majorString = majorString;
	}
	public String toString() {
		// TODO Auto-generated method stub
		return "Student[gpa = ";
	}
	
}
