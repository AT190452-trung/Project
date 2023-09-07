package com.actvn.java06.deantotngiep;

import Comparator.SoSanhTen;
import Comparator.Top10SPHSDGanNgayHienTai;
import Comparator.top10SPItNhat;
import Comparator.top10SpNhieuNhat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

//kho
public class DanhSachSanPham {
    
    
  
    public ArrayList<SanPham> danhSach;
    public ArrayList<SanPham> spHetHan = new ArrayList<>();
    public ArrayList<SanPham> SapXep10SPcoHSD = new ArrayList<>();
    public ArrayList<SanPham> SPCungTen = new ArrayList<>();
      public ArrayList<SanPham> Top10SPnhieunhat = new ArrayList<>();
     public ArrayList<SanPham> Top10SPitnhat = new ArrayList<>();
      public ArrayList<SanPham> SPcungNSX = new ArrayList<>();
    public ArrayList<SanPham> getTop10SPnhieunhat() {
        return Top10SPnhieunhat;
    }

    public void setTop10SPnhieunhat(ArrayList<SanPham> Top10SPnhieunhat) {
        this.Top10SPnhieunhat = Top10SPnhieunhat;
    }
    
      
     public ArrayList<SanPham> getSPCungTen() {
        return SPCungTen;
    }
     public void setSPCungTen(ArrayList<SanPham> SPCungTen) {
        this.SPCungTen = new ArrayList<>();
    }

    public ArrayList<SanPham> getSapXep10SPcoHSD() {
        return SapXep10SPcoHSD;
    }
     public void setSapXep10SPcoHSD(ArrayList<SanPham> SapXep10SPcoHSD) {
        this.SapXep10SPcoHSD = new ArrayList<>();
    }

    public ArrayList<SanPham> getSpHetHan() {
        return spHetHan;
    }
      public void setSpHetHan(ArrayList<SanPham> spHetHan) {
        this.spHetHan = new ArrayList<>();
    }
    
    

    public DanhSachSanPham() {
        this.danhSach = new ArrayList<SanPham>();
    }

    public DanhSachSanPham(ArrayList<SanPham> danhSach) {
        this.danhSach = danhSach;
    }

    public void setDanhSach(ArrayList<SanPham> danhSach) {
        this.danhSach = danhSach;
    }

    public ArrayList<SanPham> getTop10SPitnhat() {
        return Top10SPitnhat;
    }

    public ArrayList<SanPham> getSPcungNSX() {
        return SPcungNSX;
    }

    public void setTop10SPitnhat(ArrayList<SanPham> Top10SPitnhat) {
        this.Top10SPitnhat = Top10SPitnhat;
    }

    public void setSPcungNSX(ArrayList<SanPham> SPcungNSX) {
        this.SPcungNSX = SPcungNSX;
    }
    

    //nhập vào kho
    public void themSP(SanPham sp) {
        this.danhSach.add(sp);
    }

    public ArrayList<SanPham> getDanhSach() {
        return danhSach;
    }

   
    public void inSP() {
        for (SanPham sanPham : danhSach) {
            System.out.println(sanPham);
        }
    }

    public int soluong() {
        return this.danhSach.size();
    }

    public boolean ktTonTai(SanPham sp) {
        return this.danhSach.contains(sp);
    }

    public boolean XoaSPcu(SanPham sp) {
        return this.danhSach.remove(sp);
    }

    public int kiemTraNSX(LocalDate d1) {
        LocalDate d2 = LocalDate.of(2023, 1, 1);
        if (d1.isAfter(d2)) {
            return 1;
        }
        return 0;
    }
    
     public int kiemTraHSD() {
          LocalDate d1 = LocalDate.now();
         for (SanPham sanPham : danhSach) {
             if(sanPham.getHSD().isAfter(d1))
             {
                 return 1;
             }
         }
         return 0;
    }

    public SanPham timSanPhamTheoMa(String maSP) {
        for (SanPham sp : danhSach) {
            if (sp.getMaSP().equals(maSP)) {
                return sp;
            }
        }
        return null;
    }

    public  ArrayList<SanPham> locSPCoCungNSX(String NSX) {
        for (SanPham sanPham : danhSach) {
            if (sanPham.getNhaSX().equals(NSX)) {
                SPcungNSX.add(sanPham);
            }
        }
        return SPCungTen;
    }

    public ArrayList<SanPham> locNhungSPHetHan(LocalDate d1) {
        for (SanPham sanPham : danhSach) {
            if (sanPham.getHSD().isBefore(d1)) {
                spHetHan.add(sanPham);
            }

        }
        return spHetHan;
    }
   public ArrayList<SanPham> InNhngSPCungTen(String ten) {
        for (SanPham sanPham : danhSach) {
            if (sanPham.getTen().contains(ten)) {
                SPCungTen.add(sanPham);
            }
        }
        return SPCungTen;
    }

    public ArrayList<SanPham> SapXeptop10SPNhieuNhat() {
        Collections.sort(danhSach, new top10SpNhieuNhat());
       
        for(int i=0;i<10;i++)
        {
            Top10SPnhieunhat.add(danhSach.get(i));
        }
        Collections.sort(Top10SPnhieunhat, new SoSanhTen());
        return Top10SPnhieunhat;
    }

    public  ArrayList<SanPham> SapXeptop10SPItNhat() {
        Collections.sort(danhSach, new top10SPItNhat());
        for(int i=0;i<10;i++)
        {
            Top10SPitnhat.add(danhSach.get(i));
        }
        return Top10SPitnhat;
    }

   public void SapXepTenSP() {
        Collections.sort(danhSach);
    }
   public ArrayList<SanPham> SapXep10SPcoHSD() {
        Collections.sort(danhSach, new Top10SPHSDGanNgayHienTai());
        for (int i = 0; i < 10; i++) {
            SapXep10SPcoHSD.add(danhSach.get(i));
        }
        return SapXep10SPcoHSD;
    }
   
    public void intTop10()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println(danhSach.get(i));
        }
    }
    
 
   public void inTop5BestSeller()
   {
       for(int i=0;i<5;i++)
       {
           System.out.println(danhSach.get(i).getTen());
       }
   }

    public boolean get(int size) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}
