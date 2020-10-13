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
import com.project0.model.Bid;

public class BidDao {
	static Logger log = Logger.getLogger(CarDao.class);

	public List<Bid> findAll() {
		List<Bid> bids = new LinkedList<>();
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "select * from bid";
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				bids.add(new Bid(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));

			}
			rs.close();
			s.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bids;
	}

	public Bid findById(Integer id) {
		Bid b = null;
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from bid where id = ?"; // this will sanitize the input
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new Bid(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

//	@Override
//	public Car update(Car t) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public Bid create(Bid b) {
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "insert into bid (car_id, customer_id, amount) values (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, b.getCarId());
			ps.setInt(2, b.getCustomerId());
			ps.setInt(3, b.getAmount());
			int updated = ps.executeUpdate();
			log.info("Bid created" + b);
		} catch (SQLException e) {
			log.error("Error while creating bid: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
		return b;
	}

	public int delete(Bid b) {
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			String sql = "delete from bid where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, b.getId());
			int rs = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	public int deleteAllForCar(Integer carId) {
		try (Connection conn = FileConnectionUtil.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			String sql = "call delete_bids_for_carid( ? )";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, carId);
			int rs = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

}
