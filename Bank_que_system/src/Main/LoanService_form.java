package Main;


import Main.Frame;
import static Main.Withdraw_form.newQueue;
import static Main.Withdraw_form.quenum;
import static Main.Withdraw_form.ticket;
import Main.public_dash;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author reyes
 */
public class LoanService_form extends javax.swing.JPanel {
    public String newQueue;
    public static String transaction = "Loan Service";
    public static String counter = "2";
    private Frame frame;
    public LoanService_form(Frame frame) {
        initComponents();
        this.frame = frame;
        Clock();
        limits();
    }
    
    /* WAG GALAWIN
    
public String getNextQueueNumber(String prefix) {
    String nextQueueNumber = prefix + " - 001"; 

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/banking_sino_ka_man", "root", "");

        String sql = "SELECT Que_Num FROM informations WHERE Que_Num LIKE ? ORDER BY Que_Num DESC LIMIT 1";
        java.sql.PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, prefix + " - %");
        java.sql.ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String lastQueue = rs.getString("Que_Num"); 
            if (lastQueue != null && lastQueue.contains(" - ")) {
                String[] parts = lastQueue.split(" - ");
                int num = Integer.parseInt(parts[1]); // get number part
                num++; // increment
                nextQueueNumber = prefix + " - " + String.format("%03d", num);
            }
        }

        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return nextQueueNumber;
}


public void insertUser() {
    try {
        newQueue = getNextQueueNumber("L");

        String username = U_name.getText();
        int age = Integer.parseInt(Age.getText());
        String mobileNum = MobileNum.getText();

        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/banking_sino_ka_man", "root", ""
        );

        // Insert into informations (active queue)
        String sqlInfo = "INSERT INTO informations (Username, Age, MobileNum, Que_Num) VALUES (?, ?, ?, ?)";
        try (java.sql.PreparedStatement pst = con.prepareStatement(sqlInfo)) {
            pst.setString(1, username);
            pst.setInt(2, age);
            pst.setString(3, mobileNum);
            pst.setString(4, newQueue);
            pst.executeUpdate();
        }

        // Insert into history_transaction (permanent log)
        String sqlHist = "INSERT INTO history_transaction (Name, Age, Mobile_number, Que_number) VALUES (?, ?, ?, ?)";
        try (java.sql.PreparedStatement pstHist = con.prepareStatement(sqlHist)) {
            pstHist.setString(1, username);
            pstHist.setInt(2, age);
            pstHist.setString(3, mobileNum);
            pstHist.setString(4, newQueue);
            pstHist.executeUpdate();
        }
        con.close();

    } catch (Exception ex) {
        ex.printStackTrace();
        //JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
}

*/

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

        exit_btn = new javax.swing.JButton();
        Time = new javax.swing.JLabel();
        U_name = new javax.swing.JTextField();
        Age = new javax.swing.JTextField();
        MobileNum = new javax.swing.JTextField();
        confirm = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

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

        Time.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Time.setForeground(java.awt.Color.white);
        Time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Time.setToolTipText("");
        add(Time);
        Time.setBounds(1080, 650, 130, 40);

        U_name.setBorder(null);
        add(U_name);
        U_name.setBounds(30, 290, 380, 40);

        Age.setBorder(null);
        add(Age);
        Age.setBounds(30, 380, 90, 50);

        MobileNum.setBorder(null);
        add(MobileNum);
        MobileNum.setBounds(30, 490, 380, 40);

        confirm.setBorderPainted(false);
        confirm.setContentAreaFilled(false);
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        add(confirm);
        confirm.setBounds(1130, 550, 170, 70);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/transaction_form.gif"))); // NOI18N
        add(bg);
        bg.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        frame.setContentPane(new public_dash(frame));
        frame.revalidate();
    }//GEN-LAST:event_exit_btnActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        //helps to insert user
        //insertUser();
        frame.setContentPane(new Que_num(frame));
        frame.revalidate();
        
        
        Que_num.QUE_NO.setText(newQueue);
        Que_num.TYPE.setText(transaction);
        Que_num.COUNTER.setText(counter);

    }//GEN-LAST:event_confirmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Age;
    private javax.swing.JTextField MobileNum;
    private javax.swing.JLabel Time;
    private javax.swing.JTextField U_name;
    private javax.swing.JLabel bg;
    private javax.swing.JButton confirm;
    private javax.swing.JButton exit_btn;
    // End of variables declaration//GEN-END:variables
}
