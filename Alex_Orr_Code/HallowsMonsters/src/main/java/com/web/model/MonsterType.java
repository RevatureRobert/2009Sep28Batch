package com.web.model;

public class MonsterType {
	private int id;
	private String type;
	private boolean fur;
	private boolean paws;
	public MonsterType(int id, String type, boolean fur, boolean paws) {
		super();
		this.id = id;
		this.type = type;
		this.fur = fur;
		this.paws = paws;
	}
	public MonsterType(String type, boolean fur, boolean paws) {
		super();
		this.type = type;
		this.fur = fur;
		this.paws = paws;
	}
	public MonsterType() {
		super();	
	}
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
	public boolean isFur() {
		return fur;
	}
	public void setFur(boolean fur) {
		this.fur = fur;
	}
	public boolean isPaws() {
		return paws;
	}
	public void setPaws(boolean paws) {
		this.paws = paws;
	}
	@Override
	public String toString() {
		return "MonsterType [id=" + id + ", type=" + type + ", fur=" + fur + ", paws=" + paws + "]";
	}
}
