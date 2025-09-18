/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Employee;

import Constructors.next_in_que;
import javax.swing.JTable;

/**
 *
 * @author reyes
 */
public class Monitoring extends javax.swing.JPanel {

    private Main.Frame frame;
    public Monitoring(Main.Frame frame) {
        initComponents();
        this.frame = frame;
        update();
    }
    
    public void update(){
        new javax.swing.Timer(0000, e -> {
        /*
            loadPendings(Pending);
            loadSkipped(Skipped);
            loadDone( done);
         */
        }).start();
    }
    
    /* WAG GALAWIN

    public void loadPendings(JTable table) {
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
    
    public void loadSkipped(JTable table) {
    try (java.sql.Connection con = java.sql.DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/Banking_sino_ka_man", "root", "")) {
        
        String sql = "SELECT Que_Num FROM Skipped";
        java.sql.PreparedStatement pst = con.prepareStatement(sql);

        java.sql.ResultSet rs = pst.executeQuery();

        // 2. Create table model with one column
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        model.addColumn("Queue Number");

        // 3. Add rows from result
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("Que_Num")
            });
        }

        table.setModel(model);

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
    
    public void loadDone(JTable table) {
    try (java.sql.Connection con = java.sql.DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/Banking_sino_ka_man", "root", "")) {
        
        String sql = "SELECT Que_Num FROM complete_transaction";
        java.sql.PreparedStatement pst = con.prepareStatement(sql);

        java.sql.ResultSet rs = pst.executeQuery();

        // 2. Create table model with one column
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        model.addColumn("Queue Number");

        // 3. Add rows from result
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("Que_Num")
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

        mngment_btn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        done = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Skipped = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        Pending = new javax.swing.JTable();
        back_btn = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setLayout(null);

        mngment_btn.setBorderPainted(false);
        mngment_btn.setContentAreaFilled(false);
        mngment_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mngment_btnActionPerformed(evt);
            }
        });
        add(mngment_btn);
        mngment_btn.setBounds(0, 250, 330, 80);

        done.setModel(new javax.swing.table.DefaultTableModel(
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
        done.setRowHeight(40);
        jScrollPane3.setViewportView(done);

        add(jScrollPane3);
        jScrollPane3.setBounds(970, 270, 252, 340);

        Skipped.setModel(new javax.swing.table.DefaultTableModel(
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
        Skipped.setRowHeight(40);
        jScrollPane2.setViewportView(Skipped);

        add(jScrollPane2);
        jScrollPane2.setBounds(695, 270, 250, 340);

        Pending.setModel(new javax.swing.table.DefaultTableModel(
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
        Pending.setRowHeight(40);
        jScrollPane1.setViewportView(Pending);

        add(jScrollPane1);
        jScrollPane1.setBounds(420, 270, 250, 340);

        back_btn.setBorderPainted(false);
        back_btn.setContentAreaFilled(false);
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        add(back_btn);
        back_btn.setBounds(0, 540, 330, 100);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/MONITORING.png"))); // NOI18N
        add(bg);
        bg.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void mngment_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngment_btnActionPerformed
        frame.setContentPane(new Management(frame));
        frame.revalidate();
    }//GEN-LAST:event_mngment_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        frame.setContentPane(new E_Dashboard(frame));
        frame.revalidate();
    }//GEN-LAST:event_back_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Pending;
    private javax.swing.JTable Skipped;
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel bg;
    private javax.swing.JTable done;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton mngment_btn;
    // End of variables declaration//GEN-END:variables
}
