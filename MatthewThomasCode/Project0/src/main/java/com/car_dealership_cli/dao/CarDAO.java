package com.car_dealership_cli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.car_dealership_cli.model.Car;

import com.car_dealership_cli.repo.DAOContract;
import com.car_dealership_cli.repo.DAOUtilities;

public class CarDAO implements DAOContract<Car, Integer> {

	
	public Map<Integer,Car> findMapAll() {
		Connection con = DAOUtilities.getConnection();
		Map<Integer,Car> carList = new TreeMap<Integer,Car>();
		String sql = "select * from car where car_owner = 0;"; 
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Car tempUser = new Car(rs.getInt("car_id"),rs.getString("make"),rs.getString("model"),rs.getInt("car_year"),rs.getDouble("msrp"));
				
				carList.put(tempUser.getCarId(), tempUser);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(carList.get(1));
		return carList;
	}
	public Map<Integer,Car> findMapUser(int in) {
		Connection con = DAOUtilities.getConnection();
		Map<Integer,Car> carList = new TreeMap<Integer,Car>();
		String sql = "select * from car where car_owner = ?;"; 
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, in);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Car tempUser = new Car(rs.getInt("car_id"),rs.getString("make"),rs.getString("model"),rs.getInt("car_year"),rs.getDouble("msrp"));
				tempUser.setDebt(rs.getDouble("debt"));
				tempUser.setPrinciple(rs.getDouble("principle"));
				tempUser.setPayment(rs.getDouble("payment"));
				
				carList.put(tempUser.getCarId(), tempUser);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(carList.get(1));
		return carList;
	}
	public Map<Integer,Car> findMapDebtors() {
		Connection con = DAOUtilities.getConnection();
		Map<Integer,Car> carList = new TreeMap<Integer,Car>();
		String sql = "select * from car where car_owner != 0;"; 
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Car tempUser = new Car(rs.getInt("car_id"),rs.getString("make"),rs.getString("model"),rs.getInt("car_year"),rs.getDouble("msrp"));
				
				carList.put(tempUser.getCarId(), tempUser);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(carList.get(1));
		return carList;
	}
	public Map<Integer,Car> findMapAll(int i) {
		Connection con = DAOUtilities.getConnection();
		Map<Integer,Car> carList = new TreeMap<Integer,Car>();
		String sql = "select * from car where car_owner = ?;"; 
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, i);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Car tempUser = new Car(rs.getInt("car_id"),rs.getString("make"),rs.getString("model"),rs.getInt("car_year"),rs.getDouble("msrp"));
				carList.put(tempUser.getCarId(), tempUser);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carList;
		
	}
	@Override
	public Car findById(Integer i) {
		Connection con = DAOUtilities.getConnection();
		Car rU = new Car();
		String sql = "select * from car where car_id=?";
		UserDAO ud = new UserDAO();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, i);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				rU.setCarId(i);
				rU.setOwner(ud.findById(rs.getInt(2)));
				rU.setMake(rs.getString("make"));
				rU.setModel(rs.getString("model"));
				rU.setMSRP(rs.getDouble("msrp"));
				rU.setYear(rs.getInt("car_year"));
				rU.setPayment(rs.getDouble("payment"));
				rU.setDebt(rs.getDouble("debt"));
				rU.setPrinciple(rs.getDouble("principle"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rU;
	}

	//@Override
	public Car update(Car t, int i) {
		Connection con = DAOUtilities.getConnection();
		String sql = "update car set car_owner=?,payment=?,debt=?,principle=0 where car_id = ?;";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, i);
			stmt.setDouble(2, t.getPayment());
			stmt.setDouble(3, t.getDebt());
			stmt.setInt(4, t.getCarId());
			stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Car create(Car t) {
		Connection con = DAOUtilities.getConnection();
		
		String sql = "insert into cd.car (car_owner, make, model, car_year, msrp) values (0,?,?,?,?);";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,t.getMake());
			stmt.setString(2,t.getModel());
			stmt.setInt(3, t.getYear());
			stmt.setDouble(4, t.getMSRP());
			stmt.executeUpdate();
			//System.out.println("test "+x);
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int delete(Integer i) {
		Connection con = DAOUtilities.getConnection();
		int result = 0;
		String sql = "delete from car where car_id=?";
		//UserDAO ud = new UserDAO();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, i);
			result = stmt.executeUpdate();				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public List<Car> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Car update(Car t) {
		// TODO Auto-generated method stub
		return null;
	}

}
