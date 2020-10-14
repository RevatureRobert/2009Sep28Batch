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
import com.model.Employee;
import com.model.Offer;
import com.model.Payment;
import com.ui.EmployeeMenu;

public class EmployeeDao implements DaoContract <Employee, Integer>
{
	final static Logger logger = Logger.getLogger(EmployeeDao.class);
	
	Scanner scan = new Scanner(System.in);
	
	EmployeeMenu emm = new EmployeeMenu();
	
	@Override
	public Employee findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee create(Employee t) 
	{
		
		logger.info("Entering the create an employee method.");
		
		Employee bro = null;
		
		String firstName = "";
		String lastName = "";
		String password = "";
		String employeeLevel = "";
		
		System.out.println("To Register for an account, we will need some additional information.\n");
		System.out.print("Enter your first name: ");
		firstName = scan.nextLine();
		System.out.println();
		System.out.print("Enter last name: ");
		lastName = scan.nextLine();
		System.out.println();
		System.out.print("Enter password: ");
		password = scan.nextLine();
		System.out.println();
		System.out.println("Enter your employee level: ");
		employeeLevel = scan.nextLine();
		
		
		t.setFirstName(firstName);
		t.setLastName(lastName);
		t.setPassword(password);
		t.setEmployeeLevel(employeeLevel);
		
		
		String sql = "insert into employees values (?, ?, ?, ?);";
		String sql2 = "select userid from employees where (firstname = ? and lastname = ? and password = ?)";
		
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				PreparedStatement ps2 = conn.prepareStatement(sql2)) {
			ps.setString(1, t.getFirstName());
			ps.setString(2, t.getLastName());
			ps.setString(3, t.getPassword());
			ps.setString(4, t.getEmployeeLevel());
			ps2.setString(1, t.getFirstName());
			ps2.setString(2, t.getLastName());
			ps2.setString(3, t.getPassword());
			
			int rs = ps.executeUpdate();
			ResultSet rs1 = ps2.executeQuery();
			
			while(rs1.next())
			{
				bro = new Employee(rs1.getInt(1));
				System.out.println("Your account has successfully been added to our database.");
				
				System.out.println(bro.toStringUserID(rs1.getInt(1)));
			}
			
			logger.info("The employee successfully registered their account.");
			
			return t;
	} catch(SQLException e)
		{
			logger.error("The employee was NOT able to register their account.");
			System.out.println(e);
		}
		
