package com.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

    Connection connection;

    public Connection getCon() {
        try {
            String dbDriver = "com.mysql.cj.jdbc.Driver";
            String dbURL = "jdbc:mysql://127.0.0.1:3306/lab2";
            String dbUsername = "admin";
            String dbPassword = "123456";

            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbURL + "?" + "user=" + dbUsername + "&"
                    + "password=" + dbPassword);
            System.out.println("connected");
        } catch (ClassNotFoundException e) { // 
            System.out.println("Driver not found " + e);
        } catch (SQLException e) {
            System.out.println("Connect not possible" + e);
        }
        return connection;
    }
}
