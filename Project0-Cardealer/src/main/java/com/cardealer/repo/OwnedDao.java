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
import com.cardealer.model.Owned;


public class OwnedDao implements DaoContract<Owned, String> {
	Logger logger;

	public OwnedDao(Logger logger) {
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
	public List<Owned> findAll() {
		List<Owned> a = new LinkedList<>();
		try (Connection conn = RDBConnection.CreateRDBConnection(logger)) {
			Statement s = conn.createStatement();
			String sql = "select * from cardealer.\"owned\"";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				a.add(new Owned(rs));
			}
			rs.close();
			s.close();
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
	public List<Owned> findUserOwned(String i) {
		List<Owned> a = new LinkedList<>();
		String sql = "SELECT * FROM cardealer.owned WHERE userid=?";
		try(Connection conn = RDBConnection.CreateRDBConnection(logger); PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1,i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a.add(new Owned(rs));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	public boolean exists(int i, String j) {
		String sql = "select exists(SELECT * FROM cardealer.owned WHERE carid=? AND userid = ?)";
		try(Connection conn = RDBConnection.CreateRDBConnection(logger); PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1,i);
			ps.setString(2, j);
			ResultSet result = ps.executeQuery();
			result.next();
			return result.getBoolean("exists");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	//Make payment
	public Owned update(Owned t) {
		String sql = "update cardealer.owned set carpaymentleft = ?  WHERE carid=? AND userid = ?";
		try(Connection conn = RDBConnection.CreateRDBConnection(logger); PreparedStatement ps = conn.prepareStatement(sql)){
			//System.out.println(t.toString());
			ps.setInt(1,t.getPaymentLeft() - t.getPaymentMonthly());
			ps.setInt(2,t.getCarID());
			ps.setString(3,t.getUserID());
			ps.execute();
			logger.info("Payment made");
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Owned create(Owned a) {
		String sql = "insert into cardealer.owned (userid, carid, carpaymentleft, carmonthly) values (?, ?, ?, ?)";
		try(Connection conn = RDBConnection.CreateRDBConnection(logger); PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, a.getUserID());
			ps.setInt(2, a.getCarID());
			ps.setInt(3, a.getPaymentLeft());
			ps.setInt(4, a.getPaymentMonthly());
			ps.execute();
			logger.info("Car: " + a.getCarID() + "is now owned by " + a.getUserID());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int delete(String i) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Owned findById(String i) {
		// TODO Auto-generated method stub
		return null;
	}
}
