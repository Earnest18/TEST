/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package CLIENT_VIEW;

import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author reyes
 */
public class Create_Account extends javax.swing.JPanel {

    private Frame frame;
    public Create_Account(Frame frame) {
        initComponents();
        limits();
        this.frame = frame;
    }
    
    //this helps to insert user in database
    public void insertClientInfo(String username, String bday, int age, String mobileNum, String password) {
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/tbaqs", "root", ""
        );

        String insertSql = "INSERT INTO pending_users (Username, Birthday, Age, MobileNum, Password) VALUES (?, ?, ?, ?, ?)";
        java.sql.PreparedStatement pstmt = con.prepareStatement(insertSql);
        pstmt.setString(1, NAME.getText());
        pstmt.setString(2, BDAY.getText());
        pstmt.setInt(3, Integer.parseInt(AGE.getText()));
        pstmt.setString(4, MOBILENUM.getText());
        pstmt.setInt(5, Integer.parseInt(PASSWORD.getText()));

        int rows = pstmt.executeUpdate();

        if (rows > 0) {
           System.out.print("\nUser in!");
        }

        con.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, e);
    }
   }
    
    public void limits() {

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

    // AGE: only numbers, max 2
    AGE.setDocument(new javax.swing.text.PlainDocument() {
        @Override
        public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
                throws javax.swing.text.BadLocationException {
            if (str == null) return;

            String newText = getText(0, getLength()) + str;

            if (newText.length() <= 2 && newText.matches("[0-9]*")) {
                super.insertString(offs, str, a);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Age must be exactly 2 digits (numbers only).");
            }
        }
    });

    // BIRTHDAY: YYYY-MM-DD format (10 chars)
    BDAY.setDocument(new javax.swing.text.PlainDocument() {
        @Override
        public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
                throws javax.swing.text.BadLocationException {
            if (str == null) return;

            if ((getLength() + str.length()) <= 10 && str.matches("[0-9-]+")) {
                super.insertString(offs, str, a);
            } else {
                JOptionPane.showMessageDialog(null, "Birthday must follow YYYY-MM-DD format.");
            }
        }
    });

    // MOBILE NUMBER: 11 digits only
    MOBILENUM.setDocument(new javax.swing.text.PlainDocument() {
        @Override
        public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
                throws javax.swing.text.BadLocationException {
            if (str == null) return;

            String newText = getText(0, getLength()) + str;

            if (newText.length() <= 11 && newText.matches("[0-9]*")) {
                super.insertString(offs, str, a);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Mobile Number must be exactly 11 digits (numbers only).");
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
}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CONFIRM = new javax.swing.JButton();
        CANCEL = new javax.swing.JButton();
        verification = new javax.swing.JCheckBox();
        BACK = new javax.swing.JButton();
        PASSWORD = new javax.swing.JPasswordField();
        MOBILENUM = new javax.swing.JTextField();
        AGE = new javax.swing.JTextField();
        BDAY = new javax.swing.JTextField();
        NAME = new javax.swing.JTextField();
        ABT = new javax.swing.JButton();
        FAQS = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setLayout(null);

        CONFIRM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/CFU.png"))); // NOI18N
        CONFIRM.setBorderPainted(false);
        CONFIRM.setContentAreaFilled(false);
        CONFIRM.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/CFC.png"))); // NOI18N
        CONFIRM.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/CFC.png"))); // NOI18N
        CONFIRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONFIRMActionPerformed(evt);
            }
        });
        add(CONFIRM);
        CONFIRM.setBounds(1032, 578, 198, 51);

        CANCEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/CLU.png"))); // NOI18N
        CANCEL.setBorderPainted(false);
        CANCEL.setContentAreaFilled(false);
        CANCEL.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/CLC.png"))); // NOI18N
        CANCEL.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/CLC.png"))); // NOI18N
        CANCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CANCELActionPerformed(evt);
            }
        });
        add(CANCEL);
        CANCEL.setBounds(808, 578, 198, 51);

        verification.setContentAreaFilled(false);
        verification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificationActionPerformed(evt);
            }
        });
        add(verification);
        verification.setBounds(200, 490, 20, 20);

        BACK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/HU.png"))); // NOI18N
        BACK.setBorderPainted(false);
        BACK.setContentAreaFilled(false);
        BACK.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/HC.png"))); // NOI18N
        BACK.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/HC.png"))); // NOI18N
        BACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BACKActionPerformed(evt);
            }
        });
        add(BACK);
        BACK.setBounds(23, 175, 57, 57);

        PASSWORD.setBackground(java.awt.Color.white);
        PASSWORD.setBorder(null);
        add(PASSWORD);
        PASSWORD.setBounds(329, 449, 832, 20);

        MOBILENUM.setBackground(java.awt.Color.white);
        MOBILENUM.setBorder(null);
        add(MOBILENUM);
        MOBILENUM.setBounds(810, 400, 350, 20);

        AGE.setBackground(java.awt.Color.white);
        AGE.setBorder(null);
        add(AGE);
        AGE.setBounds(1050, 354, 111, 20);

        BDAY.setBackground(java.awt.Color.white);
        BDAY.setBorder(null);
        add(BDAY);
        BDAY.setBounds(330, 400, 312, 20);

        NAME.setBackground(java.awt.Color.white);
        NAME.setBorder(null);
        add(NAME);
        NAME.setBounds(330, 354, 634, 20);

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
        ABT.setBounds(769, 117, 144, 35);

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
        FAQS.setBounds(937, 117, 101, 35);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/AC_CAC.png"))); // NOI18N
        add(background);
        background.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        frame.setContentPane(new TRANSACTIONS(frame));
        frame.revalidate();
    }//GEN-LAST:event_BACKActionPerformed

    private void verificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificationActionPerformed
        
    }//GEN-LAST:event_verificationActionPerformed

    private void CONFIRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONFIRMActionPerformed
        
        String name = NAME.getText();
        String age = AGE.getText();
        String number = MOBILENUM.getText();
        String bday = BDAY.getText();
        String pass = PASSWORD.getText();
        
        if (PASSWORD.getText().length() != 5) {
        JOptionPane.showMessageDialog(null, "Password must be exactly 5 characters long.");
        return; // stop saving
        } else {
        
        if (verification.isSelected()){
            System.out.print("\nUser information : " + name + " " + age + " " + number + " " + age + " " + pass);
            insertClientInfo(NAME.getText(), BDAY.getText(), Integer.parseInt(AGE.getText()), MOBILENUM.getText(), PASSWORD.getText());
            NAME.setText(null); AGE.setText(null); MOBILENUM.setText(null); BDAY.setText(null); PASSWORD.setText(null);
        } else {
            System.out.print("\nPlease aggre to the terms and privacy provided");
        }
        }
    }//GEN-LAST:event_CONFIRMActionPerformed

    private void CANCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANCELActionPerformed
        NAME.setText(null); BDAY.setText(null); PASSWORD.setText(null); AGE.setText(null); MOBILENUM.setText(null);
    }//GEN-LAST:event_CANCELActionPerformed

    private void ABTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ABTActionPerformed
        frame.setContentPane(new ABOUT(frame));
        frame.revalidate();
    }//GEN-LAST:event_ABTActionPerformed

    private void FAQSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FAQSActionPerformed
        frame.setContentPane(new FAQS(frame));
        frame.revalidate();
    }//GEN-LAST:event_FAQSActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ABT;
    private javax.swing.JTextField AGE;
    private javax.swing.JButton BACK;
    private javax.swing.JTextField BDAY;
    private javax.swing.JButton CANCEL;
    private javax.swing.JButton CONFIRM;
    private javax.swing.JButton FAQS;
    private javax.swing.JTextField MOBILENUM;
    private javax.swing.JTextField NAME;
    private javax.swing.JPasswordField PASSWORD;
    private javax.swing.JLabel background;
    private javax.swing.JCheckBox verification;
    // End of variables declaration//GEN-END:variables
}
