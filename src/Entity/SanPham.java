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
public class SanPham {
    private String masp;
    private String tensp;
    private String maloai;
    private Double giaban;

    public SanPham() {
    }

    public SanPham(String tensp) {
        this.tensp = tensp;
    }

    public SanPham(String tensp, String maloai, Double giaban) {
        this.tensp = tensp;
        this.maloai = maloai;
        this.giaban = giaban;
    }
    
    public SanPham(String masp, String tensp, String maloai, Double giaban) {
        this.masp = masp;
        this.tensp = tensp;
        this.maloai = maloai;
        this.giaban = giaban;
    }

    public void SanPham(String tensp, String maloai, Double giaban) {
        this.tensp = tensp;
        this.maloai = maloai;
        this.giaban = giaban;
    }
    
    public void setMasp(String masp) throws Exception {
        this.masp = masp;
        if(this.masp == "") {
            throw new Exception("Ko de ma sp trong");
        }
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public void setMaloai(String maloai) throws Exception   {
        this.maloai = maloai;
        if(this.maloai == "")   {
            throw new Exception("ko de ma loai trong");
        }
    }

    public void setGiaban(Double giaban) {
        this.giaban = giaban;
    }

    public String getMasp() {
        return masp;
    }

    public String getTensp() {
        return tensp;
    }

    public String getMaloai() {
        return maloai;
    }

    public Double getGiaban() {
        return giaban;
    }



    


    
    
    
}
