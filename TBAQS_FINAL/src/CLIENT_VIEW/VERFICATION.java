/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package CLIENT_VIEW;

import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author reyes
 */
public class VERFICATION extends javax.swing.JPanel {
    
    private Frame frame;
    public VERFICATION(Frame frame) {
        initComponents();
        limits();
        this.frame = frame;
    }
    
    public String generateQueueNumber(String username, String transactionType) {
    String newQueueNum = "";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/tbaqs", "root", ""
        );

        // 🔹 Get last queue number but only for this transaction type
        String sql = "SELECT QueNum FROM quenum WHERE Transaction_Type = ? ORDER BY ID DESC LIMIT 1";
        java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, transactionType);
        java.sql.ResultSet rs = pstmt.executeQuery();

        int nextNum = 1;
        if (rs.next()) {
            String lastQue = rs.getString("QueNum"); // e.g. "W - 011"
            if (lastQue != null && lastQue.contains(" - ")) {
                String[] parts = lastQue.split(" - ");
                nextNum = Integer.parseInt(parts[1]) + 1;
            }
        }

        // 🔹 Get prefix based on transaction type (W for Withdraw, L for Loan)
        String prefix = transactionType.substring(0, 1).toUpperCase();

        // 🔹 Format new queue number
        newQueueNum = String.format("%s - %03d", prefix, nextNum);

        // 🔹 Insert new record into table
        String insertSql = "INSERT INTO quenum (Username, Age, MobileNum, QueNum, Transaction_Type) VALUES (?, ?, ?, ?, ?)";
        java.sql.PreparedStatement insertPstmt = con.prepareStatement(insertSql);
        insertPstmt.setString(1, username);
        insertPstmt.setString(2, AGE.getText());
        insertPstmt.setString(3, MOBILENUM.getText());
        insertPstmt.setString(4, newQueueNum);
        insertPstmt.setString(5, transactionType);
        insertPstmt.executeUpdate();

        con.close();

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }

    return newQueueNum;
}


