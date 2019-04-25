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
public class KhachHang {
    private String makh;
    private String sdt;
    private String tenkh;
    public KhachHang()  {
        
    }
    public KhachHang(String makh, String sdt, String tenkh) {
        this.makh = makh;
        this.sdt = sdt;
        this.tenkh = tenkh;
    }

    public KhachHang(String sdt, String tenkh) {
        this.sdt = sdt;
        this.tenkh = tenkh;
    }

    
    public String getMakh() {
        return makh;
    }

    public String getSdt() {
        return sdt;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setMakh(String makh) throws Exception{
        this.makh = makh;
        if(this.makh == "") {
            throw new Exception("ko de ma khach hang trong");
        }
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }
    
    
}
