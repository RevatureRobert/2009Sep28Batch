package com.revature.model;

import java.util.Set;

public class Circus {

	private String name;
	private String ringleader;
	private boolean isEntertaining;
	private Set<Bear> bears;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRingleader() {
		return ringleader;
	}
	public void setRingleader(String ringleader) {
		this.ringleader = ringleader;
	}
	public boolean isEntertaining() {
		return isEntertaining;
	}
	public void setEntertaining(boolean isEntertaining) {
		this.isEntertaining = isEntertaining;
	}
	public Set<Bear> getBears() {
		return bears;
	}
	public void setBears(Set<Bear> bears) {
		this.bears = bears;
	}
	@Override
	public String toString() {
		return "Circus [name=" + name + ", ringleader=" + ringleader + ", isEntertaining=" + isEntertaining + ", bears="
				+ bears + "]";
	}
	public Circus(String name, String ringleader, boolean isEntertaining, Set<Bear> bears) {
		super();
		this.name = name;
		this.ringleader = ringleader;
		this.isEntertaining = isEntertaining;
		this.bears = bears;
	}
	public Circus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
