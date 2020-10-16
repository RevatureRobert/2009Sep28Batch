package com.revature.ui;

import java.util.Scanner;

import com.revature.controller.BearController;

public class BearMenu {
	
	private BearController bc;
	
	public BearMenu() {
		this(new BearController());
	}
	
	public BearMenu(BearController bc) {
		super();
		this.bc = bc;
	}
	
	public String bearMenu(Scanner scan) {
		System.out.println("Please make a selection");
		System.out.println("1. get all bears");
		System.out.println("0. return");
		
		int selection = scan.nextInt();
		switch(selection) {
		case 1:
			return bc.findAll().toString();
		case 0:
			return null;
		default:
			return bearMenu(scan);
		}
	}
}
