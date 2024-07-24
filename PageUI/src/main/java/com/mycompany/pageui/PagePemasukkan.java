/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pageui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class PagePemasukkan extends javax.swing.JFrame {

    /**
     * Creates new form PagePemasukkan
     */
    public PagePemasukkan() {
        initComponents();
        setTitle("FORM PAGE PEMASUKAN");
        this.setLocation(200, 100);
        PageUI.getConnection();
        refreshPemasukan();
    }
    /*
    initComponents(): Memanggil metode yang menginisialisasi komponen GUI.
    setTitle("FORM DATA ANGGOTA"): Mengatur judul dari jendela aplikasi menjadi "FORM DATA ANGGOTA".
    this.setLocation(200, 100): Mengatur posisi jendela pada layar.
    ProjectPakKhadafi.getConnection(): Memanggil metode untuk mendapatkan koneksi ke database dari kelas ProjectPakKhadafi.
    refreshSiswa(): Metode untuk memperbarui data siswa (belum diberikan di kode, tetapi diasumsikan ada untuk menyegarkan data di tabel atau list).
    BtnEdit.setEnabled(false): Menonaktifkan tombol edit saat pertama kali aplikasi dijalankan.*/

    private void SimpanPemasukan() {
        String sql = "INSERT INTO pemasukkan (jumlah, keterangan) VALUES (?, ?)";

        try {
            PreparedStatement st = PageUI.conn.prepareStatement(sql);
            st.setString(1, txtPemasukan.getText());
            st.setString(2, txtKet.getText());
            st.execute();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan");
            refreshPemasukan();
            clearData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void editPemasukan() {
        String sql = "UPDATE pemasukkan SET jumlah=?, keterangan=? WHERE pemasukkan_id=?";

        try {
            PreparedStatement st = PageUI.conn.prepareStatement(sql);
            st.setString(1, txtPemasukan.getText());
            st.setString(2, txtKet.getText());
            st.setString(3, TablePemasukkan.getValueAt(TablePemasukkan.getSelectedRow(), 0).toString());
            st.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil diupdate");
            refreshPemasukan();
            clearData();
            BtnAdd.setEnabled(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void hapusPemasukan(String pemasukkanId) {
        String sql = "DELETE FROM pemasukkan WHERE pemasukkan_id=?";
        try {
            PreparedStatement st = PageUI.conn.prepareStatement(sql);
            st.setString(1, pemasukkanId);
            st.execute();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
            refreshPemasukan();
            clearData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void tampilPemasukkan(String keyword) {
        Statement st;
        ResultSet rs;
        try {
            st = PageUI.conn.createStatement();
            String sql = "SELECT * FROM pemasukkan WHERE keterangan LIKE '%" + keyword + "%'";
            rs = st.executeQuery(sql);
            String[] header = {"pemasukkan_id", "Tanggal", "Jumlah", "Keterangan"};
            DefaultTableModel model = new DefaultTableModel(header, 0);
            while (rs.next()) {
                Object[] row = {
                    rs.getString("pemasukkan_id"),
                    rs.getString("tanggal"),
                    rs.getString("jumlah"),
                    rs.getString("keterangan")
                };
                model.addRow(row);
            }
            TablePemasukkan.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public void refreshPemasukan() {
        Statement st;
        ResultSet rs;
        try {
            st = PageUI.conn.createStatement();
            String sql = "SELECT * FROM pemasukkan ORDER BY pemasukkan_id ASC";
            rs = st.executeQuery(sql);
            String[] header = {"Pemasukkan ID", "Tanggal", "Jumlah", "Keterangan"};
            DefaultTableModel model = new DefaultTableModel(header, 0);
            while (rs.next()) {
                Object[] row = {
                    rs.getString("pemasukkan_id"),
                    rs.getString("tanggal"),
                    rs.getString("jumlah"),
                    rs.getString("keterangan")
                };
                model.addRow(row);
            }
            TablePemasukkan.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void clearData() {
        txtPemasukan.setText("");
        txtKet.setText("");
        txtPemasukan.requestFocus();
    }

    void Keluar() {
        int jawab = javax.swing.JOptionPane.showConfirmDialog(null, "Kamu yakin ingin keluar?", "Konfirmasi", javax.swing.JOptionPane.YES_NO_OPTION);
        if (jawab == 0) this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBg = new javax.swing.JPanel();
        index = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        home = new javax.swing.JButton();
        outcome = new javax.swing.JButton();
        income = new javax.swing.JButton();
        RiTra = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Pemasukkan = new javax.swing.JPanel();
        HeadMasuk = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtPemasukan = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtKet = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePemasukkan = new javax.swing.JTable();
        BtnAdd = new javax.swing.JButton();
        BtnScr = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBg.setBackground(new java.awt.Color(0, 0, 102));
        jBg.setPreferredSize(new java.awt.Dimension(1400, 800));

        index.setBackground(new java.awt.Color(0, 51, 153));
        index.setPreferredSize(new java.awt.Dimension(310, 800));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WALLET");

        home.setBackground(new java.awt.Color(0, 51, 153));
        home.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setText("Home");
        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        outcome.setBackground(new java.awt.Color(0, 51, 153));
        outcome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        outcome.setForeground(new java.awt.Color(255, 255, 255));
        outcome.setText("Pengeluaran");
        outcome.setBorderPainted(false);
        outcome.setContentAreaFilled(false);
        outcome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        outcome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outcomeActionPerformed(evt);
            }
        });

        income.setBackground(new java.awt.Color(0, 51, 153));
        income.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        income.setForeground(new java.awt.Color(255, 255, 255));
        income.setText("Pemasukkan");
        income.setBorderPainted(false);
        income.setContentAreaFilled(false);
        income.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        income.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incomeActionPerformed(evt);
            }
        });

        RiTra.setBackground(new java.awt.Color(0, 51, 153));
        RiTra.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        RiTra.setForeground(new java.awt.Color(255, 255, 255));
        RiTra.setText("Riwayat Transaksi");
        RiTra.setBorderPainted(false);
        RiTra.setContentAreaFilled(false);
        RiTra.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        RiTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RiTraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout indexLayout = new javax.swing.GroupLayout(index);
        index.setLayout(indexLayout);
        indexLayout.setHorizontalGroup(
            indexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(indexLayout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addGroup(indexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(outcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(income, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(indexLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        indexLayout.setVerticalGroup(
            indexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(indexLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(61, 61, 61)
                .addComponent(home)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(income)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(outcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RiTra)
                .addContainerGap(323, Short.MAX_VALUE))
        );

        Pemasukkan.setBackground(new java.awt.Color(0, 0, 102));

        HeadMasuk.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        HeadMasuk.setForeground(new java.awt.Color(255, 255, 255));
        HeadMasuk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HeadMasuk.setText("Pemasukkan");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Jumlah");

        txtPemasukan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPemasukanActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Keterangan");

        txtKet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKetActionPerformed(evt);
            }
        });

        TablePemasukkan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablePemasukkan);

        BtnAdd.setText("Add");
        BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddActionPerformed(evt);
            }
        });

        BtnScr.setText("Search");
        BtnScr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnScrActionPerformed(evt);
            }
        });

        BtnDelete.setText("Delete");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PemasukkanLayout = new javax.swing.GroupLayout(Pemasukkan);
        Pemasukkan.setLayout(PemasukkanLayout);
        PemasukkanLayout.setHorizontalGroup(
            PemasukkanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HeadMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
            .addGroup(PemasukkanLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(PemasukkanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30)
                    .addComponent(txtPemasukan)
                    .addComponent(txtKet, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PemasukkanLayout.createSequentialGroup()
                        .addComponent(BtnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnScr)
                        .addGap(18, 18, 18)
                        .addComponent(BtnDelete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        PemasukkanLayout.setVerticalGroup(
            PemasukkanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PemasukkanLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(HeadMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(PemasukkanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PemasukkanLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(txtPemasukan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(txtKet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(PemasukkanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnAdd)
                            .addComponent(BtnDelete)
                            .addComponent(BtnScr)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jBgLayout = new javax.swing.GroupLayout(jBg);
        jBg.setLayout(jBgLayout);
        jBgLayout.setHorizontalGroup(
            jBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBgLayout.createSequentialGroup()
                .addComponent(index, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pemasukkan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jBgLayout.setVerticalGroup(
            jBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBgLayout.createSequentialGroup()
                .addComponent(index, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jBgLayout.createSequentialGroup()
                .addComponent(Pemasukkan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jBg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jBg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
     PageHome PageHomeFrame = new PageHome();
        PageHomeFrame.setVisible(true);
        PageHomeFrame.pack();
        PageHomeFrame.setLocationRelativeTo(null);
        this.dispose();   

    }//GEN-LAST:event_homeActionPerformed

    private void outcomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outcomeActionPerformed
     PagePengeluaran PagePengeluaranFrame = new PagePengeluaran();
        PagePengeluaranFrame.setVisible(true);
        PagePengeluaranFrame.pack();
        PagePengeluaranFrame.setLocationRelativeTo(null);
        this.dispose();   
    }//GEN-LAST:event_outcomeActionPerformed

    private void incomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incomeActionPerformed
      PagePemasukkan PagePemasukkanFrame = new PagePemasukkan();
        PagePemasukkanFrame.setVisible(true);
        PagePemasukkanFrame.pack();
        PagePemasukkanFrame.setLocationRelativeTo(null);
        this.dispose();  
    }//GEN-LAST:event_incomeActionPerformed

    private void RiTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RiTraActionPerformed
      PageRiTra PageRiTraFrame = new PageRiTra();
        PageRiTraFrame.setVisible(true);
        PageRiTraFrame.pack();
        PageRiTraFrame.setLocationRelativeTo(null);
        this.dispose();  
    }//GEN-LAST:event_RiTraActionPerformed

    private void txtPemasukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPemasukanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPemasukanActionPerformed

    private void txtKetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKetActionPerformed

    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
        SimpanPemasukan();
    }//GEN-LAST:event_BtnAddActionPerformed

    private void BtnScrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnScrActionPerformed
        String pemasukkanId = JOptionPane.showInputDialog(this, "Cari Pemasukkan:");
        tampilPemasukkan(pemasukkanId);
    }//GEN-LAST:event_BtnScrActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        String pemasukkanId = TablePemasukkan.getValueAt(TablePemasukkan.getSelectedRow(), 0).toString();
        hapusPemasukan(pemasukkanId);
    }//GEN-LAST:event_BtnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PagePemasukkan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagePemasukkan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagePemasukkan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagePemasukkan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PagePemasukkan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnScr;
    private javax.swing.JLabel HeadMasuk;
    private javax.swing.JPanel Pemasukkan;
    private javax.swing.JButton RiTra;
    private javax.swing.JTable TablePemasukkan;
    private javax.swing.JButton home;
    private javax.swing.JButton income;
    private javax.swing.JPanel index;
    private javax.swing.JPanel jBg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton outcome;
    private javax.swing.JTextField txtKet;
    private javax.swing.JTextField txtPemasukan;
    // End of variables declaration//GEN-END:variables
}
