package com.bankapp.ui;

import java.util.Scanner;

public class CustomerMenu {
	static void CustomerMenu(Scanner scanner) {
		System.out.println("What would you like to do?\n1. Apply for a new bank account\n2. View account Balance\n3. View transfers\n4. Transfer");
		int action1 = scanner.nextInt();
		if(action1 == 1) {
			System.out.println("What type of account would you like to apply for?\n1. Checking\n2. Savings");
			int accType = scanner.nextInt();
			if(accType == 1) {
				System.out.println("Your checking account application was submitted");
				//send application to employee
				CustomerMenu(scanner);
			}
			if(accType == 2) {
				System.out.println("Your savings account application was submitted");
				//send application to employee 
			}
			CustomerMenu(scanner);
		}
		if(action1 == 2) {
			System.out.println("Which account would you like to view?");
			//show all accounts for customer
			CustomerMenu(scanner);
		}
		if(action1 == 3) {
			System.out.println("Here are your transfers");
			//show all transfer transactions
			CustomerMenu(scanner);
		}
		if(action1 == 4) {
			Transfer(scanner);
			CustomerMenu(scanner);
		}
	}
	static void Transfer(Scanner scanner) {
		System.out.println("Transfer information");
		System.out.println("Transfer to:\n1. Checking\n2. Savings");
		int transfer1 = scanner.nextInt();
		System.out.println("Transfer from:\n1. Checking\n2. Savings");
		int transfer2 = scanner.nextInt();
		if(transfer1 == transfer2) {
			System.out.println("You cannot transfer money from the same type of account, try again.\n");
			Transfer(scanner);
		}else {
			System.out.println("Transfer amount");
			int amount = scanner.nextInt();
			if (amount < 0) {
				System.out.println("You cannot transfer a negative amount of money");
				//do not try to transfer the money
				Transfer(scanner);
			}else {
				//transfer desired amount to the account specified
				System.out.println("Transfer Successful!");					
			}
		}
	}
}
