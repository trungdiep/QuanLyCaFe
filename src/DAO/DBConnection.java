/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DBConnection {
    private Connection conn = null;

    public DBConnection(String URL, String user, String pass) throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(URL, user, pass);
            System.out.println("connected");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public DBConnection() throws SQLException {
        this("jdbc:sqlserver://localhost:1433;databaseName=QuanLyQuanCafe", "sa", "123456");
    }
    
    public static void main(String[] args) throws SQLException {
        new DBConnection();
    }

    public Connection getConnection() {
        return conn;
    }
}
