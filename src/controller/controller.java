/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import inventory.PENJUALAN;
import java.sql.SQLException;

/**
 *
 * @author musti
 */
public interface controller {
    public void Simpan(PENJUALAN P) throws SQLException;
    public void Tampil(PENJUALAN P) throws SQLException;
    public void Ubah(PENJUALAN P) throws SQLException;
    public void KlikTable(PENJUALAN P) throws SQLException;
    public void Hapus(PENJUALAN P) throws SQLException;
}
