/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Trung
 */
public class User {
    private String usename;
    private String password;
    private int role;
    private String manv;
    
    public void setUsename(String usename) throws Exception  {
        this.usename = usename;
        if(this.usename == "")  {
            throw new Exception("Ten dang ko duoc de trong !");
        }     
    }

    public User(String usename, String password, int role, String manv) {
        this.usename = usename;
        this.password = password;
        this.role = role;
        this.manv = manv;
    }

    
    
    public void setPassword(String password) throws Exception    {
        this.password = password;
        if(this.password == "") {
            throw new Exception("Ma dang nhap ko duoc de trong");
        }
    }

    public void setRole(short role) {
        this.role = role;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }
    
    public String getUsename()  {
        return this.usename;
    }
    public String getPassword() {
        return this.password;
    }

    public int getRole() {
        return role;
    }

    public String getManv() {
        return manv;
    }
    
}
