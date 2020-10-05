package com.inter.collections;

import java.util.Comparator;

public class Student implements Comparator<Student>{//implements Comparable<Student>

	private double gpa;
	private String name;
	private String major;
	
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
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public Student() {
		super();
	}
	
	public Student(double gpa, String name, String major) {
		this.gpa = gpa;
		this.name = name;
		this.major = major;
	}

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
