package com.example.cake;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    public static Connection getConnection() {
        Connection con = null;
        try{
            String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=CakeData;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String password = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e) {
            System.out.println("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=CakeData;encrypt=true;trustServerCertificate=true");
            System.out.println("Error: ##############");
            e.printStackTrace();
        }
        return con;
    }
}
