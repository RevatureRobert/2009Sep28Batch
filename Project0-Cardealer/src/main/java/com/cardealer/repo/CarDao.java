package com.cardealer.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;


import com.cardealer.config.RDBConnection;
import com.cardealer.model.Car;


public class CarDao implements DaoContract<Car, Integer> {
	Logger logger;

	public CarDao(Logger logger) {
		super();
		this.logger = logger;
	}
	/**
	 * this method will be using a Statement. It is referred to as a simple
	 * statement. In general, we want to stay away from simple statements and use
	 * prepared statements.
	 * 
	 * The simple statement does not have a way of sanitizing input, also it is less
	 * performant than the prepared statement.
	 */
	@Override
	public List<Car> findAll() {
		List<Car> c = new LinkedList<>();
		try (Connection conn = RDBConnection.CreateRDBConnection(logger)) {
			Statement s = conn.createStatement();
			String sql = "select * from cardealer.\"lot\"";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				c.add(new Car(rs));
			}
			rs.close();
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	/**
	 * this is will use a prepared statement.
	 * 
	 * A prepared statement will sanitize the input and precompile the statement
	 * before sending it to be executed by the db.
	 */
	@Override
	public Car findById(Integer i) {
		Car c = null;

		String sql = "select * from cardealer.lot where carid= ?"; // this will sanitize the input
		try (Connection conn = RDBConnection.CreateRDBConnection(logger);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new Car(rs);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	public Car findMyById(Integer i, String j) {
		Car c = null;

		String sql = "select * from cardealer.lot where carid= ?"; // this will sanitize the input
		try (Connection conn = RDBConnection.CreateRDBConnection(logger);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new Car(rs);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	
	public Car update(Integer carID) {
		String sql = "update cardealer.lot set carowned = true where carid = ?";
		try(Connection conn = RDBConnection.CreateRDBConnection(logger); PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1,carID);
			ps.execute();
			logger.info("set " + carID + " to owned");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean exists(Integer i) {
		String sql = "select exists(SELECT * FROM cardealer.lot WHERE  carid=?)";
		try(Connection conn = RDBConnection.CreateRDBConnection(logger); PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1,i);
			ResultSet result = ps.executeQuery();
			result.next();
			return result.getBoolean("exists");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Car create(Car c) {
		String sql = "insert into cardealer.lot (carmaker, carmodel, caryear,  carcolor, carvalue) values (?, ?, ?, ?, ?)";
		try(Connection conn = RDBConnection.CreateRDBConnection(logger); PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, c.getCarMake());
			ps.setString(2, c.getCarModel());
			ps.setString(3, c.getCarYear());
			ps.setString(4, c.getCarColor());
			ps.setInt(5, c.getCarValue());
			ps.execute();
			logger.info("Car added to lot");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Car updateSettings(Car c) {
		String sql = "update cardealer.lot set carmaker = ?, carmodel = ?, caryear=?,  carcolor=?, carvalue=? where carid = ?";
		try(Connection conn = RDBConnection.CreateRDBConnection(logger); PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, c.getCarMake());
			ps.setString(2, c.getCarModel());
			ps.setString(3, c.getCarYear());
			ps.setString(4, c.getCarColor());
			ps.setInt(5, c.getCarValue());
			ps.setInt(6, c.getCarID());
			ps.execute();
			logger.info("Car with ID: " +c.getCarID() + " updated");
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return null;
	}
	@Override
	public int delete(Integer i) {
		String sql = "delete from cardealer.lot where carid= ? AND carowned = false"; // this will sanitize the input
		try (Connection conn = RDBConnection.CreateRDBConnection(logger);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, i);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	
		return 0;
	}
	@Override
	public Car update(Car t) {
		// TODO Auto-generated method stub
		return null;
	}
}
