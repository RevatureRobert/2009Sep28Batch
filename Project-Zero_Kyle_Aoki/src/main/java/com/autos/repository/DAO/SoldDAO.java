package com.autos.repository.DAO;

import com.autos.repository.DAO.interfaces.SoldInterface;
import com.autos.repository.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SoldDAO implements SoldInterface {

    @Override
    public ResultSet selectSoldCarsByUsername(String username) {
        ResultSet resultSet = null;
        String sql = "select * from projectzero.sold where username = ?;";
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, username);
            resultSet = prep.executeQuery();
        } catch (SQLException e) {
            e.getErrorCode();
        }
        return resultSet;
    }

    @Override
    public ResultSet selectSoldCarsBySoldId(String sold_id) {
        ResultSet resultSet = null;
        String sql = "select * from projectzero.sold where sold_id = ?;";
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setInt(1, Integer.parseInt(sold_id));
            resultSet = prep.executeQuery();
        } catch (SQLException e) {
            e.getErrorCode();
        }
        return resultSet;
    }

    @Override
    public ResultSet selectSoldCarsByUsernameAndSoldId(String username, String sold_id){
        ResultSet resultSet = null;
        String sql = "select * from projectzero.sold where username = ? and sold_id = ?;";
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, username);
            prep.setInt(2, Integer.parseInt(sold_id));
            resultSet = prep.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

}
