package Main;

import static Main.Deposit_form.newQueue;
import static Main.Withdraw_form.counter;
import static Main.Withdraw_form.ticket;
import static Main.Withdraw_form.transac;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

public class public_dash extends javax.swing.JPanel {
    public int quenum = 0;
     public static String transaction = "Inquire";
    public static String counter = "4", newQueue;
    private Frame frame;
    public public_dash(Frame frame) {
        initComponents();
        this.frame = frame;
        Clock();
        KeyCombinations();
      
        /*
        withdraw_info.setVisible(false);
        Loan_info.setVisible(false);
        Deposit_info.setVisible(false);
        Inquire_info.setVisible(false);
       */
    }
    
    //database WAG GALAWIN
    /*
    
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
            String lastQueue = rs.getString("Que_Num"); // e.g., W - 001
            if (lastQueue != null && lastQueue.contains(" - ")) {
                String[] parts = lastQueue.split(" - ");
                int num = Integer.parseInt(parts[1]); 
                num++;
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
        newQueue = getNextQueueNumber("I");

        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/banking_sino_ka_man", "root", ""
        );

        String sqlInfo = "INSERT INTO informations (Username, Age, MobileNum, Que_Num) VALUES (?, ?, ?, ?)";
        try (java.sql.PreparedStatement pst = con.prepareStatement(sqlInfo)) {
            pst.setString(1, "NULL");
            pst.setInt(2, 0);
            pst.setString(3, "NULL");
            pst.setString(4, newQueue);
            pst.executeUpdate();
        }

        String sqlHist = "INSERT INTO history_transaction (Name, Age, Mobile_number, Que_number) VALUES (?, ?, ?, ?)";
        try (java.sql.PreparedStatement pstHist = con.prepareStatement(sqlHist)) {
            pstHist.setString(1, "NULL");
            pstHist.setInt(2, 0);
            pstHist.setString(3, "NULL");
            pstHist.setString(4, newQueue);
            pstHist.executeUpdate();
        }
        con.close();
    } catch (Exception ex) {
        ex.printStackTrace();
        
    }
}

*/
    
  public void KeyCombinations() {
    SwingUtilities.invokeLater(() -> {
        JRootPane RP = this.getRootPane();

        if (RP == null) {
            System.err.println("RootPane not initialized yet!");
            return;
        }

        RP.setFocusable(true);
        RP.requestFocusInWindow(); // force focus on root pane

        RP.addKeyListener(new KeyAdapter() {
            // admin shortcut
            private boolean shiftPressed = false;
            private boolean aPressed = false;
            private boolean dPressed = false;

            // employee shortcut
            private boolean ePressed = false;
            private boolean mPressed = false;

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SHIFT) shiftPressed = true;

                // admin keys
                if (e.getKeyCode() == KeyEvent.VK_A) aPressed = true;
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    dPressed = true;
                    if (shiftPressed && aPressed && dPressed) {
                        frame.setContentPane(new Admin.Admin_Login(frame));
                        frame.revalidate();
                        resetKeys();
                    }
                }

                // employee keys
                if (e.getKeyCode() == KeyEvent.VK_E) ePressed = true;
                if (e.getKeyCode() == KeyEvent.VK_M) {
                    mPressed = true;
                    if (shiftPressed && ePressed && mPressed) {
                        frame.setContentPane(new Employee.Employeee_Login(frame));
                        frame.revalidate();
                        resetKeys();
                    }
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SHIFT) shiftPressed = false;
                if (e.getKeyCode() == KeyEvent.VK_A) aPressed = false;
                if (e.getKeyCode() == KeyEvent.VK_D) dPressed = false;
                if (e.getKeyCode() == KeyEvent.VK_E) ePressed = false;
                if (e.getKeyCode() == KeyEvent.VK_M) mPressed = false;
            }

            private void resetKeys() {
                shiftPressed = false;
                aPressed = false;
                dPressed = false;
                ePressed = false;
                mPressed = false;
            }
        });
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
        create_acc = new javax.swing.JButton();
        Deposit = new javax.swing.JButton();
        w_u = new javax.swing.JButton();
        w_c = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        faqs_btn = new javax.swing.JButton();
        about_btn = new javax.swing.JButton();
        Loan_service = new javax.swing.JButton();
        Inquire = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        background2 = new javax.swing.JLabel();

