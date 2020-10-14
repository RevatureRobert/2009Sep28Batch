package com.car_dealership_cli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.car_dealership_cli.model.Customer;
import com.car_dealership_cli.model.User;
import com.car_dealership_cli.repo.DAOContract;
import com.car_dealership_cli.repo.DAOUtilities;

public class CustomerDAO implements DAOContract<Customer, Integer> {

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer update(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer create(Customer t, User u) {
		Connection con = DAOUtilities.getConnection();
		
		String sql = "insert into customer (user_id, first_name, last_name) values (?,?,?);";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,u.getUserId());
			stmt.setString(2, t.getFirstName());
			stmt.setString(3, t.getLastName());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		return null;
	}

	@Override
	public int delete(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Customer create(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

}
