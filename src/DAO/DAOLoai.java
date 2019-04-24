/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.CFConnection;
import Entity.Loai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DAOLoai {
    CFConnection cfconn;
    Connection conn;
    public DAOLoai(CFConnection cfconn)   {
        this.cfconn = cfconn;
        this.conn=cfconn.getConn();
    }
    
    public int addLoai(Loai l){
        int n = 0;
        String sql = "insert into tbl_Loai(MaLoai, TenLoai) values ('"+ l.getMaloai() +"','"+ l.getTenloai() +"')";
        try {
            Statement statement =  conn.createStatement();
            n = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            return 0;
        }
        return n;
    }
    
    public int updateLoai(Loai l){
        int n = 0;
        String sql = "update tbl_Loai set TenLoai =? where MaLoai =?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, l.getTenloai());
            preparedStatement.setString(2, l.getMaloai());
            n = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public int removeLoai(String maLoai){
        int n = 0;
        String sql = "delete from tbl_Loai where MaLoai = '"+ maLoai +"'";
        try {
            Statement statement = conn.createStatement();
            n = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public ArrayList <Loai> searchLoai(String ma){
        ArrayList <Loai> loai = new ArrayList<>();
        String sql = "SELECT * FROM tbl_Loai where MaLoai like '%"+ ma +"%'";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String maLoai = resultSet.getString("MaLoai");
                String tenLoai = resultSet.getString("TenLoai");
                loai.add(new Loai(maLoai, tenLoai));
            }
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return loai;
    }
    
    public ArrayList <Loai> displayAll(){
        ArrayList <Loai> loai = new ArrayList<>();
        String sql = "SELECT * FROM tbl_Loai";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String maLoai = resultSet.getString("MaLoai");
                String tenLoai = resultSet.getString("TenLoai");
                loai.add(new Loai(maLoai, tenLoai));
            }
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return loai;
    }
    public static void main(String[] args) {
        CFConnection conn = new CFConnection();
        DAOLoai dl = new DAOLoai(conn);
        System.out.println(dl.removeLoai("L02"));
    }
}
