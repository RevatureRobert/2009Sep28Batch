package com.project0.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project0.config.EnvironmentConnectionUtil;
import com.project0.models.Offer;

public class OfferDao implements DaoContract<Offer,Integer> {
	
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
			// TODO Auto-generated catch block
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
		// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
		// TODO Auto-generated catch block
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
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Integer> getCarIDs(){
		ArrayList<Integer> ids = new ArrayList<Integer>();
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "select distinct CarID from offers;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ids.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ids;
	}//end of getCarIds
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return offers;
	}//end of findAllCurretn

	public Offer approveOffer(Offer t) {
		Offer x = t;
		try(Connection con = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql = "update offers set Approved = true where OfferID = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, x.getAmount());
			ps.setInt(2, x.getOfferID());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
}
