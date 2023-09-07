package com.actvn.java06.deantotngiep;

import QuanLyKhachHang.BanHang1;
import QuanLyKhachHang.GiamGia;
import QuanLyKhachHang.Hoadon;
import QuanLyKhachHang.QuanLyKH;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<SanPham> list = (ArrayList<SanPham>) DocAndGhiFile.docfile();
        Scanner sc = new Scanner(System.in);
        DanhSachSanPham dssp = new DanhSachSanPham(list);
        BanHang1 banHang = new BanHang1();
        QuanLyKH quanlykhachhang = new QuanLyKH();
        dssp.inSP();

        int luachon = 0;
        do {
            System.out.println("1 . them");
            System.out.println("2 . in thong tin");
            System.out.println("3. in ra so luong");
            System.out.println("4. kiem tra ton tai SP");
            System.out.println("5. sua thong tin SP");
            System.out.println("6. in cac san pham cung nha san xuat");
            System.out.println("7. in 10 sp co so luong it nhat");
            System.out.println("8.in 10 sp co so luong nhieu nhat");
            System.out.println("9.  ban hang");
            System.out.println("10. in sp da ban");
            System.out.println("11. vut sp da het han");
            System.out.println("12 . in nhung san pham da het han");
            System.out.println("13. in nhung san pham co gan NSX");
            System.out.println("14. tinh tien ");
            System.out.println("15. in top 5 best seller");
            System.out.println("16. in nhung san pham cung ten");
            System.out.println("17. lưu dữ liệu");
            System.out.println("18. them hoa don cho khach hang da co san");// đồng thời in cả hóa đơn cho lần mua mới nhất
            System.out.println("19. in ra thong tin tat ca khach hang");
            System.out.println("20. giam gia");
            luachon = sc.nextInt();
            sc.nextLine();
            if (luachon == 1) {
                System.out.println("Nhap ma san pham: ");
                String maSP = sc.nextLine();
                System.out.println("Nhap ten san pham: ");
                String ten = sc.nextLine();
                System.out.println("Nhap nha san xuat: ");
                String nhaSX = sc.nextLine();
                System.out.println("Nhap ngay san xuat (yyyy-MM-dd): ");
                String NSX = sc.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
                LocalDate NSX1 = LocalDate.parse(NSX, formatter);
                System.out.println("Nhap ngay het han (yyyy-MM-dd): ");
                String HSD = sc.nextLine();
                LocalDate HSD1 = LocalDate.parse(HSD, formatter);
                System.out.println("Nhap so luong: ");
                int soLuong = sc.nextInt();
                System.out.println("Nhap gia: ");
                int gia = sc.nextInt();
                SanPham sp = new SanPham(maSP, ten, nhaSX, soLuong, gia, NSX1, HSD1);
                if (dssp.kiemTraNSX(NSX1) == 1) {
                    System.out.println("nhap hang thanh cong");
                    dssp.themSP(sp);
                } else {
                    System.out.println("ko the nhap hang");
                }

            } else if (luachon == 2) {
                dssp.inSP();
            } else if (luachon == 3) {
                System.out.println("so luong sp : " + dssp.soluong());
            } else if (luachon == 4) {
                String maSP = sc.nextLine();
                SanPham sp = new SanPham(maSP);
                System.out.println("kiem tra : " + dssp.ktTonTai(sp));
            } else if (luachon == 5) {
                System.out.println("Nhap ma san pham can sua thong tin: ");
                String maSP = sc.nextLine();
                SanPham sp = dssp.timSanPhamTheoMa(maSP);
                if (sp != null) {
                    dssp.XoaSPcu(sp);
                    System.out.println("Nhap ten san phm moi: ");
                    String ten = sc.nextLine();
                    System.out.println("Nhap nha san xuat moi: ");
                    String nhaSX = sc.nextLine();
                    System.out.println("Nhap ngay san xuat moi: ");
                    String NSX2 = sc.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
                    LocalDate NSX = LocalDate.parse(NSX2, formatter);
                    System.out.println("Nhap ngay het han moi: ");
                    String HSD2 = sc.nextLine();
                    LocalDate HSD = LocalDate.parse(HSD2, formatter);
                    System.out.println("Nhap so luong moi: ");
                    int soLuong = sc.nextInt();
                    System.out.println("Nhap gia moi: ");
                    int gia = sc.nextInt();
                    SanPham spMoi = new SanPham(maSP, ten, nhaSX, soLuong, gia, NSX, HSD);
                    dssp.themSP(spMoi);
                } else {
                    System.out.println("ko tim thay san pham");
                }
            } else if (luachon == 6) {
                System.out.println("nhap ten nha san xuat ");
                String nhaSX = sc.nextLine();
                dssp.locSPCoCungNSX(nhaSX);
                for (SanPham sanPham : dssp.SPcungNSX) {
                    System.out.println(sanPham.getTen());
                }
                DocAndGhiFile.ghifileSPcungNSX(dssp.SPcungNSX);
                dssp.setSPcungNSX(dssp.SPcungNSX);
            } else if (luachon == 7) {
                dssp.SapXeptop10SPItNhat();
                 dssp.intTop10();
                DocAndGhiFile.ghifileTop10SPitnhat(dssp.Top10SPitnhat);
                dssp.setTop10SPitnhat(dssp.Top10SPitnhat);
            } else if (luachon == 8) {
                dssp.Top10SPnhieunhat = dssp.SapXeptop10SPNhieuNhat();
               dssp.intTop10();
                DocAndGhiFile.ghifileTop10SPnhieunhat(dssp.Top10SPnhieunhat);
                dssp.setTop10SPnhieunhat(dssp.Top10SPnhieunhat);
            } else if (luachon == 9) {
                int b = 0;
                do {
                    banHang.banSanPham(dssp);
                    b = sc.nextInt();

                } while (b != 0);
                sc.nextLine();
                System.out.println("Nhap ten khach hang:");
                String name = sc.nextLine();
                System.out.println("Nhap sdt khach hang:");
                String sdt = sc.nextLine();
                System.out.println("Nhap ma Hoa don:");
                String mahoadon = sc.nextLine();
                Hoadon c = new Hoadon(name, sdt, mahoadon);
                c.setSanPhamDaMua(banHang.getLuutamthoi());
                System.out.println(c.toString());
                banHang.inSanPhamVuaBan();
                quanlykhachhang.add(c);
                banHang.setLuutamthoi();
            } else if (luachon == 10) {
                banHang.inSanPhamDaBan();
            } else if (luachon == 11) {
                System.out.println("Nhap ma san pham can kiem tra ");
                String maSP = sc.nextLine();
                SanPham sp = dssp.timSanPhamTheoMa(maSP);
                if (sp != null) {
                    if (banHang.kiemTraHanSuDung(sp) == true) {
                        dssp.XoaSPcu(sp);
                        System.out.println("xoa san pham thanh cong");
                    } else {
                        System.out.println("san pham chua het han");
                    }
                }
            } else if (luachon == 12) {
                LocalDate d3 = LocalDate.of(2024, 10, 10);
                dssp.locNhungSPHetHan(d3);
                for (SanPham sp : dssp.getSpHetHan()) {
                    System.out.println(sp.getTen());
                }
                DocAndGhiFile.ghifilespHetHan(dssp.spHetHan);
                dssp.setSpHetHan(dssp.spHetHan);
            } else if (luachon == 13) {
                dssp.SapXep10SPcoHSD();
                dssp.intTop10();
                DocAndGhiFile.ghifileSapXep10SPcoHSD(dssp.SapXep10SPcoHSD);
                dssp.setSapXep10SPcoHSD(dssp.SapXep10SPcoHSD());
            } else if (luachon == 14) {
                System.out.println("Tong tien: " + banHang.tinhTongTienTheoNgay());
            } else if (luachon == 15) {
                dssp.SapXeptop10SPItNhat();
                dssp.inTop5BestSeller();
            } else if (luachon == 16) {
                System.out.println("nhap ki tu :");
                String ten = sc.nextLine();
                dssp.InNhngSPCungTen(ten);
                for (SanPham sp : dssp.SPCungTen) {
                    System.out.println(sp.getTen());
                }
                DocAndGhiFile.ghifileSPCungTen(dssp.SPCungTen);
                dssp.setSPCungTen(dssp.SPCungTen);
            } else if (luachon == 17) {
                DocAndGhiFile.ghifile(dssp.getDanhSach());
            } else if (luachon == 18) {
                System.out.println("Nhap sdt khach hang :");
                String SavedSDT = sc.nextLine();
                int d;
                do {
                    banHang.banSanPham(dssp);
                    d = sc.nextInt();
                } while (d != 0);
                quanlykhachhang.timKhachHangTheoSDT(SavedSDT).addSanPhamDaMua(banHang.getLuutamthoi());
                quanlykhachhang.timKhachHangTheoSDT(SavedSDT).setDatetime(new Date());
                System.out.println(quanlykhachhang.timKhachHangTheoSDT(SavedSDT).toString());
                banHang.inSanPhamVuaBan();
                banHang.setLuutamthoi();
            } else if (luachon == 19) {
                for (Hoadon hoadon : quanlykhachhang.getListhoadon()) {
                    System.out.println(hoadon.inradanhsachkhachhang());
                }
                DocAndGhiFile.ghifilehoadon(quanlykhachhang.getListhoadon());
            } else if (luachon == 20) {

            }

        } while (luachon != 0);
    }

}
