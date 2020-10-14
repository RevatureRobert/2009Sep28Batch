package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.databaseconfiguration.PlainTextConnectionUtil;
import com.model.Car;
import com.model.Customer;
import com.model.Employee;
import com.ui.CustomerMenu;


public class CustomerDao implements DaoContract <Customer, Integer>
{
	final static Logger logger = Logger.getLogger(CustomerDao.class);
	
	Scanner scan = new Scanner(System.in);
	
	CustomerMenu cdd = new CustomerMenu();
	Customer dude = new Customer();
	
	@Override
	public Customer findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer create(Customer t) 
	{
		logger.info("Entering the customer registration method.");
		Customer bro = null;
		
		String firstName = "";
		String lastName = "";
		String password = "";
		String employeeLevel = "";
		
		System.out.println("To Register for a customer account, we will need to some additional information.\n");
		System.out.print("Enter your first name: ");
		firstName = scan.nextLine();
		System.out.println();
		System.out.print("Enter last name: ");
		lastName = scan.nextLine();
		System.out.println();
		System.out.print("Enter password: ");
		password = scan.nextLine();
		System.out.println();
		
		
		
		t.setFirstName(firstName);
		t.setLastName(lastName);
		t.setPassword(password);
		
		
		String sql = "insert into customers values (?, ?, ?);";
		String sql2 = "select userid from customers where (firstname = ? and lastname = ? and password = ?)";
		
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				PreparedStatement ps2 = conn.prepareStatement(sql2)) {
			ps.setString(1, t.getFirstName());
			ps.setString(2, t.getLastName());
			ps.setString(3, t.getPassword());
			ps2.setString(1, t.getFirstName());
			ps2.setString(2, t.getLastName());
			ps2.setString(3, t.getPassword());
			
			int rs = ps.executeUpdate();
			ResultSet rs1 = ps2.executeQuery();
			
			while(rs1.next())
			{
				bro = new Customer(rs1.getInt(1));
				System.out.println("Your customer account has successfully been added to our database.");
				
				System.out.println(bro.toStringUserID(rs1.getInt(1)));
			}
			
			logger.info("The customer account has successfully been registered and added to the database.");
			
			return t;
	} catch(SQLException e)
		{
			logger.error("The customer account has NOT been registered and was unsuccessful.");
			System.out.println(e);
		}
		
		return t;
		
	}

	@Override
	public Customer update(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Customer t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String validateLogin(int userID, String password)
	{
		logger.info("Entering the validation login method.");
		
		Customer cust = null;
		String sql = "select firstname from customers where (userid = ? and password = ?);";
		
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userID);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				cust = new Customer(rs.getString(1));
			}
			
			
			logger.info("The customer was successfully able to validate thier login credentials.");
			return cust.toStringFirstName();
				
		} catch (SQLException e) {
			logger.error("The customer was NOT able to validate their login credentials.");
			System.out.println(e);
		}
		
		return cust.toStringFirstName();
		
	}
	
	public String viewCarsByCustomer()
	{
		logger.info("Entering the view cars on lot method.");
		List<Car> cars = new LinkedList<>();
		String sql = "select * from cars where owner = ?";
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Dawit");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cars.add(new Car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6)));
			}
			rs.close();
			ps.close();
			logger.info("The customer was successfully able to view the cars on the lot.");
		} catch (SQLException e) {
			logger.error("The customer was NOT able to view the cars on the lot.");
			e.printStackTrace();
		}
		System.out.println("Here is a list of cars available on the lot.\n");
		
		
			System.out.println((cars.toString()));
			
			int doneNumber = 0;
		
		System.out.print("\nWhen done viewing press 9: ");
		while(doneNumber != 9)
		{
			int hit = 0;
			try
			{
				/*
				if(hit > 0)
				{	
				scan.nextLine();
				}
				*/
			doneNumber = scan.nextInt();
			scan.nextLine();
			if(doneNumber != 9)
			{
				hit++;
				System.out.println("Please enter 9 when finished.");
				System.out.print(": ");
				doneNumber = scan.nextInt();
				scan.nextLine();
				continue;
			}
			

			
			if(doneNumber == 9)
			{
				return cdd.CustomerMenu(scan);
			}
			}
			catch(Exception e)
			{
				hit++;
				System.out.println("Please enter 9 when finished.");
				System.out.print(": ");
				scan.nextLine();
				continue;
			}
					
		}
		return "";
	}
	
	public String viewDebtBalance(int userID)
	{
		logger.info("Entering the view debt balance method.");
		Customer cust = null;
		String sql = "select balance from customers where userid = ?;";
		
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				cust = new Customer(userID,rs.getInt(1));
			}
			
			System.out.println(cust.toStringDebtBalance());
			
			logger.info("The customer was able to view his debt balance.");
			System.out.print("\nWhen done viewing press 9: ");
			int doneNumber = 0;
			while(doneNumber != 9)
			{
				int hit = 0;
				try
				{
					/*
					if(hit > 0)
					{	
					scan.nextLine();
					}
					*/
				doneNumber = scan.nextInt();
				scan.nextLine();
				if(doneNumber != 9)
				{
					hit++;
					System.out.println("Please enter 9 when finished.");
					System.out.print(": ");
					doneNumber = scan.nextInt();
					scan.nextLine();
					continue;
				}
				

				
				if(doneNumber == 9)
				{
					return cdd.CustomerMenu(scan);
				}
				}
				catch(Exception e)
				{
					hit++;
					System.out.println("Please enter 9 when finished.");
					System.out.print(": ");
					scan.nextLine();
					continue;
				}
			
			}
		}	
		 catch (SQLException e) {
			
			logger.error("The customer was NOT able to view his debt balance.");
			 System.out.println(e);
		}
		
		return cust.toStringFirstName();
	}
	

}
