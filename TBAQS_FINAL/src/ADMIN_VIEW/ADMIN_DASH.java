/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ADMIN_VIEW;

/**
 *
 * @author reyes
 */
public class ADMIN_DASH extends javax.swing.JPanel {

    private CLIENT_VIEW.Frame frame;
    public ADMIN_DASH(CLIENT_VIEW.Frame frame) {
        initComponents();
        
        this.frame = frame;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        QUEUING = new javax.swing.JButton();
        HISTORY1 = new javax.swing.JButton();
        ACC_MANAGEMENT = new javax.swing.JButton();
        ABT = new javax.swing.JButton();
        FAQS = new javax.swing.JButton();
        LOGOUT = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setLayout(null);

        QUEUING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/QUU.png"))); // NOI18N
        QUEUING.setBorderPainted(false);
        QUEUING.setContentAreaFilled(false);
        QUEUING.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/QUC.png"))); // NOI18N
        QUEUING.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/QUC.png"))); // NOI18N
        QUEUING.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QUEUINGActionPerformed(evt);
            }
        });
        add(QUEUING);
        QUEUING.setBounds(40, 275, 368, 95);

        HISTORY1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/HIU.png"))); // NOI18N
        HISTORY1.setBorderPainted(false);
        HISTORY1.setContentAreaFilled(false);
        HISTORY1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/HIC.png"))); // NOI18N
        HISTORY1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/HIC.png"))); // NOI18N
        HISTORY1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HISTORY1ActionPerformed(evt);
            }
        });
        add(HISTORY1);
        HISTORY1.setBounds(40, 434, 368, 95);

        ACC_MANAGEMENT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/AMU.png"))); // NOI18N
        ACC_MANAGEMENT.setBorderPainted(false);
        ACC_MANAGEMENT.setContentAreaFilled(false);
        ACC_MANAGEMENT.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/AMC.png"))); // NOI18N
        ACC_MANAGEMENT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/AMC.png"))); // NOI18N
        ACC_MANAGEMENT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ACC_MANAGEMENTActionPerformed(evt);
            }
        });
        add(ACC_MANAGEMENT);
        ACC_MANAGEMENT.setBounds(891, 275, 368, 95);

        ABT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/ABU.png"))); // NOI18N
        ABT.setBorderPainted(false);
        ABT.setContentAreaFilled(false);
        ABT.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/ABC.png"))); // NOI18N
        ABT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/ABC.png"))); // NOI18N
        ABT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ABTActionPerformed(evt);
            }
        });
        add(ABT);
        ABT.setBounds(937, 115, 144, 35);

        FAQS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/FAQU.png"))); // NOI18N
        FAQS.setBorderPainted(false);
        FAQS.setContentAreaFilled(false);
        FAQS.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/FAQC.png"))); // NOI18N
        FAQS.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/FAQC.png"))); // NOI18N
        FAQS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FAQSActionPerformed(evt);
            }
        });
        add(FAQS);
        FAQS.setBounds(1150, 116, 101, 35);

        LOGOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/LOU.png"))); // NOI18N
        LOGOUT.setBorderPainted(false);
        LOGOUT.setContentAreaFilled(false);
        LOGOUT.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/LOC.png"))); // NOI18N
        LOGOUT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/LOC.png"))); // NOI18N
        LOGOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGOUTActionPerformed(evt);
            }
        });
        add(LOGOUT);
        LOGOUT.setBounds(891, 434, 368, 95);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/ADMIN_DASH.gif"))); // NOI18N
        add(background);
        background.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void QUEUINGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QUEUINGActionPerformed
        frame.setContentPane(new ADMIN_QUE_MANAGEMENT(frame));
        frame.revalidate();
    }//GEN-LAST:event_QUEUINGActionPerformed

    private void HISTORY1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HISTORY1ActionPerformed
        frame.setContentPane(new ADMIN_HISTORY_COMPLETED(frame));
        frame.revalidate();
    }//GEN-LAST:event_HISTORY1ActionPerformed

    private void ACC_MANAGEMENTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ACC_MANAGEMENTActionPerformed
       frame.setContentPane(new ADMIN_ACC_MANAGEMENT(frame));
        frame.revalidate();
    }//GEN-LAST:event_ACC_MANAGEMENTActionPerformed

    private void ABTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ABTActionPerformed
        
        frame.revalidate();
    }//GEN-LAST:event_ABTActionPerformed

    private void FAQSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FAQSActionPerformed
        
        frame.revalidate();
    }//GEN-LAST:event_FAQSActionPerformed

    private void LOGOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGOUTActionPerformed
        frame.setContentPane(new CLIENT_VIEW.TRANSACTIONS(frame));
        frame.revalidate();
    }//GEN-LAST:event_LOGOUTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ABT;
    private javax.swing.JButton ACC_MANAGEMENT;
    private javax.swing.JButton FAQS;
    private javax.swing.JButton HISTORY1;
    private javax.swing.JButton LOGOUT;
    private javax.swing.JButton QUEUING;
    private javax.swing.JLabel background;
    // End of variables declaration//GEN-END:variables
}
