package com.revature.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.config.FileConnectionUtil;
import com.revature.model.Customer;
import com.revature.model.Employee;
import com.revature.repo.CustomerDao;
import com.revature.repo.DaoUtil;

public class MiscService {
	private CustomerDao cd = new CustomerDao();
	private DaoUtil du = new DaoUtil();
	//TODO BONUS: ALLOW SYSTEM TO CALCULATE REMAINING PAYMENTS ON A LOAN
	public Customer signUp(String firstname, String lastname, String email, String password) {
		//create customer with id of zero, database manages customer_id automatically with serial
		Customer c = new Customer(0, firstname, lastname, email, password);
		cd.create(c);
		return c;
	}
	public Customer customerLogin(String email, String password) {
		Customer c = null;
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from customers where email = ? and password = ?"; //this will sanitize the input
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public Employee employeeLogin(String email, String password) {
		Employee a = null;
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from employees where email = ? and password = ?"; //this will sanitize the input
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2,  password);
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
	
	//Returns employee object if employee is manager, otherwise returns null
	public Employee isManager(int employee_id) {
		Employee a = null;
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from employees where employee_id = ?"; //this will sanitize the input
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employee_id);
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
	
	public void removePending() {
		du.callRemovePending();
	}
}
