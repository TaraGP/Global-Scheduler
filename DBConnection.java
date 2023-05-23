package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException{
        String url="jdbc:postgresql://localhost:5432/caseSchedule";
        String username="example ";
        String password="password";
        return DriverManager.getConnection(url,username,password);
    }
}
