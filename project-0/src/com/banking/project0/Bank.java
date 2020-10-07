package com.banking.project0;

import java.util.Scanner;


public class Bank {

		
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			
//			System.out.println("the name you entered is: "+name);
			GetInformation(scanner);
//			scanner.close();
			
			// scanners cannot be opened once closed. no matter the circumstance inside the same program.
//	<<<<<<< HEAD
//			scanner = new Scanner(System.in);
//			scanner.next();
//			scanner.close();
//	=======
//			scanner = new Scanner(System.in);
//			scanner.next();
//	>>>>>>> master
//			Scanner scanner2 = new Scanner(System.in);
//			System.out.println("get information");
//			scanner2.next();
		}
		
		static void GetInformation(Scanner scanner) {
			
//			System.out.println("Are you logging in or creating a new account?: \n1. Login \n2. Create new account");
//			int account = scanner.nextInt();
//			if (account == 1) {
				System.out.println("Username:");
				String username = scanner.nextLine();
				System.out.println("Password:");
				String password = scanner.nextLine();
//			}else if(account == 2) {
//				System.out.println("troubleshooting");
//				
//			}
			System.out.println("Are you a: \n1. user,\n2. employee,\n3. customer");
			int role = scanner.nextInt();
			if(role == 1) {
				System.out.println("Would you like to start a new account?: \n1. yes,\n2. no");
				int option = scanner.nextInt();
				if(option == 1) {
					System.out.println("troubleshooting");
				}
			}
		}
		
		//imagine a controller class in another package below
		
		
		static void ShareInformation(String name, String email, int age) {
			System.out.print("Your user has been created: ");
			System.out.println("name: "+name);
			System.out.println("age: "+age);
			System.out.println("email: "+email);
		}
}
