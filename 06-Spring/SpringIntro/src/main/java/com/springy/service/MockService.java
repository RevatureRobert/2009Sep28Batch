package com.springy.service;

import java.util.Map;

import com.springy.repo.MockDao;

public class MockService {

	private MockDao md;

	public MockService() {
		super();
		System.out.println("in the no arg");
	}

	public MockService(MockDao md) {
		super();
		this.md = md;
		System.out.println("in the constructor");
	}

	public MockDao getMd() {
		return md;
	}

	public void setMd(MockDao md) {
		this.md = md;
		System.out.println("in the setter");
	}

	public Map<String, Integer> getAllVotes(){
		return md.getAllVotes();
	}
	
}
