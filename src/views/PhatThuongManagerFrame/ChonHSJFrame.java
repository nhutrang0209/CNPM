/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.PhatThuongManagerFrame;

import controllers.PhatThuongManagerController.ChonHSController;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.HocSinh;

/**
 *
 * @author TNTDT
 */
public class ChonHSJFrame extends javax.swing.JFrame {

    private JFrame parentJFrame;
    private DefaultTableModel tableModel;
    private List<HocSinh> lstHs;

    /**
     * Creates new form ChonHocSinhJRame
     */
    public ChonHSJFrame(JFrame parentJFrame) {
        initComponents();
        this.parentJFrame = parentJFrame;
        tableModel = (DefaultTableModel) tblHS.getModel();
        tblHS.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        tblHS.setRowHeight(28);
        tblHS.validate();
        tblHS.repaint();
        tblHS.setFont(new Font("Arial", Font.PLAIN, 14));
        tblHS.getColumnModel().getColumn(0).setMaxWidth(40);
        tblHS.getColumnModel().getColumn(0).setMinWidth(40);
        tblHS.getColumnModel().getColumn(0).setPreferredWidth(80);

        parentJFrame.setEnabled(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                parentJFrame.setEnabled(true);
                close();
            }
        });
        showHS();
    }

    private void close() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure to close??", "Confirm", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            this.parentJFrame.setEnabled(true);
            dispose();
        }
    }

    public void showHS() {
        lstHs = new ArrayList<>();
        lstHs = ChonHSController.findAll();
        tableModel.setRowCount(0);
        lstHs.forEach((HocSinh hss) -> {
            tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, hss.getIdNhanKhau(),
                hss.getHoTen(), hss.getGioiTinh(), hss.getNamSinh()});
        });

    }

    public String chonHs() {
        int selectIndex = tblHS.getSelectedRow();
        String tenHs = "";
        if (selectIndex >= 0) {
            HocSinh hs = lstHs.get(selectIndex);
            tenHs = hs.getHoTen();
        }
        return tenHs;
    }

    public String chonID() {
        int selectIndex = tblHS.getSelectedRow();
        String id = "";
        if (selectIndex >= 0) {
            HocSinh hs = lstHs.get(selectIndex);
            int x = hs.getIdNhanKhau();
            id = Integer.toString(x);
        }
        return id;
    }

    public String chonNs() {
        int selectIndex = tblHS.getSelectedRow();
        String tenNs = "";
        if (selectIndex >= 0) {
            HocSinh hs = lstHs.get(selectIndex);
            tenNs = hs.getNamSinh().toString();
        }
        return tenNs;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHS = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JLabel();
        txtNamSinh = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtIDNK = new javax.swing.JLabel();
        txtHT = new javax.swing.JLabel();
        txtNS = new javax.swing.JLabel();
        txtID = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Danh sách học sinh");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 18, 283, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tìm kiếm theo tên:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 64, 138, -1));

        txtTim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKeyPressed(evt);
            }
        });
        getContentPane().add(txtTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 61, 213, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 64, -1, -1));

        tblHS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "ID Nhân Khẩu", "Họ Tên", "Giới Tính", "Ngày Sinh "
            }
        ));
        tblHS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHS);
        if (tblHS.getColumnModel().getColumnCount() > 0) {
            tblHS.getColumnModel().getColumn(0).setMinWidth(50);
            tblHS.getColumnModel().getColumn(0).setMaxWidth(50);
            tblHS.getColumnModel().getColumn(1).setMinWidth(120);
            tblHS.getColumnModel().getColumn(1).setMaxWidth(120);
            tblHS.getColumnModel().getColumn(3).setMinWidth(100);
            tblHS.getColumnModel().getColumn(3).setMaxWidth(100);
            tblHS.getColumnModel().getColumn(4).setMinWidth(120);
            tblHS.getColumnModel().getColumn(4).setMaxWidth(120);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 99, 594, 310));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Họ Tên:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 78, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Ngày Sinh:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 78, -1));

        txtHoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 202, -1));

        txtNamSinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtNamSinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 468, 202, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Xác nhận");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, -1, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Show all");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(516, 64, 86, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("ID Nhân Khẩu:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 110, -1));

        txtIDNK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtIDNK, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 506, 154, -1));

        txtHT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtHT, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 220, -1));

        txtNS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtNS, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 220, -1));

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 210, -1));

        jLabel6.setText(" ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 520, 50, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String ht = txtHT.getText();
        String ns = txtNS.getText();
        String id = txtID.getText();
        if (!"".equals(ht) && !"".equals(ns)) {
            this.parentJFrame.setEnabled(true);
            dispose();
            PTCuoiNamJFrame.setTxtHoTen(ht);
            PTCuoiNamJFrame.setTxtNamSinh(ns);
            PTCuoiNamJFrame.setIDNK(id);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblHSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHSMouseClicked
        // TODO add your handling code here:
        String s1 = chonHs(), s2 = chonNs(), s3 = chonID();
        if (!"".equals(s1)) {
            txtHT.setText(s1);
            txtNS.setText(s2);
            txtID.setText(s3);
        }
    }//GEN-LAST:event_tblHSMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String ten = txtTim.getText();
        if (!"".equals(ten)) {
            lstHs = ChonHSController.timKienTheoTen(ten);
            tableModel.setRowCount(0);
            lstHs.forEach((HocSinh hss) -> {
                tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, hss.getIdNhanKhau(),
                    hss.getHoTen(), hss.getGioiTinh(), hss.getNamSinh()});
            });
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        showHS();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtTimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String ten = txtTim.getText();
            if (!"".equals(ten)) {
                lstHs = ChonHSController.timKienTheoTen(ten);
                tableModel.setRowCount(0);
                lstHs.forEach((HocSinh hss) -> {
                    tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, hss.getIdNhanKhau(),
                        hss.getHoTen(), hss.getGioiTinh(), hss.getNamSinh()});
                });
            }
        }
    }//GEN-LAST:event_txtTimKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHS;
    private javax.swing.JLabel txtHT;
    private javax.swing.JLabel txtHoTen;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtIDNK;
    private javax.swing.JLabel txtNS;
    private javax.swing.JLabel txtNamSinh;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
