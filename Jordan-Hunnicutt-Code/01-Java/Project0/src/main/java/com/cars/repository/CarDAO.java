package com.cars.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cars.config.EnvConnUtil;
import com.cars.config.PTConnUtil;
import com.cars.model.Car;

public class CarDAO implements RepositoryFunctions<Car, Integer>{

	
	
	
	@Override
	public List<Car> findAll() {
		List<Car> cars = new ArrayList<>(); //this prevents nullpointerexceptions by passing an empty list at the very least
		try(Connection conn = PTConnUtil.getInstance().getConnection()){ //connection will auto close after try block ends
			String sql = "select * from ?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, "car");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cars.add(new Car(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7)));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars; 
	}

	public List<Car> findSome(Integer i){
		List<Car> cars = new ArrayList<>(); //this prevents nullpointerexceptions by passing an empty list at the very least
		try(Connection conn = PTConnUtil.getInstance().getConnection()){ //connection will auto close after try block ends
			String sql = "select * from car where userId = ?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cars.add(new Car(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7)));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars; 
	}
	
	@Override
	public Car findById(Integer i) {
		Car c = null;
		
		try(Connection conn = PTConnUtil.getInstance().getConnection()){
			String sql = "select * from car where carId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				c = new Car(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public Car update(Car t) {
		
		try(Connection conn = PTConnUtil.getInstance().getConnection()){
			String sql = "update car set (make, model, color, carYear, listPrice, userId) = (?,?,?,?,?,?) where carId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getMake());
			ps.setString(2, t.getModel());
			ps.setString(3, t.getColor());
			ps.setInt(4, t.getYear());
			ps.setInt(5, t.getListPrice());
			ps.setInt(6, t.getUserId());
			ps.setInt(7, t.getCarId());
			int updated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return t;
	}

	@Override
	public Car create(Car t) {
		
		try(Connection conn = PTConnUtil.getInstance().getConnection()){
			String sql = "insert into car (make, model, color, carYear, listPrice, userid) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getMake());
			ps.setString(2, t.getModel());
			ps.setString(3, t.getColor());
			ps.setInt(4, t.getYear());
			ps.setInt(5, t.getListPrice());
			ps.setInt(6, t.getUserId());
			int inserted = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return t;
	}

	@Override
	public int delete(Integer i) {
		
		try(Connection conn = PTConnUtil.getInstance().getConnection()){
			String sql = "delete from car where carId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			int deleted = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
		return 1;
	}

}
