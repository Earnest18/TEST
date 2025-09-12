/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ADMIN_VIEW;

import javax.swing.JOptionPane;

/**
 *
 * @author reyes
 */
public class ADMIN_ADD_EMPLOYEE extends javax.swing.JPanel {

    private CLIENT_VIEW.Frame frame;
    public ADMIN_ADD_EMPLOYEE(CLIENT_VIEW.Frame frame) {
        initComponents();
        
        this.frame = frame;
    }
    
    public void registerEmployee(String name, String username, String password) {
    try {
        // Load MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connect to DB
        try (java.sql.Connection con = java.sql.DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tbaqs", "root", "");
             java.sql.PreparedStatement ps = con.prepareStatement(
                "INSERT INTO new_registered_employee (Name, Username, Password) VALUES (?, ?, ?)")) {

            // Set values
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, password);

            // Execute insert
            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Employee registered successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Registration failed!");
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}

    public void limits() {
    // USERNAME: allow only letters, 3–15 characters
    NAME.setDocument(new javax.swing.text.PlainDocument() {
        @Override
        public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
                throws javax.swing.text.BadLocationException {
            if (str == null) return;

            String newText = getText(0, getLength()) + str;

            if (newText.matches("[a-zA-Z]{0,15}")) {
                super.insertString(offs, str, a);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Name must be 3–15 characters (letters only).");
            }
        }
    });
    
    // USERNAME: allow only letters, 3–15 characters
    USERNAME.setDocument(new javax.swing.text.PlainDocument() {
        @Override
        public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
                throws javax.swing.text.BadLocationException {
            if (str == null) return;

            String newText = getText(0, getLength()) + str;

            if (newText.matches("[a-zA-Z]{0,15}")) {
                super.insertString(offs, str, a);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Name must be 3–15 characters (letters only).");
            }
        }
    });

    // PASSWORD: exactly 5 digits (numbers only)
    PASSWORD.setDocument(new javax.swing.text.PlainDocument() {
        @Override
        public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
                throws javax.swing.text.BadLocationException {
            if (str == null) return;

            String newText = getText(0, getLength()) + str;

            if (newText.length() <= 5 && newText.matches("[0-9]*")) {
                super.insertString(offs, str, a);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Password must be exactly 5 digits (numbers only).");
            }
        }
    });
    
    // PASSWORD: exactly 5 digits (numbers only)
    CONFIRM_PASS.setDocument(new javax.swing.text.PlainDocument() {
        @Override
        public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
                throws javax.swing.text.BadLocationException {
            if (str == null) return;

            String newText = getText(0, getLength()) + str;

            if (newText.length() <= 5 && newText.matches("[0-9]*")) {
                super.insertString(offs, str, a);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Password must be exactly 5 digits (numbers only).");
            }
        }
    });
}


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        REGISTER_AC = new javax.swing.JButton();
        ACCOUNT_APPROVAL = new javax.swing.JButton();
        BACK = new javax.swing.JButton();
        USERNAME = new javax.swing.JTextField();
        NAME = new javax.swing.JTextField();
        CONFIRM_PASS = new javax.swing.JPasswordField();
        CLEAR1 = new javax.swing.JButton();
        LOGIN = new javax.swing.JButton();
        PASSWORD = new javax.swing.JPasswordField();
        background = new javax.swing.JLabel();

        setLayout(null);

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

        USERNAME.setBackground(java.awt.Color.white);
        USERNAME.setBorder(null);
        add(USERNAME);
        USERNAME.setBounds(630, 348, 500, 25);

        NAME.setBackground(java.awt.Color.white);
        NAME.setBorder(null);
        add(NAME);
        NAME.setBounds(630, 300, 500, 25);

        CONFIRM_PASS.setBackground(java.awt.Color.white);
        CONFIRM_PASS.setBorder(null);
        add(CONFIRM_PASS);
        CONFIRM_PASS.setBounds(630, 459, 500, 25);

        CLEAR1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/CLU.png"))); // NOI18N
        CLEAR1.setBorderPainted(false);
        CLEAR1.setContentAreaFilled(false);
        CLEAR1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/CLC.png"))); // NOI18N
        CLEAR1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/CLC.png"))); // NOI18N
        CLEAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEAR1ActionPerformed(evt);
            }
        });
        add(CLEAR1);
        CLEAR1.setBounds(770, 560, 198, 51);

        LOGIN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/CFU.png"))); // NOI18N
        LOGIN.setBorderPainted(false);
        LOGIN.setContentAreaFilled(false);
        LOGIN.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/CFC.png"))); // NOI18N
        LOGIN.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/CFC.png"))); // NOI18N
        LOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGINActionPerformed(evt);
            }
        });
        add(LOGIN);
        LOGIN.setBounds(995, 560, 198, 51);

        PASSWORD.setBackground(java.awt.Color.white);
        PASSWORD.setBorder(null);
        add(PASSWORD);
        PASSWORD.setBounds(630, 401, 500, 25);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/ADMIN_AM_ADD_EMPLOYEE.gif"))); // NOI18N
        add(background);
        background.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void REGISTER_ACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REGISTER_ACActionPerformed
        frame.setContentPane(new ADMIN_RA_EMPLOYEES(frame));
        frame.revalidate();
    }//GEN-LAST:event_REGISTER_ACActionPerformed

    private void ACCOUNT_APPROVALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ACCOUNT_APPROVALActionPerformed
        frame.setContentPane(new ADMIN_ACC_APPROVAL_PENDING(frame));
        frame.revalidate();
    }//GEN-LAST:event_ACCOUNT_APPROVALActionPerformed

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        frame.setContentPane(new ADMIN_DASH(frame));
        frame.revalidate();
    }//GEN-LAST:event_BACKActionPerformed

    private void CLEAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEAR1ActionPerformed
        NAME.setText(null); PASSWORD.setText(null);
    }//GEN-LAST:event_CLEAR1ActionPerformed

    private void LOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGINActionPerformed
       System.out.print("USER : " + NAME.getText() + " " + "PASSWORD : " + CONFIRM_PASS.getText());
        
       if (PASSWORD.getText().equals(CONFIRM_PASS.getText())){
           
           String name = NAME.getText();
           String uname = USERNAME.getText();
           String pass = PASSWORD.getText();
           
           registerEmployee(name, uname, pass);
           
       } else {
           JOptionPane.showMessageDialog(null, "PASSWORD DIDN'T MATCHED!");
       }

    }//GEN-LAST:event_LOGINActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ACCOUNT_APPROVAL;
    private javax.swing.JButton BACK;
    private javax.swing.JButton CLEAR1;
    private javax.swing.JPasswordField CONFIRM_PASS;
    private javax.swing.JButton LOGIN;
    private javax.swing.JTextField NAME;
    private javax.swing.JPasswordField PASSWORD;
    private javax.swing.JButton REGISTER_AC;
    private javax.swing.JTextField USERNAME;
    private javax.swing.JLabel background;
    // End of variables declaration//GEN-END:variables
}
