/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.HocSinh;
import services.MysqlConnection;
import views.PhatThuongManagerFrame.DipDacBietJFrame;
import views.PhatThuongManagerFrame.PTCuoiNamJFrame;
import views.PhatThuongManagerFrame.PTDacBietJrame;
import views.PhatThuongManagerFrame.QuanLyPhanQuaJFrame;


/**
 *
 * @author TNTDT
 */
public class PhatThuongManagePanel extends javax.swing.JPanel {

    private JFrame parentFrame;
    private DefaultTableModel tableModel;
    private JFrame parentJFrame;
    private DefaultTableModel tblModel;
    private DefaultTableModel tblModel1;
    List<HocSinh> lstHs;

    /**
     * Creates new form HoKhauManagePanel
     *
     * @param parentFrame
     */
    public PhatThuongManagePanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        initComponents();
        initTableModel();
        initTableModel1();
        initComboBox();
       
    }

    private void initTableModel() {
        String[] columnNames = new String[]{"STT", "ID hộ", "Số quà đã nhận", "Tổng giá trị"};
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(columnNames);
        tblthongke.setModel(tblModel);

        //tblModel= (DefaultTableModel) tblthongke.getModel();
        tblthongke.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        tblthongke.setRowHeight(30);
        tblthongke.validate();
        tblthongke.repaint();
        tblthongke.setFont(new Font("Arial", Font.PLAIN, 14));
        tblthongke.getColumnModel().getColumn(0).setMaxWidth(40);
        tblthongke.getColumnModel().getColumn(0).setMinWidth(40);
        tblthongke.getColumnModel().getColumn(0).setPreferredWidth(80);
    }

    private void initTableModel1() {
        String[] columnNames = new String[]{"STT", "ID hộ khẩu", "ID nhân khẩu", "Tên nhân khẩu", "Phần quà", "Số lượng"," Tổng giá trị"};
        tblModel1 = new DefaultTableModel();
        tblModel1.setColumnIdentifiers(columnNames);
        tblchitiet.setModel(tblModel1);
        //tblModel= (DefaultTableModel) tblthongke.getModel();
        tblchitiet.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        tblchitiet.setRowHeight(28);
        tblchitiet.validate();
        tblchitiet.repaint();
        tblchitiet.setFont(new Font("Arial", Font.PLAIN, 12));
      //  tblchitiet.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblchitiet.getColumnModel().getColumn(0).setPreferredWidth(70);
        tblchitiet.getColumnModel().getColumn(0).setMaxWidth(40);
        tblchitiet.getColumnModel().getColumn(0).setMinWidth(40);
        tblchitiet.getColumnModel().getColumn(3).setPreferredWidth(140);

    }
    
    private void initComboBox() {
        Connection conn = null;
        Statement stm = null;
        try {
            conn = MysqlConnection.getMysqlConnection();
            String sql = "select tenDipDacBiet from dip_dac_biet";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            boxDip.removeAllItems();
            boxDip.addItem("Chọn dịp phát quà");
            while (rs.next()) {
                boxDip.addItem(rs.getString("tenDipDacBiet"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        boxDip.addItem("Cuối năm");
    }
    
    private int idDip(String dip) {
        int idDip = -1;
        Connection conn = null;
        Statement stm = null;
        try {
            conn = MysqlConnection.getMysqlConnection();
            String sql = "select ID, tenDipDacBiet from dip_dac_biet";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("tenDipDacBiet").equals(dip)) {
                    idDip = rs.getInt("ID");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        return idDip;
    }
    
    private void showHK() {
        Connection conn = null;
        Statement stm = null;

        try {
            conn = MysqlConnection.getMysqlConnection();

            String sql = "select idHoKhau, sum(p.soLuong) as sophanthuong, sum(p.soLuong*q.giaTri) as sotienqua "
                    + "from nhan_khau n, thanh_vien_cua_ho t, phat_thuong_cuoi_nam p, phan_qua q, danh_hieu dh "
                    + "where t.idNhanKhau = n.ID and dh.ID = p.IDHS and dh.IDNhanKhau = n.ID "
                    + "and p.IDPhanQua = q.ID group by idHoKhau";;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            tblModel.setRowCount(0);
            while (rs.next()) {
                tblModel.addRow(new Object[]{
                    tblModel.getRowCount() + 1,
                    rs.getString("idHoKhau"),
                    rs.getInt("sophanthuong"),
                    rs.getInt("sotienqua"),});
            }
            tblModel.fireTableDataChanged();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
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

        btnPhatThuongCuoiNam = new javax.swing.JButton();
        btnphathuongdacbiet = new javax.swing.JButton();
        btnQuanLyPhanQua = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblchitiet = new javax.swing.JTable(){
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        btnchitiet = new javax.swing.JButton();
        txtTimkiem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblthongke = new javax.swing.JTable(){
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        boxDip = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPhatThuongCuoiNam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPhatThuongCuoiNam.setText("Phát thưởng cuối năm");
        btnPhatThuongCuoiNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhatThuongCuoiNamActionPerformed(evt);
            }
        });
        add(btnPhatThuongCuoiNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, 210, 40));

        btnphathuongdacbiet.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnphathuongdacbiet.setText("Phát thưởng dịp đặc biệt");
        btnphathuongdacbiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnphathuongdacbietActionPerformed(evt);
            }
        });
        add(btnphathuongdacbiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 210, 40));

        btnQuanLyPhanQua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnQuanLyPhanQua.setText("Quản lý phần quà");
        btnQuanLyPhanQua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyPhanQuaActionPerformed(evt);
            }
        });
        add(btnQuanLyPhanQua, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 210, 40));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Thông tin dịp đặc biệt");
        jButton1.setActionCommand("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 210, 40));
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 6, 103, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblchitiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "ID Hộ Khẩu", "ID nhân khẩu", "Họ Tên", "Phần quà", "Số lượng", "Giá trị"
            }
        ));
        jScrollPane2.setViewportView(tblchitiet);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 530, 130));

        btnchitiet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnchitiet.setText("Thống Kê Chi Tiết");
        btnchitiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchitietActionPerformed(evt);
            }
        });
        jPanel1.add(btnchitiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 140, -1));

        txtTimkiem.setBackground(new java.awt.Color(242, 242, 242));
        txtTimkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimkiem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtTimkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 170, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("ID hộ khẩu cần thống kê:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 180, 30));

        tblthongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "ID hộ", "Tổng số quà đã nhận", "Tổng giá trị"
            }
        ));
        tblthongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblthongkeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblthongke);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 530, 120));

        boxDip.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        boxDip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxDip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxDipActionPerformed(evt);
            }
        });
        jPanel1.add(boxDip, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 220, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Chọn dịp phát quà");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Bảng thống kê số phần quà mỗi hộ đã nhận");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 340, 25));

        jLabel6.setText("(Nhập hoặc chọn ở bảng phía trên)");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 200, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 560, 450));
    }// </editor-fold>//GEN-END:initComponents

    private void btnPhatThuongCuoiNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhatThuongCuoiNamActionPerformed
        // TODO add your handling code here:
        PTCuoiNamJFrame ptCuoiNam = new PTCuoiNamJFrame(parentFrame);
        ptCuoiNam.setLocationRelativeTo(null);
        ptCuoiNam.setResizable(false);
        ptCuoiNam.setVisible(true);

    }//GEN-LAST:event_btnPhatThuongCuoiNamActionPerformed

    private void btnQuanLyPhanQuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyPhanQuaActionPerformed
        // TODO add your handling code here:
        QuanLyPhanQuaJFrame qlPhanQua = new QuanLyPhanQuaJFrame(parentFrame);
        qlPhanQua.setLocationRelativeTo(null);
        qlPhanQua.setResizable(false);
        qlPhanQua.setVisible(true);

    }//GEN-LAST:event_btnQuanLyPhanQuaActionPerformed

    private void btnphathuongdacbietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnphathuongdacbietActionPerformed
        // TODO add your handling code here:
        PTDacBietJrame phatThuong = new PTDacBietJrame(parentFrame);
        phatThuong.setLocationRelativeTo(null);
        phatThuong.setResizable(false);
        phatThuong.setVisible(true);
    }//GEN-LAST:event_btnphathuongdacbietActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DipDacBietJFrame dipDB = new DipDacBietJFrame(parentFrame);
        dipDB.setLocationRelativeTo(null);
        dipDB.setResizable(false);
        dipDB.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblthongkeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblthongkeMouseClicked
        // TODO add your handling code here:
        int selectIndex = tblthongke.getSelectedRow();
        if (selectIndex >= 0) {
            String id = String.valueOf(tblthongke.getValueAt(selectIndex, 1));
            txtTimkiem.setText(id);
        }
        Connection conn = null;
        Statement stm = null;
        String dipPhatQua = boxDip.getSelectedItem().toString();
        int idDipDacBiet = this.idDip(dipPhatQua);
        String id = Integer.toString(idDipDacBiet);

        try {
            conn = MysqlConnection.getMysqlConnection();
            if (txtTimkiem.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ban chua nhap gia tri tim kiem");
            }else if (dipPhatQua.equals("Cuối năm")){
                String sql1 = "select DISTINCT t.idHoKhau, dh.IDNhanKhau, dh.hoTen, q.tenQua, p.soLuong, p.soLuong*q.giaTri as giaTri " +
                "from thanh_vien_cua_ho t, nhan_khau n, phat_thuong_cuoi_nam p, phan_qua q, danh_hieu dh " +
                "where t.idNhanKhau = n.ID and dh.ID = p.IDHS and dh.IDNhanKhau = n.ID and p.IDPhanQua = q.ID " +
                "and idHoKhau = " + txtTimkiem.getText() + "";
                

                PreparedStatement pstmt = conn.prepareStatement(sql1);

                ResultSet rs1 = pstmt.executeQuery();

                tblModel1.setRowCount(0);
                while (rs1.next()) {
                    tblModel1.addRow(new Object[]{
                        tblModel1.getRowCount() + 1,
                        rs1.getInt("idHoKhau"),
                        rs1.getInt("IDNhanKhau"),
                        rs1.getString("hoTen"),
                        rs1.getString("tenQua"),
                        rs1.getInt("soLuong"),
                        rs1.getInt("giaTri")
                    });
            }

            tblModel1.fireTableDataChanged();
        }
        else {
            String sql1 = "select DISTINCT t.idHoKhau, n.ID, n.hoTen, q.tenQua, p.soLuong , p.soLuong*q.giaTri as giatri " +
                "from thanh_vien_cua_ho t, nhan_khau n, pt_dip_dac_biet p, phan_qua q " +
                "where t.idNhanKhau = n.id and n.ID = p.IDHS and p.IDPhanQua = q.ID " +
                "and idHoKhau = " + txtTimkiem.getText() + " " +
                "and idDipDacBiet = " + id + "";
            PreparedStatement pstmt = conn.prepareStatement(sql1);

            ResultSet rs1 = pstmt.executeQuery();

            tblModel1.setRowCount(0);
            while (rs1.next()) {
                tblModel1.addRow(new Object[]{
                    tblModel1.getRowCount() + 1,
                    rs1.getInt("idHoKhau"),
                    rs1.getInt("ID"),
                    rs1.getString("hoTen"),
                    rs1.getString("tenQua"),
                    rs1.getInt("soLuong"),
                    rs1.getInt("giaTri")
                });
        }

        tblModel1.fireTableDataChanged();
        }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_tblthongkeMouseClicked

    private void btnchitietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchitietActionPerformed
        // TODO add your handling code here:
        Connection conn = null;
        Statement stm = null;
        String dipPhatQua = boxDip.getSelectedItem().toString();
        int idDipDacBiet = this.idDip(dipPhatQua);
        String id = Integer.toString(idDipDacBiet);

        try {
            conn = MysqlConnection.getMysqlConnection();
            if (txtTimkiem.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ban chua nhap gia tri tim kiem");
            }else if (dipPhatQua.equals("Cuối năm")){
                String sql1 = "select DISTINCT t.idHoKhau, dh.IDNhanKhau, dh.hoTen, q.tenQua, p.soLuong, p.soLuong*q.giaTri as giaTri " +
                "from thanh_vien_cua_ho t, nhan_khau n, phat_thuong_cuoi_nam p, phan_qua q, danh_hieu dh " +
                "where t.idNhanKhau = n.ID and dh.ID = p.IDHS and dh.IDNhanKhau = n.ID and p.IDPhanQua = q.ID " +
                "and idHoKhau = " + txtTimkiem.getText() + "";

                PreparedStatement pstmt = conn.prepareStatement(sql1);

                ResultSet rs1 = pstmt.executeQuery();

                tblModel1.setRowCount(0);
                while (rs1.next()) {
                    tblModel1.addRow(new Object[]{
                        tblModel1.getRowCount() + 1,
                        rs1.getInt("idHoKhau"),
                        rs1.getInt("IDNhanKhau"),
                        rs1.getString("hoTen"),
                        rs1.getString("tenQua"),
                        rs1.getInt("soLuong"),
                        rs1.getInt("giaTri")
                    });
                }

                tblModel1.fireTableDataChanged();
            }
            else {
                String sql1 = "select DISTINCT t.idHoKhau, n.ID, n.hoTen, q.tenQua, p.soLuong , p.soLuong*q.giaTri as giatri " +
                "from thanh_vien_cua_ho t, nhan_khau n, pt_dip_dac_biet p, phan_qua q " +
                "where t.idNhanKhau = n.id and n.ID = p.IDHS and p.IDPhanQua = q.ID " +
                "and idHoKhau = " + txtTimkiem.getText() + " " +
                "and idDipDacBiet = " + id + "";
                PreparedStatement pstmt = conn.prepareStatement(sql1);

                ResultSet rs1 = pstmt.executeQuery();

                tblModel1.setRowCount(0);
                while (rs1.next()) {
                    tblModel1.addRow(new Object[]{
                        tblModel1.getRowCount() + 1,
                        rs1.getInt("idHoKhau"),
                        rs1.getInt("ID"),
                        rs1.getString("hoTen"),
                        rs1.getString("tenQua"),
                        rs1.getInt("soLuong"),
                        rs1.getInt("giaTri")
                    });
                }

                tblModel1.fireTableDataChanged();
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnchitietActionPerformed

    private void boxDipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxDipActionPerformed
        Connection conn = null;
        Statement stm = null;
        if (boxDip.getSelectedItem()!=null){
            String dipPhatQua = boxDip.getSelectedItem().toString();
        int idDipDacBiet = this.idDip(dipPhatQua);
        String id = Integer.toString(idDipDacBiet);
        
        try {
            conn = MysqlConnection.getMysqlConnection();
//            if ("Chọn dịp phát quà".equals(dipPhatQua)) {
//                JOptionPane.showMessageDialog(this, "Chọn dịp phát quà cần thống kê");
//            } else 
            if (dipPhatQua.equals("Cuối năm")){
                showHK();
            }
            else {
                String sql = "select idHoKhau, count(IDPhanQua)*p.soLuong as sophanthuong, sum(p.soLuong * q.giaTri) as sotienqua "
                + "from nhan_khau n, thanh_vien_cua_ho t, pt_dip_dac_biet p, phan_qua q "
                + "where t.idNhanKhau = n.id and n.ID = p.IDHS and p.IDPhanQua = q.ID and idDipDacBiet = " + id + " group by idHoKhau";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                tblModel.setRowCount(0);
                while (rs.next()) {
                    tblModel.addRow(new Object[]{
                        tblModel.getRowCount() + 1,
                        rs.getString("idHoKhau"),
                        rs.getInt("sophanthuong"),
                        rs.getInt("sotienqua"),});
            }
            tblModel.fireTableDataChanged();
        }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        }
        
    }//GEN-LAST:event_boxDipActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxDip;
    private javax.swing.JButton btnPhatThuongCuoiNam;
    private javax.swing.JButton btnQuanLyPhanQua;
    private javax.swing.JButton btnchitiet;
    private javax.swing.JButton btnphathuongdacbiet;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblchitiet;
    private javax.swing.JTable tblthongke;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables

    private int idDip() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
