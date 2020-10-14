
package com.autos.repository.DAO.interfaces;

import java.sql.ResultSet;

public interface SoldInterface {
    ResultSet selectSoldCarsByUsername(String username);
    ResultSet selectSoldCarsBySoldId(String sold_id);
    ResultSet selectSoldCarsByUsernameAndSoldId(String username, String sold_id);
}
