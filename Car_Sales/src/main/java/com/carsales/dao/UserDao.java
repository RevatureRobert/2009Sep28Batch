package com.carsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.carsales.model.User;
import com.carsales.util.ConnectionUtil;

public class UserDao {
	
	public UserDao() {
		super();
	}
	
	public int addUser(User usr)
	{
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement add = conn.prepareStatement("insert into carlot_schema.user_tab (username_t, password_t, usr_role) "
					+ "values (?, ?, ?);");
			add.setString(1, usr.getUserName());
			add.setString(2, usr.getPassWord());
			add.setString(3, usr.getRole());
			add.execute();
			
			add.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	public User LoginCheck(User usr)
	{
		User m = new User();
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement check = conn.prepareStatement("select * from carlot_schema.user_tab where \"username_t\" = ? and \"password_t\" = ?");
			check.setString(1, usr.getUserName());
			check.setString(2, usr.getPassWord());
			ResultSet res = check.executeQuery();
			if(res.next())
			{
			m = new User(res.getInt(1), res.getString(2), res.getString(3), res.getString(4));
			}
			else
				return null;
			
			check.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public User PermissionCheck(User usr)
	{
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement check = conn.prepareStatement("select * from carlot_schema.user_tab where \"username_t\" = ? and \"password_t\" = ?");
			check.setString(1, usr.getUserName());
			check.setString(2, usr.getPassWord());
			ResultSet res = check.executeQuery();
			if(res.next())
			{
				return new User(res.getInt(1), res.getString(2), res.getString(3), res.getString(4));
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User getbyId(int id)
	{
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement check = conn.prepareStatement("select * from carlot_schema.user_tab where \"user_id\" = ?");
			check.setInt(1, id);
			ResultSet res = check.executeQuery();
			if(res.next())
			{
				return new User(res.getInt(1), res.getString(2), res.getString(3), res.getString(4));
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<User> getAllbyRole(String role)
	{
		List<User> users = new LinkedList<User>();
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement check = conn.prepareStatement("select * from carlot_schema.user_tab where \"usr_role\" = ?");
			check.setString(1, role);
			ResultSet res = check.executeQuery();
			while(res.next())
			{
				users.add(new User(res.getInt(1), res.getString(2), res.getString(3), res.getString(4)));
			}
			
			check.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public int removeUser(int id)
	{
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement remo = conn.prepareStatement("delete from carlot_schema.user_tab where user_id = ?");
			remo.setInt(1,id);
			remo.execute();
			
			remo.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
		
	}
	
	
    
}
