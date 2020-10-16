package com.web.model;

public class MonsterType {
	private boolean furry;
	private boolean paws;
	
	public MonsterType(String type, boolean furry, boolean paws) {
		super();
		this.type = type;
		this.furry = furry;
		this.paws = paws;
	}
	private String type;
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
}
