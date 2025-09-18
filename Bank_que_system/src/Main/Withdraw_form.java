package Main;


import Main.Frame;
import Main.public_dash;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.sql.DriverManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author reyes
 */

public class Withdraw_form extends javax.swing.JPanel {
    public static String counter ="1", ticket, transac = "Withdraw", newQueue;
    
public static int quenum = 0;
    private Frame frame;
    
    public Withdraw_form(Frame frame) {
        initComponents();
        this.frame = frame;
        Clock();
        limits();
        
    }
    
    
    public void insertClientInfo(String username, int age, String mobileNum) {
    String prefix = "W - ";
    String nextQueueNumber = prefix + "001"; 

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/banking_sino_ka_man", "root", ""
        );

        String sql = "SELECT Que_Num FROM informations ORDER BY Que_Num DESC LIMIT 1";
        java.sql.Statement stmt = con.createStatement();
        java.sql.ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            String lastQueue = rs.getString("Que_Num");

            String numberPart = lastQueue.replaceAll("[^0-9]", ""); 
            int number = Integer.parseInt(numberPart);
            number++;

            nextQueueNumber = prefix + String.format("%03d", number);
            newQueue = nextQueueNumber;
        }

        String insertSql = "INSERT INTO informations (Username, Age, MobileNum, Que_Num) VALUES (?, ?, ?, ?)";
        java.sql.PreparedStatement pstmt = con.prepareStatement(insertSql);
        pstmt.setString(1, username);
        pstmt.setInt(2, age);
        pstmt.setString(3, mobileNum);
        pstmt.setString(4, nextQueueNumber);

        int rows = pstmt.executeUpdate();

        if (rows > 0) {
            JOptionPane.showMessageDialog(null,
                "Registered Successfully!\nYour Ticket Number: " + nextQueueNumber);
        }

        con.close();
    } catch (Exception e) {
        
    }
}

    public void limits(){
        
        Age.setDocument(new javax.swing.text.PlainDocument() {
            @Override
            public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
                    throws javax.swing.text.BadLocationException {
                if (str == null)
                    return;
                if ((getLength() + str.length() <= 2)) {
                    super.insertString(offs, str, a);
                } else if (!(getLength() + str.length() <= 2)) {
                    JOptionPane.showMessageDialog(null,"Age must not exceed 2 characters");
                    Age.setText(null);
                } 
            }
        });
        
        MobileNum.setDocument(new javax.swing.text.PlainDocument() {
            @Override
            public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
                    throws javax.swing.text.BadLocationException {
                if (str == null)
                    return;
                if ((getLength() + str.length() <= 11)) {
                    super.insertString(offs, str, a);
                } else if (!(getLength() + str.length() <= 11)) {
                    JOptionPane.showMessageDialog(null,"Mobile number must not exceed 11 characters");
                    MobileNum.setText(null);
                } 
            }
        });
    }
    
   
    private void updateTime() {
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a"); 
    String currentTime = sdf.format(new Date());
    Time.setText(currentTime);
    }

    public void Clock() {
    Timer timer = new Timer(1000, e -> updateTime());
    timer.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Time = new javax.swing.JLabel();
        Confirm_btn = new javax.swing.JButton();
        Age = new javax.swing.JTextField();
        MobileNum = new javax.swing.JTextField();
        U_name = new javax.swing.JTextField();
        exit_btn = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setLayout(null);

        Time.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Time.setForeground(java.awt.Color.white);
        Time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Time.setToolTipText("");
        add(Time);
        Time.setBounds(1080, 650, 130, 40);

        Confirm_btn.setBorderPainted(false);
        Confirm_btn.setContentAreaFilled(false);
        Confirm_btn.setFocusPainted(false);
        Confirm_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Confirm_btnActionPerformed(evt);
            }
        });
        add(Confirm_btn);
        Confirm_btn.setBounds(1120, 540, 180, 80);

        Age.setBorder(null);
        add(Age);
        Age.setBounds(30, 380, 90, 50);

        MobileNum.setBorder(null);
        add(MobileNum);
        MobileNum.setBounds(30, 490, 380, 40);

        U_name.setBorder(null);
        add(U_name);
        U_name.setBounds(30, 290, 380, 40);

        exit_btn.setBorderPainted(false);
        exit_btn.setContentAreaFilled(false);
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        add(exit_btn);
        exit_btn.setBounds(0, 540, 190, 90);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/transaction_form.gif"))); // NOI18N
        add(bg);
        bg.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        frame.setContentPane(new public_dash(frame));
        frame.revalidate();
    }//GEN-LAST:event_exit_btnActionPerformed

    private void Confirm_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Confirm_btnActionPerformed

        if(MobileNum.getText().length() == 11) { 
            
    frame.setContentPane(new Que_num(frame));
    //insertClientInfo(U_name.getText(), Integer.parseInt(Age.getText()), MobileNum.getText()); - to register 
    frame.revalidate();
    Que_num.QUE_NO.setText(newQueue);
    Que_num.TYPE.setText(transac);
    Que_num.COUNTER.setText(counter);
        } else {
            JOptionPane.showMessageDialog(null, "Number should be 11 digits");
        }
    }//GEN-LAST:event_Confirm_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Age;
    private javax.swing.JButton Confirm_btn;
    private javax.swing.JTextField MobileNum;
    private javax.swing.JLabel Time;
    private javax.swing.JTextField U_name;
    private javax.swing.JLabel bg;
    private javax.swing.JButton exit_btn;
    // End of variables declaration//GEN-END:variables
}
