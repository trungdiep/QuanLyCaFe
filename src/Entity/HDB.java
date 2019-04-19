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
    private String ngayban;
    private String manv;
    private String makh;
    private String tongtien;

    public void setMahdb(String mahdb) throws Exception {
        this.mahdb = mahdb;
        if(this.mahdb == "")
            throw new Exception("ko de ma hoa don trong");
    }

    public void setNgayban(String ngayban) {
        this.ngayban = ngayban;
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

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }
    
    
}
