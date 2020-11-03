package com.example.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * 
 * Entity tells hibernate that this is going to be a persistent entity
 * 
 * Id tells hibernate that this is the primary key
 * 
 * GeneratedValue tells hibernate that this is going to be self incrementing
 * 
 * Column gives hibernate additional information about the column
 * 
 * Table gives hibernate additional information about the table
 *
 */
@Entity
//@Table("oven")  //optional
public class Oven {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "color", nullable = false)
	private String color;
	
	@Column(nullable = false)
	private int degree;
	
	@OneToMany(mappedBy = "oven", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<Turkey> turkeys;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public Set<Turkey> getTurkeys() {
		return turkeys;
	}

	public void setTurkeys(Set<Turkey> turkeys) {
		this.turkeys = turkeys;
	}

	@Override
	public String toString() {
		return "Oven [id=" + id + ", color=" + color + ", degree=" + degree + ", turkeys=" + turkeys + "]";
	}

	public Oven(int id, String color, int degree, Set<Turkey> turkeys) {
		super();
		this.id = id;
		this.color = color;
		this.degree = degree;
		this.turkeys = turkeys;
	}

	public Oven() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
