package com.revature.model;

import java.util.Set;

public class Circus {
	private String name;
	private String ringLeader;
	private boolean entertaining;
	private Set<Bear> bears;
	
	public Circus(String name, String ringLeader, boolean entertaining, Set<Bear> bears) {
		super();
		this.name = name;
		this.ringLeader = ringLeader;
		this.entertaining = entertaining;
		this.bears = bears;
	}
	
	@Override
	public String toString() {
		return "Circus [name=" + name + ", ringLeader=" + ringLeader + ", entertaining=" + entertaining + ", bears="
				+ bears + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRingLeader() {
		return ringLeader;
	}
	public void setRingLeader(String ringLeader) {
		this.ringLeader = ringLeader;
	}
	public boolean isEntertaining() {
		return entertaining;
	}
	public void setEntertaining(boolean entertaining) {
		this.entertaining = entertaining;
	}
	public Set<Bear> getBears() {
		return bears;
	}

	public void setBears(Set<Bear> bears) {
		this.bears = bears;
	}
	
}
