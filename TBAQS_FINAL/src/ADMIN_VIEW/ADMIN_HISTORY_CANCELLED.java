/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ADMIN_VIEW;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author reyes
 */
public class ADMIN_HISTORY_CANCELLED extends javax.swing.JPanel {

    private CLIENT_VIEW.Frame frame;
    public ADMIN_HISTORY_CANCELLED(CLIENT_VIEW.Frame frame) {
        initComponents();
        update();
        this.frame = frame;
    }
    
    public void update(){
        
        new javax.swing.Timer(0000, e -> {
            TABLE(CANCELLED);
        }).start();
    }
   
public void TABLE(JTable cancelled) {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Username");
    model.addColumn("Age");
    model.addColumn("MobileNum");
    model.addColumn("Que Number");
    model.addColumn("Type");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (java.sql.Connection con = java.sql.DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tbaqs", "root", "")) {

            String sql = "SELECT Username, Age, MobileNum, Que_Num, Transaction_Type FROM cancelled ORDER BY id ASC";
            try (java.sql.PreparedStatement ps = con.prepareStatement(sql);
                 java.sql.ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    String username = rs.getString("Username");
                    int age = rs.getInt("Age");
                    String mobilenum = rs.getString("MobileNum");
                    String quenum = rs.getString("Que_Num");
                    String type = rs.getString("Transaction_Type");
                    String transactionType = rs.getString("Transaction_Type"); 

                    model.addRow(new Object[]{username,age, mobilenum, quenum, type, transactionType});
                }
            }
        }

        cancelled.setModel(model);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error loading onhold table: " + e.getMessage());
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BACK = new javax.swing.JButton();
        COMPLETED = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CANCELLED = new javax.swing.JTable();
        background = new javax.swing.JLabel();

        setLayout(null);

        BACK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/fillers.png"))); // NOI18N
        BACK.setBorderPainted(false);
        BACK.setContentAreaFilled(false);
        BACK.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/exitc.png"))); // NOI18N
        BACK.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/exitc.png"))); // NOI18N
        BACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BACKActionPerformed(evt);
            }
        });
        add(BACK);
        BACK.setBounds(0, 550, 352, 90);

        COMPLETED.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/fillers.png"))); // NOI18N
        COMPLETED.setBorderPainted(false);
        COMPLETED.setContentAreaFilled(false);
        COMPLETED.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        COMPLETED.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        COMPLETED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                COMPLETEDActionPerformed(evt);
            }
        });
        add(COMPLETED);
        COMPLETED.setBounds(0, 273, 352, 90);

        CANCELLED.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        CANCELLED.setRowHeight(30);
        jScrollPane1.setViewportView(CANCELLED);

        add(jScrollPane1);
        jScrollPane1.setBounds(356, 160, 945, 480);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/historyy.gif"))); // NOI18N
        add(background);
        background.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        frame.setContentPane(new ADMIN_DASH(frame));
        frame.revalidate();
    }//GEN-LAST:event_BACKActionPerformed

    private void COMPLETEDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_COMPLETEDActionPerformed
         frame.setContentPane(new ADMIN_HISTORY_COMPLETED(frame));
        frame.revalidate();
    }//GEN-LAST:event_COMPLETEDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BACK;
    private javax.swing.JTable CANCELLED;
    private javax.swing.JButton COMPLETED;
    private javax.swing.JLabel background;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
