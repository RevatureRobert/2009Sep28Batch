package com.example.oop.accesscheck;

import com.example.oop.encapsulation.EndCap;

public class FirstHubCap extends EndCap {
	
	public FirstHubCap() {
		super(15.5, "gray", "hubsrus");
	}
	public String getColor() {
		return this.color;
	
	}
}
