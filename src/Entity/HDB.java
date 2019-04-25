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
public class HDB {
    private String mahdb;
    private String manv;
    private String date;
    private String makh;
    private Double tongtien;

    public HDB(String mahdb, String manv, String makh, Double tongtien) {
        this.mahdb = mahdb;
        this.manv = manv;
        this.makh = makh;
        this.tongtien = tongtien;
    }

    public HDB(String mahdb, String manv, String date, String makh, Double tongtien) {
        this.mahdb = mahdb;
        this.manv = manv;
        this.date = date;
        this.makh = makh;
        this.tongtien = tongtien;
    }

    public HDB(String manv, String makh, Double tongtien) {
        this.manv = manv;
        this.makh = makh;
        this.tongtien = tongtien;
    }

    public String getMahdb() {
        return mahdb;
    }



    public String getManv() {
        return manv;
    }

    public String getMakh() {
        return makh;
    }

    public Double getTongtien() {
        return tongtien;
    }

    
    public void setMahdb(String mahdb) throws Exception {
        this.mahdb = mahdb;
        if(this.mahdb == "")
            throw new Exception("ko de ma hoa don trong");
    }



    public void setManv(String manv) throws Exception {
        this.manv = manv;
         if(this.manv == "")
            throw new Exception("ko de ma nhan vien trong");
    }

    public void setMakh(String makh) throws Exception {
        this.makh = makh;
         if(this.makh == "")
            throw new Exception("ko de ma hoa don trong");
    }

    public void setTongtien(Double tongtien) {
        this.tongtien = tongtien;
    }

    @Override
    public String toString() {
        return "HDB{" + "mahdb=" + mahdb + ", manv=" + manv + ", date=" + date + ", makh=" + makh + ", tongtien=" + tongtien + '}';
    }


   
    
}
