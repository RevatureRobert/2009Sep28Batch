package com.autos.service;

import com.autos.repository.DAO.UsersDAO;
import com.autos.models.User;
import com.autos.utility.Utils;

import java.sql.ResultSet;


public class UsersService {

    private final UsersDAO ud = new UsersDAO();

    public void insertUser(User u1){ ud.insertUser(u1); }

    public void deleteUser(String username){  ud.deleteUser(username); }

    public boolean doesUserExist(String username){
        User user = ud.selectUserByUsername(username);
        return user.getUsername() != null;
    }

    public User getUser(String username){ return ud.selectUserByUsername(username); }

    public void viewAllEmployees(){
        ResultSet resultSet = ud.selectUsersByAccounttype("Employee", true);
        Utils.printTable(resultSet);
    }

    public boolean validateUser(String username, String pw) {
        int numUsers = ud.selectCountByUsernameAndPw(username, pw);
        if (numUsers == 1) { return true; }
        else if (numUsers == 0) { return false; }
        else {
            System.out.println("Something has gone SERIOUSLY wrong.");
            System.exit(-666);
        }
        return false;
    }
    
    public void viewAllCustomers() {
        ResultSet resultSet = ud.selectUsersByAccounttype("Customer", false);
        Utils.printTable(resultSet);
    }

}
