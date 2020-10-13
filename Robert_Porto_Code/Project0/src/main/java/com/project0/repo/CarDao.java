package com.project0.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.project0.config.FileConnectionUtil;
import com.project0.model.Car;

public class CarDao implements DaoContract<Car, Integer> {

	static Logger log = Logger.getLogger(CarDao.class);

	@Override
	public List<Car> findAll() {
		List<Car> cars = new LinkedList<>();
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from car";
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				cars.add(new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(6),
						rs.getInt(7)));

			}
			rs.close();
			s.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}

	@Override
	public Car findById(Integer i) {
		Car c = null;
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from car where id = ?"; // this will sanitize the input
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(6), rs.getInt(7));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Car update(Car t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car create(Car t) {
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "insert into car (make, model, year, balance, orig_price) values (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getMake());
			ps.setString(2, t.getModel());
			ps.setInt(3, t.getYear());
			ps.setInt(4, t.getPrice());
			ps.setInt(5, t.getBalance());
			int updated = ps.executeUpdate();
			log.info("car created" + t.toString());
		} catch (SQLException e) {
			log.error("Error while creating car: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
		return t;
	}

	@Override
	public int delete(Integer i) {
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "delete from car where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			int rs = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	public List<Car> findAvailableCars() {
		List<Car> cars = new LinkedList<>();
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from show_available_cars();";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				cars.add(new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(6),
						rs.getInt(7)));

			}
			rs.close();
			s.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}

	public List<Car> findCarsByOwnerId(Integer i) {
		List<Car> cars = new LinkedList<>();
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from car where owner_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cars.add(new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(6),
						rs.getInt(7)));

			}
			rs.close();
			s.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}

	public int addCusToCar(Integer cusId, Integer carId) {
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "update car set owner_id = ? where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cusId);
			ps.setInt(2, carId);

			int updated = ps.executeUpdate();
			ps.close();
			s.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	public List<Car> findAllCarsWithBalance(Integer cusId) {
		List<Car> cars = new LinkedList<>();
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
//			Statement s = conn.createStatement();
			String sql = "select * from car where owner_id = ? and balance > 0";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cusId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cars.add(new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(6),
						rs.getInt(7)));

			}
			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}

	public List<Car> findAllCarsWithBalance() {
		List<Car> cars = new LinkedList<>();
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
//			Statement s = conn.createStatement();
			String sql = "select * from car where owner_id is not null and balance > 0";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cars.add(new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(6),
						rs.getInt(7)));

			}
			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}

	public int makePayment(Integer carId, Integer amount) {
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
//			Statement s = conn.createStatement();
			String sql = "update car set balance = (balance - ?) where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, amount);
			ps.setInt(2, carId);
			int updated = ps.executeUpdate();

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

}
