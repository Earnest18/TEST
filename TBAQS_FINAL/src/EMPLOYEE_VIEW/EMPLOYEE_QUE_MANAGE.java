/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package EMPLOYEE_VIEW;

import CLIENT_VIEW.QUE_NUM_CONSTRUCTOR;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author reyes
 */
public class EMPLOYEE_QUE_MANAGE extends javax.swing.JPanel {
    public static TRANSACTIONS t;
    public int hoveredRow = -1;;
    private CLIENT_VIEW.Frame frame;
    public EMPLOYEE_QUE_MANAGE(CLIENT_VIEW.Frame frame) {
        initComponents();
        update();
        tablehovered();
        this.frame = frame;
        jPanel2.setVisible(false);
        jPanel1.setVisible(true);
    }
    
     public void update(){
         
        new javax.swing.Timer(0000, e -> {
        //load ques from database
        bridge();
        styleTable(T1);
        styleTable(T2);
        styleTable(T3);
        styleTable(T4);
        styleTable(ONHOLD);
        loadQueueNumbers(T1, "Withdraw");
        loadQueueNumbers(T2, "Deposit");
        loadQueueNumbers(T3, "Loan");
        loadQueueNumbers(T4, "Inquire");
        loadOnHoldTable(ONHOLD);
        
        bridge();
        }).start();
    }
     
     public void bridge() {
        ArrayList<String> values = new ArrayList<>();
        values.add(C1.getText()); // withdraw
        values.add(C2.getText()); // deposit
        values.add(C3.getText()); // loan
        values.add(C4.getText()); // inquire

        t = new TRANSACTIONS(values);
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
    
  // Load all queue numbers for a specific transaction type
public void loadQueueNumbers(JTable table, String transactionType) {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Que");
    model.addColumn("Name");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection con = java.sql.DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/tbaqs", "root", ""
        );

        // Adjusted column names to match quenum table
        String sql = "SELECT QueNum, Username FROM quenum WHERE Transaction_Type = ? ORDER BY id ASC";
        java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, transactionType);
        java.sql.ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            String queNum = rs.getString("QueNum");
            String username = rs.getString("Username");
            model.addRow(new Object[]{queNum, username});
        }

        table.setModel(model);
        pstmt.close();
        rs.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}

// Call next in queue, move to ongoing, remove from quenum
public void callNext(JTable table, JLabel lblCurrent, String transactionType) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (java.sql.Connection con = java.sql.DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tbaqs", "root", "")) {

            String currentQueNum = lblCurrent.getText();

            // 1️⃣ If lblCurrent has a value, store it in completed
            if (!currentQueNum.isEmpty()) {
                String selectSql = "SELECT * FROM quenum WHERE QueNum = ? AND Transaction_Type = ?";
                int id = -1;
                String username = "";
                int age = 0;
                String mobile = "";

                try (java.sql.PreparedStatement ps = con.prepareStatement(selectSql)) {
                    ps.setString(1, currentQueNum);
                    ps.setString(2, transactionType);
                    try (java.sql.ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            id = rs.getInt("id");
                            username = rs.getString("Username");
                            age = rs.getInt("Age");
                            mobile = rs.getString("MobileNum");
                        }
                    }
                    ps.close();
                }

                if (id != -1) {
                    // Insert into completed
                    String insertCompleted = "INSERT INTO completed (Username, Age, MobileNum, Que_Num, ID, Transaction_Type) VALUES (?, ?, ?, ?, ?, ?)";
                    try (java.sql.PreparedStatement psInsert = con.prepareStatement(insertCompleted)) {
                        psInsert.setString(1, username);
                        psInsert.setInt(2, age);
                        psInsert.setString(3, mobile);
                        psInsert.setString(4, currentQueNum);
                        psInsert.setInt(5, id);
                        psInsert.setString(6, transactionType);
                        psInsert.executeUpdate();
                      
                    }

                    // Delete from quenum **only after storing in completed**
                    String deleteSql = "DELETE FROM quenum WHERE id = ?";
                    try (java.sql.PreparedStatement psDelete = con.prepareStatement(deleteSql)) {
                        psDelete.setInt(1, id);
                        psDelete.executeUpdate();
                         psDelete.close();
                    }
                   
                }

                lblCurrent.setText(""); // Clear after storing
            }

            // 2️⃣ Get next client from quenum (first row)
            String selectNextSql = "SELECT * FROM quenum WHERE Transaction_Type = ? ORDER BY id ASC LIMIT 1";
            try (java.sql.PreparedStatement psNext = con.prepareStatement(selectNextSql)) {
                psNext.setString(1, transactionType);
                try (java.sql.ResultSet rsNext = psNext.executeQuery()) {
                    if (rsNext.next()) {
                        String nextQueNum = rsNext.getString("QueNum");
                        lblCurrent.setText(nextQueNum); // Show next client in JLabel
                    } else {
                        lblCurrent.setText("");
                        JOptionPane.showMessageDialog(null, "No more clients in queue!");
                    }
                    
                }
                psNext.close();
            }

            // 3️⃣ Refresh table
            loadQueueNumbers(table, transactionType);

