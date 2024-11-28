/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frm_ATM;

import ATM_Server.ATM_Interface;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Frm_Home extends javax.swing.JFrame {

    private ATM_Interface atm;

    public class TuyenDoan_Home extends Thread {

        private final ATM_Interface atm;
        private final JFrame frame;

        public TuyenDoan_Home(ATM_Interface atm, JFrame frame) {
            this.atm = atm;
            this.frame = frame;
        }

        @Override
        public void run() {
            try {
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        try {
                            int result_Close = JOptionPane.showConfirmDialog(frame, "Bạn có chắc muốn đóng không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                            if (result_Close == JOptionPane.YES_OPTION) {
                                boolean result = atm.CapNhatTrangThai_KhongHoatDong(HoTen.getText());
                                if(result){
                                     frame.dispose(); // Đóng frame nếu chọn Yes
                                }                            
                            } else {
                                // Nếu chọn No, giữ frame mở
                                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(Frm_Home.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            } catch (Exception ex) {
                Logger.getLogger(Frm_LichSu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Creates new form Frm_Home
     *
     * @param hoTen
     * @param soTaiKhoan
     */
    public Frm_Home(String hoTen, String soTaiKhoan) {
        try {
            initComponents();

            Image icon = new ImageIcon(this.getClass().getResource("/icon.jpg")).getImage();
            this.setIconImage(icon);

            HoTen.setText(hoTen);
            SoTaiKhoan.setText(soTaiKhoan);

            // Kết nối đến thanh ghi
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            atm = (ATM_Interface) registry.lookup("ATM");

            TuyenDoan_Home tuyenDoan_Home = new TuyenDoan_Home(atm, this);
            tuyenDoan_Home.start();

        } catch (RemoteException e) {
            System.err.println("Lỗi RemoteException: " + e.getMessage());
        } catch (NotBoundException e) {
            System.err.println("Lỗi NotBoundException: " + e.getMessage());
        }
    }

    private Frm_Home() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        HoTen = new java.awt.Label();
        Button_RutTien = new javax.swing.JButton();
        Button_ChuyenTien = new javax.swing.JButton();
        Button_SoDu = new javax.swing.JButton();
        Button_NapTien = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        SoTaiKhoan = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon.png"))); // NOI18N

        label1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("ATM BANK");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(121, 121, 121)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(199, 199, 199)
                .addComponent(jLabel2))
        );

        label2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("Welcome:");

        HoTen.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        HoTen.setForeground(new java.awt.Color(255, 255, 255));
        HoTen.setText("Người dùng");

        Button_RutTien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Button_RutTien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-star-48.png"))); // NOI18N
        Button_RutTien.setText("Rút tiền");
        Button_RutTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_RutTienActionPerformed(evt);
            }
        });

        Button_ChuyenTien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Button_ChuyenTien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-next-48.png"))); // NOI18N
        Button_ChuyenTien.setText("Chuyển tiền");
        Button_ChuyenTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ChuyenTienActionPerformed(evt);
            }
        });

        Button_SoDu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Button_SoDu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-search-50.png"))); // NOI18N
        Button_SoDu.setText("Kiểm tra số dư");
        Button_SoDu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SoDuActionPerformed(evt);
            }
        });

        Button_NapTien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Button_NapTien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-add-48.png"))); // NOI18N
        Button_NapTien.setText("Nạp tiền");
        Button_NapTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_NapTienActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-back-64.png"))); // NOI18N
        jButton5.setText("Kết thúc");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-change-50.png"))); // NOI18N
        jButton6.setText("Đổi mật khẩu");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-history-50.png"))); // NOI18N
        jButton1.setText("Lịch sử");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        SoTaiKhoan.setText("label3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(Button_RutTien, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_ChuyenTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(121, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Button_SoDu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Button_NapTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(130, 130, 130))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(HoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(SoTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SoTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_RutTien)
                    .addComponent(Button_ChuyenTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_SoDu)
                    .addComponent(Button_NapTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_RutTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_RutTienActionPerformed
        // TODO add your handling code here:
        Frm_RutTien frm_ruttien = new Frm_RutTien(HoTen.getText(), SoTaiKhoan.getText());
        frm_ruttien.show();
        this.dispose();
    }//GEN-LAST:event_Button_RutTienActionPerformed

    private void Button_ChuyenTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ChuyenTienActionPerformed
        // TODO add your handling code here:
        Frm_ChuyenTien frm_chuyentien = new Frm_ChuyenTien(HoTen.getText(), SoTaiKhoan.getText());
        frm_chuyentien.show();
        this.dispose();
    }//GEN-LAST:event_Button_ChuyenTienActionPerformed

    private void Button_SoDuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SoDuActionPerformed
        // TODO add your handling code here:
        Frm_SoDu frm_sodu = new Frm_SoDu(HoTen.getText(), SoTaiKhoan.getText());
        frm_sodu.show();
        this.dispose();
    }//GEN-LAST:event_Button_SoDuActionPerformed

    private void Button_NapTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_NapTienActionPerformed
        // TODO add your handling code here:
        Frm_NapTien frm_naptien = new Frm_NapTien(HoTen.getText(), SoTaiKhoan.getText());
        frm_naptien.show();
        this.dispose();
    }//GEN-LAST:event_Button_NapTienActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Frm_CapNhatMatKhau frm_capnhatlaimatkhau = new Frm_CapNhatMatKhau(HoTen.getText(), SoTaiKhoan.getText());
        frm_capnhatlaimatkhau.show();
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Frm_DangNhap frm_dangnhap = null;
        try {
            boolean result = atm.CapNhatTrangThai_KhongHoatDong(HoTen.getText());
            frm_dangnhap = new Frm_DangNhap();
            if (result == true) {
                frm_dangnhap.show();
                this.dispose();
            }
        } catch (Exception ex) {
            Logger.getLogger(Frm_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Frm_LichSu frm_lichsu = new Frm_LichSu(HoTen.getText(), SoTaiKhoan.getText());
        frm_lichsu.show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Frm_Home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_ChuyenTien;
    private javax.swing.JButton Button_NapTien;
    private javax.swing.JButton Button_RutTien;
    private javax.swing.JButton Button_SoDu;
    private java.awt.Label HoTen;
    private java.awt.Label SoTaiKhoan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables
}
