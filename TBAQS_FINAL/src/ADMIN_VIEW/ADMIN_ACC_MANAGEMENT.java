/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ADMIN_VIEW;

import ADMIN_VIEW.ADMIN_DASH;

/**
 *
 * @author reyes
 */
public class ADMIN_ACC_MANAGEMENT extends javax.swing.JPanel {

    private CLIENT_VIEW.Frame frame;
    public ADMIN_ACC_MANAGEMENT(CLIENT_VIEW.Frame frame) {
        initComponents();
        
        this.frame = frame;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ACCOUNT_APPROVAL = new javax.swing.JButton();
        ADD_EM = new javax.swing.JButton();
        REGISTER_AC = new javax.swing.JButton();
        BACK = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setLayout(null);

        ACCOUNT_APPROVAL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/fillers.png"))); // NOI18N
        ACCOUNT_APPROVAL.setBorderPainted(false);
        ACCOUNT_APPROVAL.setContentAreaFilled(false);
        ACCOUNT_APPROVAL.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        ACCOUNT_APPROVAL.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        ACCOUNT_APPROVAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ACCOUNT_APPROVALActionPerformed(evt);
            }
        });
        add(ACCOUNT_APPROVAL);
        ACCOUNT_APPROVAL.setBounds(0, 458, 352, 90);

        ADD_EM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/fillers.png"))); // NOI18N
        ADD_EM.setBorderPainted(false);
        ADD_EM.setContentAreaFilled(false);
        ADD_EM.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        ADD_EM.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        ADD_EM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADD_EMActionPerformed(evt);
            }
        });
        add(ADD_EM);
        ADD_EM.setBounds(0, 365, 352, 90);

        REGISTER_AC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/fillers.png"))); // NOI18N
        REGISTER_AC.setBorderPainted(false);
        REGISTER_AC.setContentAreaFilled(false);
        REGISTER_AC.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        REGISTER_AC.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        REGISTER_AC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REGISTER_ACActionPerformed(evt);
            }
        });
        add(REGISTER_AC);
        REGISTER_AC.setBounds(0, 273, 352, 90);

        BACK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/fillers.png"))); // NOI18N
        BACK.setBorderPainted(false);
        BACK.setContentAreaFilled(false);
        BACK.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/exitc.png"))); // NOI18N
        BACK.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/exitc.png"))); // NOI18N
        BACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BACKActionPerformed(evt);
            }
        });
        add(BACK);
        BACK.setBounds(0, 550, 352, 90);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/ADMIN_VIEW.gif"))); // NOI18N
        add(background);
        background.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void ACCOUNT_APPROVALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ACCOUNT_APPROVALActionPerformed
        frame.setContentPane(new ADMIN_ACC_APPROVAL_PENDING(frame));
        frame.revalidate();             
    }//GEN-LAST:event_ACCOUNT_APPROVALActionPerformed

    private void ADD_EMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADD_EMActionPerformed
         frame.setContentPane(new ADMIN_ADD_EMPLOYEE(frame));
        frame.revalidate();
    }//GEN-LAST:event_ADD_EMActionPerformed

    private void REGISTER_ACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REGISTER_ACActionPerformed
         frame.setContentPane(new ADMIN_RA_EMPLOYEES(frame));
         frame.revalidate();
    }//GEN-LAST:event_REGISTER_ACActionPerformed

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        frame.setContentPane(new ADMIN_DASH(frame));
        frame.revalidate();
    }//GEN-LAST:event_BACKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ACCOUNT_APPROVAL;
    private javax.swing.JButton ADD_EM;
    private javax.swing.JButton BACK;
    private javax.swing.JButton REGISTER_AC;
    private javax.swing.JLabel background;
    // End of variables declaration//GEN-END:variables
}
