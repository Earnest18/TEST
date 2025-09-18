/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Employee;

/**
 *
 * @author reyes
 */
public class E_Dashboard extends javax.swing.JPanel {

    private Main.Frame frame;
    public E_Dashboard(Main.Frame frame) {
        initComponents();
        this.frame = frame;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        que = new javax.swing.JButton();
        screen = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        Acc_approval = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        que.setBorderPainted(false);
        que.setContentAreaFilled(false);
        que.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queActionPerformed(evt);
            }
        });
        add(que);
        que.setBounds(0, 230, 420, 70);

        screen.setBorderPainted(false);
        screen.setContentAreaFilled(false);
        screen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screenActionPerformed(evt);
            }
        });
        add(screen);
        screen.setBounds(0, 320, 420, 70);

        exit_btn.setBorderPainted(false);
        exit_btn.setContentAreaFilled(false);
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        add(exit_btn);
        exit_btn.setBounds(0, 540, 190, 90);

        Acc_approval.setBorderPainted(false);
        Acc_approval.setContentAreaFilled(false);
        Acc_approval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Acc_approvalActionPerformed(evt);
            }
        });
        add(Acc_approval);
        Acc_approval.setBounds(0, 390, 430, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/Employee_background.gif"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        frame.setContentPane(new Main.public_dash(frame));
        frame.revalidate();
    }//GEN-LAST:event_exit_btnActionPerformed

    private void queActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queActionPerformed
        frame.setContentPane(new Management(frame));
        frame.revalidate();
    }//GEN-LAST:event_queActionPerformed

    private void screenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_screenActionPerformed
        frame.setContentPane(new History_completed(frame));
        frame.revalidate();
    }//GEN-LAST:event_screenActionPerformed

    private void Acc_approvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Acc_approvalActionPerformed
        frame.setContentPane(new Account_approval(frame));
        frame.revalidate();
    }//GEN-LAST:event_Acc_approvalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Acc_approval;
    private javax.swing.JButton exit_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton que;
    private javax.swing.JButton screen;
    // End of variables declaration//GEN-END:variables
}
