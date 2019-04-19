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
public class CTHDB {
    private String mahdb;
    private String masp;
    private String tensp;
    private String soluong;
    private String thanhtien;
    private String khuyenmai;

    public String getMahdb() {
        return mahdb;
    }

    public String getMasp() {
        return masp;
    }

    public String getTensp() {
        return tensp;
    }

    public String getSoluong() {
        return soluong;
    }

    public String getThanhtien() {
        return thanhtien;
    }

    public String getKhuyenmai() {
        return khuyenmai;
    }

    public void setMahdb(String mahdb) throws Exception{
        this.mahdb = mahdb;
        if(this.mahdb == null)
            throw new Exception("ko de ma hoa don ban trong");
    }

    public void setMasp(String masp) throws Exception {
        this.masp = masp;
         if(this.masp == "")
            throw  new Exception("ko de ma san pham trong");
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public void setThanhtien(String thanhtien) {
        this.thanhtien = thanhtien;
    }

    public void setKhuyenmai(String khuyenmai) {
        this.khuyenmai = khuyenmai;
    }
    
    
}
