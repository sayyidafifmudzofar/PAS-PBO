/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;


import inventory.PRODUK;
import java.sql.SQLException;

/**
 *
 * @author musti
 */
public interface controller_produk {
     public void Simpan(PRODUK A) throws SQLException;
    public void Tampil( PRODUK A) throws SQLException;
    public void KlikTable(PRODUK A) throws SQLException;
    public void Hapus(PRODUK A) throws SQLException;
       public void Ubah(PRODUK A) throws SQLException;
       public void Baru(PRODUK A) throws SQLException;
}
