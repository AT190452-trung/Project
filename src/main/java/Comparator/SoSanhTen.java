/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparator;

import com.actvn.java06.deantotngiep.SanPham;
import java.util.Comparator;

/**
 *
 * @author HP
 */
public class SoSanhTen implements Comparator<SanPham>{

    @Override
    public int compare(SanPham o1, SanPham o2) {
        String[] str1 = o1.getTen().split(" ");
        String[] str2 = o2.getTen().split(" ");
        System.out.println(str1[str1.length-1]+" "+str2[str2.length-1]);
        return o1.getTen().split(" ")[o1.getTen().split(" ").length-1].compareTo(o2.getTen().split(" ")[o2.getTen().split(" ").length-1]);
    }
    
}
