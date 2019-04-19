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
public class NhanVien {
    private String manv;
    private String tennv;
    private String noio;
    private String gioitinh;
    private String ngaysinh;
    private String que;
    private String sdt;

    public NhanVien(String manv, String tennv, String noio, String gioitinh, String ngaysinh, String que, String sdt) {
        this.manv = manv;
        this.tennv = tennv;
        this.noio = noio;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.que = que;
        this.sdt = sdt;
    }

    
    
    public String getManv() {
        return manv;
    }

    public String getTennv() {
        return tennv;
    }

    public String getNoio() {
        return noio;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getque() {
        return que;
    }

    public String getSdt() {
        return sdt;
    }

    public void setManv(String manv) throws Exception {
        this.manv = manv;
        if(this.manv == "") {
            throw new Exception("ko de ma nhan vien trong");
        }
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public void setNoio(String diachi) {
        this.noio = diachi;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setque(String que) {
        this.que = que;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
      
}
