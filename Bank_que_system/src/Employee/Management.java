/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Employee;

import Constructors.next_in_que;
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
public class Management extends javax.swing.JPanel {
    private JTable Counter1;
    private Main.Frame frame;
    public String queNum;
    
    public Management(Main.Frame frame) {
        initComponents();
        
        this.frame = frame;
        //update();
    }
    
    /* WAG GALAWIN
    
    private static void saveToDatabase(String value) {
        java.sql.Connection con = null;
        java.sql.PreparedStatement pst = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to DB (change db name, user, password as needed)
            con = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/banking_sino_ka_man",
                    "root", "");

            String sql = "INSERT INTO complete_transaction (Que_Num) VALUES (?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, value);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Value saved: " + value);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
}
    
    
    public void skip(){
        String currentQueue = counter_1.getText();  
        
    if (currentQueue != null && !currentQueue.isEmpty()) {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = java.sql.DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/banking_sino_ka_man", "root", ""
            );

            String sql = "INSERT INTO skipped (Que_Num) VALUES (?)";
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, currentQueue);
            pst.executeUpdate();

            System.out.print("User" + currentQueue + "skipped!");
            
            counter_1.setText("");

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, 
                "Error: " + ex.getMessage());
        }
    }
}
    
    public void update(){
        new javax.swing.Timer(0000, e -> {
        //load ques from database
        loadQueue(Counter5, "W");
        loadQueue(Counter2, "L");
        loadQueue(Counter3, "D");
        loadQueue(Counter4, "I");
        
        //make table transparent
        styleTable(Counter5);
        styleTable(Counter2);
        styleTable(Counter3);
        styleTable(Counter4);
        new next_in_que(counter_1);
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

   public void loadQueue(JTable table, String prefix) {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Queue Number"}, 0);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/banking_sino_ka_man", "root", "");

            String sql = "SELECT Que_Num FROM informations WHERE Que_Num LIKE ?";
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, prefix + "%"); 

            java.sql.ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String queueNum = rs.getString("Que_Num");
                model.addRow(new Object[]{queueNum});
            }

            table.setModel(model);

            rs.close();
            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }


   public void serveNextClient() {
    DefaultTableModel model = (DefaultTableModel) Counter5.getModel();

    if (model.getRowCount() > 0) {
        String queNum = model.getValueAt(0, 0).toString(); 

        counter_1.setText( queNum);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = java.sql.DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/banking_sino_ka_man", "root", ""
            );

            String sql = "DELETE FROM informations WHERE Que_Num = ?";
            java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, queNum);
            pstmt.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        loadQueue(Counter5, "W");

    } else {
        JOptionPane.showMessageDialog(this, "No more clients in queue.");
        counter_1.setText("None");
    }
}


*/
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        monitoring = new javax.swing.JButton();
        skip4 = new javax.swing.JButton();
        skip3 = new javax.swing.JButton();
        skip2 = new javax.swing.JButton();
        skip1 = new javax.swing.JButton();
        nxt_in_line3 = new javax.swing.JButton();
        nxt_in_line2 = new javax.swing.JButton();
        nxt_in_line1 = new javax.swing.JButton();
        nxt_in_line = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        Counter5 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Counter2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        Counter3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        Counter4 = new javax.swing.JTable();
        counter_1 = new javax.swing.JLabel();
        counter_2 = new javax.swing.JLabel();
        counter_3 = new javax.swing.JLabel();
        counter_4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        monitoring.setBorderPainted(false);
        monitoring.setContentAreaFilled(false);
        monitoring.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monitoringActionPerformed(evt);
            }
        });
        add(monitoring);
        monitoring.setBounds(0, 330, 330, 90);

        skip4.setBackground(new java.awt.Color(171, 4, 4));
        skip4.setText("SKIP");
        skip4.setBorder(null);
        skip4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skip4ActionPerformed(evt);
            }
        });
        add(skip4);
        skip4.setBounds(1040, 578, 208, 41);

        skip3.setBackground(new java.awt.Color(171, 4, 4));
        skip3.setText("SKIP");
        skip3.setBorder(null);
        skip3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skip3ActionPerformed(evt);
            }
        });
        add(skip3);
        skip3.setBounds(824, 578, 208, 41);

        skip2.setBackground(new java.awt.Color(171, 4, 4));
        skip2.setText("SKIP");
        skip2.setBorder(null);
        skip2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skip2ActionPerformed(evt);
            }
        });
        add(skip2);
        skip2.setBounds(603, 578, 208, 41);

        skip1.setBackground(new java.awt.Color(171, 4, 4));
        skip1.setText("SKIP");
        skip1.setBorder(null);
        skip1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skip1ActionPerformed(evt);
            }
        });
        add(skip1);
        skip1.setBounds(383, 578, 208, 41);

        nxt_in_line3.setBackground(new java.awt.Color(33, 109, 6));
        nxt_in_line3.setText("NEXT");
        nxt_in_line3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nxt_in_line3ActionPerformed(evt);
            }
        });
        add(nxt_in_line3);
        nxt_in_line3.setBounds(1042, 528, 206, 41);

        nxt_in_line2.setBackground(new java.awt.Color(33, 109, 6));
        nxt_in_line2.setText("NEXT");
        nxt_in_line2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nxt_in_line2ActionPerformed(evt);
            }
        });
        add(nxt_in_line2);
        nxt_in_line2.setBounds(823, 528, 203, 41);

        nxt_in_line1.setBackground(new java.awt.Color(33, 109, 6));
        nxt_in_line1.setText("NEXT");
        nxt_in_line1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nxt_in_line1ActionPerformed(evt);
            }
        });
        add(nxt_in_line1);
        nxt_in_line1.setBounds(604, 528, 205, 41);

        nxt_in_line.setBackground(new java.awt.Color(33, 109, 6));
        nxt_in_line.setText("NEXT");
        nxt_in_line.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nxt_in_lineActionPerformed(evt);
            }
        });
        add(nxt_in_line);
        nxt_in_line.setBounds(383, 528, 208, 41);

        back_btn.setBorderPainted(false);
        back_btn.setContentAreaFilled(false);
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        add(back_btn);
        back_btn.setBounds(0, 540, 330, 100);

        Counter5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Counter5.setRowHeight(40);
        jScrollPane5.setViewportView(Counter5);

        add(jScrollPane5);
        jScrollPane5.setBounds(384, 370, 206, 150);

        Counter2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Counter2.setRowHeight(40);
        jScrollPane2.setViewportView(Counter2);

        add(jScrollPane2);
        jScrollPane2.setBounds(604, 370, 204, 150);

        Counter3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Counter3.setRowHeight(40);
        jScrollPane3.setViewportView(Counter3);

        add(jScrollPane3);
        jScrollPane3.setBounds(824, 370, 204, 150);

        Counter4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Counter4.setRowHeight(40);
        jScrollPane4.setViewportView(Counter4);

        add(jScrollPane4);
        jScrollPane4.setBounds(1043, 370, 205, 150);

        counter_1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        counter_1.setForeground(java.awt.Color.black);
        counter_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(counter_1);
        counter_1.setBounds(440, 280, 100, 30);

        counter_2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        counter_2.setForeground(java.awt.Color.black);
        counter_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(counter_2);
        counter_2.setBounds(660, 280, 100, 30);

        counter_3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        counter_3.setForeground(java.awt.Color.black);
        counter_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(counter_3);
        counter_3.setBounds(880, 280, 100, 30);

        counter_4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        counter_4.setForeground(java.awt.Color.black);
        counter_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(counter_4);
        counter_4.setBounds(1100, 280, 100, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/que_screen.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        frame.setContentPane(new E_Dashboard(frame));
        frame.revalidate();
    }//GEN-LAST:event_back_btnActionPerformed

    private void nxt_in_lineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nxt_in_lineActionPerformed
        if (counter_1.getText() == null || counter_1.getText().trim().isEmpty()) {
            System.out.println("No current customer");
            //serveNextClient(); - helps to save sa database (wag tanggalin)
            } else {
            //saveToDatabase(counter_1.getText()); - wag tanggalin
            counter_1.setText(null);
        }
    }//GEN-LAST:event_nxt_in_lineActionPerformed

    private void nxt_in_line1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nxt_in_line1ActionPerformed
        
       
    }//GEN-LAST:event_nxt_in_line1ActionPerformed

    private void nxt_in_line2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nxt_in_line2ActionPerformed
       
    }//GEN-LAST:event_nxt_in_line2ActionPerformed

    private void nxt_in_line3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nxt_in_line3ActionPerformed
        
    }//GEN-LAST:event_nxt_in_line3ActionPerformed

    private void skip1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skip1ActionPerformed
       // skip(); - wag galawin
    }//GEN-LAST:event_skip1ActionPerformed

    private void skip2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skip2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skip2ActionPerformed

    private void skip3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skip3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skip3ActionPerformed

    private void skip4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skip4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_skip4ActionPerformed

    private void monitoringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monitoringActionPerformed
        frame.setContentPane(new Monitoring(frame));
        frame.revalidate();
    }//GEN-LAST:event_monitoringActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Counter2;
    private javax.swing.JTable Counter3;
    private javax.swing.JTable Counter4;
    private javax.swing.JTable Counter5;
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel counter_1;
    private javax.swing.JLabel counter_2;
    private javax.swing.JLabel counter_3;
    private javax.swing.JLabel counter_4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton monitoring;
    private javax.swing.JButton nxt_in_line;
    private javax.swing.JButton nxt_in_line1;
    private javax.swing.JButton nxt_in_line2;
    private javax.swing.JButton nxt_in_line3;
    private javax.swing.JButton skip1;
    private javax.swing.JButton skip2;
    private javax.swing.JButton skip3;
    private javax.swing.JButton skip4;
    // End of variables declaration//GEN-END:variables
}
