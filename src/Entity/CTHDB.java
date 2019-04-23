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
    private int soluong;
    private Double thanhtien;

    public CTHDB(String mahdb, String masp, String tensp, int soluong, Double thanhtien) {
        this.mahdb = mahdb;
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }

    
    public String getMahdb() {
        return mahdb;
    }

    public String getMasp() {
        return masp;
    }

    public String getTensp() {
        return tensp;
    }

    public int getSoluong() {
        return soluong;
    }

    public Double getThanhtien() {
        return thanhtien;
    }

    public void setMahdb(String mahdb) {
        this.mahdb = mahdb;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setThanhtien(Double thanhtien) {
        this.thanhtien = thanhtien;
    }

    @Override
    public String toString() {
        return "CTHDB{" + "mahdb=" + mahdb + ", masp=" + masp + ", tensp=" + tensp + ", soluong=" + soluong + ", thanhtien=" + thanhtien + '}';
    }

  
}
