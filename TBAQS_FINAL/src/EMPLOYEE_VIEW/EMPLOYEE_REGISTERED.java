/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package EMPLOYEE_VIEW;

import java.awt.Color;
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
public class EMPLOYEE_REGISTERED extends javax.swing.JPanel {
    public int hoveredRow = -1;
    private CLIENT_VIEW.Frame frame;
    public EMPLOYEE_REGISTERED(CLIENT_VIEW.Frame frame) {
        initComponents();
        update();
        tablehovered();
        this.frame = frame;
    }
    
    public void update(){
        new javax.swing.Timer(0000, e -> {
            //update table
            Registered_user(REGISTERED);
        }).start();
    }
    
    public void tablehovered(){
// Set custom renderer to apply hover effect
REGISTERED.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
    @Override
    public java.awt.Component getTableCellRendererComponent(JTable table, Object value,
                                                            boolean isSelected, boolean hasFocus,
                                                            int row, int column) {
        java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Highlight hovered row
        if (row == hoveredRow) {
            c.setBackground(new java.awt.Color(173, 216, 230)); // light blue
        } else {
            c.setBackground(Color.WHITE); // default
        }

        // Preserve selection colors
        if (isSelected) {
            c.setBackground(table.getSelectionBackground());
            c.setForeground(table.getSelectionForeground());
        } else {
            c.setForeground(Color.BLACK);
        }

        return c;
    }
});
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AAP = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        REGISTERED = new javax.swing.JTable();
        BACK = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setLayout(null);

        AAP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/fillers.png"))); // NOI18N
        AAP.setBorderPainted(false);
        AAP.setContentAreaFilled(false);
        AAP.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        AAP.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        AAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AAPActionPerformed(evt);
            }
        });
        add(AAP);
        AAP.setBounds(0, 275, 352, 90);

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
        REGISTERED.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                REGISTEREDMouseMoved(evt);
            }
        });
        REGISTERED.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                REGISTEREDMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(REGISTERED);

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

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/ACC_APP_REGISTERED.gif"))); // NOI18N
        add(background);
        background.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void AAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AAPActionPerformed
        frame.setContentPane(new ACCOUNT_APPROVAL_PENDING(frame));
        frame.revalidate();
    }//GEN-LAST:event_AAPActionPerformed

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        frame.setContentPane(new EMPLOYEE_DASH(frame));
        frame.revalidate();
    }//GEN-LAST:event_BACKActionPerformed

    private void REGISTEREDMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REGISTEREDMouseMoved
        //moved
       int row = REGISTERED.rowAtPoint(evt.getPoint());
        if (row != hoveredRow) {
            hoveredRow = row;
            REGISTERED.repaint(); // update hover
        }
    }//GEN-LAST:event_REGISTEREDMouseMoved

    private void REGISTEREDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REGISTEREDMouseExited
         // Reset hovered row when mouse leaves the table
        hoveredRow = -1;
        REGISTERED.repaint(); // repaint table to remove hover color
                                      
    }//GEN-LAST:event_REGISTEREDMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AAP;
    private javax.swing.JButton BACK;
    private javax.swing.JTable REGISTERED;
    private javax.swing.JLabel background;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
