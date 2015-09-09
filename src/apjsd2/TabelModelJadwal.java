/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apjsd2;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author zaf
 */
public class TabelModelJadwal extends AbstractTableModel{

    private List<Jadwal> jadwal;

    public TabelModelJadwal(List<Jadwal> jadwal) {
        this.jadwal = jadwal;
    }
    
    public int getRowCount() {
        return jadwal.size();
    }

    public int getColumnCount() {
        return 3;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return jadwal.get(rowIndex).getJam();
            case 1:
                return jadwal.get(rowIndex).getPelajaran();
            case 2:
                return jadwal.get(rowIndex).getGuru();
            default:
                return null;
        }
    }
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "JAM";
            case 1:
                return "PELAJARAN";
            case 2:
                return "GURU";
            default:
                return null;
        }
    }
    
}
