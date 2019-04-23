/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.CFConnection;
import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author MSI
 */
public class DAOUser {
    CFConnection cfconn;
    Connection conn;
    public DAOUser(CFConnection cfconn)   {
        this.cfconn = cfconn;
        this.conn=cfconn.getConn();
    }
    public int addUser(User us ) {
        int n = 0;
        String sql = "insert into tbl_User(Username,Password,Role_User,MaNhanVien) values ('"+us.getUsename()+"','"+us.getPassword()+"','"+us.getRole()+"','"+us.getManv()+"')";
        Statement state;
        try {
            state = conn.createStatement();
            n = state.executeUpdate(sql);
        }catch(SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE,null,ex);
        }
        return n;
    }
    public int insertUse(User us)   {
        int n =0 ;
        String sql = "insert into tbl_User(Username,Password,Role_User,MaNhanVien) values (?,?,?,?)";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1,us.getUsename());
            pre.setString(2,us.getPassword());
            pre.setInt(3,us.getRole());
            pre.setString(4,us.getManv());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE,null,ex);
            System.out.println("loi");
        }
        return n;
    }
    public int updateUser(User us)   {
        int n = 0;
        String sql = "update User set Password = ?, Role_User = ? , MaNhanVien = ? where Username=?";
        try {   
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,us.getPassword());
            pre.setString(4,us.getUsename());
            pre.setInt(2,us.getRole());
            pre.setString(3,us.getManv());
            n = pre.executeUpdate();
        }catch(SQLException ex)    {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE,null,ex);
        }
        return n;
    }
    public int removeUser(String user) throws SQLException    {
        int n =0 ;
        String sql = "delete from tbl_User where Username = '"+user+"'";
        Statement state  = conn.createStatement();
        n = state.executeUpdate(sql);
        return n ;
    }
    public  String[] checkUser(String user,String password)  {
        ResultSet rs = null;
        String[] role = new String[2]; //role = 3 sai mat khau   
        try {
            String sql = "select Role_User, MaNhanVien from tbl_User where Username = '"+ user +"' and Password = '" + password +"'";
            Statement state = conn.createStatement();
            rs  = state.executeQuery(sql);
            while(rs.next())    {
                role[0] = String.valueOf(rs.getShort("Role_User"));
                role[1] = rs.getString("MaNhanVien");
            }
        }
        catch(SQLException ex)  {
            System.out.println("loi");
        }     
        return role;
    }
    public String getMaNhanVien(String user) {
        ResultSet rs = null;
        String sql = "select MaNhanVien from tbl_User where User = '" + user +"'";
        String manv = null ; 
        Statement stm;
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            if(rs.next())
            {
                manv = rs.getString("MaNhanVien");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return manv;
    }
    public static void main(String[] args) throws SQLException {
        CFConnection conn = new CFConnection();
        DAOUser pro = new DAOUser(conn);
        User us = new  User("tmt","19980519",0,"NV01");
        System.out.println(pro.insertUse(us));
        }
}
