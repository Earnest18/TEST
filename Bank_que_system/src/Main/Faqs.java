package Main;


import Main.About;
import Main.Frame;
import Main.public_dash;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author reyes
 */
public class Faqs extends javax.swing.JPanel {

    private Frame frame;
    public Faqs(Frame frame) {
        initComponents();
        this.frame = frame;
        Clock();
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
        about_btn = new javax.swing.JButton();
        faqs_btn = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        about_btn1 = new javax.swing.JButton();
        create_acc = new javax.swing.JButton();
        exit_btn2 = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setLayout(null);

        Time.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Time.setForeground(java.awt.Color.white);
        Time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Time.setToolTipText("");
        add(Time);
        Time.setBounds(1080, 650, 130, 40);

        about_btn.setBorderPainted(false);
        about_btn.setContentAreaFilled(false);
        about_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                about_btnActionPerformed(evt);
            }
        });
        add(about_btn);
        about_btn.setBounds(750, 100, 160, 50);

        faqs_btn.setBorderPainted(false);
        faqs_btn.setContentAreaFilled(false);
        faqs_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faqs_btnActionPerformed(evt);
            }
        });
        add(faqs_btn);
        faqs_btn.setBounds(920, 120, 120, 50);

        exit_btn.setBorderPainted(false);
        exit_btn.setContentAreaFilled(false);
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        add(exit_btn);
        exit_btn.setBounds(0, 540, 190, 90);

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
        create_acc.setBounds(1060, 114, 212, 40);

        exit_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BACKU.png"))); // NOI18N
        exit_btn2.setBorderPainted(false);
        exit_btn2.setContentAreaFilled(false);
        exit_btn2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BACKC.png"))); // NOI18N
        exit_btn2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BACKU.png"))); // NOI18N
        exit_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btn2ActionPerformed(evt);
            }
        });
        add(exit_btn2);
        exit_btn2.setBounds(15, 173, 70, 63);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BSKM PHOTOS/PANELS/PHOTO_ AC FAQs.png"))); // NOI18N
        add(bg);
        bg.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        frame.setContentPane(new public_dash(frame));
        frame.revalidate();
    }//GEN-LAST:event_exit_btnActionPerformed

    private void about_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_btnActionPerformed
        frame.setContentPane(new About(frame));
        frame.revalidate();
    }//GEN-LAST:event_about_btnActionPerformed

    private void faqs_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faqs_btnActionPerformed
        frame.setContentPane(new Faqs(frame));
        frame.revalidate();
    }//GEN-LAST:event_faqs_btnActionPerformed

    private void about_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_btn1ActionPerformed
        frame.setContentPane(new About(frame));
        frame.revalidate();
    }//GEN-LAST:event_about_btn1ActionPerformed

    private void create_accActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_accActionPerformed
        frame.setContentPane(new Create_acc(frame));
        frame.revalidate();
    }//GEN-LAST:event_create_accActionPerformed

    private void exit_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btn2ActionPerformed
        frame.setContentPane(new public_dash(frame));
        frame.revalidate();
    }//GEN-LAST:event_exit_btn2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Time;
    private javax.swing.JButton about_btn;
    private javax.swing.JButton about_btn1;
    private javax.swing.JLabel bg;
    private javax.swing.JButton create_acc;
    private javax.swing.JButton exit_btn;
    private javax.swing.JButton exit_btn2;
    private javax.swing.JButton faqs_btn;
    // End of variables declaration//GEN-END:variables
}
