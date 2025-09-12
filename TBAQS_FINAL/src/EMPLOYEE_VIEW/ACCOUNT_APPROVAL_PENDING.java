/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package EMPLOYEE_VIEW;

import CLIENT_VIEW.QUE_NUM;
import CLIENT_VIEW.QUE_NUM_CONSTRUCTOR;
import static EMPLOYEE_VIEW.EMPLOYEE_QUE_MANAGE.styleTable;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author reyes
 */
public class ACCOUNT_APPROVAL_PENDING extends javax.swing.JPanel {

    private CLIENT_VIEW.Frame frame;
    public ACCOUNT_APPROVAL_PENDING(CLIENT_VIEW.Frame frame) {
        initComponents();
        update();
        this.frame = frame;
    }
    
    public void update(){
        new javax.swing.Timer(0000, e -> {
        //load ques from database
        pending_users(PENDING);
        }).start();
        
    }

    public void pending_users(JTable pending) {
    // Define the table model
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Username");
    model.addColumn("Age");
    model.addColumn("Birthday");
    model.addColumn("Password");
    model.addColumn("MobileNum");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tbaqs", "root", "")) {

            String sql = "SELECT Username, Age, Birthday, Password, MobileNum FROM pending_users";
            try (java.sql.PreparedStatement ps = con.prepareStatement(sql);
                 java.sql.ResultSet rs = ps.executeQuery()) {

                // Loop through each row from DB and add to JTable
                while (rs.next()) {
                    String username = rs.getString("Username");
                    int age = rs.getInt("Age");
                    String birthday = rs.getString("Birthday");
                    String password = rs.getString("Password");
                    String mobileNum = rs.getString("MobileNum");

                    model.addRow(new Object[]{username, age, birthday, password, mobileNum});
                }
            }
        }

        // Set the model to the table
        pending.setModel(model);

        // Center-align all cells
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        centerRenderer.setVerticalAlignment(JLabel.CENTER);
        for (int i = 0; i < pending.getColumnCount(); i++) {
            pending.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error loading pending");
 }
    }
    
    
    public void insert_user(int row){
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/tbaqs", "root", "")) {
            
                String insertCompleted = "INSERT INTO new_registered_user (Username, Age, Birthday, Password, MobileNum) VALUES (?, ?, ?, ?, ?)";
                    try (java.sql.PreparedStatement psInsert = con.prepareStatement(insertCompleted)) {
                        psInsert.setString(1, PENDING.getValueAt(row, 0).toString()); //username
                        psInsert.setString(2, PENDING.getValueAt(row, 1).toString()); //age
                        psInsert.setString(3, PENDING.getValueAt(row, 2).toString()); //birthday
                        psInsert.setString(4, PENDING.getValueAt(row, 3).toString()); //password
                        psInsert.setString(5, PENDING.getValueAt(row, 4).toString()); //mobilenum
                        psInsert.executeUpdate();
                    }
                    
                    String deleteSql = "DELETE FROM pending_users WHERE Username = ?";
                    try (java.sql.PreparedStatement psDelete = con.prepareStatement(deleteSql)) {
                        psDelete.setString(1, PENDING.getValueAt(row, 0).toString());
                        psDelete.executeUpdate();
                    }
            }
            
        } catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ER = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PENDING = new javax.swing.JTable();
        BACK = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setLayout(null);

        ER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/fillers.png"))); // NOI18N
        ER.setBorderPainted(false);
        ER.setContentAreaFilled(false);
        ER.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        ER.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        ER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ERActionPerformed(evt);
            }
        });
        add(ER);
        ER.setBounds(0, 365, 352, 90);

        PENDING.setModel(new javax.swing.table.DefaultTableModel(
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
        PENDING.setRowHeight(30);
        PENDING.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PENDINGMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(PENDING);

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

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/ACCOUNT_APP_PENDING.gif"))); // NOI18N
        add(background);
        background.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void ERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ERActionPerformed
        frame.setContentPane(new EMPLOYEE_REGISTERED(frame));
        frame.revalidate();
    }//GEN-LAST:event_ERActionPerformed

    private void PENDINGMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PENDINGMousePressed
        int x = PENDING.getSelectedRow();
        
        if (x != -1){
            String user = PENDING.getValueAt(x, 0).toString();
            String password = PENDING.getValueAt(x,3).toString();
            JOptionPane.showMessageDialog(null,"USER : " + user + " " + "PASSWORD : " + password);
            insert_user(x);
            
        } 
    }//GEN-LAST:event_PENDINGMousePressed

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        frame.setContentPane(new EMPLOYEE_DASH(frame));
        frame.revalidate();
    }//GEN-LAST:event_BACKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BACK;
    private javax.swing.JButton ER;
    private javax.swing.JTable PENDING;
    private javax.swing.JLabel background;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
