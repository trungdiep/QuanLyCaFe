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
import java.util.ArrayList;
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
    public int insertNhanVien(NhanVien nv) {
        int n = 0;
        String sql = "insert into tbl_NhanVien(TenNhanVien,DiaChi,GioiTinh,NgaySinh,Que,SDT) values(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nv.getTennv());
            preparedStatement.setString(2, nv.getNoio());
            preparedStatement.setString(3, nv.getGioitinh());
            preparedStatement.setString(4, nv.getNgaysinh());
            preparedStatement.setString(5, nv.getque());
            preparedStatement.setString(6, nv.getSdt());
            
            n = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    public int RemoveNhanVien(String tenNhanVien)  {
        int n = 0;
        String sql = "delete from tbl_NhanVien Where TenNhanVien = '"+ tenNhanVien +"'";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }       
        return n;
    }
    public int updateNhanVien(NhanVien nv) {
        int n = 0;
        String sql = "update tbl_NhanVien set DiaChi=?, GioiTinh=?, NgaySinh=?, Que=?, SDT=? Where TenNhanVien= ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, nv.getNoio());
            preparedStatement.setString(2, nv.getGioitinh());
            preparedStatement.setString(3, nv.getNgaysinh());
            preparedStatement.setString(4, nv.getque());
            preparedStatement.setString(5, nv.getSdt());
            preparedStatement.setString(6, nv.getTennv());
            
            n = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    public ArrayList <NhanVien> displayAll(){
        ArrayList <NhanVien> nhanVien = new ArrayList<>();
        String sql = "select * from tbl_NhanVien";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {                
                String maNhanVien = resultSet.getString("MaNhanVien");
                String tenNhanVien = resultSet.getString("TenNhanVien");
                String diaChi = resultSet.getString("DiaChi");
                String gioiTinh = resultSet.getString("GioiTinh");
                String ngaySinh = resultSet.getString("NgaySinh");
                String que = resultSet.getString("Que");
                String sDT = resultSet.getString("SDT");
                nhanVien.add(new NhanVien(maNhanVien, tenNhanVien, diaChi, gioiTinh, ngaySinh, que, sDT));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nhanVien;
    }
    
    public ArrayList <NhanVien> searchNhanVien(String ten){
        ArrayList <NhanVien> nhanVien = new ArrayList<>();
        String sql ="select * from tbl_NhanVien where TenNhanVien like '%"+ ten +"%'";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {                
                String maNhanVien = resultSet.getString("MaNhanVien");
                String tenNhanVien = resultSet.getString("TenNhanVien");
                String diaChi = resultSet.getString("DiaChi");
                String gioiTinh = resultSet.getString("GioiTinh");
                String ngaySinh = resultSet.getString("NgaySinh");
                String que = resultSet.getString("Que");
                String sDT = resultSet.getString("SDT");
                nhanVien.add(new NhanVien(maNhanVien, tenNhanVien, diaChi, gioiTinh, ngaySinh, que, sDT));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nhanVien;
    }
}
