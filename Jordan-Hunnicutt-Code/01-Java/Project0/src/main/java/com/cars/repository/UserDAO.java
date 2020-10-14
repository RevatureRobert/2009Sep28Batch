package com.cars.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.cars.config.PTConnUtil;
import com.cars.model.User;

public class UserDAO implements RepositoryFunctions<User, Object>{

	@Override
	public List<User> findAll() {
		List<User> users = new LinkedList<>(); //this prevents nullpointerexceptions by passing an empty list at the very least
		try(Connection conn = PTConnUtil.getInstance().getConnection()){ //connection will auto close after try block ends
			String sql = "select * from user_account where userId > ?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, 0);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4)));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users; 
	}

	@Override
	public User findById(Object i) {
		User u = null;
		if(i.getClass() == String.class) {
			String s = i.toString();
			
			try(Connection conn = PTConnUtil.getInstance().getConnection()){
				String sql = "select * from user_account where username = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, s);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					u = new User(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4));
				}
				rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} else if(i.getClass() == Integer.class) {
			int x = Integer.parseInt(i.toString());
			
			try(Connection conn = PTConnUtil.getInstance().getConnection()){
				String sql = "select * from user_account where userId = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, x);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					u = new User(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4));
				}
				rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return u;
	}

	@Override
	public User update(User t) {
		
		try(Connection conn = PTConnUtil.getInstance().getConnection()){
			String sql = "update user_account set (username, userPass, userType) = (?,?,?) where userId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getUsername());
			ps.setString(2, t.getPassword());
			ps.setInt(3, t.getUserType());
			ps.setInt(4, t.getUserId());
			int updated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return t;
	}

	@Override
	public User create(User t) {
		try(Connection conn = PTConnUtil.getInstance().getConnection()){
			String sql = "insert into user_account (username, userPass, userType) values (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getUsername());
			ps.setString(2, t.getPassword());
			ps.setInt(3, t.getUserType());
			int inserted = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		return t;
	}

	@Override
	public int delete(Object i) {
		
		if(i.getClass() == String.class) {
			String s = i.toString();
		
			try(Connection conn = PTConnUtil.getInstance().getConnection()){
				String sql = "delete from user_account where username = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, s);
				int deleted = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
		} else if(i.getClass() == Integer.class) {
			int x = Integer.parseInt(i.toString());
			
			try(Connection conn = PTConnUtil.getInstance().getConnection()){
				String sql = "delete from user_account where userId = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, x);
				int deleted = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
		}
		return 1;
	}

}
