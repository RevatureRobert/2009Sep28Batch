package com.project.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.project.config.PlainTextConnectionUtil;
import com.project.model.Car;
import com.project.ui.Printers;

public class CarDAO implements DAOContract<Car, Integer> {
	
	final static Logger logger = Logger.getLogger(CarDAO.class);
	
	@Override
	public List<Car> findAll() {
		List<Car> cars = new LinkedList<>();
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from \"carDealership\".car where cust_id is null";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cars.add(new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			logger.info("Connection issue. Are credentials authorized?");
		}
		return cars;
	}
	
	public List<Car> findAllOwned() {		// Not in DAOContract, but finds all cars that are owned
		List<Car> cars = new LinkedList<>();
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from \"carDealership\".car where cust_id is not null";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cars.add(new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}

	@Override
	public Car findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Car updateOwner(Car t) {
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			String sql = "update \"carDealership\".car set cust_id=? where car_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getBelongsTo());
			ps.setInt(2, t.getID());
			int updated = ps.executeUpdate();
			updated += updated;
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return t;
	}
	
	public List<Car> ownedCars(Integer i) {
		List<Car> cars = new LinkedList<>();
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from \"carDealership\".car where cust_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cars.add(new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}

	@Override
	public Car create(Car t) {
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			String sql = "insert into \"carDealership\".car (Make, Model, Car_Year, Color, car_condition) values (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getMake());
			ps.setString(2, t.getModel());
			ps.setInt(3, t.getYear());
			ps.setString(4, t.getColor());
			ps.setString(5, t.getSize());
			int updated = ps.executeUpdate();
			updated += updated;
			ps.close();
		} catch (SQLException e) {
//			e.printStackTrace();
			logger.error("Error creating car, likely duplicate");
			Printers.invalid("duplicate");
			return null;
		}
		return t;
	}

	@Override
	public int delete(Integer i) {
		int updated = 0;
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			String sql = "delete from \"carDealership\".car where car_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			updated = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
//			e.printStackTrace();
			logger.error("The only way you're seeing this is an error with the connection.");
		}
		return updated;
	}

	@Override
	public int update(Car t) {
		int updated = 0;
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			String sql = "update \"carDealership\".car set make=?, model=?, car_year=?, color=?, car_condition=? where car_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getMake());
			ps.setString(2, t.getModel());
			ps.setInt(3, t.getYear());
			ps.setString(4, t.getColor());
			ps.setString(5, t.getSize());
			ps.setInt(6, t.getID());
			updated = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			logger.error("Error while updating car");
			Printers.invalid("duplicate");
			return updated;
		}
		return updated;
	}

	
	
}
