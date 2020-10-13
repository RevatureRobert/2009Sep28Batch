package com.project0.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.project0.config.FileConnectionUtil;
import com.project0.model.Customer;

public class CustomerDao implements DaoContract<Customer, Integer> {
//	public static void main(String[] args) {
//		CustomerDao cd = new CustomerDao();
//		System.out.println(cd.findByLogin("Derrick", "abcd"));
//
//	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customers = new LinkedList<>();
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from customer";
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				customers.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3)));

			}
			rs.close();
			s.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public Customer findById(Integer i) {
		Customer c = null;
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from customer where id = ?"; // this will sanitize the input
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public Customer findByLogin(String name, String password) {
		Customer c = null;
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from customer where name = ? and password = ?"; // this will sanitize the input
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Customer update(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer create(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Customer newCustomer(Customer c) {
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "insert into customer (name, password) values (?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getPassword());
			int updated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return c;
	}

}
