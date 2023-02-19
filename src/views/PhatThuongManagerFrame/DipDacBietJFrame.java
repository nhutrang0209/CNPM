/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.PhatThuongManagerFrame;

import controllers.PhatThuongManagerController.DipDacBietController;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Date;
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
import models.DipDacBietModel;
import services.MysqlConnection;

/**
 *
 * @author TNTDT
 */
public class DipDacBietJFrame extends javax.swing.JFrame {

    private JFrame parentJFrame;
    DefaultTableModel tableModel;
    DefaultTableModel tableModel2;
    List<DipDacBietModel> lst;

    /**
     * Creates new form DipDacBietJFrame
     */
    public DipDacBietJFrame(JFrame parentJFrame) {
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
        tableModel = (DefaultTableModel) table.getModel();
        tableModel2 = (DefaultTableModel) tblHS.getModel();
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.setRowHeight(30);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(40);
        table.getColumnModel().getColumn(0).setMinWidth(40);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);

        tblHS.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        tblHS.setRowHeight(30);
        tblHS.validate();
        tblHS.repaint();
        tblHS.setFont(new Font("Arial", Font.PLAIN, 14));
        tblHS.getColumnModel().getColumn(0).setMaxWidth(40);
        tblHS.getColumnModel().getColumn(0).setMinWidth(40);
        tblHS.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.showList();
        this.showHS();

    }

    private void close() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure to close??", "Confirm", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            this.parentJFrame.setEnabled(true);
            dispose();
        }
    }

    public void showList() {
        lst = new ArrayList<>();
        lst = DipDacBietController.fillAll();
        tableModel.setRowCount(0);
        lst.forEach((DipDacBietModel dip) -> {
            tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, dip.getTenDipDacBiet(),
                dip.getNgayDienRa()});
        });
    }

    public void showHS() {
        Connection conn = null;
        Statement stm = null;

        try {
            conn = MysqlConnection.getMysqlConnection();
            String sql = "select hoTen, namSinh, tenQua, tenDipDacBiet, pt.soLuong "
                    + "from dip_dac_biet, phan_qua, pt_dip_dac_biet pt, nhan_khau "
                    + "where IDHS = nhan_khau.ID and IDPhanQua = phan_qua.ID and IDDipDacBiet = dip_dac_biet.ID "
                    + "and YEAR(CURRENT_TIMESTAMP) - YEAR(namSinh) <= 18";
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            tableModel2.setRowCount(0);
            while (rs.next()) {
                tableModel2.addRow(new Object[]{tableModel2.getRowCount() + 1, 
                    rs.getString("hoTen"),
                    rs.getDate("namSinh"), 
                    rs.getString("tenQua"), 
                    rs.getString("tenDipDacBiet"),
                    rs.getInt("soLuong")
                });
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PTCuoiNamJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String chonTen() {
        int selectIndex = table.getSelectedRow();
        String ten = "";
        if (selectIndex >= 0) {
            DipDacBietModel dip = lst.get(selectIndex);
            ten = dip.getTenDipDacBiet();
        }
        return ten;
    }

    public String chonNgay() {
        int selectIndex = table.getSelectedRow();
        String tenNgay = "";
        if (selectIndex >= 0) {
            DipDacBietModel dip = lst.get(selectIndex);
            tenNgay = dip.getNgayDienRa().toString();
        }
        return tenNgay;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable(){
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtNgay = new javax.swing.JTextField();
        txtSua = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHS = new javax.swing.JTable(){
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Dịp phát quà đặc biệt");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên Dịp", "Ngày diễn ra"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 340, 190));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Quản lý dịp phát quà");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 9, 198, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 80, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Dịp Phát Quà:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 126, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Ngày Diễn Ra:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 126, 20));

        txtHoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 200, 30));

        txtNgay.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtNgay.setText("yyyy-MM-dd");
        txtNgay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNgayFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNgayFocusLost(evt);
            }
        });
        jPanel1.add(txtNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 199, 30));

        txtSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSua.setText("Sửa");
        txtSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSuaActionPerformed(evt);
            }
        });
        jPanel1.add(txtSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 80, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 560, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Danh sách nhận quà");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 253, -1));

        tblHS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Họ Tên", "Ngày Sinh", "Tên Quà", "Dịp Nhận", "Số Lượng"
            }
        ));
        jScrollPane2.setViewportView(tblHS);
        if (tblHS.getColumnModel().getColumnCount() > 0) {
            tblHS.getColumnModel().getColumn(0).setMinWidth(50);
            tblHS.getColumnModel().getColumn(0).setMaxWidth(50);
            tblHS.getColumnModel().getColumn(2).setMinWidth(100);
            tblHS.getColumnModel().getColumn(2).setMaxWidth(100);
            tblHS.getColumnModel().getColumn(3).setMinWidth(100);
            tblHS.getColumnModel().getColumn(3).setMaxWidth(100);
            tblHS.getColumnModel().getColumn(5).setMinWidth(80);
            tblHS.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 679, 277));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Điền thông tin để thêm");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 300, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Chọn Item bảng bên để sửa");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String ten = txtHoTen.getText();
        String ngay = txtNgay.getText();

        if (!"".equals(ten) && !"".equals(ngay)) {
            Date d = Date.valueOf(ngay);
            DipDacBietModel dip = new DipDacBietModel(ten, d);
            DipDacBietController.themMoi(dip);
            this.showList();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Điền thông tin");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSuaActionPerformed
        // TODO add your handling code here:        int selectIndex = tblPhanQua.getSelectedRow();
        int selectIndex = table.getSelectedRow();
        if (selectIndex >= 0) {
            int option = JOptionPane.showConfirmDialog(rootPane, "Sửa thông tin?");
            DipDacBietModel dip = lst.get(selectIndex);
            String tenDip = txtHoTen.getText();
            String ngay = txtNgay.getText();
            if (!"".equals(tenDip) && !"".equals(ngay) && option == 0) {
                Date nGN = Date.valueOf(ngay);
                DipDacBietController.sua(dip.getID(), tenDip, nGN);
                this.showList();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Điền thông tin");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Chọn quà cần sửa");
        }
    }//GEN-LAST:event_txtSuaActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        String s1 = chonTen();
        String s2 = chonNgay();
        txtHoTen.setText(s1);
        txtNgay.setText(s2);
        txtNgay.setFont(new Font("Segoe UI", Font.PLAIN, 14));

    }//GEN-LAST:event_tableMouseClicked

    private void txtNgayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNgayFocusLost
        // TODO add your handling code here:
        if (txtNgay.getText().equals("")) {
            txtNgay.setText("yyyy-MM-dd");
            txtNgay.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        }
    }//GEN-LAST:event_txtNgayFocusLost

    private void txtNgayFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNgayFocusGained
        // TODO add your handling code here:
        if (txtNgay.getText().equals("yyyy-MM-dd")) {
            txtNgay.setText("");
            txtNgay.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        }
    }//GEN-LAST:event_txtNgayFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JTable tblHS;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JButton txtSua;
    // End of variables declaration//GEN-END:variables
}
