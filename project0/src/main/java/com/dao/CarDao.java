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
import com.ui.CustomerMenu;
import com.ui.EmployeeMenu;

public class CarDao implements DaoContract <Car, Integer>
{
	final static Logger logger = Logger.getLogger(CarDao.class);
	
	Scanner scan = new Scanner(System.in);
	
	EmployeeMenu em = new EmployeeMenu();
	CustomerMenu cm = new CustomerMenu();
	
	
	@Override
	public Car findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> findAll() 
	{
		return null;
	}
	
	public String viewCarsByCustomer()
	{
		logger.info("Entering the viewsCarsByCustomer method");
		
		List<Car> cars = new LinkedList<>();
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from cars";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				cars.add(new Car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6)));
			}
			logger.info("Query to select all data from cars table successful");
			rs.close();
			s.close();
		} catch (SQLException e) {
			logger.error("SQL query to select all data from cars table failed");
			e.printStackTrace();
		}
		System.out.println("Here is a list of cars available on the lot.\n");
		
		
			System.out.println((cars.toString()));
			
			int doneNumber = 0;
		
		System.out.println("When done viewing press 9: ");
		while(doneNumber != 9)
		{
			doneNumber = scan.nextInt();
			scan.nextLine();
			if(doneNumber != 9)
			{
				System.out.println("Please enter 9 when finished.");
				System.out.print(": ");
			}
			
			if(doneNumber == 9)
			{
				return cm.CustomerMenu(scan);
			}
					
		}
		return "";
	}
	
	public void viewCarsByEmployee()
	{
		
	}

	@Override
	public Car create(Car t) 
	{
		logger.info("Entering car creation method.");
		String brand = "";
		String color = "";
		String year = "";
		double price = 1.0;
		String owner = "Dawit";
		
		System.out.println("To add a car to the lot, we will need to some additional information.\n");
		System.out.print("Enter car brand: ");
		brand = scan.nextLine();
		System.out.println("\n");
		System.out.print("Enter car color: ");
		color = scan.nextLine();
		System.out.println("\n");
		System.out.print("Enter car year: ");
		year = scan.nextLine();
		System.out.println("\n");
		System.out.println("Enter car price: ");
		price = scan.nextDouble();
		scan.nextLine();
		System.out.println("Enter car owner: ");
		owner = scan.nextLine();
		
		t.setBrand(brand);
		t.setColor(color);
		t.setOwner(owner);
		t.setPrice(price);
		t.setYear(year);
		
		String sql = "insert into cars values (?, ?, ?, ?, ?);";
		
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, t.getBrand());
			ps.setString(2, t.getColor());
			ps.setString(3, t.getYear());
			ps.setDouble(4, t.getPrice());
			ps.setString(5, t.getOwner());
			int rs = ps.executeUpdate();
			
			logger.info("The update to add a car was successful");
			System.out.println(t.toString());
			System.out.println("Has successfully been added to the lot.");
			
			return t;
	} catch(SQLException e)
		{
			logger.error("The query to add a car failed");
		System.out.println(e);
		}
		
		return t;
	}

	@Override
	public Car update(Car t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Car t) 
	{
		
		logger.info("Entering the delete a car method.");
		int carID = 0;
		
		System.out.println("To remove a car from the lot, please provide the carid.\n");
		System.out.print("Enter carID: ");
		carID = scan.nextInt();
		scan.nextLine();
		
		t.setCarID(carID);
		
		int rs = 0;
		
		String sql = "delete from cars where carid = ?;";
		
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) 
		{
			ps.setInt(1, t.getCarID());
			
			rs = ps.executeUpdate();
			
			logger.info("The car was successfully deleted");
			System.out.println(t.toString(t) + carID);
			System.out.println("Has successfully been removed from the lot.");
			
			return rs;
	}
		catch(SQLException e)
		{
			logger.error("The car was NOT able to be deleted.");
			System.out.println(e);
		}
		
		return rs;
	}
	
	public String viewCarsOwned(String userID)
	{
		logger.info("Entering the viewsCarsOwned method.");
		
		Car mycars = null;
		String sql = "select * from cars where owner = ?";
		
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, userID);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					mycars = new Car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6));
					System.out.println(mycars.toString());
				}
				logger.info("The customer was able to view their owned cars.");
				
				
				int doneNumber = 0;
				
				System.out.print("\nWhen done viewing press 9: ");
				while(doneNumber != 9)
				{
					doneNumber = scan.nextInt();
					scan.nextLine();
					if(doneNumber != 9)
					{
						System.out.println("Please enter 9 when finished.");
						System.out.print(": ");
					}
					
					if(doneNumber == 9)
					{
						cm.CustomerMenu(scan);
					}
							
				}
				
				
			} catch (SQLException e) {
				
				logger.error("The customer was not able to view their owned cars.");
				System.out.println(e);
			}
			
			return "";
		
	}
	
}
