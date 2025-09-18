/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Employee;

import Main.public_dash;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author reyes
 */
public class Employeee_Login extends javax.swing.JPanel {

    private Main.Frame frame;
    public Employeee_Login(Main.Frame frame) {
        initComponents();
        this.frame = frame;
        pass_limit();
    }
    
    public void pass_limit(){
        password.setDocument(new javax.swing.text.PlainDocument() {
            @Override
            public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
                    throws javax.swing.text.BadLocationException {
                if (str == null)
                    return;
                if ((getLength() + str.length() <= 5)) {
                    super.insertString(offs, str, a);
                } else if (!(getLength() + str.length() <= 5)) {
                    JOptionPane.showMessageDialog(null,"Enter 5 characters only");
                    password.setText(null);
                } 
            }
        });
    }
    
    /* WAG GALAWIN

    public boolean checkLogin(String username, String password) {
    boolean valid = false;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        java.sql.Connection con = java.sql.DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/banking_sino_ka_man", "root", ""
        );

        String sql = "SELECT * FROM bskm_employees WHERE Username=? AND Password=?";
        java.sql.PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, username);
        pst.setString(2, password);

        java.sql.ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            valid = true;
            System.out.print("User found");
            //next panel
        } else {
            System.out.print("User not found");
            Uname.setText(null); //password.setText(null);
            
        }

        con.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return valid;
}

*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Uname = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        enter_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        admin_field = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setLayout(null);

        Uname.setBackground(java.awt.Color.white);
        Uname.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        Uname.setForeground(java.awt.Color.black);
        Uname.setBorder(null);
        add(Uname);
        Uname.setBounds(570, 360, 390, 30);

        password.setBackground(java.awt.Color.white);
        password.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        password.setForeground(java.awt.Color.black);
        password.setBorder(null);
        add(password);
        password.setBounds(570, 450, 370, 20);

        enter_btn.setBorderPainted(false);
        enter_btn.setContentAreaFilled(false);
        enter_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enter_btnActionPerformed(evt);
            }
        });
        add(enter_btn);
        enter_btn.setBounds(1090, 540, 210, 80);

        exit_btn.setBorderPainted(false);
        exit_btn.setContentAreaFilled(false);
        exit_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit_btnMouseExited(evt);
            }
        });
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        add(exit_btn);
        exit_btn.setBounds(0, 540, 190, 90);

        admin_field.setBorderPainted(false);
        admin_field.setContentAreaFilled(false);
        admin_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_fieldActionPerformed(evt);
            }
        });
        add(admin_field);
        admin_field.setBounds(0, 460, 280, 80);

        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(1040, 460, 260, 80);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/employee log.png"))); // NOI18N
        add(bg);
        bg.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void enter_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enter_btnActionPerformed
        //checks if employee is registered
        //checkLogin(Uname.getText(), password.getText());
        frame.setContentPane(new E_Dashboard(frame));
        frame.revalidate();
        
    }//GEN-LAST:event_enter_btnActionPerformed

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        frame.setContentPane(new Main.public_dash(frame));
        frame.revalidate();
    }//GEN-LAST:event_exit_btnActionPerformed

    private void admin_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_fieldActionPerformed
        frame.setContentPane(new Admin.Admin_Login(frame));
        frame.revalidate();
    }//GEN-LAST:event_admin_fieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frame.setContentPane(new Register.Register_employee(frame));
        frame.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void exit_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseEntered
       
    }//GEN-LAST:event_exit_btnMouseEntered

    private void exit_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_btnMouseExited
        
    }//GEN-LAST:event_exit_btnMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Uname;
    private javax.swing.JButton admin_field;
    private javax.swing.JLabel bg;
    private javax.swing.JButton enter_btn;
    private javax.swing.JButton exit_btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables
}
