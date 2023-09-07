/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyKhachHang;

import com.actvn.java06.deantotngiep.SanPham;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author HP
 */
public class Hoadon {
    
  private String name;
    private String sdt;
    private String MaHoaDon;
    private ArrayList<SanPham> SanPhamDaMua = new ArrayList<>();
    private Date datetime;
    private int Tien;

    public Hoadon() {
    }

    
    public Hoadon(String name,String sdt, String MaHoaDon) {
        this.name = name;
        this.sdt = sdt;
        this.MaHoaDon = MaHoaDon;
        this.datetime = new Date();
    }

    public Hoadon(String name, String sdt, String MaHoaDon, int Tien) {
        this.name = name;
        this.sdt = sdt;
        this.MaHoaDon = MaHoaDon;
        this.Tien = Tien;
    }
    
        public Hoadon(String name, String sdt, String MaHoaDon, int Tien, Date datetime) {
        this.name = name;
        this.sdt = sdt;
        this.MaHoaDon = MaHoaDon;
        this.Tien = Tien;
        this.datetime = datetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
   
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public ArrayList<SanPham> getSanPhamDaMua() {
        return SanPhamDaMua;
    }

    public void setSanPhamDaMua(ArrayList<SanPham> SanPhamDaMua) {
        this.SanPhamDaMua.addAll(SanPhamDaMua);
    }

    public void addSanPhamDaMua(ArrayList<SanPham> a){
        this.SanPhamDaMua.addAll(a);
    }
    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
    
    public int TongTienDaChi(){
        int tongtien = 0;
        for(SanPham sp : SanPhamDaMua){
            tongtien += sp.getTien();
        }
        return tongtien;
    }

    public int showTien(){
        return Tien;
    }
    public int getTien() {
         int tongtien1 = 0;
        for(SanPham sp : SanPhamDaMua){
            tongtien1 += sp.getTien();
        }
        return tongtien1;
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
        final Hoadon other = (Hoadon) obj;

        return Objects.equals(sdt, other.sdt);
    }
    public String toString(){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String DateString = df.format(datetime);
        return "Ten khach hang: "+getName()+ "; Sdt: "+ getSdt()+ "; Ma hoa don: "+getMaHoaDon()+"; Time: "+ DateString;
    }
    public String inradanhsachkhachhang(){
        return "Ten khach hang: "+getName()+ "; Sdt: "+ getSdt()+"; Ma hoa don: "+getMaHoaDon()+ "; Tien Tich Diem: "+ TongTienDaChi();
    }
    public String writeCSV2()
    {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String DateString = df.format(datetime);
        String str =String.format("%s,%s,%s,%d,%s\n",getName(),getSdt(),getMaHoaDon(),TongTienDaChi(),DateString);
        return str;
    }
    
}
