/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.PhatThuongManagerFrame;

import controllers.PhatThuongManagerController.DanhHieuController;
import controllers.PhatThuongManagerController.PTCuoiNamController;
import controllers.PhatThuongManagerController.PhanQuaController;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.DanhHieuModel;
import models.PhanQuaModel;
import models.PhatThuongCuoiNamModel;
import services.MysqlConnection;

/**
 *
 * @author TNTDT
 */
public class PTCuoiNamJFrame extends javax.swing.JFrame {

    private JFrame parentJFrame;
    DefaultTableModel tableModel;

    /**
     * Creates new form PTCuoiNamJFrame
     */
    public PTCuoiNamJFrame(JFrame parentJFrame) {
        initComponents();
        this.parentJFrame = parentJFrame;
        parentJFrame.setEnabled(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                parentJFrame.setEnabled(true);
                close();
            }

        });
        tableModel = (DefaultTableModel) tblHsNhanThuong.getModel();
        tblHsNhanThuong.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        tblHsNhanThuong.setRowHeight(40);
        tblHsNhanThuong.validate();
        tblHsNhanThuong.repaint();
        tblHsNhanThuong.setFont(new Font("Arial", Font.PLAIN, 14));
        tblHsNhanThuong.getColumnModel().getColumn(0).setMaxWidth(40);
        tblHsNhanThuong.getColumnModel().getColumn(0).setMinWidth(40);
        tblHsNhanThuong.getColumnModel().getColumn(0).setPreferredWidth(80);

        showHSNhanThuong();

    }

    public static void setTxtPT(String qua) {
        txtPhanThuong.setText(qua);
    }

    public static void setTxtHoTen(String hoTen) {
        txtHoTen.setText(hoTen);
    }

    public static void setIDNK(String ID) {
        txtIDNK.setText(ID);
    }

    public static void setTxtNamSinh(String namSinh) {
        txtNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtNamSinh.setText(namSinh);
    }

    private void close() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure to close??", "Confirm", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            this.parentJFrame.setEnabled(true);
            dispose();
        }
    }

    public void showHSNhanThuong() {

        Connection conn = null;
        Statement stm = null;

        try {
            conn = MysqlConnection.getMysqlConnection();
            String sql = "select hoTen, namSinh, danhHieu, tenQua, pt.soLuong "
                    + "from danh_hieu, phan_qua, phat_thuong_cuoi_nam pt "
                    + "where IDHS = danh_hieu.ID and IDPhanQua = phan_qua.ID";
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            tableModel.setRowCount(0);
            while (rs.next()) {
                tableModel.addRow(new Object[]{tableModel.getRowCount() + 1,
                    rs.getString("hoTen"),
                    rs.getDate("namSinh"),
                    rs.getString("danhHieu"),
                    rs.getString("tenQua"),
                    rs.getInt("soLuong")
                });
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PTCuoiNamJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHsNhanThuong = new javax.swing.JTable(){
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDanhHieu = new javax.swing.JTextField();
        btnPhatThuong = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtIDNK = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JLabel();
        txtNamSinh = new javax.swing.JLabel();
        txtPhanThuong = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtSoLuongPhat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Phát Thưởng Cuối Năm");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Danh sách học sinh đã nhận thưởng cuối năm");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 436, 30));

        tblHsNhanThuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Họ Tên", "Ngày Sinh", "Danh Hiệu", "Phần Thưởng", "Số lượng"
            }
        ));
        jScrollPane1.setViewportView(tblHsNhanThuong);
        if (tblHsNhanThuong.getColumnModel().getColumnCount() > 0) {
            tblHsNhanThuong.getColumnModel().getColumn(0).setMinWidth(40);
            tblHsNhanThuong.getColumnModel().getColumn(0).setMaxWidth(40);
            tblHsNhanThuong.getColumnModel().getColumn(2).setMinWidth(150);
            tblHsNhanThuong.getColumnModel().getColumn(2).setMaxWidth(150);
            tblHsNhanThuong.getColumnModel().getColumn(3).setMinWidth(100);
            tblHsNhanThuong.getColumnModel().getColumn(3).setMaxWidth(100);
            tblHsNhanThuong.getColumnModel().getColumn(4).setMinWidth(120);
            tblHsNhanThuong.getColumnModel().getColumn(4).setMaxWidth(120);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 710, 259));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 630, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Phát thưởng cho học sinh");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 12, 323, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Họ Tên:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 93, 24));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Danh hiệu:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 81, 25));

        txtDanhHieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDanhHieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel1.add(txtDanhHieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 400, 30));

        btnPhatThuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPhatThuong.setText("Phát Thưởng");
        btnPhatThuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhatThuongActionPerformed(evt);
            }
        });
        jPanel1.add(btnPhatThuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 136, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Chọn Quà:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 103, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Chọn phần quà");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 120, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Ngày Sinh:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 80, 21));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Chọn Học Sinh ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 130, 26));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("ID Nhân Khẩu:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 109, -1));

        txtIDNK.setBackground(new java.awt.Color(255, 255, 255));
        txtIDNK.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        txtIDNK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtIDNK.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIDNKFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDNKFocusLost(evt);
            }
        });
        txtIDNK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIDNKMouseClicked(evt);
            }
        });
        jPanel1.add(txtIDNK, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 260, 30));

        txtHoTen.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtHoTen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtHoTen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHoTenMouseClicked(evt);
            }
        });
        jPanel1.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 400, 30));

        txtNamSinh.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtNamSinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtNamSinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNamSinhMouseClicked(evt);
            }
        });
        jPanel1.add(txtNamSinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 400, 30));

        txtPhanThuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPhanThuong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtPhanThuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPhanThuongMouseClicked(evt);
            }
        });
        jPanel1.add(txtPhanThuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 270, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Số lượng");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        txtSoLuongPhat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoLuongPhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongPhatActionPerformed(evt);
            }
        });
        jPanel1.add(txtSoLuongPhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 400, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPhatThuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhatThuongActionPerformed
        // TODO add your handling code here:
        String hoTen = txtHoTen.getText();
        String idnk = txtIDNK.getText();
        String namSinh = txtNamSinh.getText();
        String danhHieu = txtDanhHieu.getText();
        String phanQua = txtPhanThuong.getText();
        String soLuong = txtSoLuongPhat.getText();
        int idQua = ChonQuaJFrame.getIdQua();
        int idNK = Integer.parseInt(idnk);
        int soluong = Integer.parseInt(soLuong);

        if (!"".equals(idnk) && !"".equals(hoTen) && !"".equals(namSinh) && !"".equals(danhHieu)
                && !"".equals(phanQua)) {
            if (!PhanQuaController.check(idQua, soluong)) {
                Date ns = Date.valueOf(namSinh);
                DanhHieuModel danhhieu = new DanhHieuModel(idNK, hoTen, ns, danhHieu);
                DanhHieuController.themDanhHieu(danhhieu);
                // System.out.println(danhhieu.getIDNhanKhau());
                // System.out.println(idNK);
                // System.out.println(danhhieu.getDanhHieu());
                int idHs = DanhHieuController.getID(idnk, danhHieu);
                PhatThuongCuoiNamModel pt = new PhatThuongCuoiNamModel(idHs, idQua, soluong);
                PTCuoiNamController.phatThuong(pt);
                showHSNhanThuong();
                PhanQuaModel qua = PhanQuaController.find(idQua);
                PhanQuaController.tangSoLuongDaPhat(qua, soluong);
                JOptionPane.showMessageDialog(rootPane, "Phát thưởng thành công");
            }else {
                JOptionPane.showMessageDialog(rootPane, "Hêt phần thưởng");
            } 
        } else {
            JOptionPane.showMessageDialog(rootPane, "Điền đầy đủ thông tin");
        }


    }//GEN-LAST:event_btnPhatThuongActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ChonQuaJFrame chonQua = new ChonQuaJFrame(parentJFrame);
        chonQua.setLocationRelativeTo(null);
        chonQua.setResizable(false);
        chonQua.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ChonHSJFrame chonHs = new ChonHSJFrame(parentJFrame);
        chonHs.setLocationRelativeTo(null);
        chonHs.setResizable(false);
        chonHs.setVisible(true);
        txtIDNK.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtHoTen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtNamSinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));

    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtIDNKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDNKMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn học sinh");
    }//GEN-LAST:event_txtIDNKMouseClicked

    private void txtHoTenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHoTenMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Vui lòng nhấn chọn học sinh");
    }//GEN-LAST:event_txtHoTenMouseClicked

    private void txtNamSinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNamSinhMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Vui lòng nhấn chọn học sinh");
    }//GEN-LAST:event_txtNamSinhMouseClicked

    private void txtIDNKFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDNKFocusGained
        // TODO add your handling code here:    
    }//GEN-LAST:event_txtIDNKFocusGained

    private void txtIDNKFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDNKFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDNKFocusLost

    private void txtPhanThuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPhanThuongMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Vui lòng nhấn chọn phần quà");
    }//GEN-LAST:event_txtPhanThuongMouseClicked

    private void txtSoLuongPhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongPhatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongPhatActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPhatThuong;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHsNhanThuong;
    private javax.swing.JTextField txtDanhHieu;
    private static javax.swing.JLabel txtHoTen;
    private static javax.swing.JLabel txtIDNK;
    private static javax.swing.JLabel txtNamSinh;
    private static javax.swing.JLabel txtPhanThuong;
    private javax.swing.JTextField txtSoLuongPhat;
    // End of variables declaration//GEN-END:variables
}
