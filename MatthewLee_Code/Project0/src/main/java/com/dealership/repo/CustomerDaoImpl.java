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
import com.dealership.model.Car;
import com.dealership.model.Customer;
import com.dealership.model.Offer;
import com.dealership.model.Payment;

public class CustomerDaoImpl implements CustomerDao {

	private static final Logger logger = LogManager.getLogger(CustomerDaoImpl.class.getName());
	private final ConnectionInterface CI = EnvironmentConnectionUtil.getInstance();
	
	@Override
	public int register(String username, String password) {
		logger.info(String.format("Registering customer account, username: %s", username));
		int updated = 0;
		String sql = "INSERT INTO customer VALUES (DEFAULT, ?, ?);";
		
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
	public Customer login(String username, String password) {
		logger.info(String.format("Customer Login - Username: %s", username));
		if (username.equals("null")) { // invalid username
			return null;
		}

		Customer customer = null;
		String sql = "SELECT * FROM customer WHERE username = ? AND password = ?";

		try (Connection conn = CI.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customer = new Customer(rs.getInt(1));
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return customer;
	}

	@Override
	public List<Car> viewCarLot() {
		logger.info("Viewing car lot");
		List<Car> cars = new ArrayList<>();
		String sql = "SELECT * FROM car WHERE customer_id = -1 ORDER BY car_id;";

		try (Connection conn = CI.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cars.add(new Car(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7)));
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return cars;
	}

	@Override
	public int makeOffer(Offer offer) {
		logger.info(String.format("Making offer - ID: %d", offer.getOfferId()));
		int updated = 0;
		String sql1 = "DELETE FROM offer WHERE customer_id = ? AND car_id = ? AND accepted = 0;";
		String sql2 = "INSERT INTO offer VALUES (DEFAULT, ?, ?, DEFAULT, ?, ?);";
		
		try (Connection conn = CI.getConnection();
				PreparedStatement ps1 = conn.prepareStatement(sql1);
				PreparedStatement ps2 = conn.prepareStatement(sql2)) {
			
			ps1.setInt(1, offer.getCustomerId());
			ps1.setInt(2, offer.getCarId());
			ps1.executeUpdate();
			
			ps2.setInt(1, offer.getAmount());
			ps2.setInt(2, offer.getMonths());
			ps2.setInt(3, offer.getCustomerId());
			ps2.setInt(4, offer.getCarId());
			
			updated = ps2.executeUpdate();
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return updated;
	}
	
	@Override
	public List<Car> viewCustomerCars(int customerId) {
		logger.info("Viewing customer's cars");
		List<Car> cars = new ArrayList<>();
		String sql = "SELECT * FROM car WHERE customer_id = ? ORDER BY car_id";

		try (Connection conn = CI.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setInt(1, customerId);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cars.add(new Car(rs.getInt(1), rs.getString(3), rs.getString(4), 
						rs.getInt(5), rs.getInt(6), rs.getInt(7)));
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return cars;
	}
	
	@Override
	public List<Payment> viewPayments(int customerId) {
		logger.info("Viewing payments");
		List<Payment> payments = new ArrayList<>();
		String sql = "SELECT * FROM payments_with_offer WHERE customer_id = ?;";

		try (Connection conn = CI.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
				
			ps.setInt(1, customerId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				double balance = rs.getInt(4) - rs.getDouble(3);
				double monthlyPayment = rs.getInt(4) / (double) rs.getInt(5);
				payments.add(new Payment(rs.getInt(1), rs.getInt(2), rs.getInt(3), balance, monthlyPayment));			}
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return payments;
	}
	
	@Override
	public int makePayment(Payment payment) {
		logger.info(String.format("Making payment - Customer ID: %d, Car ID: %d",
				payment.getCustomerId(), payment.getCarId()));
		int updated = 0;
		String sql = "INSERT INTO payment VALUES (DEFAULT, ?, ?, ?);";
		
		try (Connection conn = CI.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setDouble(1, payment.getMonthlyPayment());
			ps.setInt(2, payment.getCustomerId());
			ps.setInt(3, payment.getCarId());
			
			updated = ps.executeUpdate();
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return updated;
	}
	
}
