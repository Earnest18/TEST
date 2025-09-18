/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Main;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author reyes
 */
public class Que_Screen extends javax.swing.JPanel {

    private Que_Frame frame;
    public Que_Screen(Que_Frame frame) {
        initComponents();
        this.frame = frame;
        
        //update();
        
        
    }
    
    /* WAG GALAWIN
    
    public void update(){
        new javax.swing.Timer(1000, e -> {
            loadQueueNumbers(Counter1);
            counter_1.setText(Constructors.next_in_que.queueNumber);
            
            updateTransaction(Counter1, "W", "Withdraw");
            updateTransaction(Counter2, "L", "Loan");
            updateTransaction(Counter3, "D", "Deposit");
            updateTransaction(Counter4, "I", "Inquiry");
            
        }).start();
    }

   public static void updateTransaction(JTable table, String prefix, String transactionName) {
    ArrayList<String> values = new ArrayList<>();

    try {
        // DB connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection con = java.sql.DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/banking_sino_ka_man", "root", "");

        String sql = "SELECT Que_Num FROM informations WHERE Que_Num LIKE ?";
        java.sql.PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, prefix + "%");

        java.sql.ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            values.add(rs.getString("Que_Num"));
        }

        rs.close();
        pst.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    // Column headers: Transaction, 1, 2, 3...
    String[] cols = new String[values.size() + 1];
    cols[0] = "Transaction";
    for (int i = 1; i <= values.size(); i++) {
        cols[i] = String.valueOf(i);
    }

    String[][] data = new String[1][values.size() + 1];
    data[0][0] = transactionName;
    for (int j = 0; j < values.size(); j++) {
        data[0][j + 1] = values.get(j);
    }

    DefaultTableModel model = new DefaultTableModel(data, cols);
    table.setModel(model);

    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);

    for (int i = 0; i < table.getColumnCount(); i++) {
        table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }

    ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
            .setHorizontalAlignment(JLabel.CENTER);
}
   
    public void loadQueueNumbers(JTable table) {
    try (java.sql.Connection con = java.sql.DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/Banking_sino_ka_man", "root", "")) {
        
        String sql = "SELECT Que_num FROM informations";
        java.sql.PreparedStatement pst = con.prepareStatement(sql);

        java.sql.ResultSet rs = pst.executeQuery();

        // 2. Create table model with one column
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        model.addColumn("Queue Number");

        // 3. Add rows from result
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("Que_num")
            });
        }

        table.setModel(model);

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}


   */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        counter_1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Counter2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        Counter3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        Counter4 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        Counter1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        counter_1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        counter_1.setForeground(java.awt.Color.black);
        counter_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(counter_1);
        counter_1.setBounds(90, 180, 180, 90);

        jScrollPane2.setAlignmentX(10.0F);

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
        Counter2.setRowHeight(74);
        jScrollPane2.setViewportView(Counter2);

        add(jScrollPane2);
        jScrollPane2.setBounds(420, 240, 840, 110);

        jScrollPane3.setAlignmentX(10.0F);

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
        Counter3.setRowHeight(74);
        jScrollPane3.setViewportView(Counter3);

        add(jScrollPane3);
        jScrollPane3.setBounds(420, 360, 840, 110);

        jScrollPane4.setAlignmentX(10.0F);

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
        Counter4.setRowHeight(74);
        jScrollPane4.setViewportView(Counter4);

        add(jScrollPane4);
        jScrollPane4.setBounds(420, 480, 840, 110);

        jScrollPane1.setAlignmentX(10.0F);

        Counter1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Counter1.setRowHeight(74);
        jScrollPane1.setViewportView(Counter1);

        add(jScrollPane1);
        jScrollPane1.setBounds(420, 120, 840, 110);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/Que_Screen(Public).gif"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Counter1;
    private javax.swing.JTable Counter2;
    private javax.swing.JTable Counter3;
    private javax.swing.JTable Counter4;
    private javax.swing.JLabel counter_1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
