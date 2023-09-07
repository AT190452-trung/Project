/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyKhachHang;

import java.time.LocalDate;

public class GiamGia {
     private String moTa;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private double phanTramGiam;
    private String tenSanPham;
    public GiamGia(String moTa, LocalDate ngayBatDau, LocalDate ngayKetThuc, double phanTramGiam,String tenSanPham) {
        this.moTa = moTa;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.phanTramGiam = phanTramGiam;
        this.tenSanPham=tenSanPham;
    }
    public String getMoTa() {
        return moTa;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public double getPhanTramGiam() {
        return phanTramGiam;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }
    
}
