package com.web.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.web.model.MonsterType;
import com.web.util.ConnectionUtil;

public class MonsterTypeDao implements DaoContract<MonsterType,Integer>{

	@Override
	public List<MonsterType> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MonsterType findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(MonsterType t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int create(MonsterType t) {
		int x = 0;
		try(Connection con = ConnectionUtil.getInstance().getConnection()){
			String sql = "insert into monster_type (type, fur,paws) values (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getType());
			ps.setBoolean(2, t.isFurry());
			ps.setBoolean(3, t.isPaws());
			x = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public int delete(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MonsterType findByName(String name) {
		MonsterType mt = new MonsterType();
		try(Connection con = ConnectionUtil.getInstance().getConnection()){
			String sql = "select * from monster_type where type = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt(1);
				mt.setId(rs.getInt(1));
				mt.setType(rs.getString(2));
				mt.setFurry(rs.getBoolean(3));
				mt.setPaws(rs.getBoolean(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mt;
	}

}
