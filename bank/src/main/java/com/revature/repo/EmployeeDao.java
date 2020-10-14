package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.config.FileConnectionUtil;
import com.revature.model.Employee;

public class EmployeeDao implements DaoContract<Employee, Integer>{

	public List<Employee> findAll() {
		List<Employee> employees = new LinkedList<>();
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from employees";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				employees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
			rs.close();
			s.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public Employee findById(Integer i) {
		Employee a = null;
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from employees where employee_id = ?"; //this will sanitize the input
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				a = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public Employee update(Employee t) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "update employees set employee_id = ?, firstname = ?, lastname = ?, email = ?, password = ? where account_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getEmployeeID());
			ps.setString(2, t.getFirstname());
			ps.setString(3,  t.getLastname());
			ps.setString(4, t.getEmail());
			ps.setString(5, t.getPassword());
			ps.setInt(6, t.getEmployeeID());
			ps.executeUpdate();
		} catch(SQLException e ) {
			e.printStackTrace();
			return null;
		}
		return t;
	}

	public Employee create(Employee t) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "insert into employees (employee_id, firstname, lastname, email, password) values (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getEmployeeID());
			ps.setString(2, t.getFirstname());
			ps.setString(3,  t.getLastname());
			ps.setString(4, t.getEmail());
			ps.setString(5,  t.getPassword());
			ps.executeUpdate();
		} catch(SQLException e ) {
			e.printStackTrace();
			return null;
		}
		return t;
	}

	public int delete(Integer i) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "delete from employees where employee_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ps.executeUpdate();
		} catch(SQLException e ) {
			e.printStackTrace();
			return - 1;
		}
		return i;
	}

}
