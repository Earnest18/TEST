package Main;


import Main.Frame;
import Main.public_dash;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

public class Ads extends javax.swing.JPanel {

    private Frame frame;
    public Ads(Frame frame) {
        initComponents();
        this.frame = frame;
       
        
    }

    

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ads_img = new javax.swing.JButton();

        setBackground(java.awt.Color.black);
        setLayout(null);

        ads_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/ADS.png"))); // NOI18N
        ads_img.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ads_imgActionPerformed(evt);
            }
        });
        add(ads_img);
        ads_img.setBounds(0, -10, 1300, 710);
    }// </editor-fold>//GEN-END:initComponents

    private void ads_imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ads_imgActionPerformed
        
        frame.setContentPane(new public_dash(frame));
        frame.revalidate();
        
    }//GEN-LAST:event_ads_imgActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ads_img;
    // End of variables declaration//GEN-END:variables
}

