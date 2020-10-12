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
import com.dealership.model.Employee;
import com.dealership.model.Offer;
import com.dealership.model.Payment;

public class EmployeeDaoImpl implements EmployeeDao {

	private static final Logger logger = LogManager.getLogger(EmployeeDaoImpl.class.getName());
	private final ConnectionInterface CI = EnvironmentConnectionUtil.getInstance();
	
	@Override
	public Employee login(String username, String password) {
		logger.info(String.format("Employee Login - Username: %s", username));
		Employee emp = null;
		String sql = "SELECT employee_id, username FROM employee WHERE username = ? and password = ?;";
		
		try (Connection conn = CI.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employee(rs.getInt(1), rs.getString(2));
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return emp;
	}

	@Override
	public List<Car> viewCars() {
		logger.info("Viewing cars");
		List<Car> cars = new ArrayList<>();
		String sql = "SELECT * FROM car WHERE customer_id = -1 ORDER BY car_id";

		try (Connection conn = CI.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

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
	public int addCar(Car car) {
		logger.info(String.format("Adding Car - ID: %d", car.getId()));
		int updated = 0;
		String sql = "INSERT INTO car VALUES (DEFAULT, DEFAULT, ?, ?, ?, ?, ?);";
		
		try (Connection conn = CI.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, car.getMake());
			ps.setString(2, car.getModel());
			ps.setInt(3, car.getYear());
			ps.setInt(4, car.getMpg());
			ps.setInt(5, car.getPrice());

			updated = ps.executeUpdate();

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return updated;
	}
	
	@Override
	public int editCar(Car car) {
		logger.info(String.format("Editing car - ID: %d", car.getId()));
		int updated = 0;
		
		String sql = "UPDATE car SET make = ?, model = ?, year = ?, mpg = ?, price = ? "
				+ "WHERE car_id = ?;";
		
		try (Connection conn = CI.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setString(1, car.getMake());
			ps.setString(2, car.getModel());
			ps.setInt(3, car.getId());
			ps.setInt(4, car.getMpg());
			ps.setInt(5, car.getPrice());
			ps.setInt(6, car.getId());
			
			updated = ps.executeUpdate();
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return updated;
	}

	@Override
	public int removeCar(int carId) {
		logger.info(String.format("Removing car - ID: %d", carId));
		int updated = 0;
		String sql1 = "DELETE FROM offer WHERE car_id = ?;";
		String sql2 = "DELETE FROM car where car_id = ?;";
		
		try (Connection conn = CI.getConnection();
				PreparedStatement ps1 = conn.prepareStatement(sql1);
				PreparedStatement ps2 = conn.prepareStatement(sql2)) {

			ps1.setInt(1, carId);
			
			ps2.setInt(1, carId);
			updated = ps2.executeUpdate();

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return updated;
	}

	@Override
	public List<Offer> viewOffers() {
		logger.info("Viewing offers");
		List<Offer> offers = new ArrayList<>();
		String sql = "SELECT * FROM offer WHERE accepted = 0;";

		try (Connection conn = CI.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				offers.add(new Offer(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getInt(4), rs.getInt(5), rs.getInt(6)));
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return offers;
	}

	@Override
	public void acceptOffer(int offerId) {
		logger.info(String.format("Accepting offer - ID: %d", offerId));
		String sql = "CALL accept_offer(?);";

		try (Connection conn = CI.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, offerId);
			ps.executeUpdate();

		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public int rejectOffer(int offerId) {
		logger.info(String.format("Rejecting offer - ID: %d", offerId));
		int updated = 0;
		String sql = "UPDATE offer SET accepted = -1 WHERE offer_id = ?;";
		
		try (Connection conn = CI.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setInt(1, offerId);
			updated = ps.executeUpdate();
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return updated;
	}
	
	@Override
	public List<Payment> viewPayments() {
		logger.info("Viewing payments");
		List<Payment> payments = new ArrayList<>();
		String sql = "SELECT * FROM payments_with_offer;";
		
		try (Connection conn = CI.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				double balance = rs.getInt(4) - rs.getDouble(3);
				double monthlyPayment = rs.getInt(4) / (double) rs.getInt(5);
				payments.add(new Payment(rs.getInt(1), rs.getInt(2), rs.getDouble(3), balance, monthlyPayment));
			}
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return payments;
	}

}
