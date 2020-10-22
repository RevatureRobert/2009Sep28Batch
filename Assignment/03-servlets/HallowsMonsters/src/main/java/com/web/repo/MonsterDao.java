package com.web.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.web.model.Monster;
import com.web.model.MonsterType;
import com.web.util.ConnectionUtil;

public class MonsterDao implements DaoContract<Monster,Integer>{

	@Override
	public List<Monster> findAll() {
		List<Monster> monsters = new LinkedList<>();
		String sql = "select * from complete_monsters;";
		try(Connection conn = ConnectionUtil.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MonsterType mt = new MonsterType();
				mt.setType(rs.getString("mtype"));
				mt.setFurry(rs.getBoolean("fur"));
				mt.setPaws(rs.getBoolean("paws"));
				monsters.add(new Monster(0,rs.getString("name"), mt));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return monsters;
	}

	@Override
	public Monster findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Monster t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int create(Monster t) {
		int x = 0;
		try(Connection con = ConnectionUtil.getInstance().getConnection()){
			String sql = "insert into monster (name, monster_type) values (?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getName());
			ps.setInt(2, new MonsterTypeDao().findByName(t.getType().getType()).getId());
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
	public Monster findByName(String name) {
		Monster m = null;
		String sql = "select * from complete_monsters where name = ?;";
		try(Connection conn = ConnectionUtil.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				MonsterType mt = new MonsterType();
				mt.setType(rs.getString("mtype"));
				mt.setFurry(rs.getBoolean("fur"));
				mt.setPaws(rs.getBoolean("paws"));
				m = new Monster(0,rs.getString("name"), mt);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

}
