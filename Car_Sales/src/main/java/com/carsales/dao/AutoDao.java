package com.carsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.carsales.model.Auto;
import com.carsales.util.ConnectionUtil;

public class AutoDao {
	
	public AutoDao() {
		super();
	}
	
	public int addAuto(Auto a)
	{
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement add = conn.prepareStatement("insert into carlot_schema.auto_lot (c_year, c_make, c_model, c_milage, c_price) "
					+ "values (?, ?, ?, ?, ?);");
			add.setInt(1, a.getYear());
			add.setString(2, a.getMake());
			add.setString(3, a.getModel());
			add.setInt(4, a.getMileage());
			add.setInt(5, a.getPrice());
			if(!add.execute())
				return 1;
			
			add.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
		
	}
	
	public List<Auto> getAllAuto()
	{
		List<Auto> autos = new LinkedList<>();
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement add = conn.prepareStatement("select * from carlot_schema.auto_lot");
			ResultSet rs = add.executeQuery();
			while(rs.next())
			{
				autos.add(new Auto(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7)));
			}
			
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return autos;
		
	}
	
	public List<Auto> getAutoByOwner(String own)
	{
		List<Auto> autos = new LinkedList<>();
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement add = conn.prepareStatement("select * from carlot_schema.auto_lot where \"c_owner\" = ?");
			add.setString(1, own);
			ResultSet rs = add.executeQuery();
			while(rs.next())
			{
				autos.add(new Auto(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7)));
			}
			
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return autos;
		
	}
	
	public Auto getAutoById(int id)
	{
		List<Auto> autos = new LinkedList<>();
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement add = conn.prepareStatement("select * from carlot_schema.auto_lot where \"car_id\" = ?");
			add.setInt(1, id);
			ResultSet rs = add.executeQuery();
			while(rs.next())
			{
				autos.add(new Auto(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7)));
			}
			
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//don't judge me
		return autos.get(0);
		
	}
	
	public int removeAuto(int id)
	{
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement remo = conn.prepareStatement("delete from carlot_schema.auto_lot where car_id = ?");
			remo.setInt(1,id);
			remo.execute();
			
			remo.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
		
	}
	
	public int UpdateAutoOwner(String username, int autoid, int price)
	{
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement remo = conn.prepareStatement("update carlot_schema.auto_lot set c_price = ?, c_owner= ? where car_id = ?");
			remo.setInt(1, price);
			remo.setString(2, username);
			remo.setInt(3, autoid);
			
			if(remo.execute())
			{
				return 1;
			}
			
			remo.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
		
	}
	
	//public int purchaseAuto(int id, int price, int owner)
	//{
		
	//}

}
