package com.cardealer.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;


import com.cardealer.config.RDBConnection;
import com.cardealer.model.Offer;


public class OfferDao implements DaoContract<Offer, Integer> {
	Logger logger;

	public OfferDao(Logger logger) {
		super();
		this.logger = logger;
	}
	/**
	 * this method will be using a Statement. It is referred to as a simple
	 * statement. In general, we want to stay away from simple statements and use
	 * prepared statements.
	 * 
	 * The simple statement does not have a way of sanitizing input, also it is less
	 * performant than the prepared statement.
	 */
	@Override
	public List<Offer> findAll() {
		List<Offer> a = new LinkedList<>();
		try (Connection conn = RDBConnection.CreateRDBConnection(logger)) {
			Statement s = conn.createStatement();
			String sql = "select * from cardealer.offer";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				a.add(new Offer(rs));
			}
			rs.close();
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	public List<Offer> findAll(String userID) {
		List<Offer> a = new LinkedList<>();
		String sql = "select * from cardealer.\"offer\" where userid = ?";
		try (Connection conn = RDBConnection.CreateRDBConnection(logger); 
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, userID);
			
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a.add(new Offer(rs));
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	/**
	 * this is will use a prepared statement.
	 * 
	 * A prepared statement will sanitize the input and precompile the statement
	 * before sending it to be executed by the db.
	 */
	@Override
	public Offer findById(Integer i) {
		Offer a = null;
//			String sql = "select * from bear where tag_id = "+i;	this will cause sqlinjection
		String sql = "select * from cardealer.offer where offerid = ?"; // this will sanitize the input
		try (Connection conn = RDBConnection.CreateRDBConnection(logger);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Offer(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	

	@Override
	public Offer update(Offer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Offer create(Offer a) {
		String sql = "insert into cardealer.Offer (userid, carid, caroffertotal, caroffermonths) values (?, ?, ?, ?)";
		try(Connection conn = RDBConnection.CreateRDBConnection(logger); PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, a.getUserID());
			ps.setInt(2, a.getCarID());
			ps.setInt(3, a.getOfferTotal());
			ps.setInt(4, a.getOfferMonths());
			ps.execute();
			logger.info("Offer created for: " + a.getUserID());
			System.out.println("Created " + a.toString());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public int delete(Integer i) {
		String sql = "delete from cardealer.offer where offerid= ? "; // this will sanitize the input
		try (Connection conn = RDBConnection.CreateRDBConnection(logger);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, i);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void deleteByCarID(Integer i) {
		String sql = "delete from cardealer.offer where carid= ? "; // this will sanitize the input
		try (Connection conn = RDBConnection.CreateRDBConnection(logger);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, i);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}
}
