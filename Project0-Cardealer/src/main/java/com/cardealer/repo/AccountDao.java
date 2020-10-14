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
import com.cardealer.model.Account;


public class AccountDao implements DaoContract<Account, String> {
	Logger logger;

	public AccountDao(Logger logger) {
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
	public List<Account> findAll() {
		List<Account> a = new LinkedList<>();
		try (Connection conn = RDBConnection.CreateRDBConnection(logger)) {
			Statement s = conn.createStatement();
			String sql = "select * from cardealer.\"user\"";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				a.add(new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getBoolean(5), rs.getBoolean(6)));
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
	@Override
	public Account findById(String i) {
		Account a = null;
//			String sql = "select * from bear where tag_id = "+i;	this will cause sqlinjection
		String sql = "select * from cardealer.user where username = ?"; // this will sanitize the input
		try (Connection conn = RDBConnection.CreateRDBConnection(logger);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getBoolean(5), rs.getBoolean(6));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	public boolean exists(String i) {
		String sql = "select exists(SELECT * FROM cardealer.USER WHERE Username=?)";
		try(Connection conn = RDBConnection.CreateRDBConnection(logger); PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1,i);
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
	public Account update(Account t) {
		String sql = "update cardealer.user set isadmin = ? where username = ?";
		try(Connection conn = RDBConnection.CreateRDBConnection(logger); PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setBoolean(1, !t.isAdminPrivilages());
			ps.setString(2,t.getUserName());
			ps.execute();
			if(!t.isAdminPrivilages()) {
				logger.info("Demoted " + t.getUserName() );
			}
			else {
				logger.info("promoted" + t.getUserName());
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account create(Account a) {
		String sql = "insert into cardealer.user (username, userpassword, lastname, firstname,  isAdmin, isManager) values (?, ?, ?, ?, ?, ?)";
		try(Connection conn = RDBConnection.CreateRDBConnection(logger); PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, a.getUserName());
			ps.setString(2, a.getPassword());
			ps.setString(3, a.getLastName());
			ps.setString(4, a.getFirstName());
			ps.setBoolean(5, a.isAdminPrivilages());
			ps.setBoolean(6, a.isManager());
			ps.execute();
			logger.info("Account created with username: " + a.getUserName());
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
}