        setLayout(null);

        Time.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Time.setForeground(java.awt.Color.white);
        Time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Time.setToolTipText("");
        add(Time);
        Time.setBounds(1080, 650, 130, 40);

        create_acc.setIcon(new javax.swing.ImageIcon("C:\\Users\\reyes\\Downloads\\BSKM PHOTOS\\BUTTONS\\FAQU.png")); // NOI18N
        create_acc.setBorderPainted(false);
        create_acc.setContentAreaFilled(false);
        create_acc.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/BSKM PHOTOS/BUTTONS/CAC.png"))); // NOI18N
        create_acc.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/BSKM PHOTOS/BUTTONS/CAC.png"))); // NOI18N
        create_acc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_accActionPerformed(evt);
            }
        });
        add(create_acc);
        create_acc.setBounds(1058, 110, 212, 40);

        Deposit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/DPU.png"))); // NOI18N
        Deposit.setBorderPainted(false);
        Deposit.setContentAreaFilled(false);
        Deposit.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/DPC.png"))); // NOI18N
        Deposit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/DPU.png"))); // NOI18N
        Deposit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DepositMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DepositMouseExited(evt);
            }
        });
        Deposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepositActionPerformed(evt);
            }
        });
        add(Deposit);
        Deposit.setBounds(890, 270, 370, 100);

        w_u.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/WDU.png"))); // NOI18N
        w_u.setBorderPainted(false);
        w_u.setContentAreaFilled(false);
        w_u.setPressedIcon(new javax.swing.ImageIcon("C:\\Users\\reyes\\Desktop\\Bank_que_system\\src\\IMG'S\\WDC.png")); // NOI18N
        w_u.setRolloverIcon(new javax.swing.ImageIcon("C:\\Users\\reyes\\Desktop\\Bank_que_system\\src\\IMG'S\\WDU.png")); // NOI18N
        w_u.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                w_uMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                w_uMouseExited(evt);
            }
        });
        w_u.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                w_uActionPerformed(evt);
            }
        });
        add(w_u);
        w_u.setBounds(40, 270, 370, 100);

        w_c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/WDC.png"))); // NOI18N
        w_c.setBorderPainted(false);
        w_c.setContentAreaFilled(false);
        w_c.setPressedIcon(new javax.swing.ImageIcon("C:\\Users\\reyes\\Downloads\\BSKM PHOTOS\\BUTTONS\\PHOTO_AC WD.png")); // NOI18N
        w_c.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/WDC.png"))); // NOI18N
        w_c.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                w_cMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                w_cMouseExited(evt);
            }
        });
        w_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                w_cActionPerformed(evt);
            }
        });
        add(w_c);
        w_c.setBounds(40, 270, 370, 100);

        exit_btn.setIcon(new javax.swing.ImageIcon("C:\\Users\\reyes\\Downloads\\BSKM PHOTOS\\BUTTONS\\EX U.png")); // NOI18N
        exit_btn.setBorderPainted(false);
        exit_btn.setContentAreaFilled(false);
        exit_btn.setPressedIcon(new javax.swing.ImageIcon("C:\\Users\\reyes\\Downloads\\BSKM PHOTOS\\BUTTONS\\EX C.png")); // NOI18N
        exit_btn.setRolloverIcon(new javax.swing.ImageIcon("C:\\Users\\reyes\\Downloads\\BSKM PHOTOS\\BUTTONS\\EX C.png")); // NOI18N
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        add(exit_btn);
        exit_btn.setBounds(0, 550, 178, 66);

        faqs_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BSKM PHOTOS/BUTTONS/ABTU.png"))); // NOI18N
        faqs_btn.setBorderPainted(false);
        faqs_btn.setContentAreaFilled(false);
        faqs_btn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/BSKM PHOTOS/BUTTONS/FAQC.png"))); // NOI18N
        faqs_btn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/BSKM PHOTOS/BUTTONS/FAQC.png"))); // NOI18N
        faqs_btn.setSelected(true);
        faqs_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faqs_btnActionPerformed(evt);
            }
        });
        add(faqs_btn);
        faqs_btn.setBounds(937, 110, 101, 47);

        about_btn.setIcon(new javax.swing.ImageIcon("C:\\Users\\reyes\\Downloads\\BSKM PHOTOS\\BUTTONS\\CAU.png")); // NOI18N
        about_btn.setBorderPainted(false);
        about_btn.setContentAreaFilled(false);
        about_btn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/BSKM PHOTOS/BUTTONS/ABTC.png"))); // NOI18N
        about_btn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/BSKM PHOTOS/BUTTONS/ABTC.png"))); // NOI18N
        about_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                about_btnActionPerformed(evt);
            }
        });
        add(about_btn);
        about_btn.setBounds(770, 110, 145, 47);

        Loan_service.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/LSU.png"))); // NOI18N
        Loan_service.setBorderPainted(false);
        Loan_service.setContentAreaFilled(false);
        Loan_service.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/LSC.png"))); // NOI18N
        Loan_service.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/LSU.png"))); // NOI18N
        Loan_service.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Loan_serviceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Loan_serviceMouseExited(evt);
            }
        });
        Loan_service.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Loan_serviceActionPerformed(evt);
            }
        });
        add(Loan_service);
        Loan_service.setBounds(40, 430, 370, 100);

        Inquire.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/IQU.png"))); // NOI18N
        Inquire.setBorderPainted(false);
        Inquire.setContentAreaFilled(false);
        Inquire.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/IQC.png"))); // NOI18N
        Inquire.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/IQU.png"))); // NOI18N
        Inquire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InquireMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InquireMouseExited(evt);
            }
        });
        Inquire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InquireActionPerformed(evt);
            }
        });
        add(Inquire);
        Inquire.setBounds(890, 430, 380, 100);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/public_dashboard.gif"))); // NOI18N
        add(background);
        background.setBounds(0, 0, 1300, 700);

        background2.setText("jLabel1");
        add(background2);
        background2.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void about_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_btnActionPerformed
        frame.setContentPane(new About(frame));
        frame.revalidate();
    }//GEN-LAST:event_about_btnActionPerformed

    private void faqs_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faqs_btnActionPerformed
        frame.setContentPane(new Faqs(frame));
        frame.revalidate();
    }//GEN-LAST:event_faqs_btnActionPerformed

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        frame.setContentPane(new Ads(frame));
        frame.revalidate();
    }//GEN-LAST:event_exit_btnActionPerformed

    private void w_uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_w_uActionPerformed
        frame.setContentPane(new Withdraw_form(frame));
        frame.revalidate();
    }//GEN-LAST:event_w_uActionPerformed

    private void Loan_serviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Loan_serviceActionPerformed
        frame.setContentPane(new LoanService_form(frame));
        frame.revalidate();
    }//GEN-LAST:event_Loan_serviceActionPerformed

    private void DepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepositActionPerformed
        frame.setContentPane(new Deposit_form(frame));
        frame.revalidate();
    }//GEN-LAST:event_DepositActionPerformed

    private void InquireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InquireActionPerformed
        //insertUser(); - WAG GALAWIN
        frame.setContentPane(new Que_num(frame));
        frame.revalidate();
        Que_num.QUE_NO.setText(newQueue);
        Que_num.TYPE.setText(transaction);
        Que_num.COUNTER.setText(counter);
    }//GEN-LAST:event_InquireActionPerformed

    private void create_accActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_accActionPerformed
        frame.setContentPane(new Create_acc(frame));
        frame.revalidate();
    }//GEN-LAST:event_create_accActionPerformed

    private void w_uMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_w_uMouseEntered
       ImageIcon img = new ImageIcon("C:\\Users\\reyes\\Desktop\\Bank_que_system\\src\\Hovered_Background_Transactions\\WD HOVER.gif");
       background.setIcon(img);
       background.repaint();
    }//GEN-LAST:event_w_uMouseEntered

    private void w_uMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_w_uMouseExited
       ImageIcon img = new ImageIcon("C:\\Users\\reyes\\Desktop\\Bank_que_system\\src\\IMG'S\\public_dashboard.gif");
       background.setIcon(img);
       background.setVisible(true);
       background.repaint();
       background.revalidate();
    }//GEN-LAST:event_w_uMouseExited

    private void Loan_serviceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Loan_serviceMouseEntered
       ImageIcon img = new ImageIcon("C:\\Users\\reyes\\Desktop\\Bank_que_system\\src\\Hovered_Background_Transactions\\LS HOVER.gif");
       background.setIcon(img);
    }//GEN-LAST:event_Loan_serviceMouseEntered

    private void Loan_serviceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Loan_serviceMouseExited
       ImageIcon img = new ImageIcon("C:\\Users\\reyes\\Desktop\\Bank_que_system\\src\\IMG'S\\public_dashboard.gif");
       background.setIcon(img);
    }//GEN-LAST:event_Loan_serviceMouseExited

    private void DepositMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DepositMouseEntered
       ImageIcon img = new ImageIcon("C:\\Users\\reyes\\Desktop\\Bank_que_system\\src\\Hovered_Background_Transactions\\DEPO HOVER.gif");
       background.setIcon(img);
    }//GEN-LAST:event_DepositMouseEntered

    private void DepositMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DepositMouseExited
       ImageIcon img = new ImageIcon("C:\\Users\\reyes\\Desktop\\Bank_que_system\\src\\IMG'S\\public_dashboard.gif");
       background.setIcon(img);
    }//GEN-LAST:event_DepositMouseExited

    private void InquireMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InquireMouseEntered
       ImageIcon img = new ImageIcon("C:\\Users\\reyes\\Desktop\\Bank_que_system\\src\\Hovered_Background_Transactions\\IQ HOVER.gif");
       background.setIcon(img);
    }//GEN-LAST:event_InquireMouseEntered

    private void InquireMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InquireMouseExited
       ImageIcon img = new ImageIcon("C:\\Users\\reyes\\Desktop\\Bank_que_system\\src\\IMG'S\\public_dashboard.gif");
       background.setIcon(img);
    }//GEN-LAST:event_InquireMouseExited

    private void w_cMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_w_cMouseEntered
       ImageIcon img = new ImageIcon("");
       background.setIcon(img);
    }//GEN-LAST:event_w_cMouseEntered

    private void w_cMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_w_cMouseExited
       ImageIcon img = new ImageIcon("");
       background.setIcon(img);
    }//GEN-LAST:event_w_cMouseExited

    private void w_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_w_cActionPerformed
       ImageIcon img = new ImageIcon("");
       background.setIcon(img);
    }//GEN-LAST:event_w_cActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Deposit;
    private javax.swing.JButton Inquire;
    private javax.swing.JButton Loan_service;
    private javax.swing.JLabel Time;
    private javax.swing.JButton about_btn;
    private javax.swing.JLabel background;
    private javax.swing.JLabel background2;
    private javax.swing.JButton create_acc;
    private javax.swing.JButton exit_btn;
    private javax.swing.JButton faqs_btn;
    private javax.swing.JButton w_c;
    private javax.swing.JButton w_u;
    // End of variables declaration//GEN-END:variables
}
