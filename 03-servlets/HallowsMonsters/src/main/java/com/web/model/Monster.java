package com.web.model;

public class Monster {
	private int id;
	private String name;
	private MonsterType type;

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

	public MonsterType getType() {
		return type;
	}

	public void setType(MonsterType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Monster [id=" + id + ", name=" + name + ", type=" + type + "]";
	}

	public Monster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Monster(int id, String name, MonsterType type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

}
