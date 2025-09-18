/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Employee;

import javax.swing.JTable;

/**
 *
 * @author reyes
 */
public class History_cancelled extends javax.swing.JPanel {

    private Main.Frame frame;
    public History_cancelled(Main.Frame frame) {
        initComponents();
        
        this.frame = frame;
        update();
    }
    
    public void update(){
        new javax.swing.Timer(0000, e -> {
        //loadskipped(skipped);
        }).start();
    }
    
    /* WAG GALAWIN
    
    public void loadskipped(JTable table) {
    try (java.sql.Connection con = java.sql.DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/Banking_sino_ka_man", "root", "")) {
        
        String sql = "SELECT Que_num FROM skipped";
        java.sql.PreparedStatement pst = con.prepareStatement(sql);

        java.sql.ResultSet rs = pst.executeQuery();

        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        model.addColumn("Queue Number");

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

        jScrollPane1 = new javax.swing.JScrollPane();
        skipped = new javax.swing.JTable();
        cmpt_btn = new javax.swing.JButton();
        bck_btn = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setLayout(null);

        skipped.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(skipped);

        add(jScrollPane1);
        jScrollPane1.setBounds(328, 139, 970, 500);

        cmpt_btn.setBorderPainted(false);
        cmpt_btn.setContentAreaFilled(false);
        cmpt_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmpt_btnActionPerformed(evt);
            }
        });
        add(cmpt_btn);
        cmpt_btn.setBounds(0, 250, 330, 80);

        bck_btn.setBorderPainted(false);
        bck_btn.setContentAreaFilled(false);
        bck_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bck_btnActionPerformed(evt);
            }
        });
        add(bck_btn);
        bck_btn.setBounds(0, 540, 330, 100);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/History_Cancelled.png"))); // NOI18N
        add(bg);
        bg.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void bck_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bck_btnActionPerformed
        frame.setContentPane(new E_Dashboard(frame));
        frame.revalidate();
    }//GEN-LAST:event_bck_btnActionPerformed

    private void cmpt_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmpt_btnActionPerformed
        frame.setContentPane(new History_completed(frame));
        frame.revalidate();
    }//GEN-LAST:event_cmpt_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bck_btn;
    private javax.swing.JLabel bg;
    private javax.swing.JButton cmpt_btn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable skipped;
    // End of variables declaration//GEN-END:variables
}
