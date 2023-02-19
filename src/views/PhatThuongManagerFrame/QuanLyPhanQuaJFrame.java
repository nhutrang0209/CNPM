/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.PhatThuongManagerFrame;

import controllers.PhatThuongManagerController.PhanQuaController;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.PhanQuaModel;
import services.MysqlConnection;

/**
 *
 * @author TNTDT
 */
public class QuanLyPhanQuaJFrame extends javax.swing.JFrame {

    private JFrame parentJFrame;
    List<PhanQuaModel> lstQua = new ArrayList<>();
    DefaultTableModel tableModel;

    /**
     * Creates new form ThongKePhanQuaJFrame
     */
    public QuanLyPhanQuaJFrame(JFrame parentJFrame) {
        initComponents();
        this.parentJFrame = parentJFrame;
        tableModel = (DefaultTableModel) tblPhanQua.getModel();
        tblPhanQua.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        tblPhanQua.setRowHeight(40);
        tblPhanQua.validate();
        tblPhanQua.repaint();
        tblPhanQua.setFont(new Font("Arial", Font.PLAIN, 14));
        tblPhanQua.getColumnModel().getColumn(0).setMaxWidth(40);
        tblPhanQua.getColumnModel().getColumn(0).setMinWidth(40);
        tblPhanQua.getColumnModel().getColumn(0).setPreferredWidth(80);
        parentJFrame.setEnabled(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                parentJFrame.setEnabled(true);
                close();
            }
        });
        countTong();
        countDaPhat();
        tongTien();
        showQua();
    }

    private void close() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure to close??", "Confirm", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            this.parentJFrame.setEnabled(true);
            dispose();
        }
    }

    public void countTong() {
        Connection conn = null;
        Statement stm = null;

        int count = 0;
        try {
            conn = MysqlConnection.getMysqlConnection();
            String sql = "select soLuong from phan_qua";
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                count += rs.getInt("soLuong");
            }
            txtTong.setText(Integer.toString(count));

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(QuanLyPhanQuaJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void countDaPhat() {
        Connection conn = null;
        Statement stm = null;

        int count = 0;
        try {
            conn = MysqlConnection.getMysqlConnection();
            String sql = "select soLuongDaPhat from phan_qua";
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                count += rs.getInt("soLuongDaPhat");
            }
            txtConLai.setText(Integer.toString(count));

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(QuanLyPhanQuaJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void tongTien() {
        Connection conn = null;
        Statement stm = null;

        int tong = 0;
        try {
            conn = MysqlConnection.getMysqlConnection();
            String sql = "select giaTri, soLuong from phan_qua";
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                tong = tong + rs.getInt("giatri") * rs.getInt("soLuong");
            }
            txtTien.setText(Integer.toString(tong));

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(QuanLyPhanQuaJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showQua() {
        lstQua = PhanQuaController.findAll();

        tableModel.setRowCount(0);
        lstQua.forEach((PhanQuaModel qua) -> {
            tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, qua.getTenQua(),
                qua.getGiaTri(), qua.getSoLuong(), qua.getSoLuongDaPhat()});
        });
    }

    public void setText() {
        txtTenQua.setText(null);
        txtGiaTri.setText(null);
        txtSoLuong.setText(null);

    }

//    public void mouseClick() {
//        int selectIndex = tblPhanQua.getSelectedRow();
//        if (selectIndex >= 0) {
//            PhanQuaModel qua = lstQua.get(selectIndex);
//            txtTenQua.setText(qua.getTenQua());
//            txtGiaTri.setText(Integer.toString(qua.getGiaTri()));
//            txtSoLuong.setText(Integer.toString(qua.getSoLuong()));
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTong = new javax.swing.JLabel();
        txtConLai = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnThemMoi = new javax.swing.JButton();
        txtTenQua = new javax.swing.JTextField();
        txtGiaTri = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhanQua = new javax.swing.JTable(){
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        jLabel3 = new javax.swing.JLabel();
        txtTien = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("QUẢN LÝ PHẦN QUÀ");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Số lượng phần quà:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 24));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Số phần quà đã phát:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        txtTong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(txtTong, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 65, 24));

        txtConLai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(txtConLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 65, 19));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnThemMoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThemMoi.setText("Thêm mới");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });
        jPanel2.add(btnThemMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 114, -1));

        txtTenQua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(txtTenQua, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 270, -1));

        txtGiaTri.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(txtGiaTri, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 225, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("VNĐ");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 36, -1));

        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });
        jPanel2.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 270, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Tên phần quà:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 108, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Giá trị:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 108, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Số lượng:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 108, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 570, 160));

        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 530, -1, -1));

        tblPhanQua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên Phần Quà", "Giá Trị (VNĐ)", "Số Lượng", "Đã Phát"
            }
        ));
        tblPhanQua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhanQuaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhanQua);
        if (tblPhanQua.getColumnModel().getColumnCount() > 0) {
            tblPhanQua.getColumnModel().getColumn(0).setMinWidth(50);
            tblPhanQua.getColumnModel().getColumn(0).setMaxWidth(50);
            tblPhanQua.getColumnModel().getColumn(3).setMinWidth(100);
            tblPhanQua.getColumnModel().getColumn(3).setMaxWidth(100);
            tblPhanQua.getColumnModel().getColumn(4).setMinWidth(100);
            tblPhanQua.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 569, 251));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tổng số tiền:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 98, -1));

        txtTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(txtTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 113, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("VNĐ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 81, -1));

        jLabel5.setText("Điền thông tin để thêm mới");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 180, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Hướng dẫn");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        // TODO add your handling code here:
        String tenQua = txtTenQua.getText();
        String giatri = txtGiaTri.getText();
        String soluong = txtSoLuong.getText();

        if (!"".equals(tenQua) && !"".equals(giatri) && !"".equals(soluong)) {
            int giaTri = Integer.parseInt(giatri);
            int soLuong = Integer.parseInt(soluong);
            PhanQuaModel phanQua = new PhanQuaModel(tenQua, giaTri, soLuong);
            PhanQuaController.themMoiPhanQua(phanQua);
            JOptionPane.showMessageDialog(rootPane, "Thêm mới thành công");
            countTong();
            countDaPhat();
            tongTien();
            showQua();
            setText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin");
        }

    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void tblPhanQuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhanQuaMouseClicked
        // TODO add your handling code here:
        //mouseClick();
    }//GEN-LAST:event_tblPhanQuaMouseClicked

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ThongKePhanQuaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ThongKePhanQuaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ThongKePhanQuaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ThongKePhanQuaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new QuanLyPhanQuaJFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPhanQua;
    private javax.swing.JLabel txtConLai;
    private javax.swing.JTextField txtGiaTri;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenQua;
    private javax.swing.JLabel txtTien;
    private javax.swing.JLabel txtTong;
    // End of variables declaration//GEN-END:variables
}
