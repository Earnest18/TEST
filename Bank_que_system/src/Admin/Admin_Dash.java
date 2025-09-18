/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Admin;

/**
 *
 * @author reyes
 */
public class Admin_Dash extends javax.swing.JPanel {

    private Main.Frame frame;
    public Admin_Dash(Main.Frame frame) {
        initComponents();
        this.frame = frame;
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit_btn = new javax.swing.JButton();
        acc_mng = new javax.swing.JButton();
        monitoring = new javax.swing.JButton();
        screen = new javax.swing.JButton();
        queuing = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        exit_btn.setBorderPainted(false);
        exit_btn.setContentAreaFilled(false);
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        add(exit_btn);
        exit_btn.setBounds(0, 540, 190, 90);

        acc_mng.setBorderPainted(false);
        acc_mng.setContentAreaFilled(false);
        acc_mng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_mngActionPerformed(evt);
            }
        });
        add(acc_mng);
        acc_mng.setBounds(0, 470, 420, 70);

        monitoring.setBorderPainted(false);
        monitoring.setContentAreaFilled(false);
        monitoring.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monitoringActionPerformed(evt);
            }
        });
        add(monitoring);
        monitoring.setBounds(0, 390, 420, 70);

        screen.setBorderPainted(false);
        screen.setContentAreaFilled(false);
        screen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screenActionPerformed(evt);
            }
        });
        add(screen);
        screen.setBounds(0, 320, 420, 70);

        queuing.setBorderPainted(false);
        queuing.setContentAreaFilled(false);
        queuing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queuingActionPerformed(evt);
            }
        });
        add(queuing);
        queuing.setBounds(0, 240, 420, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/Admin_Dashboard.gif"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        frame.setContentPane(new Main.public_dash(frame));
        frame.revalidate();
    }//GEN-LAST:event_exit_btnActionPerformed

    private void queuingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queuingActionPerformed
        frame.setContentPane(new Queuing(frame));
        frame.revalidate();
    }//GEN-LAST:event_queuingActionPerformed

    private void screenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_screenActionPerformed
        frame.setContentPane(new Screen(frame));
        frame.revalidate();
    }//GEN-LAST:event_screenActionPerformed

    private void monitoringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monitoringActionPerformed
        frame.setContentPane(new Monitoring(frame));
        frame.revalidate();
    }//GEN-LAST:event_monitoringActionPerformed

    private void acc_mngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acc_mngActionPerformed
        frame.setContentPane(new Acc_management(frame));
        frame.revalidate();
    }//GEN-LAST:event_acc_mngActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acc_mng;
    private javax.swing.JButton exit_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton monitoring;
    private javax.swing.JButton queuing;
    private javax.swing.JButton screen;
    // End of variables declaration//GEN-END:variables
}
