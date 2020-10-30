package com.web.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.web.model.MonsterType;
import com.web.util.ConnectionUtil;

public class MonsterTypeDao implements DaoContract<MonsterType, Integer> {

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
		return 0;
	}

	@Override
	public int create(MonsterType t) {
<<<<<<< HEAD
		int result = 0;
		try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "insert into monster_type (type, fur, paws) values (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getType());
			ps.setBoolean(2, t.isFurry());
			ps.setBoolean(3, t.isPaws());
			result = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
||||||| 9817e6de
		// TODO Auto-generated method stub
		return 0;
=======
		int result = 0;
		try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "insert into monster_type (type, fur, paws) values (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getType());
			ps.setBoolean(2, t.isFurry());
			ps.setBoolean(3, t.isPaws());
			result = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
>>>>>>> 9ca05587b685d91cfb74715f39a948bd3cfb10b7
	}

	@Override
	public int delete(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MonsterType findByName(String name) {
<<<<<<< HEAD
		MonsterType mt = new MonsterType();
		try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from monster_type where type=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("in the name while");
				mt.setId(rs.getInt(1));
				mt.setType(rs.getString(2));
				mt.setFurry(rs.getBoolean("fur"));
				mt.setPaws(rs.getBoolean("paws"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mt;
||||||| 9817e6de
		// TODO Auto-generated method stub
		return null;
=======
		MonsterType mt = new MonsterType();
		try (Connection conn = ConnectionUtil.getInstance().getConnection()) {
			String sql = "select * from monster_type where type = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			mt.setId(rs.getInt(1));
			mt.setType(rs.getString(2));
			mt.setFurry(rs.getBoolean("fur"));
			mt.setPaws(rs.getBoolean("paws"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mt;

>>>>>>> 9ca05587b685d91cfb74715f39a948bd3cfb10b7
	}

}
