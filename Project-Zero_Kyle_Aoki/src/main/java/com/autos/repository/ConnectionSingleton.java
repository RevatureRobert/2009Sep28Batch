package com.autos.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionSingleton {

    private static ConnectionSingleton connsing;
    private final Connection conn;

    public ConnectionSingleton() { this.conn = this.createDatabaseConnection(); }

    public Connection getConn() { return conn; }

    public static ConnectionSingleton getInstance(){
        if (connsing == null){
            connsing = new ConnectionSingleton();
        }
        return connsing;
    }

    private Connection createDatabaseConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(this.getURL());
        } catch (SQLException e) {
            System.out.println("Check Internet Connection (?)");
        }
        return conn;
    }

    public String getURL(){
        String connPropsFilepath = "connection.properties";
        String URL = null;
        try {
            Properties prop = new Properties();
            InputStream is = getClass().getClassLoader().getResourceAsStream(connPropsFilepath);
            if (is != null){
                prop.load(is);
            } else {
                throw new FileNotFoundException("File Not Found");
            }
            URL = prop.getProperty("URL");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return URL;
    }

}