con.close();

        }
        
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error processing client: " + e.getMessage());
    }
}

// Skip Button (move current number to Skipped DB)
public void skipQueue(JTable table, JLabel lblCurrent, String transactionType) {
    String queNum = lblCurrent.getText(); // get the queue number from JLabel

    if (queNum.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No client selected to skip!");
        return;
    }

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (java.sql.Connection con = java.sql.DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tbaqs", "root", "")) {

            // 1️⃣ Fetch client details from quenum using queNum
            String selectSql = "SELECT * FROM quenum WHERE QueNum = ? AND Transaction_Type = ?";
            String username = "";
            int age = 0;
            String mobile = "";
            int id = -1;

            try (java.sql.PreparedStatement selectPstmt = con.prepareStatement(selectSql)) {
                selectPstmt.setString(1, queNum);
                selectPstmt.setString(2, transactionType);

                try (java.sql.ResultSet rs = selectPstmt.executeQuery()) {
                    if (rs.next()) {
                        username = rs.getString("Username");
                        age = rs.getInt("Age");
                        mobile = rs.getString("MobileNum");
                        id = rs.getInt("id");
                    } else {
                        JOptionPane.showMessageDialog(null, "Client not found in queue!");
                        return;
                    }
                }
            }

            // 2️⃣ Insert client into onhold (skipped)
            String insertSql = "INSERT INTO onhold (Username, Age, MobileNum, Que_Num, Transaction_Type, ID) VALUES (?, ?, ?, ?, ?, ?)";
            try (java.sql.PreparedStatement insertPstmt = con.prepareStatement(insertSql)) {
                insertPstmt.setString(1, username);
                insertPstmt.setInt(2, age);
                insertPstmt.setString(3, mobile);
                insertPstmt.setString(4, queNum);
                insertPstmt.setString(5, transactionType);
                insertPstmt.setInt(6, id);
                insertPstmt.executeUpdate();
            }

            // 3️⃣ Delete client from quenum
            String deleteSql = "DELETE FROM quenum WHERE id = ?";
            try (java.sql.PreparedStatement deletePstmt = con.prepareStatement(deleteSql)) {
                deletePstmt.setInt(1, id);
                deletePstmt.executeUpdate();
            }

            // 4️⃣ Refresh table
            loadQueueNumbers(table, transactionType);

            // 5️⃣ Clear lblCurrent or optionally set next client
            lblCurrent.setText("");
            
con.close();
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error skipping client: " + e.getMessage());
    }
}

