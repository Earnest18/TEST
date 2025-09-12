/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package CLIENT_VIEW;

import java.awt.Color;
import java.awt.Container;
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
public class PUBLIC_QUE extends javax.swing.JPanel {

    private CLIENT_VIEW.PUBLIC_Q_FRAME frame;
    public PUBLIC_QUE(CLIENT_VIEW.PUBLIC_Q_FRAME frame) {
        initComponents();
        update();
        
        loadQueueNumbers(WITHDRAW, "Withdraw");
        loadQueueNumbers(DEPOSIT, "Deposit");
        loadQueueNumbers(LOAN, "Loan");
        loadQueueNumbers(INQUIRY, "Inquire");
            
        this.frame = frame;
       
    }
    
    public void update() {
    new javax.swing.Timer(1000, e -> { // update every 1 second
        if (EMPLOYEE_VIEW.EMPLOYEE_QUE_MANAGE.t != null) {
            WITHDRAW_OG.setText(EMPLOYEE_VIEW.EMPLOYEE_QUE_MANAGE.t.getWithdraw());
            DEPOSIT_OG.setText(EMPLOYEE_VIEW.EMPLOYEE_QUE_MANAGE.t.getDeposit());
            LOAN_OG.setText(EMPLOYEE_VIEW.EMPLOYEE_QUE_MANAGE.t.getLoan());
            INQUIRY_OG.setText(EMPLOYEE_VIEW.EMPLOYEE_QUE_MANAGE.t.getInquire());
            
            //styling and filling
            styleTable(WITHDRAW);
            styleTable(DEPOSIT);
            styleTable(LOAN);
            styleTable(INQUIRY);
            
            //quenumbers
            loadQueueNumbers(WITHDRAW, "Withdraw");
            loadQueueNumbers(DEPOSIT, "Deposit");
            loadQueueNumbers(LOAN, "Loan");
            loadQueueNumbers(INQUIRY, "Inquire");
        }
    }).start();
}
    
    public static void styleTable(JTable table) {
    // Transparent table & header
    table.setOpaque(false);
    table.setFillsViewportHeight(true);
    table.getTableHeader().setOpaque(false);
    table.getTableHeader().setBackground(new Color(0,0,0,0)); // fully transparent

    // Grid lines
    table.setShowHorizontalLines(true);
    table.setShowVerticalLines(false);
    table.setGridColor(Color.LIGHT_GRAY);

    // Center align and transparent cells
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    centerRenderer.setOpaque(false);

    // Apply to all columns AFTER model is set
    for (int i = 0; i < table.getColumnCount(); i++) {
        table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }

    // Scroll pane transparency
    Container parent = table.getParent();
    if (parent instanceof JViewport) {
        JViewport viewport = (JViewport) parent;
        viewport.setOpaque(false);
        if (viewport.getParent() instanceof JScrollPane) {
            JScrollPane scrollPane = (JScrollPane) viewport.getParent();
            scrollPane.setOpaque(false);
            scrollPane.setBorder(null);

            scrollPane.getVerticalScrollBar().setOpaque(false);
            scrollPane.getHorizontalScrollBar().setOpaque(false);

            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        }
    }
}
    
// Load all queue numbers for a specific transaction type into a JTable
public void loadQueueNumbers(JTable table, String transactionType) {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Queue Number");

    try {
        // 1. Load Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Connect to DB
        java.sql.Connection con = java.sql.DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/tbaqs", "root", ""
        );

        // 3. SQL query (make sure your column names are correct!)
        String sql = "SELECT QueNum FROM quenum WHERE Transaction_Type = ? ORDER BY id ASC";
        java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, transactionType);

        // 4. Execute query
        java.sql.ResultSet rs = pstmt.executeQuery();

        // 5. Fill JTable
        while (rs.next()) {
            model.addRow(new Object[]{rs.getString("QueNum")});
        }
        table.setModel(model);

        // 6. Close resources
        rs.close();
        pstmt.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DEPOSIT_OG = new javax.swing.JLabel();
        LOAN_OG = new javax.swing.JLabel();
        INQUIRY_OG = new javax.swing.JLabel();
        WITHDRAW_OG = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        INQUIRY = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        DEPOSIT = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        LOAN = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        WITHDRAW = new javax.swing.JTable();
        background = new javax.swing.JLabel();

        setLayout(null);

        DEPOSIT_OG.setFont(new java.awt.Font("Segoe UI", 1, 65)); // NOI18N
        DEPOSIT_OG.setForeground(java.awt.Color.black);
        DEPOSIT_OG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(DEPOSIT_OG);
        DEPOSIT_OG.setBounds(880, 130, 250, 180);

        LOAN_OG.setFont(new java.awt.Font("Segoe UI", 1, 65)); // NOI18N
        LOAN_OG.setForeground(java.awt.Color.black);
        LOAN_OG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(LOAN_OG);
        LOAN_OG.setBounds(440, 450, 250, 180);

        INQUIRY_OG.setFont(new java.awt.Font("Segoe UI", 1, 65)); // NOI18N
        INQUIRY_OG.setForeground(java.awt.Color.black);
        INQUIRY_OG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(INQUIRY_OG);
        INQUIRY_OG.setBounds(880, 450, 250, 180);

        WITHDRAW_OG.setFont(new java.awt.Font("Segoe UI", 1, 65)); // NOI18N
        WITHDRAW_OG.setForeground(java.awt.Color.black);
        WITHDRAW_OG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(WITHDRAW_OG);
        WITHDRAW_OG.setBounds(440, 130, 250, 180);

        INQUIRY.setBackground(java.awt.Color.white);
        INQUIRY.setModel(new javax.swing.table.DefaultTableModel(
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
        INQUIRY.setRowHeight(30);
        jScrollPane4.setViewportView(INQUIRY);

        add(jScrollPane4);
        jScrollPane4.setBounds(1140, 420, 160, 220);

        DEPOSIT.setBackground(java.awt.Color.white);
        DEPOSIT.setModel(new javax.swing.table.DefaultTableModel(
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
        DEPOSIT.setRowHeight(30);
        jScrollPane3.setViewportView(DEPOSIT);

        add(jScrollPane3);
        jScrollPane3.setBounds(1140, 100, 160, 220);

        LOAN.setBackground(java.awt.Color.white);
        LOAN.setModel(new javax.swing.table.DefaultTableModel(
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
        LOAN.setRowHeight(30);
        jScrollPane2.setViewportView(LOAN);

        add(jScrollPane2);
        jScrollPane2.setBounds(700, 420, 170, 220);

        WITHDRAW.setBackground(java.awt.Color.white);
        WITHDRAW.setModel(new javax.swing.table.DefaultTableModel(
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
        WITHDRAW.setRowHeight(30);
        jScrollPane1.setViewportView(WITHDRAW);

        add(jScrollPane1);
        jScrollPane1.setBounds(700, 100, 170, 220);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/PUBLIC_QUE.gif"))); // NOI18N
        background.setText("jLabel1");
        add(background);
        background.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DEPOSIT;
    private javax.swing.JLabel DEPOSIT_OG;
    private javax.swing.JTable INQUIRY;
    private javax.swing.JLabel INQUIRY_OG;
    private javax.swing.JTable LOAN;
    private javax.swing.JLabel LOAN_OG;
    private javax.swing.JTable WITHDRAW;
    private javax.swing.JLabel WITHDRAW_OG;
    private javax.swing.JLabel background;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
