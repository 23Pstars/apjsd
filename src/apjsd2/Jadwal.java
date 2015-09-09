/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apjsd2;

/**
 *
 * @author zaf
 */
public class Jadwal {
    private int jam;
    private String pelajaran;
    private String guru;

    public void setGuru(String guru) {
        this.guru = guru;
    }

    public void setJam(int jam) {
        this.jam = jam;
    }

    public void setPelajaran(String pelajaran) {
        this.pelajaran = pelajaran;
    }

    public String getGuru() {
        return guru;
    }

    public int getJam() {
        return jam;
    }

    public String getPelajaran() {
        return pelajaran;
    }
    
}
