package com.web.model;

public class MonsterType {
<<<<<<< HEAD
	private int id;
||||||| 9817e6de
=======
	private int id;

>>>>>>> 9ca05587b685d91cfb74715f39a948bd3cfb10b7
	private String type;
	private boolean furry;
	private boolean paws;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isFurry() {
		return furry;
	}

	public void setFurry(boolean furry) {
		this.furry = furry;
	}

	public boolean isPaws() {
		return paws;
	}

	public void setPaws(boolean paws) {
		this.paws = paws;
	}

	@Override
	public String toString() {
		return "MonsterType [id=" + id + ", type=" + type + ", furry=" + furry + ", paws=" + paws + "]";
	}

	public MonsterType(String type, boolean furry, boolean paws) {
		super();
		this.type = type;
		this.furry = furry;
		this.paws = paws;
	}

	public MonsterType(int id, String type, boolean furry, boolean paws) {
		super();
		this.id = id;
		this.type = type;
		this.furry = furry;
		this.paws = paws;
	}

	public MonsterType() {
		super();
		// TODO Auto-generated constructor stub
	}

}
