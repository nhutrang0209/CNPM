package views;

import controllers.NhanKhauManagerPanelController;
import javax.swing.JFrame;
import views.NhanKhauManagerFrame.AddNewPeopleJFrame;
import views.NhanKhauManagerFrame.DangKyTamTruJFrame;
import views.NhanKhauManagerFrame.DangKyTamVangJFrame;
import views.NhanKhauManagerFrame.KhaiTuJFrame;

/**
 *
 * @author Hai
 */
public class NhanKhauManagePanel extends javax.swing.JPanel {

    /**
     * Creates new form NhanKhauManagePanel
     */
    private NhanKhauManagerPanelController controller = null;
    private JFrame parentJFrame;
    
    public NhanKhauManagePanel(JFrame parentFrame) {
        this.parentJFrame = parentFrame;
        initComponents();
        controller = new NhanKhauManagerPanelController(tablePanel, jtfSearch);
        controller.setParentJFrame(parentJFrame);
        controller.setDataTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tamVangBtn = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        addNewBtn = new javax.swing.JButton();
        tamTruBtn = new javax.swing.JButton();
        khaiTuBtn = new javax.swing.JButton();
        jtfSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tamVangBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tamVangBtn.setText("ĐK tạm vắng");
        tamVangBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamVangBtnActionPerformed(evt);
            }
        });
        add(tamVangBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 120, 30));

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );

        add(tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 76, 630, -1));

        addNewBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        addNewBtn.setText("Thêm mới");
        addNewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewBtnActionPerformed(evt);
            }
        });
        add(addNewBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 120, 30));

        tamTruBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tamTruBtn.setText("ĐK tạm trú");
        tamTruBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamTruBtnActionPerformed(evt);
            }
        });
        add(tamTruBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 120, 30));

        khaiTuBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        khaiTuBtn.setText("Khai Tử");
        khaiTuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khaiTuBtnActionPerformed(evt);
            }
        });
        add(khaiTuBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 120, 30));

        jtfSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jtfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSearchActionPerformed(evt);
            }
        });
        add(jtfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 273, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tìm kiếm theo CCCD");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel2.setText("Click đúp chuột để xem thông tin chi tiết");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addNewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewBtnActionPerformed
        AddNewPeopleJFrame addNewPeopleJFrame = new AddNewPeopleJFrame(this.controller, this.parentJFrame);
        addNewPeopleJFrame.setLocationRelativeTo(null);
        addNewPeopleJFrame.setResizable(false);
        addNewPeopleJFrame.setVisible(true);
    }//GEN-LAST:event_addNewBtnActionPerformed

    private void tamVangBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamVangBtnActionPerformed
        // hien jframe dang ky tam vang
        DangKyTamVangJFrame dangKyTamVangJFrame = new DangKyTamVangJFrame(this.parentJFrame);
        dangKyTamVangJFrame.setLocationRelativeTo(null);
        dangKyTamVangJFrame.setResizable(false);
        dangKyTamVangJFrame.setVisible(true);
    }//GEN-LAST:event_tamVangBtnActionPerformed

    private void tamTruBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamTruBtnActionPerformed
        DangKyTamTruJFrame dangKyTamTruJFrame = new DangKyTamTruJFrame(this.parentJFrame);
        dangKyTamTruJFrame.setLocationRelativeTo(null);
        dangKyTamTruJFrame.setResizable(false);
        dangKyTamTruJFrame.setVisible(true);
    }//GEN-LAST:event_tamTruBtnActionPerformed

    private void khaiTuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khaiTuBtnActionPerformed
        KhaiTuJFrame khaiTuJFrame = new KhaiTuJFrame(this.parentJFrame);
        khaiTuJFrame.setLocationRelativeTo(null);
        khaiTuJFrame.setResizable(false);
        khaiTuJFrame.setVisible(true);
    }//GEN-LAST:event_khaiTuBtnActionPerformed

    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JButton khaiTuBtn;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JButton tamTruBtn;
    private javax.swing.JButton tamVangBtn;
    // End of variables declaration//GEN-END:variables
}
