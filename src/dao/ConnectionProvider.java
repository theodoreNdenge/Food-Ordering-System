/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionProvider {
    private static final Logger LOGGER = Logger.getLogger(ConnectionProvider.class.getName());

    private ConnectionProvider() {
        throw new IllegalStateException("Utility class");
    }

public static Connection getCon() {
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String username = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");

        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fos", username, password);
    }
    catch(ClassNotFoundException | java.sql.SQLException e){
        LOGGER.log(Level.SEVERE, "Failed to create database connection", e);
        return null;
    }
}
}


