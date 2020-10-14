package com.revature;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.revature.model.Customer;
import com.revature.model.Employee;
import com.revature.ui.CustomerMenu;
import com.revature.ui.EmployeeMenu;
import com.revature.ui.LoginMenu;

public class Driver {
	
	private static final String LOG_FILE = "log4j.properties";
	public static CustomerMenu cm = new CustomerMenu();
	public static EmployeeMenu em = new EmployeeMenu();
	public static LoginMenu lm = new LoginMenu();
	private static Customer customer = null;
	private static Employee employee = null;
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		mainMenu(scanner);
	}
	private static void mainMenu(Scanner scan) {
		Logger logger = Logger.getLogger(Driver.class);
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(LOG_FILE));
			PropertyConfigurator.configure(properties);
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Welcome to the Bank CLI");
		System.out.println("Please select the relevant menu");
		System.out.println("1. Sign up for a customer account");
		System.out.println("2. Log in as a customer");
		System.out.println("3. Log in as an employee");
		System.out.println("4. Customer Menu");
		System.out.println("5. Employee Menu");
		System.out.println("6. Log out of account(s)");
		System.out.println("0. Exit");
		int selection = scan.nextInt();
		switch(selection) {
			case 1:
				logger.info("User selected to sign up for a customer account");
				Customer tempCustomer = lm.signUp(scan);
				if(tempCustomer != null)
					System.out.println("Sign up successful!");
				else
					System.out.println("Sign up failed!");
				mainMenu(scan);
			case 2:
				logger.info("User selected log in as a customer");
				customer = lm.customerLogin(scan);
				if(getCustomer() != null) {
					System.out.println("Customer log in successful!");
					System.out.println(customer.toString());
				}
				else
				{
					System.out.println("Customer log in failed!");
					System.out.println(customer.toString());
				}
				mainMenu(scan);
			case 3:
				logger.info("User selected log in as an employee");
				employee = lm.employeeLogin(scan);
				if(employee != null) {
					System.out.println("Employee log in successful!");
					System.out.println(employee.toString());
				}
				else {
					System.out.println("Employee log in failed!");
					System.out.println(employee.toString());
				}
				mainMenu(scan);
			case 4:
				logger.info("User selected customer menu");
				if(customer != null) {
					cm = new CustomerMenu(customer);
					System.out.println(cm.customerMenu(scan));
					mainMenu(scan);
				}
				else
					System.out.println("Please log in to a customer account first.");
					mainMenu(scan);
			case 5:
				logger.info("User selected employee menu");
				if(employee != null) {
					System.out.println(em.employeeMenu(scan));
					mainMenu(scan);
				}
				else
					System.out.println("Please log in to an empployee account first.");
					mainMenu(scan);
			case 6:
				logger.info("User opted to log out");
			employee = null;
				System.out.println("Log out successful.");
				mainMenu(scan);
			case 0:
				logger.info("User exited from program");
				System.exit(0);
			default:
				logger.info("User entered an invalid option");
				System.out.println("Please choose a valid option\n");
				mainMenu(scan);
				break;
		}
	}
	public static Customer getCustomer() {
		return customer;
	}
	public static void setCustomer(Customer customer) {
		Driver.customer = customer;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		Driver.employee = employee;
	}

	
}

