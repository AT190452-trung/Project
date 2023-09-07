
package com.actvn.java06.deantotngiep;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class SanPham implements Comparable<SanPham>{
    
    private String maSP;
    private String ten;
    private String nhaSX;
    private int soLuong;
    private int gia;
    private LocalDate NSX;
    private LocalDate HSD;

   
    private int tien;

    

    public SanPham() {
    }

    public SanPham(String maSP) {
        this.maSP = maSP;

    }

    public String getMaSP() {
        return maSP;
    }

    public String getTen() {
        return ten;
    }

    public String getNhaSX() {
        return nhaSX;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getGia() {
        return gia;
    }

    public LocalDate getNSX() {
        return NSX;
    }

    public LocalDate getHSD() {
        return HSD;
    }
    public int getTien() {
        return getGia()*getSoLuong();
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNhaSX(String nhaSX) {
        this.nhaSX = nhaSX;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public void setNSX(LocalDate NSX) {
        this.NSX = NSX;
    }

    public void setHSD(LocalDate HSD) {
        this.HSD = HSD;
    }

    public SanPham(String maSP, String ten, String nhaSX, int soLuong, int gia, LocalDate NSX, LocalDate HSD) {
        this.maSP = maSP;
        this.ten = ten;
        this.nhaSX = nhaSX;
        this.soLuong = soLuong;
        this.gia = gia;
        this.NSX = NSX;
        this.HSD = HSD;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSP=" + maSP + ", ten=" + ten + ", nhaSX=" + nhaSX + ", soLuong=" + soLuong + ", gia=" + gia + ", NSX=" + NSX + ", HSD=" + HSD + '}';
    }
    
      public String InSanPhammoimua(){
        return "maSP=" + maSP + ", ten=" + ten + ", nhaSX=" + nhaSX + ", soLuong=" + soLuong + ", gia=" + gia*soLuong ;
    }
    
     public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SanPham other = (SanPham) obj;
      
        
        return Objects.equals(maSP, other.maSP);
    }
     
     private String getName(String ten)
     {
         String[] str=ten.split(" ");
         return str[str.length -1];
     }

    @Override
    public int compareTo(SanPham o) {
        String str1 =getName(this.ten);
        String str2 =getName(o.getTen());
        System.out.println(str1+" "+str2);
        return str1.compareTo(str2);
    }
   public int compareTo1(SanPham o) {
       return this.getNSX().compareTo(o.getHSD());
   }
 
   public String writeCSV() {
              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
               String d1 = this.getNSX().format(formatter);
               String d2 = this.getHSD().format(formatter); 
		String str = String.format("%s,%s,%s,%d,%d,%s,%s\n",getMaSP(),getTen(),getNhaSX(),getSoLuong(),getGia(),d1,d2);
		return str;
	}
    
}
