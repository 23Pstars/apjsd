/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package apjsd2;

import java.sql.DriverManager;

/**
 *
 * @author zaf
 */
public class Connection {
    
    /** sesuaikan dengan database lokal **/
    String path = "jdbc:mysql://localhost/apjsd";
    String username = "winkom";
    String password = "gakpakepassword";
    
    public Connection(){
        try {
            koneksi = DriverManager.getConnection(path, username, password);
        } catch (Exception e){
            System.out.println("Cannot connect to database, "+e.getMessage());
        }
    }
    public java.sql.Connection getConnection(){
        return koneksi;
    }
    java.sql.Connection koneksi;
}