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
public class Loai {
    private String maloai;
    private String tenloai;

    public Loai(String maloai, String tenloai) {
        this.maloai = maloai;
        this.tenloai = tenloai;
    }

    
    public String getMaloai() {
        return maloai;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setMaloai(String maloai) throws Exception {
        this.maloai = maloai;
        if(this.maloai.equals(""))  {
            throw new Exception("ko de ma loai trong");
        }
            
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }
    
    
}
