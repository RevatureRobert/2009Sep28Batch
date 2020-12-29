package com.orm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class CandyTaco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private boolean hardShell;
	
//	@Email
	@Length(max = 3, min = 1)
	private String sauce;
	
//	@Pattern(regexp = "[a-zA-Z]")
	private String filling;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isHardShell() {
		return hardShell;
	}

	public void setHardShell(boolean hardShell) {
		this.hardShell = hardShell;
	}

	public String getSauce() {
		return sauce;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}

	public String getFilling() {
		return filling;
	}

	public void setFilling(String filling) {
		this.filling = filling;
	}

	@Override
	public String toString() {
		return "CandyTaco [id=" + id + ", hardShell=" + hardShell + ", sauce=" + sauce + ", filling=" + filling + "]";
	}

	public CandyTaco(int id, boolean hardShell, String sauce, String filling) {
		super();
		this.id = id;
		this.hardShell = hardShell;
		this.sauce = sauce;
		this.filling = filling;
	}

	public CandyTaco() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
