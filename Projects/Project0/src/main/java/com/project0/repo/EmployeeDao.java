package com.project0.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project0.config.EnvironmentConnectionUtil;
import com.project0.models.Customer;
import com.project0.models.Employee;

public class EmployeeDao implements DaoContract<Employee,Integer>{

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<Employee>();
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from users where Employee=true;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				employees.add(new Employee(id,username));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}//end of findAll method

	@Override
	public Employee findById(Integer i) {
		Employee bob = null;
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from users where UserID = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				bob = new Employee(id,username);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bob;
	}//end of findbyId method

	//won't ever use this method
	@Override
	public Employee update(Employee t) {
		Employee bob = t;
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
			e.printStackTrace();
		}
		return bob;
	}//end of update method

	@Override
	public Employee create(Employee t) {
		Employee bob = t;
		String username = t.getUser();
		int userID = 0;
		
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "insert into users (Username,Employee) values (?,true);";
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bob = new Employee(userID, username);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}//end of findId method
	
}
