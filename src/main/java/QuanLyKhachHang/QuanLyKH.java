/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyKhachHang;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class QuanLyKH {
    
 private ArrayList<Hoadon> listhoadon = new ArrayList<>();

    public void setListhoadon(ArrayList<Hoadon> listhoadon) {
        this.listhoadon = listhoadon;
    }

    public ArrayList<Hoadon> getListhoadon() {
        return listhoadon;
    }

    public void add(Hoadon a) {
        listhoadon.add(a);
    }

    public Hoadon timKhachHangTheoSDT(String SDT) {
        for (Hoadon hoadon : listhoadon) {
            if (hoadon.getSdt().equals(SDT)) {
                return hoadon;
            }
        }
        return null;
    }

}
