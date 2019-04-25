/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Connection.CFConnection;
import Entity.NhanVien;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MSI
 */
public class DAONhanVien {
    CFConnection cfconn;
    Connection conn;
    public DAONhanVien(CFConnection cfconn)   {
        this.cfconn = cfconn;
        this.conn=cfconn.getConn();
    }
    public int addNhanVien(NhanVien nv) {
        int n =0;
        PreparedStatement pre = null;
        String sql = "insert into tbl_NhanVien values (?,?,?,?,?,?,?)";
        try {
           pre = conn.prepareStatement(sql);
           pre.setString(1,nv.getManv());
           pre.setString(2,nv.getTennv());
           pre.setString(3,nv.getNoio());
           pre.setString(4,nv.getGioitinh());
           pre.setString(5,nv.getNgaysinh());
           pre.setString(6,nv.getque());
           pre.setString(7,nv.getSdt());
           n = pre.executeUpdate();
        }
        catch(SQLException ex)  {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE,null,ex);
        }
        return n;
    }
    public int RemoveNhanVien(String manv)  {
        int n = 0;
        String sql = "delete from tbl_NhanVien Where manv = '"+manv+"'";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAONhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return n;
    }
    public int  UpdateNhanVien(NhanVien nv)  {
        int n = 0;
        String sql = "Insert into tbl_NhanVien Where set tennv = '"+nv.getTennv()+"',diachi = '"
                +nv.getNoio()+"',gioitinh = '"+nv.getGioitinh()+",ngaysinh = '"+nv.getNgaysinh()+"', que = '"+nv.getque()
                +"', sdt = '"+nv.getSdt()+"'";
        Statement state;
        try {
            state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAONhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return n;
    }
    private ResultSet displayAll()  {
        ResultSet rs = null;
        String sql = "select * from tbl_NhanVien";
        try {
            Statement stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(DAONhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public static void main(String[] args) {
        CFConnection conn = new CFConnection();
        DAONhanVien nv = new DAONhanVien(conn);
        NhanVien nv1 = new NhanVien("NV01","truong","tu niem","nam","1998-05-19","thai binh","09999999");
        System.out.println(nv.addNhanVien(nv1));
    }
}
