package com.revature.ui;

import java.util.Scanner;

import com.revature.controller.BearController;

public class BearMenu {
	
	private BearController bc;
	
	public BearMenu() {
		this(new BearController());
	}
	
	private BearMenu(BearController bc) {
		super();
		this.bc = bc;
	}
	public String BearMenu(Scanner scan) {
		System.out.println("Please make a selection");
		System.out.println("1) Get all bears");
		System.out.println("0) Return");
		int selection = scan.nextInt();
		switch(selection) {
		case 1:
			return bc.findAll().toString();
		case 0:
			return null;
		default:
			return BearMenu(scan);
		}
	}
}
