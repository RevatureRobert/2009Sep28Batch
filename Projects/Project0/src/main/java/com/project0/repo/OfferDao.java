package com.project0.repo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.project0.config.EnvironmentConnectionUtil;
import com.project0.models.Offer;

public class OfferDao implements DaoContract<Offer,Integer> {
	final static Logger log = Logger.getLogger(UserDao.class);
	
	public OfferDao() {
		
	}

	@Override
	public List<Offer> findAll() {
		List<Offer> offers = new ArrayList<Offer>();
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from offers;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int offerid = rs.getInt(1);
				int userid = rs.getInt(2);
				int carid = rs.getInt(3);
				double amount = rs.getDouble(4);
				offers.add(new Offer(offerid,userid,carid,amount));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			log.error("There was a sql exception:" + e);
			e.printStackTrace();
		}
		return offers;
	}

	@Override
	public Offer findById(Integer i) {
	Offer x = null;
	try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
		String sql = "select * from offers where OfferID = ?;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, i);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			int offerid = rs.getInt(1);
			int userid = rs.getInt(2);
			int carid = rs.getInt(3);
			double amount = rs.getDouble(4);
			x= new Offer(offerid,userid,carid,amount);
		}
		rs.close();
		ps.close();
		
	} catch (SQLException e) {
		log.error("There was a sql exception:" + e);
		e.printStackTrace();
	}
		return x;
	}

	@Override
	public Offer update(Offer t) {
		Offer x = t;
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "update offers set amount = ? where OfferID = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, x.getAmount());
			ps.setInt(2, x.getOfferID());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			log.error("There was a sql exception:" + e);
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public Offer create(Offer t) {
	Offer x = t;
	try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
		String sql = "insert into offers (CustomerID,CarID,amount) values (?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,x.getPersonID());
		ps.setInt(2, x.getCarID());
		ps.setDouble(3,x.getAmount());
		ps.executeUpdate();
		ps.close();
		//getting new id
		sql = "select * from offers order by OfferID desc limit 1;";
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			x = new Offer(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getDouble(4));
		}
	} catch (SQLException e) {
		log.error("There was a sql exception:" + e);
		e.printStackTrace();
	}
		return x;
	}

	@Override
	public int delete(Integer i) {
		int result = 0;
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "delete from offers where OfferID = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,i);
			result = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			log.error("There was a sql exception:" + e);
			e.printStackTrace();
		}
		return result;
	}
	
	//gets the car ids of the cars on the lot
	public ArrayList<Integer> getCarIDs(){
		ArrayList<Integer> ids = new ArrayList<Integer>();
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select distinct CarID from offers where Approved is null;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ids.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			log.error("There was a sql exception:" + e);
			e.printStackTrace();
		}
		return ids;
	}//end of getCarIds
	
	//finds current offers
	public List<Offer> findAllCurrent() {
		List<Offer> offers = new ArrayList<Offer>();
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from offers where Approved is null;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int offerid = rs.getInt(1);
				int userid = rs.getInt(2);
				int carid = rs.getInt(3);
				double amount = rs.getDouble(4);
				offers.add(new Offer(offerid,userid,carid,amount));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			log.error("There was a sql exception:" + e);
			e.printStackTrace();
		}
		return offers;
	}//end of findAllCurretn

	public void approveOffer(Offer t) {
		Offer x = t;
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			//this calls a stored procedure to approve the offer
			String sql = "call approve(?)";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, t.getOfferID());
			cs.execute();
		} catch (SQLException e) {
			log.error("There was a sql exception:" + e);
			e.printStackTrace();
		}
	}

	public void rejectOffer(Offer t) {
		Offer x =t;
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			//this calls a stored procedure to approve the offer
			String sql = "delete from offers where carid = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, x.getCarID());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error("There was a sql exception:" + e);
			e.printStackTrace();
		}
	}

	// this will get all the offers of a specific customer
	public ArrayList<Offer> getOffersbyId(int id) {
		List<Offer> offers = new ArrayList<Offer>();
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select * from offers where CustomerID = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int offerid = rs.getInt(1);
				int userid = rs.getInt(2);
				int carid = rs.getInt(3);
				double amount = rs.getDouble(4);
				offers.add(new Offer(offerid,userid,carid,amount));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			log.error("There was a sql exception:" + e);
			e.printStackTrace();
		}
		return (ArrayList<Offer>) offers;
	}
}//end of OfferDao class
