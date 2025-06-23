package com.gsd.daw.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    public static Connection getConnection(String ip, String instance, String user, String password) throws SQLException {
    	String url = "jdbc:oracle:thin:@//" + ip + ":1521/" + instance;
        return DriverManager.getConnection(url, user, password);
    }
}