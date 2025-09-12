/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package CLIENT_VIEW;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author reyes
 */
public class QUE_NUM extends javax.swing.JPanel {
   
    private Frame frame;
    public QUE_NUM(Frame frame) {
        initComponents();
        this.frame = frame;
        
        Que_num.setText(QUE_NUM_CONSTRUCTOR.data.get(0));
        transaction.setText(QUE_NUM_CONSTRUCTOR.data.get(1));
        counter.setText(QUE_NUM_CONSTRUCTOR.data.get(2));
        MyTextPane.setVisible(false);
        
    }
    
   
    public void showAndPrintReceipt(JPanel parent, JPanel panel, JTextField area, String text) {
    
    area.setText(text);
    TranText.setText("TRANSACTION : " + QUE_NUM_CONSTRUCTOR.data.get(1));
    CounterText.setText("COUNTER : " + QUE_NUM_CONSTRUCTOR.data.get(2));
    int[] yPosition = {-500}; 

    int x = parent.getWidth() - panel.getWidth() - 130; 

    panel.setLocation(x, yPosition[0]);

    Timer timer = new Timer(25, e -> {
        yPosition[0] += 5; // move downward
        panel.setLocation(x, yPosition[0]);

        if (yPosition[0] >= 170) { // stop sliding at y=20
            ((Timer) e.getSource()).stop();
        }
    });

    timer.start();
}
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BACK = new javax.swing.JButton();
        Que_num = new javax.swing.JLabel();
        transaction = new javax.swing.JLabel();
        counter = new javax.swing.JLabel();
        MyTextPane = new javax.swing.JPanel();
        TranText = new javax.swing.JLabel();
        CounterText = new javax.swing.JLabel();
        receipt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setLayout(null);

        BACK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/PCU.png"))); // NOI18N
        BACK.setBorderPainted(false);
        BACK.setContentAreaFilled(false);
        BACK.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/PCC.png"))); // NOI18N
        BACK.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/PCC.png"))); // NOI18N
        BACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BACKActionPerformed(evt);
            }
        });
        add(BACK);
        BACK.setBounds(500, 571, 199, 51);

        Que_num.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Que_num.setForeground(java.awt.Color.black);
        Que_num.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(Que_num);
        Que_num.setBounds(220, 320, 260, 90);

        transaction.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        transaction.setForeground(java.awt.Color.black);
        transaction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(transaction);
        transaction.setBounds(90, 490, 190, 50);

        counter.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        counter.setForeground(java.awt.Color.black);
        counter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(counter);
        counter.setBounds(400, 480, 230, 60);

        MyTextPane.setLayout(null);

        TranText.setText("TRANSACTION");
        MyTextPane.add(TranText);
        TranText.setBounds(70, 170, 190, 20);

        CounterText.setText("COUNTER");
        MyTextPane.add(CounterText);
        CounterText.setBounds(70, 80, 90, 30);

        receipt.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        receipt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        receipt.setText("W - 001");
        MyTextPane.add(receipt);
        receipt.setBounds(66, 80, 210, 115);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/receipt_bg.png"))); // NOI18N
        MyTextPane.add(jLabel1);
        jLabel1.setBounds(0, 0, 340, 410);

        add(MyTextPane);
        MyTextPane.setBounds(810, 170, 340, 410);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/QUE_NUM.gif"))); // NOI18N
        add(background);
        background.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed

        Timer timer = new Timer(1000, e -> {
            //frame.setContentPane(new TRANSACTIONS(frame));
            MyTextPane.setVisible(true);
            showAndPrintReceipt(this,MyTextPane, receipt, Que_num.getText());
            frame.revalidate();
            frame.repaint();
        });
        timer.setRepeats(false); 
        timer.start();
    
        Timer timer2 = new Timer(8000, e -> {
          
            frame.setContentPane(new TRANSACTIONS(frame));
            frame.revalidate();
            frame.repaint();
        });
        timer2.setRepeats(false); 
        timer2.start();
        
    }//GEN-LAST:event_BACKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BACK;
    private javax.swing.JLabel CounterText;
    private javax.swing.JPanel MyTextPane;
    public static javax.swing.JLabel Que_num;
    private javax.swing.JLabel TranText;
    private javax.swing.JLabel background;
    public static javax.swing.JLabel counter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField receipt;
    public static javax.swing.JLabel transaction;
    // End of variables declaration//GEN-END:variables
}
