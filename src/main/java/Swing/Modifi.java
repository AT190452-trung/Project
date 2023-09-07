/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Swing;

import com.actvn.java06.deantotngiep.SanPham;
import java.time.LocalDate;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP
 */
public class Modifi extends AbstractTableModel {

    private List<SanPham> sanpham;
    private final Class[] mClasses = {String.class, String.class, String.class, Integer.class, Integer.class, LocalDate.class, LocalDate.class};
    private final String[] cl = {"mã sản phẩm", "tên", "nhàSX", "số lượng", "giá tiền", "NSX", "HSD"};

  

    
    @Override
    public int getRowCount() {
        return sanpham.size();
    }

    @Override
    public int getColumnCount() {
        return cl.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SanPham sp = sanpham.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sp.getMaSP();
            case 1:
                return sp.getTen();
            case 2:
                return sp.getNSX();
            case 3:
                return sp.getSoLuong();
            case 4:
                return sp.getTien();
            case 5:
                return sp.getNSX();
            case 6:
                return sp.getHSD();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        SanPham sp = sanpham.get(rowIndex);
        switch (columnIndex) {
            case 0:
                sp.setMaSP((String) aValue);
                break;
            case 1:
                sp.setTen((String) aValue);
                break;
            case 2:
                sp.setNhaSX((String) aValue);
                break;
            case 3:
                sp.setSoLuong((Integer) aValue);
                break;
            case 4:
                sp.setGia((Integer) aValue);
                break;
            case 5:
                sp.setNSX((LocalDate) aValue);
                break;
            case 6:
                sp.setHSD((LocalDate) aValue);
                break;
        }
        System.out.println(sp);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return false;
        }
        return true;

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return mClasses[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return cl[column];
    }

}
