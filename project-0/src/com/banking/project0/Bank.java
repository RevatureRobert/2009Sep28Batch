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
			
			System.out.println("Are you logging in or creating a new account? \n1. Login \n2. Create new account");
			int account = scanner.nextInt();
			if (account == 1) {
				Login(scanner);
			}if(account == 2) {
				NewAccount(scanner);
				
			}
//			System.out.println("Are you a: \n1. user,\n2. employee,\n3. customer");
//			int role = scanner.nextInt();
//			if(role == 1) {
//				System.out.println("Would you like to start a new account?: \n1. yes,\n2. no");
//				int option = scanner.nextInt();
//				if(option == 1) {
//					System.out.println("troubleshooting");
//				}
//				if (option == 2) {
//					System.out.println("Are you an existing user? \n1. yes \n2. no");
//					int existingUser = scanner.nextInt();
//					if(existingUser == 1) {
//						System.out.println("Redirecting");
//					}
//					if(existingUser == 2) {
//						System.out.println("then what are you doing here?");
//					}
//				}
//			}
		}
		
		//imagine a controller class in another package below
		
		
//		static void ShareInformation(String name, String email, int age) {
//			System.out.print("Your user has been created: ");
//			System.out.println("name: "+name);
//			System.out.println("age: "+age);
//			System.out.println("email: "+email);
//		}
		static void Login(Scanner scanner) {
			System.out.println("Username:");
			String username = scanner.next();
			System.out.println("Password:");
			String password = scanner.next();
			//check to see if the username matches the password
			//pull user from database and show appropriate menu
			UserAssign(scanner);
		}
		static void NewAccount(Scanner scanner){		//new account email, username, and password are stored into the database 
			System.out.println("Email:");
			String email = scanner.next();
			System.out.println("Username:");
			String username = scanner.next();
			Password(scanner);
			//store user in database
			}
		
		static void Password(Scanner scanner){		//scanner to assign the password to the account
			System.out.println("Passowrd:");
			String password = scanner.next();
			System.out.println("Confirm Password:");
			String confirmPassword = scanner.next();
			if(password.equals(confirmPassword)) {
				
				UserAssign(scanner);
			}else if(password == null || confirmPassword == null) {
				System.out.println("You must enter a valid password");
				RetryPassword(scanner);
			}
			else{
				System.out.println("Passwords are not the same");
				RetryPassword(scanner);
			}
		}
		static void RetryPassword(Scanner scanner) {
			Password(scanner);	//makes you retype the password so that it matches the original password you typed in, or you can assign a new one if you want
		}
		static void UserAssign(Scanner scanner) {
			System.out.println("Are you a: \n1. user\n2. employee\n3. customer");
			int role = scanner.nextInt();
			if(role == 1) {
				System.out.println("Role set to User");
				UserInterface(scanner);
				}
			if (role == 2) {
				System.out.println("Role set to Employee\n");
				EmployeeInterface(scanner);
			}
			if (role == 3) {
				System.out.println("Role set to Customer");
				CustomerInterface(scanner);
			}
		}
		static void UserInterface(Scanner scanner) {
			System.out.println("Would you like to create a customer account?\n1. yes\n2. no");
			int accountType = scanner.nextInt();
			if(accountType == 1) {
				//assign account to type customer
				System.out.println("Congratulations, you have created a customer account!");
				CustomerInterface(scanner);
			}
			if(accountType == 2) {
				System.out.println("Would you like to create an employee account?\n1. yes\n2. no");
				int empAcc = scanner.nextInt();
				if(empAcc == 1) {
					//assign account to type employee
					System.out.println("Congratulations, you have created an employee account!");
					EmployeeInterface(scanner);					
				}
				else {
					System.out.println("Please make a valid selection");
					UserInterface(scanner);
					
				}
			}
			else {
				System.out.println("Please make a valid selection");
				UserInterface(scanner);
			}
		}
		static void EmployeeInterface(Scanner scanner) {
			System.out.println("What would you like to do?\n1. Check account requests\n2. View customer accounts\n3. View transaction logs");
			int action = scanner.nextInt();
			if(action == 1) {
				System.out.println("Here are the new account requests:");
				//account requests inserted here
				System.out.println("Which account request do you want to view?");
				// choose account request to view
				System.out.println("Are you approving or denying this account?\n1. Approve\n2. Deny");
				int action1 = scanner.nextInt();
				if (action1 == 1) {
					System.out.println("Account Approved");
					//add account to account database
				} else if(action1 == 2) {
					System.out.println("Account Denied");
					//remove account from requests
				}
				System.out.println("Enter 0 to exit");
				int exit = scanner.nextInt();
				if(exit == 0) {
					EmployeeInterface(scanner);
				}
			}
			else if(action == 2) {
				System.out.println("Here are all customer accounts");
				//show customer accounts
				System.out.println("Enter 0 to exit");
				int exit = scanner.nextInt();
				if(exit == 0) {
					EmployeeInterface(scanner);
				}
			}
			else if(action == 3) {
				System.out.println("Here are the transaction logs");
				//insert transaction logs
				System.out.println("Enter 0 to exit");
				int exit = scanner.nextInt();
				if(exit == 0) {
					EmployeeInterface(scanner);
				}
			}
		}
		static void CustomerInterface(Scanner scanner) {
			System.out.println("What would you like to do?\n1. Apply for a new bank account\n2. View account Balance\n3. View transfers\n4. Transfer");
			int action1 = scanner.nextInt();
			if(action1 == 1) {
				System.out.println("What type of account would you like to apply for?\n1. Checking\n2. Savings");
				int accType = scanner.nextInt();
				if(accType == 1) {
					System.out.println("Your checking account application was submitted");
					//send application to employee
				}
				if(accType == 2) {
					System.out.println("Your savings account application was submitted");
					//send application to employee 
				}
				CustomerInterface(scanner);
			}
			if(action1 == 2) {
				System.out.println("Which account would you like to view?");
				//show all accounts for customer
				CustomerInterface(scanner);
			}
			if(action1 == 3) {
				System.out.println("Here are your transfers");
				//show all transfer transactions
				CustomerInterface(scanner);
			}
			if(action1 == 4) {
				Transfer(scanner);
				CustomerInterface(scanner);
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
				TransferRetry(scanner);
			}else {
				System.out.println("Transfer amount");
				int amount = scanner.nextInt();
				if (amount < 0) {
					System.out.println("You cannot transfer a negative amount of money");
					//do not try to transfer the money
					TransferRetry(scanner);
				}else {
					//transfer desired amount to the account specified
					System.out.println("Transfer Successful!");					
				}
			}
		}
		static void TransferRetry(Scanner scanner) {
			Transfer(scanner);
		}
}
