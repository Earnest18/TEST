/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ADMIN_VIEW;

import java.sql.DriverManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author reyes
 */
public class ADMIN_RA_ACCHOLDERS extends javax.swing.JPanel {

    private CLIENT_VIEW.Frame frame;
    public ADMIN_RA_ACCHOLDERS(CLIENT_VIEW.Frame frame) {
        initComponents();
        update();
        this.frame = frame;
    }

    public void update(){
        new javax.swing.Timer(0000, e -> {
            //update table
            Registered_user(REGISTERED);
        }).start();
    }
    
    public void Registered_user(JTable pending) {
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

            String sql = "SELECT Username, Age, Birthday, Password, MobileNum FROM new_registered_user";
            try (java.sql.PreparedStatement ps = con.prepareStatement(sql);
                 java.sql.ResultSet rs = ps.executeQuery()) {

                // Loop through each row from DB and add to JTable
                while (rs.next()) {
                    String username = rs.getString("Username");
                    int age = rs.getInt("Age");
                    String birthday = rs.getString("Birthday");
                    String password = "*******";
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EMPLOYEES = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        REGISTERED = new javax.swing.JTable();
        BACK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        EMPLOYEES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/fillers.png"))); // NOI18N
        EMPLOYEES.setBorderPainted(false);
        EMPLOYEES.setContentAreaFilled(false);
        EMPLOYEES.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        EMPLOYEES.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        EMPLOYEES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EMPLOYEESActionPerformed(evt);
            }
        });
        add(EMPLOYEES);
        EMPLOYEES.setBounds(0, 270, 352, 90);

        REGISTERED.setModel(new javax.swing.table.DefaultTableModel(
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
        REGISTERED.setRowHeight(30);
        jScrollPane1.setViewportView(REGISTERED);

        add(jScrollPane1);
        jScrollPane1.setBounds(356, 160, 945, 480);

        BACK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/fillers.png"))); // NOI18N
        BACK.setBorderPainted(false);
        BACK.setContentAreaFilled(false);
        BACK.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        BACK.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        BACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BACKActionPerformed(evt);
            }
        });
        add(BACK);
        BACK.setBounds(0, 550, 352, 90);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/ADMIN_RA_AC.gif"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void EMPLOYEESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EMPLOYEESActionPerformed
        frame.setContentPane(new ADMIN_RA_EMPLOYEES(frame));
        frame.revalidate();
    }//GEN-LAST:event_EMPLOYEESActionPerformed

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        frame.setContentPane(new ADMIN_ACC_MANAGEMENT(frame));
        frame.revalidate();
    }//GEN-LAST:event_BACKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BACK;
    private javax.swing.JButton EMPLOYEES;
    private javax.swing.JTable REGISTERED;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
