/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.CFConnection;
import Entity.CTHDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        String sql = "insert into tbl_CTHDB (MaHoaDonBan,MaSanPham,TenSanPham,SoLuong,ThanhTien) values (?,?,?,?,?)";
        PreparedStatement pre;
        try {
            pre  = conn.prepareStatement(sql);
            pre.setString(1,ct.getMahdb());
            pre.setString(2,ct.getMasp());
            pre.setString(3,ct.getTensp());
            pre.setInt(4,ct.getSoluong());
            pre.setDouble(5,ct.getThanhtien());
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
    public static void main(String[] args) {
        CFConnection conn = new CFConnection();
        DAOCTHDB dct = new DAOCTHDB(conn);
        CTHDB ct = new  CTHDB("HD01","SP01", "computrino",1,77000.0);
        System.out.println(dct.updateCTHDB(ct));
        //System.out.println(dct.removeCTHDB("HD01"));
    }
}
