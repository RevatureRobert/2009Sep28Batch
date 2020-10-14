package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.config.EnvironmentConnectionUtil;
import com.revature.config.PlainTextConnectionUtil;
import com.revature.model.Bear;

public class BearDao implements DaoContract<Bear, Integer>{
	
	private CircusDao cd;
	
	//why we might use an interface
	//ConnectionInterface ci = EnvironmentConnection.getInstance();
	//makes it so we only type ci for all the different inputs
	
	public BearDao() {
		
	}
	
	public BearDao(CircusDao cd) {
		super();
		this.cd = cd;
	}
			
	
	/**
	 * this method will be using a Statement. It is referred to as a simple statement.
	 * In general, we want to stay away from simple statements and use prepared statements.
	 * 
	 * The simple statement does not have a way of sanitizing input, also it is less performant than the prepared statement.
	 */
	@Override
	public List<Bear> findAll() {
		List<Bear> bears = new LinkedList<>(); //this prevents nullpointerexceptions by passing an empty list at the very least
		try(Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){ //connection will auto close after try block ends
			Statement s = conn.createStatement();
			String sql = "select * from bear";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				bears.add(new Bear(rs.getInt(1),rs.getString(2),rs.getBoolean(3),cd.findById(rs.getString(4))));//null for now, but we'l get data from circus later
			}
			rs.close();
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bears; 
	}

	/**
	 * This uses a prepared statement.
	 * 
	 * A prepared statement will sanitize the input and precompile the statement before sending it to be executed by the database.
	 */
	@Override
	public Bear findById(Integer i) {
		Bear b = null;
		try(Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
//			String sql = "select * frfom bear where tag_id = "+i; //this will cause sql injection (this will directly send the string to the sql database and run whatever it is)
			String sql = "select * from bear where tag_id = ?";   //this will sanitize the input (this will turn this into a input considered as part of a query, so it gets considered)
			PreparedStatement ps = conn.prepareStatement(sql); //technically, you could put string sql above the try, and put this into the try (resource).
			ps.setInt(1, i); //this will replace the first ? with i
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				b = new Bear(rs.getInt(1), rs.getString(2), rs.getBoolean(3), cd.findById(rs.getString(4)));
			}
			ps.close();
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return b;
	}

	@Override
	public Bear update(Bear t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bear create(Bear t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