public void recallSkipped(String queNum, String transactionType) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (java.sql.Connection con = java.sql.DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tbaqs", "root", "")) {

            // 1️⃣ Fetch all data for the skipped client
            String selectSql = "SELECT * FROM onhold WHERE Que_Num = ? AND Transaction_Type = ?";
            int id = -1;
            String username = "";
            int age = 0;
            String mobile = "";

            try (java.sql.PreparedStatement ps = con.prepareStatement(selectSql)) {
                ps.setString(1, queNum);
                ps.setString(2, transactionType);

                try (java.sql.ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        id = rs.getInt("ID");
                        username = rs.getString("Username");
                        age = rs.getInt("Age");
                        mobile = rs.getString("MobileNum");
                    } else {
                        JOptionPane.showMessageDialog(null, "Skipped client not found!");
                        return;
                    }
                }
            }

            // 2️⃣ Insert client back into quenum (do NOT set ID manually)
            String insertSql = "INSERT INTO quenum (Username, Age, MobileNum, QueNum, Transaction_Type) VALUES (?, ?, ?, ?, ?)";
            try (java.sql.PreparedStatement psInsert = con.prepareStatement(insertSql)) {
                psInsert.setString(1, username);
                psInsert.setInt(2, age);
                psInsert.setString(3, mobile);
                psInsert.setString(4, queNum);
                psInsert.setString(5, transactionType);
                psInsert.executeUpdate();
            }

            // 3️⃣ Delete client from onhold
            String deleteSql = "DELETE FROM onhold WHERE ID = ?";
            try (java.sql.PreparedStatement psDelete = con.prepareStatement(deleteSql)) {
                psDelete.setInt(1, id);
                psDelete.executeUpdate();
            }

            // Feedback message
            JOptionPane.showMessageDialog(null, "Skipped client returned to the queue successfully.");

con.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error recalling skipped client: " + e.getMessage());
    }
}

public void Skipped(String queNum, String transactionType) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (java.sql.Connection con = java.sql.DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tbaqs", "root", "")) {

            // 1️⃣ Fetch all data for the skipped client
            String selectSql = "SELECT * FROM onhold WHERE Que_Num = ? AND Transaction_Type = ?";
            int id = -1;
            String username = "";
            int age = 0;
            String mobile = "";

            try (java.sql.PreparedStatement ps = con.prepareStatement(selectSql)) {
                ps.setString(1, queNum);
                ps.setString(2, transactionType);

                try (java.sql.ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        id = rs.getInt("ID");
                        username = rs.getString("Username");
                        age = rs.getInt("Age");
                        mobile = rs.getString("MobileNum");
                    } else {
                        JOptionPane.showMessageDialog(null, "Skipped client not found!");
                        return;
                    }
                }
            }

            // 2️⃣ Insert client back into quenum (do NOT set ID manually)
            String insertSql = "INSERT INTO cancelled (Username, Age, MobileNum, Que_Num, Transaction_Type, ID) VALUES (?, ?, ?, ?, ?, ?)";
            try (java.sql.PreparedStatement psInsert = con.prepareStatement(insertSql)) {
                psInsert.setString(1, username);
                psInsert.setInt(2, age);
                psInsert.setString(3, mobile);
                psInsert.setString(4, queNum);
                psInsert.setString(5, transactionType);
                psInsert.setInt(6,id);
                psInsert.executeUpdate();
            }

            // 3️⃣ Delete client from onhold
            String deleteSql = "DELETE FROM onhold WHERE ID = ?";
            try (java.sql.PreparedStatement psDelete = con.prepareStatement(deleteSql)) {
                psDelete.setInt(1, id);
                psDelete.executeUpdate();
            }
            con.close();
        }
        
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error recalling skipped client: " + e.getMessage());
    }
}

