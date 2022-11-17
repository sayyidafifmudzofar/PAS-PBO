/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import inventory.PEMBELIAN;
import java.sql.SQLException;

/**
 *
 * @author musti
 */
public interface controller_pembelian {
         public void Simpan(PEMBELIAN B) throws SQLException;
         public void Tampil(PEMBELIAN B) throws  SQLException;
}
