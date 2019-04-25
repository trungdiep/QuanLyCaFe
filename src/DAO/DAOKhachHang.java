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
import java.util.HashMap;
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
        String sql = "insert into tbl_KhachHang (TenKhachHang,Sdt) values(?,?)";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, kh.getTenkh());
            pre.setString(2, kh.getSdt());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
           Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE,null,ex);
        }
        return n;
    }

    public int updateKhachHang(KhachHang kh,String sdt) {
        int n = 0;

        String sql = "update tbl_KhachHang set TenKhachHang = ?, Sdt = ? where tbl_KhachHang.Sdt = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, kh.getTenkh());
            preparedStatement.setString(2, kh.getSdt());
            preparedStatement.setString(3, sdt);
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
    
    public int removeKhachHang(String sdt){
        int n = 0;
        String sql = "delete from tbl_KhachHang where Sdt = '"+ sdt +"'";
        try {
            Statement statement = conn.createStatement();
            n = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public String displayMaKhacHang(String tenkh){
        String sql=" select MaKhachHang from tbl_KhachHang where TenKhachHang = '" + tenkh + "'";
        ResultSet resultSet;
        String makh = null;
        try {
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            if(resultSet.next())    {
                makh = resultSet.getString("MaKhachHang");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return makh;
    }
    public ResultSet displayAll()   {
        String sql = "select * from tbl_KhachHang ";
        ResultSet resultSet = null;
        try {
            Statement stm = conn.createStatement();
            resultSet = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  resultSet;
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
    public ResultSet Search(String sdt) {
        ResultSet rs = null;
        String sql = "select * from tbl_KhachHang where Sdt = '"+sdt+"'";
        try {
            Statement stm = conn.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet getTop10(String start,String end)  {
        ResultSet rs = null;
        String sql = "select top 10 tbl_KhachHang.MaKhachHang,tbl_KhachHang.TenKhachHang,tbl_KhachHang.Sdt,COUNT(tbl_KhachHang.MaKhachHang) as 'Số lần mượn'"
                + " from tbl_HoaDonBan inner join tbl_KhachHang on tbl_HoaDonBan.MaKhachHang=tbl_KhachHang.MaKhachHang" +
                " where tbl_HoaDonBan.NgayBan between '"+start+"' and '"+end+"' "
                + "Group by tbl_KhachHang.MaKhachHang,tbl_KhachHang.TenKhachHang,tbl_KhachHang.Sdt Order by COUNT(tbl_KhachHang.MaKhachHang) DESC";
        try {
            Statement stm = conn.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    public ResultSet thongke()  {
        ResultSet rs = null;
        String sql = "select top 10 tbl_KhachHang.MaKhachHang,tbl_KhachHang.TenKhachHang,tbl_KhachHang.Sdt,COUNT(tbl_KhachHang.MaKhachHang) as 'Số lần mượn' " +
                    "from tbl_HoaDonBan  inner join tbl_KhachHang on tbl_HoaDonBan.MaKhachHang=tbl_KhachHang.MaKhachHang " +
                    "Group by tbl_KhachHang.MaKhachHang,tbl_KhachHang.TenKhachHang,tbl_KhachHang.Sdt Order by COUNT(tbl_KhachHang.MaKhachHang) ASC";
        try {
            Statement stm = conn.createStatement();
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public static void main(String[] args) throws SQLException {
        CFConnection conn = new CFConnection();
        DAOKhachHang daokh = new DAOKhachHang(conn);
       // KhachHang khach = new KhachHang("KH02","0334031515","Diep Van Trung");
        //System.out.println(daokh.addKhachHang(khach));

        System.out.println(daokh.removeKhachHang("01697692421"));
    }

    public int addKhachHang(Tabs.KH kh) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int updateKhachHang(Tabs.KH kh) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
}
