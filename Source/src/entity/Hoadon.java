package entity;
// Generated 26-Mar-2016 11:54:59 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Hoadon generated by hbm2java
 */
public class Hoadon  implements java.io.Serializable {


     private int id;
     private Date ngaythang;
     private Float tongtien;

    public Hoadon() {
    }

	
    public Hoadon(int id) {
        this.id = id;
    }
    public Hoadon(int id, Date ngaythang, Float tongtien) {
       this.id = id;
       this.ngaythang = ngaythang;
       this.tongtien = tongtien;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Date getNgaythang() {
        return this.ngaythang;
    }
    
    public void setNgaythang(Date ngaythang) {
        this.ngaythang = ngaythang;
    }
    public Float getTongtien() {
        return this.tongtien;
    }
    
    public void setTongtien(Float tongtien) {
        this.tongtien = tongtien;
    }




}

