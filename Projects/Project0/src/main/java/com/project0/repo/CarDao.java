package com.project0.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project0.config.EnvironmentConnectionUtil;
import com.project0.enums.CarName;
import com.project0.models.Car;

public class CarDao implements DaoContract<Car,Integer>{

	@Override
	public List<Car> findAll() {
		List<Car> cars = new ArrayList<Car>();
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from cars;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int carID = rs.getInt(1);
				String carName = rs.getString(2);
				cars.add(new Car(CarName.valueOf(carName), carID));
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
		Car car = null;
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from cars where CarID = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int carID = rs.getInt(1);
				String carName = rs.getString(2);
				car= new Car(CarName.valueOf(carName), carID);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return car;
	}

	//maybe add methods to apply to either offers or payments as well? 
	@Override
	public Car update(Car t) {
		Car car = t;
		int carID = t.getCarID();
		String carName = t.getName().toString();
		
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "update cars set CarName = ? where CarID = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, carName);
			ps.setInt(2, carID);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return car;
	}

	@Override
	public Car create(Car t) {
		Car car = t;
		String carName = t.getName().toString();
		int carID = 0;
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "insert into cars (CarName) values (?);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, carName);
			ps.executeUpdate();
			//getting the new carID
			sql = "select max(carID) from cars;";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				carID = rs.getInt(1);
			}
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		car = new Car(t.getName(), carID);
		return car;
	}

	@Override
	public int delete(Integer i) {
		int result = 0;
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "delete from cars where CarID = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			result = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

/*	public List<Car> findMine(int userID) {
		List<Car> cars = new ArrayList<Car>();
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from cars where userID = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int carID = rs.getInt(1);
				String carName = rs.getString(2);
				cars.add(new Car(CarName.valueOf(carName), carID));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}
*/	

}
