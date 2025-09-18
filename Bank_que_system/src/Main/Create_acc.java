/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Main;

import javax.swing.JOptionPane;

/**
 *
 * @author reyes
 */
public class Create_acc extends javax.swing.JPanel {

    private Frame frame;
    public Create_acc(Frame frame) {
        initComponents();
        
        this.frame = frame;
    }
    
    //database, WAG GALAWIN!
    /*
    
    public void registerNewUser(String name, int age, String birthday, String mobileNum, String password) {
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");

            java.sql.Connection con = java.sql.DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/banking_sino_ka_man", "root", ""
            );

            String sql = "INSERT INTO bank_users (Name, Age, Birthday, MobileNum, Password) VALUES (?, ?, ?, ?, ?)";

            java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, birthday);  
            pstmt.setString(4, mobileNum);
            pstmt.setString(5, password);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.print("User registered successfully!");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
           System.out.print("Error: " + e.getMessage());
        }
    }

    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Age = new javax.swing.JTextField();
        Birthday = new javax.swing.JTextField();
        MobileNum = new javax.swing.JTextField();
        Name = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        consent = new javax.swing.JCheckBox();
        bck_btn = new javax.swing.JButton();
        ent_btn = new javax.swing.JButton();
        faqs_btn = new javax.swing.JButton();
        about_btn1 = new javax.swing.JButton();
        about_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        Age.setBackground(java.awt.Color.white);
        Age.setBorder(null);
        Age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgeActionPerformed(evt);
            }
        });
        add(Age);
        Age.setBounds(1008, 370, 105, 23);

        Birthday.setBackground(java.awt.Color.white);
        Birthday.setBorder(null);
        Birthday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BirthdayActionPerformed(evt);
            }
        });
        add(Birthday);
        Birthday.setBounds(317, 418, 300, 24);

        MobileNum.setBackground(java.awt.Color.white);
        MobileNum.setBorder(null);
        MobileNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MobileNumActionPerformed(evt);
            }
        });
        add(MobileNum);
        MobileNum.setBounds(778, 418, 333, 24);

        Name.setBackground(java.awt.Color.white);
        Name.setBorder(null);
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        add(Name);
        Name.setBounds(316, 370, 610, 23);

        password.setBackground(java.awt.Color.white);
        password.setBorder(null);
        password.setName(""); // NOI18N
        add(password);
        password.setBounds(318, 470, 793, 22);

        consent.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        consent.setPreferredSize(new java.awt.Dimension(30, 30));
        add(consent);
        consent.setBounds(198, 515, 20, 30);

        bck_btn.setBorderPainted(false);
        bck_btn.setContentAreaFilled(false);
        bck_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bck_btnActionPerformed(evt);
            }
        });
        add(bck_btn);
        bck_btn.setBounds(0, 540, 190, 80);

        ent_btn.setBorderPainted(false);
        ent_btn.setContentAreaFilled(false);
        ent_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ent_btnActionPerformed(evt);
            }
        });
        add(ent_btn);
        ent_btn.setBounds(1120, 540, 180, 80);

        faqs_btn.setIcon(new javax.swing.ImageIcon("C:\\Users\\reyes\\Downloads\\BSKM PHOTOS\\BUTTONS\\ABTU.png")); // NOI18N
        faqs_btn.setBorderPainted(false);
        faqs_btn.setContentAreaFilled(false);
        faqs_btn.setPressedIcon(new javax.swing.ImageIcon("C:\\Users\\reyes\\Downloads\\BSKM PHOTOS\\BUTTONS\\FAQC.png")); // NOI18N
        faqs_btn.setRolloverIcon(new javax.swing.ImageIcon("C:\\Users\\reyes\\Downloads\\BSKM PHOTOS\\BUTTONS\\FAQC.png")); // NOI18N
        faqs_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faqs_btnActionPerformed(evt);
            }
        });
        add(faqs_btn);
        faqs_btn.setBounds(936, 110, 101, 47);

        about_btn1.setIcon(new javax.swing.ImageIcon("C:\\Users\\reyes\\Downloads\\BSKM PHOTOS\\BUTTONS\\CAU.png")); // NOI18N
        about_btn1.setBorderPainted(false);
        about_btn1.setContentAreaFilled(false);
        about_btn1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/BSKM PHOTOS/BUTTONS/ABTC.png"))); // NOI18N
        about_btn1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/BSKM PHOTOS/BUTTONS/ABTC.png"))); // NOI18N
        about_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                about_btn1ActionPerformed(evt);
            }
        });
        add(about_btn1);
        about_btn1.setBounds(769, 110, 145, 47);

        about_btn.setBorderPainted(false);
        about_btn.setContentAreaFilled(false);
        about_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                about_btnActionPerformed(evt);
            }
        });
        add(about_btn);
        about_btn.setBounds(750, 100, 160, 50);

        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BACKU.png"))); // NOI18N
        exit_btn.setBorderPainted(false);
        exit_btn.setContentAreaFilled(false);
        exit_btn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BACKC.png"))); // NOI18N
        exit_btn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BACKU.png"))); // NOI18N
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        add(exit_btn);
        exit_btn.setBounds(15, 173, 70, 63);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BSKM PHOTOS/PANELS/PHOTO_ AC CA.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void AgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgeActionPerformed

    private void BirthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BirthdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BirthdayActionPerformed

    private void MobileNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MobileNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MobileNumActionPerformed

    private void bck_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bck_btnActionPerformed
        frame.setContentPane(new public_dash(frame));
        frame.revalidate();
    }//GEN-LAST:event_bck_btnActionPerformed

    private void ent_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ent_btnActionPerformed
        
     if (!Name.getText().contains(" ") && !Birthday.getText().contains(" ")){
            System.out.print("Please enter coorect informations");
     } else {
         
         /* this
        
        if (consent.isSelected()){
            
        registerNewUser(Name.getText(),
                Integer.parseInt(Age.getText()),
                Birthday.getText(),
                MobileNum.getText(),
                password.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Please check the consent form");
        }

*/

     }
    }//GEN-LAST:event_ent_btnActionPerformed

    private void faqs_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faqs_btnActionPerformed
        frame.setContentPane(new Faqs(frame));
        frame.revalidate();
    }//GEN-LAST:event_faqs_btnActionPerformed

    private void about_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_btn1ActionPerformed
        frame.setContentPane(new About(frame));
        frame.revalidate();
    }//GEN-LAST:event_about_btn1ActionPerformed

    private void about_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_btnActionPerformed
        frame.setContentPane(new About(frame));
        frame.revalidate();
    }//GEN-LAST:event_about_btnActionPerformed

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        frame.setContentPane(new public_dash(frame));
        frame.revalidate();
    }//GEN-LAST:event_exit_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Age;
    private javax.swing.JTextField Birthday;
    private javax.swing.JTextField MobileNum;
    private javax.swing.JTextField Name;
    private javax.swing.JButton about_btn;
    private javax.swing.JButton about_btn1;
    private javax.swing.JButton bck_btn;
    private javax.swing.JCheckBox consent;
    private javax.swing.JButton ent_btn;
    private javax.swing.JButton exit_btn;
    private javax.swing.JButton faqs_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables
}
