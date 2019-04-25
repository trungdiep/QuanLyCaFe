/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.CFConnection;
import Entity.CTHDB;
import Entity.HDB;
import java.sql.Array;
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
 * @author MSI
 */
public class DAOCTHDB {
    CFConnection cfconn;
    Connection conn;

    public DAOCTHDB(CFConnection cfconn) {
        this.cfconn = cfconn;
        conn = cfconn.getConn();
    }
    public int addCTDHB(CTHDB ct)  {
        int n  = 0;
        String sql = "insert into tbl_CTHDB (MaSanPham,TenSanPham,SoLuong,ThanhTien) values (?,?,?,?)";
        PreparedStatement pre;
        try {
            pre  = conn.prepareStatement(sql);
            pre.setString(1,ct.getMasp());
            pre.setString(2,ct.getTensp());
            pre.setInt(3,ct.getSoluong());
            pre.setDouble(4,ct.getThanhtien());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCTHDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public int updateCTHDB(CTHDB hdb)   {
        int n = 0;
        String sql = "update tbl_CTHDB set MaSanPham = ?, TenSanPham = ?,  SoLuong = ?, ThanhTien = ? "
                + " where MaHoaDonBan =?";
        PreparedStatement pre ;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1,hdb.getMasp());
            pre.setString(2,hdb.getTensp());
            pre.setInt(3,hdb.getSoluong());
            pre.setDouble(4,hdb.getThanhtien());
            pre.setString(5,hdb.getMahdb());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCTHDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public int removeCTHDB(String mahd) {
        int n =0;
        String sql = "delete from tbl_CTHDB where MaHoaDonBan = ?";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1,mahd);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCTHDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public ResultSet thongke (String start, String end) {
        //ArrayList <CTHDB> arr = new ArrayList<>();
        String sql = "select tbl_CTHDB.MaHoaDonBan, MaSanPham , TenSanPham , SoLuong , ThanhTien from tbl_CTHDB inner join tbl_HoaDonBan on tbl_CTHDB.MaHoaDonBan = tbl_HoaDonBan.MaHoaDonBan where NgayBan between '"+start+"' and '"+end+"'";
        ResultSet rs = null;
        try {
            Statement stm = conn.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCTHDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  rs;
    }
    public ResultSet displayAll()   {
        String sql = "select * from tbl_CTHDB ";
        ResultSet rs  = null;
        try {
            Statement stm = conn.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCTHDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public static void main(String[] args) throws SQLException {
        CFConnection conn = new CFConnection();
        DAOCTHDB dct = new DAOCTHDB(conn);
        CTHDB ct = new  CTHDB("SP001", "computrino",1,77000.0);
        System.out.println(dct.addCTDHB(ct));
        //System.out.println(dct.updateCTHDB(ct));
        //System.out.println(dct.removeCTHDB("HD01"));
       // ResultSet rs = dct.thongke("2019/04/23", "2019/04/24");
        ///while(rs.next())    {
        //    System.out.println(rs.getString(1)+"-"+rs.getString(2)+"-"+rs.getString(3)+"-"+rs.getInt(4)+"-"+rs.getDouble(5));
        //}
        
      
        
    }

    boolean addCTDHB(HDB hd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
