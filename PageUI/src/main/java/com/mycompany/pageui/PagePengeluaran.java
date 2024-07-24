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
public class PagePengeluaran extends javax.swing.JFrame {

    /**
     * Creates new form PagePengeluaran
     */
    public PagePengeluaran() {
        initComponents();
        setTitle("FORM PAGE PENGELUARAN");
        this.setLocation(200, 100);
        PageUI.getConnection();
        refreshPengeluaran();
    }
    
    private void SimpanPengeluaran() {
        String sql = "INSERT INTO pengeluaran (jumlah, keterangan) VALUES (?, ?)";

        try {
            PreparedStatement st = PageUI.conn.prepareStatement(sql);
            st.setString(1, txtPengeluaran.getText());
            st.setString(2, txtKeterangan.getText());
            st.execute();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan");
            refreshPengeluaran();
            clearData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void editPengeluaran() {
        String sql = "UPDATE pengeluaran SET jumlah=?, keterangan=? WHERE pengeluaran_id=?";

        try {
            PreparedStatement st = PageUI.conn.prepareStatement(sql);
            st.setString(1, txtPengeluaran.getText());
            st.setString(2, txtKeterangan.getText());
            st.setString(3, TablePengeluaran.getValueAt(TablePengeluaran.getSelectedRow(), 0).toString());
            st.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil diupdate");
            refreshPengeluaran();
            clearData();
            BtnAdd.setEnabled(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void hapusPengeluaran(String pengeluaranId) {
        String sql = "DELETE FROM pengeluaran WHERE pengeluaran_id=?";
        try {
            PreparedStatement st = PageUI.conn.prepareStatement(sql);
            st.setString(1, pengeluaranId);
            st.execute();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
            refreshPengeluaran();
            clearData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void tampilPengeluaran(String keyword) {
        Statement st;
        ResultSet rs;
        try {
            st = PageUI.conn.createStatement();
            String sql = "SELECT * FROM pengeluaran WHERE keterangan LIKE '%" + keyword + "%'";
            rs = st.executeQuery(sql);
            String[] header = {"pengeluaran_id", "Tanggal", "Jumlah", "Keterangan"};
            DefaultTableModel model = new DefaultTableModel(header, 0);
            while (rs.next()) {
                Object[] row = {
                    rs.getString("pengeluaran_id"),
                    rs.getString("tanggal"),
                    rs.getString("jumlah"),
                    rs.getString("keterangan")
                };
                model.addRow(row);
            }
            TablePengeluaran.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public void refreshPengeluaran() {
        Statement st;
        ResultSet rs;
        try {
            st = PageUI.conn.createStatement();
            String sql = "SELECT * FROM pengeluaran ORDER BY pengeluaran_id ASC";
            rs = st.executeQuery(sql);
            String[] header = {"pengeluaran_id", "Tanggal", "Jumlah", "Keterangan"};
            DefaultTableModel model = new DefaultTableModel(header, 0);
            while (rs.next()) {
                Object[] row = {
                    rs.getString("pengeluaran_id"),
                    rs.getString("tanggal"),
                    rs.getString("jumlah"),
                    rs.getString("keterangan")
                };
                model.addRow(row);
            }
            TablePengeluaran.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void clearData() {
        txtPengeluaran.setText("");
        txtKeterangan.setText("");
        txtPengeluaran.requestFocus();
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
        Pengeluaran = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtPengeluaran = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtKeterangan = new javax.swing.JTextField();
        BtnAdd = new javax.swing.JButton();
        BtnScr = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablePengeluaran = new javax.swing.JTable();

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

        Pengeluaran.setBackground(new java.awt.Color(0, 0, 102));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pengeluaran");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Jumlah");

        txtPengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPengeluaranActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Keterangan");

        txtKeterangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKeteranganActionPerformed(evt);
            }
        });

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

        TablePengeluaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TablePengeluaran);

        javax.swing.GroupLayout PengeluaranLayout = new javax.swing.GroupLayout(Pengeluaran);
        Pengeluaran.setLayout(PengeluaranLayout);
        PengeluaranLayout.setHorizontalGroup(
            PengeluaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1084, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(PengeluaranLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(PengeluaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel30)
                    .addComponent(txtPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(txtKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PengeluaranLayout.createSequentialGroup()
                        .addComponent(BtnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnScr)
                        .addGap(18, 18, 18)
                        .addComponent(BtnDelete)))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PengeluaranLayout.setVerticalGroup(
            PengeluaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PengeluaranLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(PengeluaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PengeluaranLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(txtPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(txtKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(PengeluaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnAdd)
                            .addGroup(PengeluaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BtnDelete)
                                .addComponent(BtnScr))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jBgLayout = new javax.swing.GroupLayout(jBg);
        jBg.setLayout(jBgLayout);
        jBgLayout.setHorizontalGroup(
            jBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBgLayout.createSequentialGroup()
                .addComponent(index, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pengeluaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jBgLayout.setVerticalGroup(
            jBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBgLayout.createSequentialGroup()
                .addComponent(index, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jBgLayout.createSequentialGroup()
                .addComponent(Pengeluaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void txtPengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPengeluaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPengeluaranActionPerformed

    private void txtKeteranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeteranganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeteranganActionPerformed

    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
        SimpanPengeluaran();
    }//GEN-LAST:event_BtnAddActionPerformed

    private void BtnScrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnScrActionPerformed
        String pengeluaranId = JOptionPane.showInputDialog(this, "Cari Pengeluaran:");
        tampilPengeluaran(pengeluaranId);
    }//GEN-LAST:event_BtnScrActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        String pengeluaranId = TablePengeluaran.getValueAt(TablePengeluaran.getSelectedRow(), 0).toString();
        hapusPengeluaran(pengeluaranId);
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
            java.util.logging.Logger.getLogger(PagePengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagePengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagePengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagePengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PagePengeluaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnScr;
    private javax.swing.JPanel Pengeluaran;
    private javax.swing.JButton RiTra;
    private javax.swing.JTable TablePengeluaran;
    private javax.swing.JButton home;
    private javax.swing.JButton income;
    private javax.swing.JPanel index;
    private javax.swing.JPanel jBg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton outcome;
    private javax.swing.JTextField txtKeterangan;
    private javax.swing.JTextField txtPengeluaran;
    // End of variables declaration//GEN-END:variables


}
