package com.dealership.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.dealership.config.EnvironmentConnectionUtil;
import com.dealership.models.Car;

public class CarDAO implements DAOBase<Car, Integer> {

	final static Logger logger = Logger.getLogger(CarDAO.class);
	
	UserDAO ud;
	
	public CarDAO() {
		ud = new UserDAO();
	}
	
	@Override
	public List<Car> findAll() {
		List<Car> cars = new LinkedList<>();
		
		try(Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from \"Cars\"";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				cars.add(new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getBoolean(6)));
			}
			
			logger.info("findAll() succesfully called");
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			logger.error("Database access denied.", e);
			e.printStackTrace();
			return null;
		}
		
		return cars;
	}
	
	public List<Car> findAllOnLot(){
		List<Car> cars = new LinkedList<>();
		
		try(Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from \"Cars\" where on_lot = true";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				cars.add(new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getBoolean(6)));
			}
			
			logger.info("findAllOnLot() successfully called");
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			logger.error("Database access denied.", e);
			e.printStackTrace();
			return null;
		}
		
		return cars;
	}
	
	public List<Car> findAllOwned(String username){
		List<Car> cars = findAll();
		int i = 0;
		while (i < cars.size()){
			if (cars.get(i).getOwner() == null) {
				cars.remove(i);
				continue;
			}
			if (cars.get(i).getOwner().equals(username)) {
				i++;
				continue;
			}
			
			cars.remove(i);
		}
		
		logger.info("findAllOwned() successfully called");
		return cars;
	}

	@Override
	public Car findById(Integer i) {
		Car car = null;
		
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from \"Cars\" where cid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				car = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(4), rs.getBoolean(5));
			}
			
			logger.info("findById() successfully called");
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			logger.error("Database access denied.", e);
			e.printStackTrace();
			return null;
		}

		return car;
	}

	@Override
	public Car update(Car t) {
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			
			//no owner, meaning car information is getting updated by employee
			if (t.getOwner() == null) {
				String sql = "update \"Cars\" set make = ?"
									  	  + "model = ?"
									  	  + "price = ?"
									  	  + "where cid = ?";
			
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, t.getMake());
				ps.setString(2, t.getModel());
				ps.setInt(3, t.getPrice());
				ps.setInt(4, t.getCarID());
				ps.executeUpdate();
			
				t = findById(t.getCarID());
			
				logger.info("update(no owner) successfully called");
				ps.close();
			}
			else { //if owner, then car has been sold
				String sql = "update \"Cars\" set car_owner = ?"
											  + "on_lot = false";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, t.getOwner());
				ps.executeUpdate();
				
				t = findById(t.getCarID());
				
				logger.info("update(owner) successfully called");
				ps.close();
			}
			
			
			
		} catch (SQLException e) {
			logger.error("Database access denied.", e);
			e.printStackTrace();
			return null;
		}
		
		return t;
	}

	@Override
	public Car create(Car t) {
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "insert into \"Cars\" (make, model, price, on_lot) values (?,?,?,true)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getMake());
			ps.setString(2, t.getModel());
			ps.setInt(3, t.getPrice());
			
			ps.executeUpdate();
			
			logger.info("create() successfully called");
			ps.close();
		} catch (SQLException e) {
			logger.error("Database access denied.", e);
			e.printStackTrace();
			return null;
		}
		
		return t;
	}

	@Override
	public int delete(Integer i) {
		int updated = 0;
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "update \"Cars\" set on_lot = false where cid = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			
			updated = ps.executeUpdate();
			
			logger.info("delete() successfull called");
			ps.close();
		} catch (SQLException e) {
			logger.error("Database access denied.", e);
			e.printStackTrace();
			return 0;
		}
		
		return updated;
	}

	
}
