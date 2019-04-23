/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.CFConnection;
import Entity.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DAOSanPham {
    
   CFConnection cfconn;
    Connection conn;
    public DAOSanPham(CFConnection cfconn)   {
        this.cfconn = cfconn;
        this.conn=cfconn.getConn();
    }

    public int insertSanPham(SanPham sp) {
        int n = 0;
        String sql = "insert into tbl_SanPham(MaSanPham,TenSanPham,MaLoai,GiaBan) values(?,?,?,?)";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, sp.getMasp());
            pre.setString(2, sp.getTensp());
            pre.setString(3, sp.getMaloai());
            pre.setDouble(4, sp.getGiaban());        
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateSanPham(SanPham sp) {
        int n = 0;
        String sql = "update tbl_SanPham set TenSanPham=?, MaLoai=?, GiaBan=? Where MaSanPham= ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, sp.getTensp());
            preparedStatement.setString(2, sp.getMaloai());
            preparedStatement.setDouble(3, sp.getGiaban());
            preparedStatement.setString(4, sp.getMasp());

            n = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateTenSanPham(String maSanPham, String tenSanPham) {
        int n = 0;
        String sql = "update tbl_SanPham set TenSanPham = " + tenSanPham + " where MaSanPham = '" + maSanPham + "'";
        try {
            Statement statement = conn.createStatement();
            n = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateMaLoaiSanPham(String maSanPham, String maLoaiSanPham) {
        int n = 0;
        String sql = "update tbl_SanPham set MaLoai=" + maLoaiSanPham + " where MaSanPham ='" + maSanPham + "'";
        try {
            Statement statement = conn.createStatement();
            n = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateGiaBan(String maSanPham, double giaBan) {
        int n = 0;
        String sql = "update tbl_SanPham set GiaBan = " + giaBan + " where MaSanPham = '" + maSanPham + "'";
        try {
            Statement statement = conn.createStatement();
            n = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }



    public int removeSanPham(String maSanPham) {
        int n = 0;
        String sql = "delete from tbl_SanPham where MaSanPham= '" + maSanPham + "'";
        try {
            Statement statement = conn.createStatement();
            n = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public void displayAll(){
        String sql = "select * from tbl_SanPham";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String maSanPham = resultSet.getString("MaSanPham");
                String tenSanPham = resultSet.getString("TenSanPham");
                String maLoai = resultSet.getString("MaLoai");
                double giaBan = resultSet.getDouble("GiaBan");
                int soLuong = resultSet.getInt("SoLuong");
                SanPham sanPham = new SanPham(maSanPham, tenSanPham, maLoai, giaBan);
                System.out.println(sanPham);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public ResultSet display()  {
        String sql = "select TenSanPham from tbl_SanPham";
        ResultSet rs = null;
        try {
            Statement statement = conn.createStatement();
            rs = statement.executeQuery(sql);
        } catch (SQLException ex)  {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE,null,ex);
        }
       return rs;
    }
    public ResultSet displayPrice(String tensp)  {
        String sql = "select GiaBan from tbl_SanPham where TenSanPham = '" + tensp + "'";
        ResultSet rs = null;
        try {
            Statement statement = conn.createStatement();
            rs = statement.executeQuery(sql);
        } catch (SQLException ex)  {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE,null,ex);
        }
       return rs;
    }
    public String displayMaSP(String tensp)  {
        String sql = "select MaSanPham from tbl_SanPham where TenSanPham = '" + tensp + "'";
        String masp = null;
        ResultSet rs;
       try {
           Statement stm = conn.createStatement();
           rs = stm.executeQuery(sql);
           while(rs.next()) {
               masp = rs.getString("MaSanPham");
           }
       } catch (SQLException ex) {
           Logger.getLogger(DAOSanPham.class.getName()).log(Level.SEVERE, null, ex);
       }
        return masp;
    }
    public HashMap getHashMap() {
        String sql = "select MaSanPham,TenSanPham from tbl_SanPham ";
        HashMap<String,String> hm = new HashMap();
        
       try {
           Statement stm = conn.createStatement();
           ResultSet rs = stm.executeQuery(sql);
           while(rs.next()) {
               hm.put(rs.getString("TenSanPham"),rs.getString("MaSanPham"));
           }
       } catch (SQLException ex) {
           Logger.getLogger(DAOSanPham.class.getName()).log(Level.SEVERE, null, ex);
       }
       return hm;
    }
    public static void main(String[] args) throws SQLException {
        CFConnection conn = new CFConnection();
        DAOSanPham daosp = new DAOSanPham(conn);
        //SanPham sp = new SanPham("SP01","computrino","L01",570000.0);
        //System.out.println(daosp.insertSanPham(sp));
        System.out.println(daosp.displayMaSP("computrino"));
    }
}
