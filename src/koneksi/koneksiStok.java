/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;

public class koneksiStok{
      private static Connection con;
    public static Connection getcon(){
        if (con == null){
            try{
                String url = "jdbc:mysql://localhost/stokmanagement"; //namadatabase
                String nama = "root";
                String Password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                con = DriverManager.getConnection(url, nama, Password);
            } catch (Exception e){
                System.out.println(e);
            }
        }
        return con;
    }
}


