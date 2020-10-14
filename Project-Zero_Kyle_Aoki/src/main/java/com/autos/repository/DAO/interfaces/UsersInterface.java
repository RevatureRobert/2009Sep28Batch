package com.autos.repository.DAO.interfaces;

import com.autos.models.User;

import java.sql.ResultSet;

public interface UsersInterface {
    
    void insertUser(User u1);

    void deleteUser(String username);

    User selectUserByUsername(String username);

    ResultSet selectUsersByAccounttype(String accounttype, boolean withPasswords);

    int selectCountByUsernameAndPw(String username, String pw);
    
}
