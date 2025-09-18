/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Admin;

import javax.swing.JOptionPane;

/**
 *
 * @author reyes
 */
public class Admin_Login extends javax.swing.JPanel {

    private Main.Frame frame;
    public Admin_Login(Main.Frame frame) {
        initComponents();
        this.frame = frame;
        pass_limit();
    }

    public void pass_limit(){
        pass.setDocument(new javax.swing.text.PlainDocument() {
            @Override
            public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
                    throws javax.swing.text.BadLocationException {
                if (str == null)
                    return;
                if ((getLength() + str.length() <= 5)) {
                    super.insertString(offs, str, a);
                } else if (!(getLength() + str.length() <= 5)) {
                    JOptionPane.showMessageDialog(null,"Enter 4 characters only");
                    pass.setText(null);
                } 
            }
        });
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pass = new javax.swing.JPasswordField();
        Enter_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setLayout(null);

        pass.setBackground(java.awt.Color.white);
        pass.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        pass.setForeground(java.awt.Color.black);
        pass.setBorder(null);
        add(pass);
        pass.setBounds(570, 442, 360, 30);

        Enter_btn.setBorderPainted(false);
        Enter_btn.setContentAreaFilled(false);
        Enter_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enter_btnActionPerformed(evt);
            }
        });
        add(Enter_btn);
        Enter_btn.setBounds(1120, 550, 180, 70);

        exit_btn.setBorderPainted(false);
        exit_btn.setContentAreaFilled(false);
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        add(exit_btn);
        exit_btn.setBounds(0, 540, 190, 90);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/Admin_log.png"))); // NOI18N
        add(bg);
        bg.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        frame.setContentPane(new Main.public_dash(frame));
        frame.revalidate();
    }//GEN-LAST:event_exit_btnActionPerformed

    private void Enter_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enter_btnActionPerformed
        
        if (pass.getText().equals("54321")){
            //pasok si admin //pass : 54321
            frame.setContentPane(new Admin.Admin_Dash(frame));
            frame.revalidate();
            
        }
        
    }//GEN-LAST:event_Enter_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Enter_btn;
    private javax.swing.JLabel bg;
    private javax.swing.JButton exit_btn;
    private javax.swing.JPasswordField pass;
    // End of variables declaration//GEN-END:variables
}
