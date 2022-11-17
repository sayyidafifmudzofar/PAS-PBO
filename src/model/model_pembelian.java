/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.controller_pembelian;
import inventory.PEMBELIAN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import koneksi.koneksiStok;


public class model_pembelian implements controller_pembelian {

    @Override
    public void Simpan(PEMBELIAN B) throws SQLException {
        try {
            Connection con = koneksiStok.getcon();
            String sql = "Insert Into pembelian Values(?,?,?)";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, B.txtnamap.getText());
            prepare.setString(2, B.txtharga.getText());
            prepare.setString(3, B.txttotal.getText());
              prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATA BERHASIL MASUK KE HATI DIA");
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            Tampil(B);
        }

    }

    @Override
    public void Tampil(PEMBELIAN B) throws SQLException {
       B.tblmodel.getDataVector().removeAllElements();
      B.tblmodel.fireTableDataChanged();
       try {
            Connection con = koneksiStok.getcon();
            java.sql.Statement stt = con.createStatement();
           // Query Menampilkan Semua Data Pada Table penjualan
           String sql = "SELECT * FROM pembelian ORDER BY Nama_produk";
           ResultSet res = stt.executeQuery(sql);
            while (res.next()) {                
                Object[] ob = new Object[5];
                ob[0] = res.getString(1);
                ob[1] = res.getString(2);
                ob[2] = res.getInt(3);
                B.tblmodel.addRow(ob);
            }
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
