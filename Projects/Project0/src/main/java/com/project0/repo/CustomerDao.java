package com.project0.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.project0.config.EnvironmentConnectionUtil;
import com.project0.models.Car;
import com.project0.models.Customer;
import com.project0.models.Employee;
import com.project0.models.User;

public class CustomerDao implements DaoContract<Customer, Integer>{
	final static Logger log = Logger.getLogger(UserDao.class);
	
	public CustomerDao() {
		
	}
	

	@Override
	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<Customer>();
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from users where Employee=false;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				customers.add(new Customer(id,username));
			}
		} catch (SQLException e) {
			log.error("There was a sql exception:" + e);
			e.printStackTrace();
		}
		return customers;
	}//end of findall

	@Override
	public Customer findById(Integer i) {
		Customer bob = null;
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from users where UserID = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				bob = new Customer(id,username);
			}
		} catch (SQLException e) {
			log.error("There was a sql exception:" + e);
			e.printStackTrace();
		}
		return bob;
	}//end of findbyid
	
	//most likely would never use this
	@Override
	public Customer update(Customer t) {
		Customer bob = t;
		int userID = t.getId();
		String username = t.getUser();
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "update users set Username = ? where UserID = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setInt(2, userID);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			log.error("There was a sql exception:" + e);
			e.printStackTrace();
		}
		return bob;
	}//end of update method

	//new Customer is created at login in UserDao
	@Override
	public Customer create(Customer t) {
		Customer bob = t;
		String username = t.getUser();
		int userID = 0;
		
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "insert into users (Username,Employee) values (?,false);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.executeUpdate();
			ps.close();
			//getting the new UserID
			sql = "select max(UserID) from users;";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				userID = rs.getInt(1);
			}
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			log.error("There was a sql exception:" + e);
			e.printStackTrace();
		}
		bob = new Customer(userID, username);
		return bob;
	}//end of create method

	@Override
	public int delete(Integer i) {
		int result = 0;
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "delete from users where UserID = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,i);
			result = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			log.error("There was a sql exception:" + e);
			e.printStackTrace();
		}
		return result;
	}//end of delete method
	
	public int findId(String username) {
		int id = 0;
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from users where username = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			log.error("There was a sql exception:" + e);
			e.printStackTrace();
		}
		return id;
	}//end of findId method

}