public void loadOnHoldTable(JTable onHoldTable) {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Name");
    model.addColumn("Age");
    model.addColumn("Mobile Number");
    model.addColumn("Que_Num");
    model.addColumn("Type");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (java.sql.Connection con = java.sql.DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tbaqs", "root", "")) {

            String sql = "SELECT Username, Age, MobileNum, Que_Num, Transaction_Type FROM onhold ORDER BY id ASC";
            try (java.sql.PreparedStatement ps = con.prepareStatement(sql);
                 java.sql.ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    String username = rs.getString("Username");
                    int age = rs.getInt("Age");
                    String mobile = rs.getString("MobileNum");
                    String queNum = rs.getString("Que_Num");
                    String transactionType = rs.getString("Transaction_Type"); // full type

                    model.addRow(new Object[]{username,age,mobile,queNum,transactionType});
                }
            }
            con.close();
        }
        
        onHoldTable.setModel(model);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error loading onhold table: " + e.getMessage());
    }
}

// Call this after initializing your table and loading data
public void setupOnHoldTable(JTable ONHOLD, int statusColumnIndex) {
    ONHOLD.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus,
                                                       int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Get the value in the status column
            Object statusValue = table.getValueAt(row, statusColumnIndex);

            if (statusValue != null && statusValue.toString().equalsIgnoreCase("On Hold")) {
                c.setBackground(Color.RED);
                c.setForeground(Color.WHITE); // optional, better readability
            } else {
                c.setBackground(Color.WHITE);
                c.setForeground(Color.BLACK);
            }

            // Preserve selection color
            if (isSelected) {
                c.setBackground(table.getSelectionBackground());
                c.setForeground(table.getSelectionForeground());
            }

            return c;
        }
    });
}

