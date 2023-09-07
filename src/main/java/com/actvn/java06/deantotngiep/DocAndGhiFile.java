/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.actvn.java06.deantotngiep;

import QuanLyKhachHang.Hoadon;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.LocalDate;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DocAndGhiFile {

    private static final String curentDir = System.getProperty("user.dir");
    private static final String separator = File.separator;
    private static final String PATH_FILE_CSV = curentDir + separator + "data" + separator + "SanPham.csv";
    private static final String PATH_FILE_CSV_1 = curentDir + separator + "data" + separator + "SP.csv";
    private static final String PATH_FILE_CSV_2 = curentDir + separator + "data" + separator + "spHetHan.csv";
    private static final String PATH_FILE_CSV_3 = curentDir + separator + "data" + separator + "SapXep10SPcoHSD.csv";
    private static final String PATH_FILE_CSV_4 = curentDir + separator + "data" + separator + "SPCungTen.csv";
    private static final String PATH_FILE_CSV_5 = curentDir + separator + "data" + separator + "Top10SPnhieunhat.csv";
    private static final String PATH_FILE_CSV_6 = curentDir + separator + "data" + separator + "Top10SPitnhat.csv";
    private static final String PATH_FILE_CSV_7 = curentDir + separator + "data" + separator + "SPcungNSX.csv";
    private static final String PATH_FILE_CSV_8 = curentDir + separator + "data" + separator + "SPsaukhiban.csv";
    private static final String PATH_FILE_CSV_9 = curentDir + separator + "data" + separator + "HoaDon.csv";

    public static List<SanPham> docfile() throws FileNotFoundException {
        List<SanPham> list = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        BufferedReader bf = new BufferedReader(new FileReader(PATH_FILE_CSV));
        String line;
        //đọc file
        try {
            bf.readLine();
            while ((line = bf.readLine()) != null) {
                String[] str = line.split(",");
                LocalDate NSX = LocalDate.parse(str[5], formatter);
                LocalDate HSD = LocalDate.parse(str[6], formatter);

                SanPham sp = new SanPham(str[0], str[1], str[2], Integer.parseInt(str[3]), Integer.parseInt(str[4]), NSX, HSD);
                list.add(sp);
            }
            bf.close();
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            System.out.println("e.printStackTrace()");
        }

        return list;
    }

    public static List<SanPham> docfile2() throws FileNotFoundException {
        List<SanPham> list2 = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        BufferedReader bf = new BufferedReader(new FileReader(PATH_FILE_CSV_8));
        String line;
        //đọc file
        try {
            bf.readLine();
            while ((line = bf.readLine()) != null) {
                String[] str = line.split(",");
                LocalDate NSX = LocalDate.parse(str[5], formatter);
                LocalDate HSD = LocalDate.parse(str[6], formatter);

                SanPham sp = new SanPham(str[0], str[1], str[2], Integer.parseInt(str[3]), Integer.parseInt(str[4]), NSX, HSD);
                list2.add(sp);
            }
            bf.close();
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            System.out.println("e.printStackTrace()");
        }

        return list2;
    }

    public static List<Hoadon> docfileHoaDon() throws FileNotFoundException {
        List<Hoadon> list3 = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new FileReader(PATH_FILE_CSV_9));
        String line;
        //đọc file
        try {
            bf.readLine();
            while ((line = bf.readLine()) != null) {
                String[] str = line.split(",");
                Date time = new Date(str[4]);
                Hoadon hd = new Hoadon(str[0], str[1], str[2], Integer.parseInt(str[3]), time);
                list3.add(hd);
            }
            bf.close();
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            System.out.println("e.printStackTrace()");
        }

        return list3;
    }

    public static void ghifile(List<SanPham> list) {
        BufferedWriter bw;

        try {
            bw = new BufferedWriter(new FileWriter(PATH_FILE_CSV));
            bw.append("maSp,ten,nhaSX,soLuong,gia,NSX,HSD\n");
            for (SanPham sanpham : list) {
                bw.append(sanpham.writeCSV());
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ghifilespHetHan(List<SanPham> list) {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(PATH_FILE_CSV_2));
            for (SanPham sanpham : list) {
                bw.append(sanpham.writeCSV());
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ghifileSapXep10SPcoHSD(List<SanPham> list) {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(PATH_FILE_CSV_3));
            for (SanPham sanpham : list) {
                bw.append(sanpham.writeCSV());
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ghifileSPCungTen(List<SanPham> list) {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(PATH_FILE_CSV_4));
            for (SanPham sanpham : list) {
                bw.append(sanpham.writeCSV());
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ghifileTop10SPnhieunhat(List<SanPham> list) {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(PATH_FILE_CSV_5));
            for (SanPham sanpham : list) {
                bw.append(sanpham.writeCSV());
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ghifileTop10SPitnhat(List<SanPham> list) {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(PATH_FILE_CSV_6));
            for (SanPham sanpham : list) {
                bw.append(sanpham.writeCSV());
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ghifileSPcungNSX(List<SanPham> list) {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(PATH_FILE_CSV_7));
            for (SanPham sanpham : list) {
                bw.append(sanpham.writeCSV());
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ghifilesaukhiban(List<SanPham> list) {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(PATH_FILE_CSV_8));
            for (SanPham sanpham : list) {
                bw.append(sanpham.writeCSV());
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ghifilehoadon(List<Hoadon> list) {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(PATH_FILE_CSV_9));
            bw.append("Ten,Sdt,Ma hoa don,Tien,DateTime\n");
            for (Hoadon hoadon : list) {
                bw.append(hoadon.writeCSV2());
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
