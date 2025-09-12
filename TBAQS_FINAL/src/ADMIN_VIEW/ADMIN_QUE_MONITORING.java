/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ADMIN_VIEW;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author reyes
 */
public class ADMIN_QUE_MONITORING extends javax.swing.JPanel {

    private CLIENT_VIEW.Frame frame;
    public ADMIN_QUE_MONITORING(CLIENT_VIEW.Frame frame) {
        initComponents();
        update();
        this.frame = frame;
    }
    
    public void update(){
        new javax.swing.Timer(0000, e -> {
        //update tables
        styleTable(PENDING);
        styleTable(ON_HOLD);
        styleTable(COMPLETED);
        Update_Table(PENDING, ON_HOLD, COMPLETED);
        }).start();
    }
    
    public static void styleTable(JTable table) {
        // Transparent table
        table.setOpaque(false);
        table.getTableHeader().setOpaque(false);

        // ✅ Show only horizontal lines (row separators)
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(false);
        table.setGridColor(Color.LIGHT_GRAY); // line color (customize as needed)

        // Center align cell contents
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        centerRenderer.setOpaque(false); // keep transparency

        // Apply to all columns
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // ✅ If the table is inside a JScrollPane, remove scrollbars
        if (table.getParent() instanceof JViewport) {
            JViewport viewport = (JViewport) table.getParent();
            if (viewport.getParent() instanceof JScrollPane) {
                JScrollPane scrollPane = (JScrollPane) viewport.getParent();
                scrollPane.setOpaque(false);
                scrollPane.getViewport().setOpaque(false);
                scrollPane.setBorder(null);

                scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
                scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            }
        }
    }
    
    public void Update_Table(JTable pending, JTable On_hold, JTable Completed) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (java.sql.Connection con = java.sql.DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tbaqs", "root", "")) {

            // 1️⃣ Pending Table
            DefaultTableModel pendingModel = new DefaultTableModel();
            pendingModel.addColumn("Que_Num");
            pendingModel.addColumn("Name");
            pendingModel.addColumn("Type");

            String sqlPending = "SELECT QueNum, Username, Transaction_Type FROM quenum ORDER BY id ASC";
            try (java.sql.PreparedStatement ps = con.prepareStatement(sqlPending);
                 java.sql.ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    pendingModel.addRow(new Object[]{
                            rs.getString("QueNum"),
                            rs.getString("Username"),
                            rs.getString("Transaction_Type")
                    });
                }
            }

            pending.setModel(pendingModel);

            // 2️⃣ On_Hold Table
            DefaultTableModel onHoldModel = new DefaultTableModel();
            onHoldModel.addColumn("Que_Num");
            onHoldModel.addColumn("Name");
            onHoldModel.addColumn("Type");

            String sqlOnHold = "SELECT Que_Num, Username, Transaction_Type FROM onhold ORDER BY id ASC";
            try (java.sql.PreparedStatement ps = con.prepareStatement(sqlOnHold);
                 java.sql.ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    onHoldModel.addRow(new Object[]{
                            rs.getString("Que_Num"),
                            rs.getString("Username"),
                            rs.getString("Transaction_Type")
                    });
                }
            }

            On_hold.setModel(onHoldModel);

            // 3️⃣ Completed Table
            DefaultTableModel completedModel = new DefaultTableModel();
            completedModel.addColumn("Que_Num");
            completedModel.addColumn("Name");
            completedModel.addColumn("Type");

            String sqlCompleted = "SELECT Que_Num, Username, Transaction_Type FROM completed ORDER BY id ASC";
            try (java.sql.PreparedStatement ps = con.prepareStatement(sqlCompleted);
                 java.sql.ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    completedModel.addRow(new Object[]{
                            rs.getString("Que_Num"),
                            rs.getString("Username"),
                            rs.getString("Transaction_Type")
                    });
                }
            }

            Completed.setModel(completedModel);

        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error loading tables: " + e.getMessage());
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MANAGEMENT = new javax.swing.JButton();
        BACK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PENDING = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        ON_HOLD = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        COMPLETED = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        MANAGEMENT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/fillers.png"))); // NOI18N
        MANAGEMENT.setBorderPainted(false);
        MANAGEMENT.setContentAreaFilled(false);
        MANAGEMENT.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        MANAGEMENT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        MANAGEMENT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MANAGEMENTActionPerformed(evt);
            }
        });
        add(MANAGEMENT);
        MANAGEMENT.setBounds(0, 273, 352, 90);

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

        PENDING.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        PENDING.setRowHeight(30);
        jScrollPane1.setViewportView(PENDING);

        add(jScrollPane1);
        jScrollPane1.setBounds(426, 282, 232, 330);

        ON_HOLD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        ON_HOLD.setRowHeight(30);
        jScrollPane2.setViewportView(ON_HOLD);

        add(jScrollPane2);
        jScrollPane2.setBounds(705, 282, 232, 328);

        COMPLETED.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        COMPLETED.setRowHeight(30);
        jScrollPane3.setViewportView(COMPLETED);

        add(jScrollPane3);
        jScrollPane3.setBounds(983, 282, 233, 328);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/okeh.gif"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void MANAGEMENTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MANAGEMENTActionPerformed
        frame.setContentPane(new ADMIN_QUE_MANAGEMENT(frame));
        frame.revalidate();
    }//GEN-LAST:event_MANAGEMENTActionPerformed

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        frame.setContentPane(new ADMIN_DASH(frame));
        frame.revalidate();
    }//GEN-LAST:event_BACKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BACK;
    private javax.swing.JTable COMPLETED;
    private javax.swing.JButton MANAGEMENT;
    private javax.swing.JTable ON_HOLD;
    private javax.swing.JTable PENDING;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
