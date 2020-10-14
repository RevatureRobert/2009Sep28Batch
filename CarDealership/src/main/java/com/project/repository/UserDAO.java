package com.project.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.project.config.PlainTextConnectionUtil;
import com.project.model.User;
import com.project.ui.Printers;

public class UserDAO implements DAOContract<User, Integer> {
	
	final static Logger logger = Logger.getLogger(UserDAO.class);

	@Override
	public List<User> findAll() {		// Really, this finds all employees
		List<User> users = new LinkedList<>();
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from \"carDealership\".users where user_type=2";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			logger.error("Possible connection issue?");
		}
		return users;
	}

	@Override
	public User findById(Integer i) {
		return null;
	}
	
	public User findByNamePass(String name, String pass) {
		User c = null;
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from \"carDealership\".users where username=? and pass=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			logger.error("Failed to log in. Record not found.");
		}
		return c;
	}

	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User create(User t) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			String sql = "insert into \"carDealership\".users (email, username, pass) values (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getEmail());
			ps.setString(2, t.getUsername());
			ps.setString(3, t.getPassword());
			int updated = ps.executeUpdate();
			updated += updated;
			ps.close();
		} catch (SQLException e) {
			logger.error("Error creating user, likely duplicate");
			Printers.invalid("duplicate");
			return null;
		}
		return t;
	}
	
	public User createEmployee(User t) {
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			String sql = "insert into \"carDealership\".users (email, username, pass, user_type) values (?,?,?,2)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getEmail());
			ps.setString(2, t.getUsername());
			ps.setString(3, t.getPassword());
			int updated = ps.executeUpdate();
			updated += updated;
			ps.close();
		} catch (SQLException e) {
			logger.error("Error creating employee, likely duplicate");
			Printers.invalid("duplicate");
			return null;
		}
		return t;
	}

	@Override
	public int delete(Integer i) {
		int updated = 0;
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			String sql = "delete from \"carDealership\".users where cust_id=? and user_type=2";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			updated = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			logger.error("Possible connection issue?");
		}
		return updated;
	}
	
}
