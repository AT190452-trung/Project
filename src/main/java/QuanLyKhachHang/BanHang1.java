/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyKhachHang;

import com.actvn.java06.deantotngiep.DanhSachSanPham;
import com.actvn.java06.deantotngiep.SanPham;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
public class BanHang1 {
    private ArrayList<SanPham> danhSachSanPhamDaBan;
    private ArrayList<SanPham> luutamthoi;
       private HashMap<LocalDate, Integer> doanhSoTheoNgay;
    public BanHang1() {
        danhSachSanPhamDaBan = new ArrayList<>();
        luutamthoi = new ArrayList<>();
         doanhSoTheoNgay = new HashMap<>();
    }
    public void banSanPham(DanhSachSanPham danhSachSanPham) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma san pham can ban: ");
        String maSanpham = sc.nextLine();
        

        SanPham spCanBan = danhSachSanPham.timSanPhamTheoMa(maSanpham);

        if (spCanBan != null) {
            System.out.println("Nhap so luong san pham ban muon ban: ");
            int soLuongBan = sc.nextInt();

            if (soLuongBan <= spCanBan.getSoLuong()) {
                spCanBan.setSoLuong(spCanBan.getSoLuong() - soLuongBan);

                SanPham spDaBan = new SanPham(spCanBan.getMaSP(),
                        spCanBan.getTen(),
                        spCanBan.getNhaSX(),
                        soLuongBan,
                        spCanBan.getGia(),
                        spCanBan.getNSX(),
                        spCanBan.getHSD());

                danhSachSanPhamDaBan.add(spDaBan);
                ArrayList<SanPham> newLuutamthoi = new ArrayList<>(luutamthoi);
                newLuutamthoi.add(spDaBan);
                luutamthoi = newLuutamthoi;

                System.out.println("Ban hang thanh cong!");
                  LocalDate ngayBan = LocalDate.now();
                doanhSoTheoNgay.put(ngayBan, doanhSoTheoNgay.getOrDefault(ngayBan, 0) + spDaBan.getGia() * soLuongBan);
            } else {
                System.out.println("Khong du hang de ban!");
            }
        } else {
            System.out.println("Khong tim thay san pham trong kho!");
        }
    }

    public ArrayList<SanPham> getDanhSachSanPhamDaBan() {
        return danhSachSanPhamDaBan;
    }

    public ArrayList<SanPham> getLuutamthoi() {
        return luutamthoi;
    }
    

    public void inSanPhamDaBan() {
        System.out.println("Danh sach san pham da ban:");
        for (SanPham sp : danhSachSanPhamDaBan) {
            System.out.println(sp.toString());
        }
    }
    public void inSanPhamVuaBan(){
        System.out.println("Danh sach san pham vua ban:");
        for(SanPham sp : luutamthoi){
            System.out.println(sp.InSanPhammoimua());
        }
    }

    public boolean kiemTraHanSuDung(SanPham sp) {
        LocalDate ngayHienTai = LocalDate.now();
        return ngayHienTai.isBefore(sp.getHSD());
    }

    public String tinhTongTienTheoNgay() {
    StringBuilder result = new StringBuilder();
   
    for (LocalDate ngay : doanhSoTheoNgay.keySet()) {
        int tongTienNgay = doanhSoTheoNgay.get(ngay);
        result.append(tongTienNgay).append(" VND\n");
    }
    return result.toString();
}

    public void setLuutamthoi() {
        this.luutamthoi = new ArrayList<>();
    }
}