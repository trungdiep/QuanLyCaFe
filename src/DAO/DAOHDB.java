/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.CFConnection;
import Entity.HDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI
 */
public class DAOHDB {
    CFConnection cfconn;
    Connection conn;

    public DAOHDB(CFConnection cfconn) {
        this.cfconn = cfconn;
        conn = cfconn.getConn();
    }
    
    public int addHDB(HDB hd)  {
        int n = 0;
        //String sql1 = "insert into tbl_HoaDonBan (MaHoaDonBan,MaNhanVien,MaKhachHang,TongTien) values('"+hd.getMahdb()+"','"+hd.getManv()+"','"+hd.getMakh()+"',"+hd.getTongtien()+");";
        
        
        
        String sql = "insert into tbl_HoaDonBan (MaNhanVien,MaKhachHang,TongTien) values(?,?,?)";
        PreparedStatement pre;
        
        try {
            pre = conn.prepareStatement(sql);

            pre.setString(1,hd.getManv());
            pre.setString(2,hd.getMakh());
            pre.setDouble(3,hd.getTongtien());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOHDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public int updateHDB(HDB hd)    {
        int n = 0;
        String sql = "update tbl_HoaDonBan set MaNhanVien = ?, MaKhachHang = ?, TongTien = ? where MaHoaDonBan = ? ";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1,hd.getManv());
            pre.setString(2,hd.getMakh());
            pre.setDouble(3,hd.getTongtien());
            pre.setString(4,hd.getMahdb());
            n = pre.executeUpdate();
                    } catch (SQLException ex) {
            Logger.getLogger(DAOHDB.class.getName()).log(Level.SEVERE, null, ex);
        }
       return n;
    }
    
    public int removeHDB(String mahdn) {
        int n =0;
        try {
            
            String sql = "delete from tbl_HoaDonBan where MaHoaDonBan = '" +mahdn +"'";
            Statement stm = conn.createStatement();
            n = stm.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOHDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public ResultSet displayAll()   {
        ResultSet rs =null;
        String sql = "select * from tbl_HoaDonBan";
        try {
            Statement stm = conn.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOHDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    public ResultSet displaytheodate(String start,String end)    {
        ResultSet rs =null;
        String sql = "select MaHoaDonBan,NgayBan,MaNhanVien,MaKhachHang,TongTien from tbl_HoaDonBan where NgayBan between '"+start+"' and '"+end+"'";
        try {
            Statement stm = conn.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOHDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public static void main(String[] args) throws SQLException {
        CFConnection conn = new CFConnection();
        DAOHDB dhd = new DAOHDB(conn);
        ResultSet rs = dhd.displayAll();
        while(rs.next())    {
            HDB hd = new HDB(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4), Double.valueOf(rs.getString(5)));
            System.out.println(hd.toString());
        }
                 
    }
        
    
}
