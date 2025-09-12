/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package EMPLOYEE_VIEW;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author reyes
 */
public class EMPLOYEE_HISTORY_COMPLETED extends javax.swing.JPanel {

    private CLIENT_VIEW.Frame frame;
    public EMPLOYEE_HISTORY_COMPLETED(CLIENT_VIEW.Frame frame) {
        initComponents();
        update();
        this.frame = frame;
    }

    public void update(){
        
        new javax.swing.Timer(0000, e -> {
            TABLE(COMPLETED);
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

            String sql = "SELECT Username, Age, MobileNum, Que_Num, Transaction_Type FROM completed ORDER BY id ASC";
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

        HISTORY_CANCELLED = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        COMPLETED = new javax.swing.JTable();
        BACK = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setLayout(null);

        HISTORY_CANCELLED.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/fillers.png"))); // NOI18N
        HISTORY_CANCELLED.setBorderPainted(false);
        HISTORY_CANCELLED.setContentAreaFilled(false);
        HISTORY_CANCELLED.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        HISTORY_CANCELLED.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        HISTORY_CANCELLED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HISTORY_CANCELLEDActionPerformed(evt);
            }
        });
        add(HISTORY_CANCELLED);
        HISTORY_CANCELLED.setBounds(0, 365, 352, 90);

        COMPLETED.setModel(new javax.swing.table.DefaultTableModel(
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
        COMPLETED.setRowHeight(30);
        jScrollPane1.setViewportView(COMPLETED);

        add(jScrollPane1);
        jScrollPane1.setBounds(356, 160, 945, 480);

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

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/EMPLOYEE_HISTORY_COMPLETED.gif"))); // NOI18N
        add(background);
        background.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void HISTORY_CANCELLEDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HISTORY_CANCELLEDActionPerformed
        frame.setContentPane(new EMPLOYEE_HISTORY_CANCELLED(frame));
        frame.revalidate();
    }//GEN-LAST:event_HISTORY_CANCELLEDActionPerformed

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        frame.setContentPane(new EMPLOYEE_DASH(frame));
        frame.revalidate();
    }//GEN-LAST:event_BACKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BACK;
    private javax.swing.JTable COMPLETED;
    private javax.swing.JButton HISTORY_CANCELLED;
    private javax.swing.JLabel background;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
