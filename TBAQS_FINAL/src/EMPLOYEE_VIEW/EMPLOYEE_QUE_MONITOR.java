/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package EMPLOYEE_VIEW;

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
public class EMPLOYEE_QUE_MONITOR extends javax.swing.JPanel {
    public int hoveredRow = -1;;
    private CLIENT_VIEW.Frame frame;
    public EMPLOYEE_QUE_MONITOR(CLIENT_VIEW.Frame frame) {
        initComponents();
        update();
        tablehovered(PENDING);
        tablehovered(ON_HOLD);
        tablehovered(COMPLETED);
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
    
    public void tablehovered(JTable table){
// Set custom renderer to apply hover effect
table.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
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

        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ON_HOLD = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        COMPLETED = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        PENDING = new javax.swing.JTable();
        BACK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/fillers.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(0, 273, 352, 90);

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
        ON_HOLD.setRowHeight(40);
        ON_HOLD.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ON_HOLDMouseMoved(evt);
            }
        });
        ON_HOLD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ON_HOLDMouseExited(evt);
            }
        });
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
        COMPLETED.setRowHeight(40);
        COMPLETED.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                COMPLETEDMouseMoved(evt);
            }
        });
        COMPLETED.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                COMPLETEDMouseExited(evt);
            }
        });
        jScrollPane3.setViewportView(COMPLETED);

        add(jScrollPane3);
        jScrollPane3.setBounds(983, 282, 233, 328);

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
        PENDING.setRowHeight(40);
        PENDING.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PENDINGMouseMoved(evt);
            }
        });
        PENDING.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PENDINGMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(PENDING);

        add(jScrollPane1);
        jScrollPane1.setBounds(426, 282, 232, 330);

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/emp_monitoring.gif"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frame.setContentPane(new EMPLOYEE_QUE_MANAGE(frame));
        frame.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        frame.setContentPane(new EMPLOYEE_DASH(frame));
        frame.revalidate();
    }//GEN-LAST:event_BACKActionPerformed

    private void PENDINGMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PENDINGMouseExited
        // TODO add your handling code here:
         // Reset hovered row when mouse leaves the table
        hoveredRow = -1;
        PENDING.repaint(); // repaint table to remove hover color
        
    }//GEN-LAST:event_PENDINGMouseExited

    private void PENDINGMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PENDINGMouseMoved

        int row = PENDING .rowAtPoint(evt.getPoint());
                if (row != hoveredRow) {
                    hoveredRow = row;
                    PENDING.repaint(); // update hover
                }

    }//GEN-LAST:event_PENDINGMouseMoved

    private void ON_HOLDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ON_HOLDMouseExited
        // Reset hovered row when mouse leaves the table
        hoveredRow = -1;
        ON_HOLD.repaint(); // repaint table to remove hover color
    }//GEN-LAST:event_ON_HOLDMouseExited

    private void ON_HOLDMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ON_HOLDMouseMoved
       int row = ON_HOLD .rowAtPoint(evt.getPoint());
                if (row != hoveredRow) {
                    hoveredRow = row;
                    ON_HOLD.repaint(); // update hover
                }
    }//GEN-LAST:event_ON_HOLDMouseMoved

    private void COMPLETEDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_COMPLETEDMouseExited
        hoveredRow = -1;
        COMPLETED.repaint(); // repaint table to remove hover color
        
    }//GEN-LAST:event_COMPLETEDMouseExited

    private void COMPLETEDMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_COMPLETEDMouseMoved
          int row = COMPLETED .rowAtPoint(evt.getPoint());
                if (row != hoveredRow) {
                    hoveredRow = row;
                    COMPLETED.repaint(); // update hover
                }
    }//GEN-LAST:event_COMPLETEDMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BACK;
    private javax.swing.JTable COMPLETED;
    private javax.swing.JTable ON_HOLD;
    private javax.swing.JTable PENDING;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
