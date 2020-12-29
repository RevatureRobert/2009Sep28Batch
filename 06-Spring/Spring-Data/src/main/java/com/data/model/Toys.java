package com.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Toys {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private boolean soft;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSoft() {
		return soft;
	}

	public void setSoft(boolean soft) {
		this.soft = soft;
	}

	public Toys(int id, String name, boolean soft) {
		super();
		this.id = id;
		this.name = name;
		this.soft = soft;
	}

	public Toys() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Toys [id=" + id + ", name=" + name + ", soft=" + soft + "]";
	}
	
	
}