		return t;
		
	}

	@Override
	public Employee update(Employee t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Employee t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// Used to validate the login credentials of an employee
	
	public String validateLogin(int userID, String password)
	{
		logger.info("Entering the validate login method.");
		
		Employee emp = null;
		String sql = "select firstname from employees where userid = ? and password = ?;";
		
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userID);
			ps.setString(2, password);
			System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();
			String answer = "";
			while(rs.next())
			{
				emp = new Employee(rs.getString(1));
				logger.info("The employee successfully validated their credentials to access their account.");
				answer = emp.toStringFirstName();
				return emp.toStringFirstName();
			}
			
			
			return answer;
			
		} catch (SQLException e) {
			
			logger.error("The employee was NOT successful in validating their credentials.");
			return "Failure";
		}
		
	}
	
	public String viewCarsByEmployee()
	{
		logger.info("Entering the view cars by employee method.");
		
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Here is a list of cars available on the lot.\n");
		
		logger.info("The employee was successfully able to view the cars on the lot.");
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
				return emm.EmployeeMenu(scan);
			}
			}
			catch(Exception e)
			{
				logger.error("The employee was not able to view the cars on the lot.");
				hit++;
				System.out.println("Please enter 9 when finished.");
				System.out.print(": ");
				scan.nextLine();
				continue;
			}
					
		}
		return "";
	}
	
	
	public String viewPayments()
	{
		logger.info("Entering the view payments method.");
		Payment payment = null;
		List <Payment> payments = new LinkedList<>();
		EmployeeMenu emm = new EmployeeMenu();
		Scanner scan = new Scanner(System.in);
		
		
		
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection())
			{
			Statement s = conn.createStatement();
			String sql = "select * from payments";
			ResultSet rs = s.executeQuery(sql);
			
			System.out.println("Here are the list of payments.");
			while(rs.next())
			{
				 payments.add(new Payment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));				
			}
			rs.close();
			s.close();
			logger.info("The employee was successfully able to view the payments.");
			
		} catch (SQLException e) {
			
			logger.error("The employee was NOT able to view the payments.");
			System.out.println(e);
		}
		
		System.out.println(payments.toString());
		
		
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
				return emm.EmployeeMenu(scan);
			}
					
		}
		
		
		return emm.EmployeeMenu(scan);
	}
	
	public String viewOffersFromCustomers()
	{
		logger.info("Entering the view offers method.");
		
		List<Offer> offers = new LinkedList<>();
	try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
		Statement s = conn.createStatement();
		String sql = "select * from offers where offerstatus = 'pending'";
		ResultSet rs = s.executeQuery(sql);
		while (rs.next()) {
			offers.add(new Offer(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
		}
		rs.close();
		s.close();
		
		logger.info("The employee was successfully able to view offers for cars.");
	} catch (SQLException e) {
		logger.error("The employee was NOT able to view offers for cars.");
		e.printStackTrace();
	}
	System.out.println("Here are the list of offers available.\n");
	
	
		System.out.println((offers.toString()));
		
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
			return emm.EmployeeMenu(scan);
		}
				
	}
	return "";
	}
	
	
	public void rejectOfferForCar(Offer o)
	{
		logger.info("Entering the reject offer for car method.");
		int offerID = 0;
		System.out.print("What is the offerid you would like to reject? ");
		offerID = scan.nextInt();
		scan.nextLine();
		
		o.setOfferid(offerID);
		
		
		String sql = "update offers set offerstatus = 'rejected' where offerid = ?";
		
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) 
		{
			ps.setInt(1, o.getOfferid());
			
			int rs = ps.executeUpdate();
			
			
			System.out.println("The offer has been updated as rejected in the database.");
			
			logger.info("The employee was successfully able to reject an offer.");
			
	}
		catch(SQLException e)
		{
			logger.error("The employee was NOT able to reject an offer on a car.");
			System.out.println(e);
		}
		
		
	}
	
	public void acceptOfferForCar(Offer o)
	{
		logger.info("Entering the accept offer method.");
		int newBalance;
		
		int offerID = 0;
		String carid = "";
		String userID = "";
		System.out.print("What is the offerid you would like to accept? ");
		offerID = scan.nextInt();
		scan.nextLine();
		System.out.println("What is the carid associated with the offer? ");
		carid = scan.nextLine();
		System.out.println("What is the customer userid associated with the offer? ");
		userID = scan.nextLine();
		
		o.setOfferid(offerID);
		o.setCarid(carid);
		o.setUserid(userID);
	
		int downPayment = 0;
		double price = 0;
		int balance = 0;
		
		String sql = "update offers set offerstatus = 'accepted' where offerid = ?";
		String sql2 = "update offers set offerstatus = 'rejected' where carid = ? and offerstatus = 'pending'";
		String sql3 = "update cars set owner = ? where carid = ?";
		String sql4 = "select downpayment from offers where (carid = ? and offerid = ?)";
		String sql5 = "select price from cars where carid = ?";
		String sql6 = "select balance from customers where userid = ?";
		String sql7 = "update customers set balance = ? where userid = ?";
		
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				PreparedStatement ps3 = conn.prepareStatement(sql3);
				PreparedStatement ps4 = conn.prepareStatement(sql4);
				PreparedStatement ps5 = conn.prepareStatement(sql5);
				PreparedStatement ps6 = conn.prepareStatement(sql6);
				PreparedStatement ps7 = conn.prepareStatement(sql7);
				) 
		{
			ps.setInt(1, o.getOfferid());
			ps2.setString(1, o.getCarid());
			ps3.setString(1,o.getUserid());
			ps3.setInt(2, Integer.parseInt(o.getCarid()));
			ps4.setString(1, o.getCarid());
			ps4.setInt(2, o.getOfferid());
			ps5.setInt(1, Integer.parseInt(o.getCarid()));
			ps6.setInt(1, Integer.parseInt(o.getUserid()));
			
			int rs = ps.executeUpdate();
			int rs2 = ps2.executeUpdate();
			int rs3 = ps3.executeUpdate();
			ResultSet rs4 = ps4.executeQuery();
			ResultSet rs5 = ps5.executeQuery();
			ResultSet rs6 = ps6.executeQuery();
			
			while(rs4.next())
			{
				downPayment = rs4.getInt(1);
			}
			
			while(rs5.next())
			{
				price = rs5.getDouble(1);
			}
			
			while(rs6.next())
			{
				balance = rs6.getInt(1);
			}
			
			newBalance = (int) ((price - downPayment) + balance);
			
			ps7.setInt(1, newBalance);
			ps7.setInt(2, Integer.parseInt(o.getUserid()));
			
			int rs7 = ps7.executeUpdate();
			
			System.out.println("The offer has been accepted in the database.");
			
			logger.info("The offer was successfully accepted and the system has changed the ownership status, debt balance, and car lot.");
					
	}
		catch(SQLException e)
		{
			logger.error("The employee has been able to accept the offer.");
			System.out.println(e);
		}
	}
		
	}

	// Used to add a new car to the database 
	
	
	

