package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.config.FileConnectionUtil;
import com.revature.model.Customer;

public class CustomerDao implements DaoContract<Customer, Integer>{

	public List<Customer> findAll() {
		List<Customer> customers = new LinkedList<>();
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from customers";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				customers.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
			rs.close();
			s.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	public Customer findById(Integer i) {
		Customer c = null;
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from customers where customer_id = ?"; //this will sanitize the input
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
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

	public Customer update(Customer t) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "update customers set customer_id = ?, firstname = ?, lastname = ?, email = ?, password = ? where customer_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getCustomerID());
			ps.setString(2, t.getFirstname());
			ps.setString(3,  t.getLastname());
			ps.setString(4, t.getEmail());
			ps.setString(5, t.getPassword());
			ps.setInt(6, t.getCustomerID());
			ps.executeUpdate();
		} catch(SQLException e ) {
			e.printStackTrace();
			return null;
		}
		return t;
	}

	public Customer create(Customer t) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "insert into customers (firstname, lastname, email, password) values (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getFirstname());
			ps.setString(2, t.getLastname());
			ps.setString(3,  t.getEmail());
			ps.setString(4,  t.getPassword());
			ps.executeUpdate();
		} catch(SQLException e ) {
			e.printStackTrace();
			return null;
		}
		return t;
	}

	public int delete(Integer i) {
		try(Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "delete from customers where customer_id = ?";
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
