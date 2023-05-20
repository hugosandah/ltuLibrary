package com.example.ltulibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    static Connection conn = null;
    private static Statement st = null;

    public static Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ltuLibrarySql"; // Replace with your database URL
        String username = "root"; // Replace with your MySQL username
        String password = "T3ams0t1s!"; // Replace with your MySQL password

        // Establishing the connection
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");
            st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public Connection getConnection() {
        return conn;
    }
}
