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
public class top10SPItNhat implements Comparator<SanPham>{

    @Override
    public int compare(SanPham o1, SanPham o2) {
          return (o1.getSoLuong() - o2.getSoLuong());
    }

   
    
}