/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.CFConnection;
import Entity.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DAOKhachHang {

    CFConnection cfconn;
    Connection conn;

    public DAOKhachHang(CFConnection cfconn) {
        this.cfconn = cfconn;
        conn = cfconn.getConn();
    }

    public int addKhachHang(KhachHang kh) {
        int n = 0;
        String sql = "insert into tbl_KhachHang (MaKhachHang,TenKhachHang,Sdt) values(?,?,?)";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, kh.getMakh());
            pre.setString(2, kh.getTenkh());
            pre.setString(3, kh.getSdt());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
           Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE,null,ex);
        }
        return n;
    }

    public int updateKhachHang(KhachHang kh) {
        int n = 0;

        String sql = "update tbl_KhachHang set TenKhachHang = ?, Sdt = ? where MaKhachHang = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, kh.getTenkh());
            preparedStatement.setString(2, kh.getSdt());
            preparedStatement.setString(3, kh.getMakh());
            n = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateTenKhachHang(String maKhachHang, String tenKhachHang) {
        int n = 0;
        String sql = "update tbl_KhachHang set TenKhachHang = " + tenKhachHang + " where MaKhachHang = maKhachHang";
        try {
            Statement statement = conn.createStatement();
            n = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateSdt(String maKhachHang, String sdt) {
        int n = 0;
        String sql = "update tbl_KhachHang set Sdt = " + sdt + " where MaKhachHang = maKhachHang";
        try {
            Statement statement = conn.createStatement();
            n = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public int removeKhachHang(String maKhachHang){
        int n = 0;
        String sql = "delete from tbl_KhachHang where MaKhachHang = '"+ maKhachHang +"'";
        try {
            Statement statement = conn.createStatement();
            n = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public ResultSet displayAll(){
        String sql=" select * from tbl_KhachHang";
        ResultSet resultSet = null;
        try {
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet display()  {
        String sql=" select TenKhachHang from tbl_KhachHang";
        ResultSet resultSet = null;
        try {
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException ex) {
           Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE,null,ex);
        }
    return resultSet;
    }
    public static void main(String[] args) throws SQLException {
        CFConnection conn = new CFConnection();
        DAOKhachHang daokh = new DAOKhachHang(conn);
        KhachHang khach = new KhachHang("KH02","0334031515","Diep Van Trung");
        System.out.println(daokh.addKhachHang(khach));
    }

    public int addKhachHang(Tabs.KH kh) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int updateKhachHang(Tabs.KH kh) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
}
