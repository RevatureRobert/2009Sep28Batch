package com.carsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.carsales.model.Auto;
import com.carsales.model.Offer;
import com.carsales.util.ConnectionUtil;

public class OfferDao {
	
	public OfferDao() {
		super();
	}
	
	public int addOffer(Offer off)
	{
		
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement add = conn.prepareStatement("insert into carlot_schema.offers_tab (car_id, user_id, username_t, o_amount) "
					+ "values (?, ?, ?, ?);");
			add.setInt(1, off.getCar_id());
			add.setInt(2, off.getUser_id());
			add.setString(3, off.getUsername());
			add.setInt(4, off.getAmount());
			if(!add.execute())
				return 1;
			
			add.close();
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return -1;
	}
	
	public List<Offer> getAllOffer()
	{
		List<Offer> offers = new LinkedList<>();
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement add = conn.prepareStatement("select * from carlot_schema.offers_tab");
			ResultSet rs = add.executeQuery();
			while(rs.next())
			{
				offers.add(new Offer(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
			}
			
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return offers;
		
	}
	
	public int removeOffer(int id)
	{
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement remo = conn.prepareStatement("delete from carlot_schema.offers_tab where offer_id = ?");
			remo.setInt(1,id);
			remo.execute();
			
			remo.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
		
	}
	
	

}
