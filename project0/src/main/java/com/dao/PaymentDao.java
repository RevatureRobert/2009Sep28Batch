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
import com.model.Payment;
import com.ui.EmployeeMenu;

public class PaymentDao implements DaoContract <Payment, Integer>
{

	final static Logger logger = Logger.getLogger(PaymentDao.class);
	
	@Override
	public Payment findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> findAll() 
	{
		logger.info("Entering the view all payments method.");
		
		EmployeeMenu em = new EmployeeMenu();
		Scanner scan = new Scanner(System.in);
		
		List<Payment> payments = new LinkedList<>();
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from payments;";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				payments.add(new Payment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			logger.info("The employee was able to view all the payments made from customer.");
			rs.close();
			s.close();
		} catch (SQLException e) {
			logger.error("The employee could NOT view all the payments.");
			e.printStackTrace();
		}
		System.out.println("Here is a list of all the payments made to Dawit's Car Dealership Inc.\n");
		
		System.out.println(payments.toString());
			
			
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
				em.EmployeeMenu(scan);
			}
					
		}
		return payments;
	}

	@Override
	public Payment create(Payment t) 
	{
		logger.info("Entering the make payment method.");
		Scanner scan = new Scanner(System.in);

		int paypay = 0;
		
		int payment;
		String userid;
		String firstName;
		String lastName;
		
		
		System.out.println("To make a payment, we will need some additional information.\n");
		System.out.print("Enter your first name: ");
		firstName = scan.nextLine();
		System.out.println();
		System.out.print("Enter your last name: ");
		lastName = scan.nextLine();
		System.out.println();
		System.out.print("Enter your payment amount: ");
		payment = scan.nextInt();
		scan.nextLine();
		System.out.println();
		System.out.println("Enter your userid: ");
		userid = scan.nextLine();
		
		int oldBalance = 0;
		
		
		t.setPayment(payment);
		t.setUserid(userid);
		t.setFirstName(firstName);
		t.setLastName(lastName);
		
		
		String sql = "insert into payments values (?, ?, ?, ?);";
		String sql2 = "select paymentid from payments where (payment = ? and userid = ? and firstname = ? and lastname = ?)";
		String sql3 = "select balance from customers where userid = ?";
		
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				PreparedStatement ps3 = conn.prepareStatement(sql3);
				) {
			ps.setInt(1, t.getPayment());
			ps.setString(2, t.getFirstName());
			ps.setString(3, t.getLastName());
			ps.setString(4, t.getUserid());
			ps2.setInt(1, t.getPayment());
			ps2.setString(3, t.getFirstName());
			ps2.setString(4, t.getLastName());
			ps2.setString(2, t.getUserid());
			ps3.setInt(1, Integer.parseInt(t.getUserid()));
			
			int rs = ps.executeUpdate();
			ResultSet rs2 = ps2.executeQuery();
			ResultSet rs3 = ps3.executeQuery();
			
			while(rs2.next())
			{
				paypay = rs2.getInt(1);
			}
			
			while(rs3.next())
			{
				oldBalance = rs3.getInt(1);
			}
			
			int newBalance = oldBalance - t.getPayment();
			
			logger.info("The customer was able to make a payment.");
			String sql4 = "update customers set balance = ? where userid = ?";
			
			try (Connection conn2 = PlainTextConnectionUtil.getInstance().getConnection();
					PreparedStatement ps4 = conn.prepareStatement(sql4);)
			{
				ps4.setInt(1, newBalance);
				ps4.setInt(2, Integer.parseInt(t.getUserid()));
				
				int rs4 = ps4.executeUpdate();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			System.out.println(t.toSttringPayments(paypay));
			System.out.println("We appreciate your business.");
			logger.info("The system updated the balance of the customer.");
			return t;
	} catch(SQLException e)
		{
			logger.error("The customer could not make a payment.");
		System.out.println(e);
		}
		
		return t;
	}

	@Override
	public Payment update(Payment t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Payment t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String viewPayments()
	{
		logger.info("Entering the view payments method.");
		Payment payment = null;
		List <Payment> payments = new LinkedList<Payment>();
		EmployeeMenu emm = new EmployeeMenu();
		Scanner scan = new Scanner(System.in);
		
		String sql = "select * from payments";
		
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next())
			{
				payment = new Payment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			logger.info("The employee is able to view the payments.");
				
		} catch (SQLException e) {
			
			logger.error("The employee could not view the payments.");
			System.out.println(e);
		}
		
		System.out.println(payment.viewPayments());
		
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

}
