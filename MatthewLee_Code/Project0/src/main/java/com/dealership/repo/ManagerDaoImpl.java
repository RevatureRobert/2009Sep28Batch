package com.dealership.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.dealership.config.ConnectionInterface;
import com.dealership.config.EnvironmentConnectionUtil;
import com.dealership.model.Employee;
import com.dealership.model.Manager;
import com.dealership.model.Offer;

public class ManagerDaoImpl implements ManagerDao {

	private static final Logger logger = LogManager.getLogger(ManagerDaoImpl.class.getName());
	private static final ConnectionInterface CI = EnvironmentConnectionUtil.getInstance();
	
	@Override
	public Manager login(String username, String password) {
		logger.info(String.format("Manager Login - Username: %s", username));
		Manager manager = null;
		String sql = "SELECT manager_id FROM manager WHERE username = ? and password = ?;";

		try (Connection conn = CI.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				manager = new Manager(rs.getInt(1));
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return manager;
	}
	
	@Override
	public int createEmployeeAccount(String username, String password) {
		logger.info(String.format("Creating employee account, username: %s", username));
		int updated = 0;
		String sql = "INSERT INTO employee VALUES (DEFAULT, ?, ?);";
		
		try (Connection conn = CI.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			updated = ps.executeUpdate();
			
		} catch (SQLException e) {
			logger.info(String.format("Username: %s already exists", username));
		}
		
		return updated;
	}
	
	@Override
	public List<Employee> viewEmployees() {
		logger.info("Viewing employees");
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT employee_id, username FROM employee;";
		
		try (Connection conn = CI.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				employees.add(new Employee(rs.getInt(1), rs.getString(2)));
			}
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return employees;
	}
	
	@Override
	public int fireEmployee(int employeeId) {
		logger.info("Firing employee");
		int updated = 0;
		String sql = "DELETE FROM employee WHERE employee_id = ?;";
		
		try (Connection conn = CI.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setInt(1, employeeId);
			updated = ps.executeUpdate();
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return updated;
	}
	
	@Override
	public List<Offer> viewSalesHistory() {
		logger.info("Viewing Sales History");
		List<Offer> offers = new ArrayList<>();
		String sql = "SELECT * FROM offer;";
		
		try (Connection conn = CI.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				offers.add(new Offer(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), 
						rs.getInt(5), rs.getInt(6)));
			}
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return offers;
	}

}
