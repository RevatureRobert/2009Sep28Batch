package com.autos.utility;

import com.autos.UI.dashboards.UserContext;
import com.autos.driver.Driver;
import com.autos.repository.ConnectionSingleton;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Lr {
    
    public static Lr lr;
    private static Logger logger;
    public Lr () { logger = Logger.getLogger(Driver.class.getName()); }
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
    
    public static Lr inst(){
        if (logger == null){
            lr = new Lr();
            return lr;
        }
        return lr;
    }
    
    public void log(String logText){
        String fullLogText = "[dateTime] [username] text";
        LocalDateTime now = LocalDateTime.now();
        String currentDateTime = now.format(formatter);
        fullLogText = StringUtils.replace(fullLogText, "dateTime", currentDateTime);
        fullLogText = StringUtils.replace(fullLogText, "username", UserContext.getUser());
        fullLogText = StringUtils.replace(fullLogText, "text", logText);
        logger.debug(fullLogText);
    }

    public static void printAllLogs(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/kylea/Desktop/logger_projectzero/log.out"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void push_logs_to_DB(){
        Lr.inst().log("Pushed Logs To DB");
        String sql1 = " CALL projectzero.delete_and_recreate_logs_table() ";
        Connection conn = ConnectionSingleton.getInstance().getConn();
        try {
            CallableStatement call = conn.prepareCall(sql1);
            call.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        StringBuilder sql2 = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/kylea/Desktop/logger_projectzero/log.out"));
            String line;
            while ((line = br.readLine()) != null) {
                sql2.append("insert into projectzero.logs (log) values ('").append(line).append("');\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement prep = conn.prepareStatement(String.valueOf(sql2));
            prep.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("-----------Logs Have Been Pushed To DB-----------");
    }

}

