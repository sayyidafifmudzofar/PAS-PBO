/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.controller_produk;
import inventory.PRODUK;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import koneksi.koneksiStok;

/**
 *
 * @author musti
 */
public class model_produk implements controller_produk {

    @Override
    public void Simpan(PRODUK A) throws SQLException {
        try {
            Connection con = koneksiStok.getcon();
            String sql = "Insert Into produk Values(?,?,?,?,?)";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, A.txtnmproduk.getText());
            prepare.setString(2, A.txtdes.getText());
            prepare.setInt(3,Integer.valueOf(A.txtharga.getText()));
            prepare.setInt(4,Integer.valueOf(A.txtqty.getText()));
            prepare.setString(5, A.txtpesanulang.getText());
              prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATA BERHASIL MASUK KE HATI DIA");
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            Tampil(A);
        }
    }

    @Override
    public void Tampil(PRODUK A) throws SQLException {
       A.tblmodel.getDataVector().removeAllElements();
      A.tblmodel.fireTableDataChanged();
       try {
            Connection con = koneksiStok.getcon();
            java.sql.Statement stt = con.createStatement();
           // Query Menampilkan Semua Data Pada Table penjualan
           String sql = "SELECT * FROM produk ORDER BY nama_produk";
           ResultSet res = stt.executeQuery(sql);
            while (res.next()) {                
                Object[] ob = new Object[5];
                ob[0] = res.getString(1);
                ob[1] = res.getString(2);
                ob[2] = res.getInt(3);
                ob[3] = res.getInt(4);
                ob[4] = res.getString(5);
                A.tblmodel.addRow(ob);
            }
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Ubah(PRODUK A) throws SQLException {
        try {
            Connection con = koneksiStok.getcon();
          String sql = "UPDATE produk SET Deskripsi=?, harga=?, Qty=?, " + "Pesanan_ulang=? WHERE nama_produk=?";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(5, A.txtnmproduk.getText());
            prepare.setString(1, A.txtdes.getText());
            prepare.setInt(2,Integer.valueOf(A.txtharga.getText()));
            prepare.setInt(3,Integer.valueOf(A.txtqty.getText()));
            prepare.setString(4, A.txtpesanulang.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diubah");
            prepare.close();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            Tampil(A);
            Baru(A);
        }
    }

    
    @Override
    public void KlikTable(PRODUK A) throws SQLException {
        try {
        int pilih = A.tabel.getSelectedRow();
        if (pilih == -1) {
            return;
        }
        A.txtnmproduk.setText(A.tblmodel.getValueAt (pilih, 0).toString());
        A.txtdes.setText(A.tblmodel.getValueAt (pilih, 1).toString());
        A.txtharga.setText(A.tblmodel.getValueAt (pilih, 2).toString());
        A.txtqty.setText(A.tblmodel.getValueAt (pilih, 3).toString());
        A.txtpesanulang.setText(A.tblmodel.getValueAt (pilih, 4).toString());
       
    } catch (Exception e) {
    }
     
  
    }

    @Override
    public void Hapus(PRODUK A) throws SQLException {
        try {
            Connection con = koneksiStok.getcon();
            String sql = "DELETE FROM produk WHERE nama_produk=?";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, A.txtnmproduk.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diHapus");
            prepare.close();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            Tampil(A);
//            A.setLebarKolom();
            Baru(A);
       }

    }

    @Override
    public void Baru(PRODUK A) throws SQLException {
       A.txtnmproduk.setText("");
        A.txtdes.setText("");
        A.txtharga.setText("");
         A.txtqty.setText("");
         A.txtpesanulang.setText("");

    }

   
    }
    

    

