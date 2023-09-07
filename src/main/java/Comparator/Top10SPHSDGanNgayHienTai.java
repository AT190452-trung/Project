/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparator;

import com.actvn.java06.deantotngiep.SanPham;
import java.util.Comparator;

/**
 *
 * @author Admin
 */
public class Top10SPHSDGanNgayHienTai implements Comparator<SanPham>{
    
     public int compare(SanPham o1, SanPham o2) {
          return o2.getNSX().compareTo(o1.getNSX());
    }
    
}