public void tablehovered(){
// Set custom renderer to apply hover effect
ONHOLD.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MONITORING = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        C2 = new javax.swing.JLabel();
        C3 = new javax.swing.JLabel();
        C4 = new javax.swing.JLabel();
        S1 = new javax.swing.JButton();
        S2 = new javax.swing.JButton();
        S3 = new javax.swing.JButton();
        S4 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        T4 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        T3 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        T2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        T1 = new javax.swing.JTable();
        N1 = new javax.swing.JButton();
        N2 = new javax.swing.JButton();
        N3 = new javax.swing.JButton();
        N4 = new javax.swing.JButton();
        C1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ONHOLD = new javax.swing.JTable();
        search = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BACK = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        MONITORING.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/fillers.png"))); // NOI18N
        MONITORING.setBorderPainted(false);
        MONITORING.setContentAreaFilled(false);
        MONITORING.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        MONITORING.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/clickc.png"))); // NOI18N
        MONITORING.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MONITORINGActionPerformed(evt);
            }
        });
        add(MONITORING);
        MONITORING.setBounds(0, 365, 352, 90);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        C2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        C2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(C2);
        C2.setBounds(301, 75, 155, 60);

        C3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        C3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(C3);
        C3.setBounds(505, 75, 155, 60);

        C4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        C4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(C4);
        C4.setBounds(708, 75, 155, 60);

        S1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/ONU.png"))); // NOI18N
        S1.setToolTipText("");
        S1.setBorderPainted(false);
        S1.setContentAreaFilled(false);
        S1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/ONC.png"))); // NOI18N
        S1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/ONC.png"))); // NOI18N
        S1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S1ActionPerformed(evt);
            }
        });
        jPanel1.add(S1);
        S1.setBounds(90, 149, 172, 44);

        S2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/ONU.png"))); // NOI18N
        S2.setToolTipText("");
        S2.setBorderPainted(false);
        S2.setContentAreaFilled(false);
        S2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/ONC.png"))); // NOI18N
        S2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/ONC.png"))); // NOI18N
        S2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S2ActionPerformed(evt);
            }
        });
        jPanel1.add(S2);
        S2.setBounds(295, 149, 172, 44);

        S3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/ONU.png"))); // NOI18N
        S3.setToolTipText("");
        S3.setBorderPainted(false);
        S3.setContentAreaFilled(false);
        S3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/ONC.png"))); // NOI18N
        S3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/ONC.png"))); // NOI18N
        S3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S3ActionPerformed(evt);
            }
        });
        jPanel1.add(S3);
        S3.setBounds(498, 149, 172, 44);

        S4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/ONU.png"))); // NOI18N
        S4.setToolTipText("");
        S4.setBorderPainted(false);
        S4.setContentAreaFilled(false);
        S4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/ONC.png"))); // NOI18N
        S4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/ONC.png"))); // NOI18N
        S4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S4ActionPerformed(evt);
            }
        });
        jPanel1.add(S4);
        S4.setBounds(702, 149, 172, 44);

        T4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        T4.setRowHeight(30);
        jScrollPane5.setViewportView(T4);

        jPanel1.add(jScrollPane5);
        jScrollPane5.setBounds(708, 235, 157, 130);

        T3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        T3.setRowHeight(30);
        jScrollPane3.setViewportView(T3);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(505, 235, 157, 130);

        T2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        T2.setRowHeight(30);
        jScrollPane2.setViewportView(T2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(299, 235, 157, 130);

        T1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        T1.setRowHeight(30);
        jScrollPane1.setViewportView(T1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(97, 235, 157, 130);

        N1.setBorderPainted(false);
        N1.setContentAreaFilled(false);
        N1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/NU.png"))); // NOI18N
        N1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/NC.png"))); // NOI18N
        N1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                N1ActionPerformed(evt);
            }
        });
        jPanel1.add(N1);
        N1.setBounds(87, 379, 176, 45);

        N2.setBorderPainted(false);
        N2.setContentAreaFilled(false);
        N2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/NU.png"))); // NOI18N
        N2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/NC.png"))); // NOI18N
        N2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                N2ActionPerformed(evt);
            }
        });
        jPanel1.add(N2);
        N2.setBounds(291, 379, 176, 45);

        N3.setBorderPainted(false);
        N3.setContentAreaFilled(false);
        N3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/NU.png"))); // NOI18N
        N3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/NC.png"))); // NOI18N
        N3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                N3ActionPerformed(evt);
            }
        });
        jPanel1.add(N3);
        N3.setBounds(495, 379, 176, 45);

        N4.setBorderPainted(false);
        N4.setContentAreaFilled(false);
        N4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/NU.png"))); // NOI18N
        N4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/BUTTONS/NC.png"))); // NOI18N
        N4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                N4ActionPerformed(evt);
            }
        });
        jPanel1.add(N4);
        N4.setBounds(699, 379, 176, 45);

        C1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        C1.setForeground(java.awt.Color.black);
        C1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(C1);
        C1.setBounds(97, 75, 155, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/MANAGE.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 946, 431);

        add(jPanel1);
        jPanel1.setBounds(355, 210, 946, 431);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        ONHOLD.setModel(new javax.swing.table.DefaultTableModel(
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
        ONHOLD.setRowHeight(30);
        ONHOLD.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ONHOLDMouseMoved(evt);
            }
        });
        ONHOLD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ONHOLDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ONHOLDMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ONHOLDMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(ONHOLD);

        jPanel2.add(jScrollPane4);
        jScrollPane4.setBounds(97, 108, 772, 308);

        search.setBackground(java.awt.Color.white);
        search.setForeground(java.awt.Color.black);
        search.setBorder(null);
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        jPanel2.add(search);
        search.setBounds(120, 59, 256, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/ON-HOLD.png"))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 0, 946, 431);

        add(jPanel2);
        jPanel2.setBounds(355, 210, 946, 431);

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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PENDING TRANSACTIONS", "ON-HOLD TRANSACTIONS" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1);
        jComboBox1.setBounds(380, 170, 250, 22);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/YEY.gif"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void MONITORINGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MONITORINGActionPerformed
        frame.setContentPane(new EMPLOYEE_QUE_MONITOR(frame));
        frame.revalidate();
    }//GEN-LAST:event_MONITORINGActionPerformed

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        frame.setContentPane(new EMPLOYEE_DASH(frame));
        frame.revalidate();
    }//GEN-LAST:event_BACKActionPerformed

    private void N1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_N1ActionPerformed
      
        callNext(T1, C1, "Withdraw");
    }//GEN-LAST:event_N1ActionPerformed

    private void S1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S1ActionPerformed
        skipQueue(T1, C1, "Withdraw");
    }//GEN-LAST:event_S1ActionPerformed

    private void N2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_N2ActionPerformed
    
        callNext(T2, C2, "Deposit");
    }//GEN-LAST:event_N2ActionPerformed

    private void N3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_N3ActionPerformed

        callNext(T3, C3, "Loan");
    }//GEN-LAST:event_N3ActionPerformed

    private void N4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_N4ActionPerformed
        
        callNext(T4, C4, "Inquire");
    }//GEN-LAST:event_N4ActionPerformed

    private void S2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S2ActionPerformed
        skipQueue(T2, C2, "Deposit");
    }//GEN-LAST:event_S2ActionPerformed

    private void S3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S3ActionPerformed
        skipQueue(T3, C3, "Loan");
    }//GEN-LAST:event_S3ActionPerformed

    private void S4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S4ActionPerformed
        skipQueue(T4, C4, "Inquire");
    }//GEN-LAST:event_S4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
        if(jComboBox1.getSelectedIndex() ==0){
            
            jPanel2.setVisible(false);
            jPanel1.setVisible(true);
            
        }else{jPanel2.setVisible(true);
        
            jPanel1.setVisible(false);}
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void ONHOLDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ONHOLDMousePressed

        int row = ONHOLD.getSelectedRow();

        if (row != -1){

            String queNum = ONHOLD.getValueAt(row, 3).toString();
            String transactionType = ONHOLD.getValueAt(row, 4).toString();

            Object[] options = {"Recover", "Skipped", "Cancel"};
            int choice = JOptionPane.showOptionDialog(
                null,
                "Do you want to recover this user?",
                "Recover User",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
            );

            if (choice == 0) {
                recallSkipped(queNum, transactionType);
                System.out.println("Recover chosen");
            } else if (choice == 1) {
                Skipped(queNum, transactionType);
                System.out.println("Skipped chosen");
            } else if (choice == 2) {

                System.out.println("Cancel chosen");
            }
        }
    }//GEN-LAST:event_ONHOLDMousePressed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
       DefaultTableModel ob = (DefaultTableModel)ONHOLD.getModel();
       TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
       ONHOLD.setRowSorter(obj);
       obj.setRowFilter(RowFilter.regexFilter(search.getText()));
    }//GEN-LAST:event_searchKeyReleased

    private void ONHOLDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ONHOLDMouseEntered
       
    }//GEN-LAST:event_ONHOLDMouseEntered

    private void ONHOLDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ONHOLDMouseExited
        // Reset hovered row when mouse leaves the table
        hoveredRow = -1;
        ONHOLD.repaint(); // repaint table to remove hover color
    }//GEN-LAST:event_ONHOLDMouseExited

    private void ONHOLDMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ONHOLDMouseMoved
        
        int row = ONHOLD.rowAtPoint(evt.getPoint());
        if (row != hoveredRow) {
            hoveredRow = row;
            ONHOLD.repaint(); // update hover
        }
    }//GEN-LAST:event_ONHOLDMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BACK;
    public static javax.swing.JLabel C1;
    public static javax.swing.JLabel C2;
    public static javax.swing.JLabel C3;
    public static javax.swing.JLabel C4;
    private javax.swing.JButton MONITORING;
    private javax.swing.JButton N1;
    private javax.swing.JButton N2;
    private javax.swing.JButton N3;
    private javax.swing.JButton N4;
    private javax.swing.JTable ONHOLD;
    private javax.swing.JButton S1;
    private javax.swing.JButton S2;
    private javax.swing.JButton S3;
    private javax.swing.JButton S4;
    private javax.swing.JTable T1;
    private javax.swing.JTable T2;
    private javax.swing.JTable T3;
    private javax.swing.JTable T4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
