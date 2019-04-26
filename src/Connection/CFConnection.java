/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

/**
 *
 * @author MSI
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class CFConnection {
    private Connection conn ;
    public CFConnection(String URL,String user,String password)   {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn =  (Connection) DriverManager.getConnection(URL,user,password);
            System.out.println("ket noi thanh cong");
        } catch (ClassNotFoundException ex) {
          ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    public Connection getConn() {
        return conn;
    }
    public void getUser(String user,String password) throws SQLException   {
        CFConnection cfConnection = new  CFConnection();
        Statement stmt = conn.createStatement();
        String sql = "select * from tbl_User where Username = '"+ user +"' and Password = '" + password +"'";
        Boolean ret = stmt.execute(sql);
        System.out.println("\nGia tri tra ve la : " + ret.toString() );
        int rows = stmt.executeUpdate(sql);
        System.out.println("So hang bi tac dong : " + rows );
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next())    {
            String useR = rs.getString("Username");
            String passworD = rs.getString("Password");
            System.out.println("usename: " + user);
            System.out.println("password: "+ password);
        }
    }
    public ResultSet getData(String sql) throws SQLException    {
        ResultSet rs = null;
        Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs = state.executeQuery(sql);
        return rs;
    }
    public CFConnection() {
        this("jdbc:sqlserver://localhost:1433;databaseName=QLQuanCafe","sa","123456");
    }

    public static void main(String[] args) throws SQLException {
        CFConnection cf = new CFConnection("jdbc:sqlserver://;databaseName=QuanLyQuanCaFe","sa","123456");

    }
}
