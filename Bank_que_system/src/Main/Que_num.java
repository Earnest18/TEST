/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Main;

import static Main.Withdraw_form.quenum;
import java.sql.DriverManager;

/**
 *
 * @author reyes
 */
public class Que_num extends javax.swing.JPanel {

    private Frame frame;
    public Que_num(Frame frame) {
        initComponents();
        this.frame = frame;
        //getquenum();
    }
    
    /* WAG GALAWIN!
    
    public void getquenum() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Banking_sino_ka_man", "root", ""
        );

        String sql = "SELECT MAX(Que_num) FROM informations";
        java.sql.Statement stmt = con.createStatement();
        java.sql.ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            String lastTicket = rs.getString(1); 
            if (lastTicket != null) {
                quenum = Integer.parseInt(lastTicket);
                QUE_NO.setText(String.valueOf(quenum));
            } else {
                quenum = 1;
            }
        } else {
            quenum = 1;
        }

        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        QUE_NO = new javax.swing.JLabel();
        COUNTER = new javax.swing.JLabel();
        TYPE = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(1120, 550, 180, 70);

        QUE_NO.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        QUE_NO.setForeground(java.awt.Color.black);
        QUE_NO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(QUE_NO);
        QUE_NO.setBounds(180, 340, 320, 60);

        COUNTER.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        COUNTER.setForeground(java.awt.Color.black);
        COUNTER.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(COUNTER);
        COUNTER.setBounds(390, 500, 230, 60);

        TYPE.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        TYPE.setForeground(java.awt.Color.black);
        TYPE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TYPE.setText("WITHDRAW");
        add(TYPE);
        TYPE.setBounds(60, 500, 230, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/que_num.gif"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       frame.setContentPane(new public_dash(frame));
       frame.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel COUNTER;
    public static javax.swing.JLabel QUE_NO;
    public static javax.swing.JLabel TYPE;
    private javax.swing.JButton jButton1;
    public static javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
