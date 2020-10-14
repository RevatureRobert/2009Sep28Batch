package com.autos.repository.DAO;

import com.autos.repository.ConnectionSingleton;
import com.autos.repository.DAO.interfaces.UsersInterface;
import com.autos.models.User;

import java.sql.*;

public class UsersDAO implements UsersInterface {

    @Override
    public void insertUser(User u1) {
        String sql = "INSERT INTO projectzero.users (username, pw, accounttype) VALUES (?, ?, ?);";
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, u1.getUsername());
            prep.setString(2, u1.getPw());
            prep.setString(3, u1.getAccounttype());
            prep.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User selectUserByUsername(String username) {
        User user = new User();
        String sql = "SELECT username, pw, accounttype FROM projectzero.users where username = ?;";
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, username);
            ResultSet rs = prep.executeQuery();
            while (rs.next()){
                user.setUsername(rs.getString("username"));
                user.setPw(rs.getString("pw"));
                user.setAccounttype(rs.getString("accounttype"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public ResultSet selectUsersByAccounttype(String accounttype, boolean withPasswords) {
        ResultSet resultSet = null;
        String sql = "";
        if (withPasswords) { sql = "select * from projectzero.users where accounttype = ?;"; }
        else { sql = "select username from projectzero.users where accounttype = ?;"; }
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, accounttype);
            resultSet = prep.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public int selectCountByUsernameAndPw(String username, String pw) {
        String sql = "select count(*) from projectzero.users where username = ? and pw = ?;";
        int numUsers = 0;
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, username);
            prep.setString(2, pw);
            ResultSet resultSet = prep.executeQuery();
            while (resultSet.next()) {
                numUsers = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numUsers;
    }

    @Override
    public void deleteUser(String username) {
        String sql = "select projectzero.delete_user_from_users_and_offers(?);";
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, username);
            prep.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


















