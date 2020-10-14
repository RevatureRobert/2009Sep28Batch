package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.databaseconfiguration.PlainTextConnectionUtil;
import com.model.Offer;

public class OfferDao implements DaoContract <Offer, Integer>
{

	final static Logger logger = Logger.getLogger(OfferDao.class);
	
	@Override
	public Offer findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Offer create(Offer t) 
	{
		logger.info("Entering the offer creation method.");
		
		Scanner scan = new Scanner(System.in);
		
		Offer off = null;
		String carid;
		String userid;
		int downpayment;
		
		
		System.out.println("To make an offer on a car, we will need some additional information.\n");
		System.out.print("Enter carid for the car you want to make an offer for: ");
		carid = scan.nextLine();
		System.out.println();
		System.out.print("Enter your userid: ");
		userid = scan.nextLine();
		System.out.println();
		System.out.print("Enter your downpayment: ");
		downpayment = scan.nextInt();
		scan.nextLine();
		System.out.println();
		
		
		t.setCarid(carid);
		t.setUserid(userid);
		t.setDownpayment(downpayment);
		
		
		String sql = "insert into offers (carid, userid, downpayment) values (?, ?, ?);";
		String sql2 = "select offerid from offers where (userid = ? and carid = ? and downpayment = ?)";
		
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				PreparedStatement ps2 = conn.prepareStatement(sql2)){
			ps.setString(1, t.getCarid());
			ps.setString(2, t.getUserid());
			ps.setInt(3, t.getDownpayment());
			ps2.setString(2, t.getCarid());
			ps2.setString(1, t.getUserid());
			ps2.setInt(3, t.getDownpayment());
			
			int rs = ps.executeUpdate();
			ResultSet rs1 = ps2.executeQuery();
			
			while(rs1.next())
			{
				off = new Offer(rs1.getInt(1));
			System.out.println(off.toString(carid, userid, downpayment, rs1.getInt(1)));
			System.out.println("Your offer will be reviewed by Dawit and his associates. Currently the offer status is pending.");			
			}
			logger.info("Offer was successfully created.");
			
			return t;
	} catch(SQLException e)
		{
			logger.error("The offer could NOT be made");
			System.out.println(e);
		}
		
		return t;
	}

	@Override
	public Offer update(Offer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Offer t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