public QUE_NUM_CONSTRUCTOR verifyUser(String username, String password) {
    QUE_NUM_CONSTRUCTOR result = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/tbaqs", "root", ""
        );

        String sql = "SELECT * FROM New_Registered_User WHERE Username = ? AND Password = ?";
        java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);

        java.sql.ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            System.out.println("USER FOUND");

            // Generate queue number only if user exists
            String queNum = generateQueueNumber(username, QUE_NUM_CONSTRUCTOR.data.get(1));

            ArrayList<String> info = new ArrayList<>();
            info.add(queNum);      // Queue Number
            info.add(QUE_NUM_CONSTRUCTOR.data.get(1));  // Transaction Type
            info.add(QUE_NUM_CONSTRUCTOR.data.get(2));         // Counter (static for now)

            result = new QUE_NUM_CONSTRUCTOR(info);
            
            Timer timer = new Timer(1000, e -> {
            frame.setContentPane(new QUE_NUM(frame));
            frame.revalidate();
            });
            timer.setRepeats(false); 
            timer.start();
        
        } else {
            System.out.println("USER NOT FOUND!");
            JOptionPane.showMessageDialog(null, "Invalid Username or Password!", "Verification Failed", JOptionPane.ERROR_MESSAGE);
            return null; 
        }

        con.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }

    return result; 
}


    //this limits all the input (Acts as guide for the user
    public void limits(){
        
        AGE.setDocument(new javax.swing.text.PlainDocument() {
            @Override
            public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
                    throws javax.swing.text.BadLocationException {
                if (str == null)
                    return;
                if ((getLength() + str.length() <= 2)) {
                    super.insertString(offs, str, a);
                } else if (!(getLength() + str.length() <= 2)) {
                    JOptionPane.showMessageDialog(null,"Age must not exceed 2 characters");
                    AGE.setText(null);
                } 
            }
        });
        
        MOBILENUM.setDocument(new javax.swing.text.PlainDocument() {
            @Override
            public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
                    throws javax.swing.text.BadLocationException {
                if (str == null)
                    return;
                if ((getLength() + str.length() <= 11)) {
                    super.insertString(offs, str, a);
                } else if (!(getLength() + str.length() <= 11)) {
                    JOptionPane.showMessageDialog(null,"Mobile number must not exceed 11 characters");
                    MOBILENUM.setText(null);
                } 
            }
        });
        
        PASSWORD.setDocument(new javax.swing.text.PlainDocument() {
            @Override
            public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
                    throws javax.swing.text.BadLocationException {
                if (str == null)
                    return;
                if ((getLength() + str.length() <= 5)) {
                    super.insertString(offs, str, a);
                } else if (!(getLength() + str.length() <= 5)) {
                    JOptionPane.showMessageDialog(null,"Mobile number must not exceed 11 characters");
                    PASSWORD.setText(null);
                } 
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BACK = new javax.swing.JButton();
        CANCEL = new javax.swing.JButton();
        CONFIRM = new javax.swing.JButton();
        MOBILENUM = new javax.swing.JTextField();
        AGE = new javax.swing.JTextField();
        NAME = new javax.swing.JTextField();
        PASSWORD = new javax.swing.JPasswordField();
        background = new javax.swing.JLabel();

        setLayout(null);

        BACK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/BU.png"))); // NOI18N
        BACK.setBorderPainted(false);
        BACK.setContentAreaFilled(false);
        BACK.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/BC.png"))); // NOI18N
        BACK.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/BC.png"))); // NOI18N
        BACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BACKActionPerformed(evt);
            }
        });
        add(BACK);
        BACK.setBounds(24, 175, 57, 57);

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
        CANCEL.setBounds(449, 571, 199, 51);

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
        CONFIRM.setBounds(672, 571, 199, 51);

        MOBILENUM.setBackground(java.awt.Color.white);
        MOBILENUM.setBorder(null);
        add(MOBILENUM);
        MOBILENUM.setBounds(610, 428, 208, 20);

        AGE.setBackground(java.awt.Color.white);
        AGE.setBorder(null);
        add(AGE);
        AGE.setBounds(342, 428, 70, 20);

        NAME.setBackground(java.awt.Color.white);
        NAME.setBorder(null);
        add(NAME);
        NAME.setBounds(342, 365, 470, 20);

        PASSWORD.setBackground(java.awt.Color.white);
        PASSWORD.setBorder(null);
        add(PASSWORD);
        PASSWORD.setBounds(342, 489, 470, 20);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/VERIFICATION.gif"))); // NOI18N
        add(background);
        background.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        frame.setContentPane(new TRANSACTIONS(frame));
        frame.revalidate();
    }//GEN-LAST:event_BACKActionPerformed

    private void CONFIRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONFIRMActionPerformed
        
        String name = NAME.getText();
        String age = AGE.getText();
        String number = MOBILENUM.getText();
        String pass = PASSWORD.getText();
        
        verifyUser(NAME.getText(), PASSWORD.getText());
        System.out.print(name + " " + age + " " + number + " " + pass);
        NAME.setText(null); AGE.setText(null); MOBILENUM.setText(null); PASSWORD.setText(null);
        
    }//GEN-LAST:event_CONFIRMActionPerformed

    private void CANCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANCELActionPerformed
       
        NAME.setText(null); AGE.setText(null); MOBILENUM.setText(null); PASSWORD.setText(null); 
        
    }//GEN-LAST:event_CANCELActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AGE;
    private javax.swing.JButton BACK;
    private javax.swing.JButton CANCEL;
    private javax.swing.JButton CONFIRM;
    private javax.swing.JTextField MOBILENUM;
    private javax.swing.JTextField NAME;
    private javax.swing.JPasswordField PASSWORD;
    private javax.swing.JLabel background;
    // End of variables declaration//GEN-END:variables
}
