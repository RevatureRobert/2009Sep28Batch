package com.project0.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.project0.config.FileConnectionUtil;
import com.project0.model.Employee;
import com.project0.ui.EmployeeMenu;

public class EmployeeDao implements DaoContract<Employee, Integer> {

	static Logger log = Logger.getLogger(EmployeeMenu.class);

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = new LinkedList<>();
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from employee";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				employees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3)));

			}
			rs.close();
			s.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee findById(Integer i) {
		Employee employee = null;
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from employee where id = ?"; // this will sanitize the input
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	public Employee findByLogin(String name, String password) {
		Employee emp = null;
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from employee where name = ? and password = ?"; // this will sanitize the input
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;

	}

	@Override
	public Employee update(Employee t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee create(Employee t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
