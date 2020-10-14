package com.project.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.project.config.PlainTextConnectionUtil;
import com.project.model.Offer;
import com.project.ui.Printers;

public class MoneyDAO implements DAOContract<Offer, Integer> {
	
	final static Logger logger = Logger.getLogger(MoneyDAO.class);

	@Override
	public List<Offer> findAll() {
		List<Offer> offers = new LinkedList<Offer>();
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from \"carDealership\".offer where owed=false";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				offers.add(new Offer(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			logger.error("Possible connection issue?");
		}
		return offers;
	}
	
	public List<Offer> findAllOwed() {
		List<Offer> offers = new LinkedList<Offer>();
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from \"carDealership\".offer where owed=true";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				offers.add(new Offer(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			logger.error("Possible connection issue?");
		}
		return offers;
	}

	@Override
	public Offer findById(Integer i) {
		Offer o = null;
		try(Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from \"carDealership\".offer where offer_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				o = new Offer(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			logger.error("Possible connection issue?");
		}
		return o;
	}
	
	// Falls outside of the DAOContract, but used to show an offer has become an owed payment
	public Offer offerBecomesOwed(Offer t) {
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			String sql = "update \"carDealership\".offer set owed=true where offer_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getOfferId());
			int updated = ps.executeUpdate();
			updated += updated;
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return t;
	}
	
	// Falls outside of the DAOContract, but finds the amount a specific customer owes
	public List<Offer> amountOwed(Integer i) {
		List<Offer> offers = new LinkedList<>();
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from \"carDealership\".offer where owed=true and cust_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				offers.add(new Offer(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return offers;
	}

	public int makePayment(Integer x, Integer y) {		// for making a payment
		int updated = 0;
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			String sql = "update \"carDealership\".offer set offer = (offer-?) where offer_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, x);
			ps.setInt(2, y);
			updated = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Error while making payment");
			Printers.invalid("duplicate");
			return updated;
		}
		return updated;
	}
	
	@Override
	public Offer create(Offer t) {
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			String sql = "insert into \"carDealership\".offer (cust_id, car_id, offer) values (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getCustomerId());
			ps.setInt(2, t.getCarId());
			ps.setInt(3, t.getOfferAmount());
			int updated = ps.executeUpdate();
			updated += updated;
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return t;
	}

	@Override
	public int delete(Integer i) {
		try (Connection conn = PlainTextConnectionUtil.getInstance().getConnection()) {
			String sql = "delete from \"carDealership\".offer where offer_id=? and owed=false";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			int updated = ps.executeUpdate();
			updated += updated;
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int update(Offer t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
