package com.web.repo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.web.util.ConnectionUtil;

public class ImageDao implements DaoContract<File, String>{

	@Override
	public List<File> findAll() {
		return null;
	}

	@Override
	public File findById(String i) {
		return null;
	}

	@Override
	public int update(File t) {
		return 0;
	}

	@Override
	public int create(File file) {
		try(Connection conn = ConnectionUtil.getInstance().getConnection()){
			FileInputStream fis = new FileInputStream(file);
			String sql = "insert into testing values (?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, file.getName());
			ps.setBinaryStream(2, fis,file.length());
			int x = ps.executeUpdate();
			ps.close();
			return x;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(String i) {
		return 0;
	}

	@Override
	public File findByName(String name) {
		File file = new File("C:\\Users\\enocho\\Desktop\\Revature Project\\2009Sep28Batch\\Assignment\\03-servlets\\HallowsMonsters\\src\\main\\webapp\\html\\img.jpg");
		try(Connection conn = ConnectionUtil.getInstance().getConnection()){
			file.createNewFile();
			String sql = "select img from testing where imgname = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				byte[] imgBytes = rs.getBytes("img");
				OutputStream os = new FileOutputStream(file);
				os.write(imgBytes);
				os.close();
			}
			ps.close();
			return file;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
