package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Turkey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	private double beardLength;

	private boolean cooked;

	//this is a bidirectional relationship, do this if it makes sense to do so.
	@ManyToOne
	@JoinColumn(name = "ovenId", referencedColumnName = "id")
	private Oven oven;

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

	public double getBeardLength() {
		return beardLength;
	}

	public void setBeardLength(double beardLength) {
		this.beardLength = beardLength;
	}

	public boolean isCooked() {
		return cooked;
	}

	public void setCooked(boolean cooked) {
		this.cooked = cooked;
	}

	public Oven getOven() {
		return oven;
	}

	public void setOven(Oven oven) {
		this.oven = oven;
	}

	public Turkey(int id, String name, double beardLength, boolean cooked, Oven oven) {
		super();
		this.id = id;
		this.name = name;
		this.beardLength = beardLength;
		this.cooked = cooked;
		this.oven = oven;
	}

	public Turkey() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Turkey [id=" + id + ", name=" + name + ", beardLength=" + beardLength + ", cooked=" + cooked + "]";
	}
	
	
}
