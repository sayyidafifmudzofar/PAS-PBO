/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.controller;
import inventory.PENJUALAN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import koneksi.koneksiStok;
import java.sql.ResultSet;

public class model implements controller {

    @Override
    public void Simpan(PENJUALAN P) throws SQLException {
         try {
            Connection con = koneksiStok.getcon();
            String sql = "INSERT INTO penjualan Values(?,?,?,?)";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, P.txtNp.getText());
            prepare.setInt(2,Integer.valueOf(P.txtNoHP.getText()));
            prepare.setString(3, P.txtemail.getText());
            prepare.setString(4, P.txtalamat.getText());
              prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATA BERHASIL MASUK KE HATI DIA");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
             Tampil(P);
         }
    }

    @Override
    public void Tampil(PENJUALAN P) throws SQLException {
      P.tblmodel.getDataVector().removeAllElements();
      P.tblmodel.fireTableDataChanged();
       try {
            Connection con = koneksiStok.getcon();
            java.sql.Statement stt = con.createStatement();
           // Query Menampilkan Semua Data Pada Table penjualan
           String sql = "SELECT * FROM penjualan ORDER BY nama";
           ResultSet res = stt.executeQuery(sql);
            while (res.next()) {                
                Object[] ob = new Object[4];
                ob[0] = res.getString(1);
                ob[1] = res.getString(2);
                ob[2] = res.getString(3);
                ob[3] = res.getString(4);
                P.tblmodel.addRow(ob);
            }
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void Ubah(PENJUALAN P) throws SQLException {
       try {
            Connection con = koneksiStok.getcon();
          String sql = "UPDATE penjualan SET phone=?, email=?," + "alamat=? WHERE nama=?";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(4, P.txtNp.getText());
            prepare.setString(1, P.txtNoHP.getText());
            prepare.setString(2, P.txtemail.getText());
            prepare.setString(3, P.txtalamat.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diUbah");
            prepare.close();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            Tampil(P);
//         
        }
    }

    @Override
    public void Hapus(PENJUALAN P) throws SQLException {
          try {
            Connection con = koneksiStok.getcon();
            String sql = "DELETE FROM penjualan WHERE nama=?";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, P.txtNp.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diHapus");
            prepare.close();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            Tampil(P);
//            P.setLebarKolom();
//            Baru(P);
       }

    }

    @Override
    public void KlikTable(PENJUALAN P) throws SQLException {
        try {
        int pilih = P.tabel.getSelectedRow();
        if (pilih == -1) {
            return;
        }
        P.txtNp.setText(P.tblmodel.getValueAt (pilih, 0).toString());
        P.txtNoHP.setText(P.tblmodel.getValueAt (pilih, 1).toString());
        P.txtemail.setText(P.tblmodel.getValueAt (pilih, 2).toString());
        P.txtalamat.setText(P.tblmodel.getValueAt (pilih, 3).toString());
       
    } catch (Exception e) {
    }
     
  
    }
    
}
