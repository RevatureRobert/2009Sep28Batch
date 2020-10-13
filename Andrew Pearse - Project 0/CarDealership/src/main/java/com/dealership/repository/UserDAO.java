package com.dealership.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.dealership.config.EnvironmentConnectionUtil;
import com.dealership.models.User;

public class UserDAO implements DAOBase<User, String>{

	final static Logger logger = Logger.getLogger(CarDAO.class);
	
	public List<User> findAll() {
		List<User> users = new LinkedList<>();
		
		try(Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from \"User\"";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				users.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
			
			logger.info("findAll() succesfully called");
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			logger.error("Database access denied.", e);
			e.printStackTrace();
			return null;
		}
		
		return users;
	}

	public User findById(String i) {
		User user = null;
		
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from \"User\" where user_name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, i);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			
			logger.info("findById() successfully called");
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			logger.error("Database access denied.", e);
			e.printStackTrace();
			return null;
		}

		return user;
	}

	public User update(User t) {
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			
			String sql = "update \"User\" set pass_word = ?"
									  	   + "where user_name = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getPassword());
			ps.setString(2, t.getUserName());
			ps.executeUpdate();
			
			t = findById(t.getUserName());
			
			logger.info("update() successfully called");
			ps.close();
			
		} catch (SQLException e) {
			logger.error("Database access denied.", e);
			e.printStackTrace();
			return null;
		}
		
		return t;
	}

	public User create(User t) {

		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "insert into \"User\" values (?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getUserName());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getFirstName());
			ps.setString(4, t.getLastName());
			ps.setString(5, t.getType());
			
			ps.executeUpdate();
			
			logger.info("create() successfully called");
			ps.close();
		} catch (SQLException e) {
			logger.error("Database access denied.", e);
			e.printStackTrace();
			return null;
		}
		
		return t;
	}

	public int delete(String i) {
		int updated = 0;
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "delete from \"User\" where user_name = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, i);
			
			updated = ps.executeUpdate();
			
			logger.info("delete() successfully called");
			ps.close();
		} catch (SQLException e) {
			logger.error("Database access denied.", e);
			e.printStackTrace();
			return 0;
		}
		
		return updated;
	}

}
