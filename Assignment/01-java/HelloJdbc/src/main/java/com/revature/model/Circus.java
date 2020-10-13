package com.revature.model;

import java.util.Set;

public class Circus {
	
	private String name;
	private String ringleader;
	private boolean Entertaining;
	private Set<Bear> bears;
	
	
	
	public Circus(String name, String ringleader, boolean entertaining, Set<Bear> bears) {
		super();
		this.name = name;
		this.ringleader = ringleader;
		Entertaining = entertaining;
		this.bears = bears;
	}
	
	public String getName() {
		return name;
	}
	public String getRingleader() {
		return ringleader;
	}
	public boolean isEntertaining() {
		return Entertaining;
	}
	public Set<Bear> getBears() {
		return bears;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRingleader(String ringleader) {
		this.ringleader = ringleader;
	}
	public void setEntertaining(boolean entertaining) {
		Entertaining = entertaining;
	}
	public void setBears(Set<Bear> bears) {
		this.bears = bears;
	}

	@Override
	public String toString() {
		return "Circus [name=" + name + ", ringleader=" + ringleader + ", Entertaining=" + Entertaining + ", bears="
				+ bears + "]";
	}
	
	
	

}
