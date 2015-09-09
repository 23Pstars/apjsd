/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package apjsd2;

/**
 *
 * @author zaf
 */
public class Query {
    public Query(){
        Connection a = new Connection();
        koneksi = a.getConnection();
        try {
            perintah = koneksi.createStatement();
        } catch (Exception e){
            
        }
    }
    boolean insertGuru(String guru){
        try {
            perintah.execute("INSERT INTO guru (guru) VALUES ('"+guru+"')");
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    boolean insertMatpel(String matpel, Object jam, Object guru){
        try {
            perintah.execute("INSERT INTO matpel (matpel, jam, guru) VALUES ('"+matpel+"', '"+jam+"', '"+guru+"')");
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    boolean insertJadwal(String hari, int kelas, int jam, String matpel){
        try {
            perintah.execute("INSERT INTO jadwal (hari, kelas, jam, matpel) VALUES ('"+hari+"', '"+kelas+"', '"+jam+"', '"+matpel+"')");
                    return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    java.sql.ResultSet getGuru(){
        try {
            hasil = perintah.executeQuery("SELECT * FROM guru");
            return hasil;
        } catch (Exception e) {
            return null;
        }
    }
    java.sql.ResultSet getMatpel(){
        try {
            hasil = perintah.executeQuery("SELECT * FROM matpel");
            return hasil;
        } catch (Exception e) {
            return null;
        }
    }
    java.sql.ResultSet getJadwal(){
        try {
            hasil = perintah.executeQuery("SELECT * FROM jadwal");
            return hasil;
        } catch (Exception e) {
            return null;
        }
    }
    java.sql.ResultSet getJadwalByHari(int kelas, String hari){
        try {
            hasil = perintah.executeQuery("SELECT * FROM jadwal, matpel WHERE jadwal.matpel = matpel.matpel AND jadwal.kelas = '"+kelas+"' AND jadwal.hari = '"+hari+"'");
            return hasil;
        } catch (Exception e) {
            return null;
        }
    }
    void setListGuru(javax.swing.JList list){
         try {
            hasil = perintah.executeQuery("SELECT * FROM guru");
            hasil.last();
            int i = 0;
            Object[] a;
            if (hasil.getRow()!=0){
                a = new Object[hasil.getRow()];
                hasil.first();
                do {
                    a[i] = hasil.getObject(2);
                    i++;
                } while (hasil.next());
            } else {
                a = new Object[0];
            }
            list.setListData(a);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    void setListMatpel(javax.swing.JList list){
         try {
            hasil = perintah.executeQuery("SELECT * FROM matpel");
            hasil.last();
            int i = 0;
            Object[] a;
            if (hasil.getRow()!=0){
                a = new Object[hasil.getRow()];
                hasil.first();
                do {
                    a[i] = hasil.getObject(2);
                    i++;
                } while (hasil.next());
            } else {
                a = new Object[0];
            }
            list.setListData(a);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    void setComboBoxGuru(javax.swing.JComboBox comboBox){
        try {
            hasil = getGuru();
            while (hasil.next()){
                comboBox.addItem(hasil.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    boolean updateGuru(String lama, String baru){
        try {
            perintah.execute("UPDATE guru SET guru = '"+baru+"' WHERE guru = '"+lama+"'");
            perintah.execute("UPDATE matpel SET guru = '"+baru+"' WHERE guru = '"+lama+"'");
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    boolean updateMatpel(String lama, String baru, Object jam, String guru){
        try {
            perintah.execute("UPDATE matpel SET matpel = '"+baru+"', jam = "+jam+", guru = '"+guru+"' WHERE matpel = '"+lama+"'\n\n");
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    boolean deleteGuru(String guru){
        try {
            perintah.execute("DELETE FROM guru WHERE guru = '"+guru+"'");
            hasil = perintah.executeQuery("SELECT * FROM matpel");
            hasil.first();
            perintah.execute("UPDATE matpel SET guru = '"+hasil.getString("guru") +"' WHERE guru = '"+guru+"'");
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    boolean deleteMatpel(String matpel){
        try {
            perintah.execute("DELETE FROM matpel WHERE matpel = '"+matpel+"'");
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    boolean truncateJadwal(){
        try {
            perintah.execute("TRUNCATE TABLE jadwal ");
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    void setHighlightMatpel(Object matpel, javax.swing.JSpinner spinnerJam, javax.swing.JComboBox comboBoxGuru){
        try {
            hasil = perintah.executeQuery("SELECT * FROM matpel WHERE matpel = '"+matpel+"'");
            hasil.first();
            spinnerJam.setValue(hasil.getObject("jam"));
            comboBoxGuru.setSelectedItem(hasil.getString("guru"));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    boolean isJadwalEmptyResult(){
        try {
            hasil = getJadwal();
            hasil.last();
            if (hasil.getRow() > 0){
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            return false;
        }
    }
    boolean isCollision(String hari, int jam, String matpel){
        try {
            hasil = perintah.executeQuery("SELECT * FROM jadwal WHERE hari = '"+hari+"' AND jam = '"+jam+"' AND matpel = '"+matpel+"'");
            hasil.last();
            //System.out.print(" last : "+hasil.getRow()+" ("+hari+", "+jam+", "+matpel+" ");
            if (hasil.getRow() > 0){
                return true;
            } else {
                return false;
            }
        } catch (Exception e){
            return false;
        }
    }
    
    private java.sql.Connection koneksi;
    private java.sql.Statement perintah;
    private java.sql.ResultSet hasil;
}
