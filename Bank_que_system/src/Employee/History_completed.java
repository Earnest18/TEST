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
public class History_completed extends javax.swing.JPanel {

    private Main.Frame frame;
    public History_completed(Main.Frame frame) {
        initComponents();
        this.frame = frame;
        update();
    }
    
    public void update(){
        new javax.swing.Timer(0000, e -> {
        //loadcompleted(completed);
        }).start();
    }
    
    /* WAG GALAWIN
    public void loadcompleted(JTable table) {
    try (java.sql.Connection con = java.sql.DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/Banking_sino_ka_man", "root", "")) {
        
        String sql = "SELECT Que_num FROM complete_transaction";
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
        completed = new javax.swing.JTable();
        bck_btn = new javax.swing.JButton();
        cancelled_btn = new javax.swing.JButton();
        about_btn = new javax.swing.JButton();
        faqs_btn = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setLayout(null);

        completed.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(completed);

        add(jScrollPane1);
        jScrollPane1.setBounds(328, 139, 970, 500);

        bck_btn.setBorderPainted(false);
        bck_btn.setContentAreaFilled(false);
        bck_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bck_btnActionPerformed(evt);
            }
        });
        add(bck_btn);
        bck_btn.setBounds(0, 540, 330, 100);

        cancelled_btn.setBorderPainted(false);
        cancelled_btn.setContentAreaFilled(false);
        cancelled_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelled_btnActionPerformed(evt);
            }
        });
        add(cancelled_btn);
        cancelled_btn.setBounds(0, 340, 330, 80);

        about_btn.setIcon(new javax.swing.ImageIcon("C:\\Users\\reyes\\Downloads\\BSKM PHOTOS\\BUTTONS\\CAU.png")); // NOI18N
        about_btn.setBorderPainted(false);
        about_btn.setContentAreaFilled(false);
        about_btn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/BSKM PHOTOS/BUTTONS/ABTC.png"))); // NOI18N
        about_btn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/BSKM PHOTOS/BUTTONS/ABTC.png"))); // NOI18N
        about_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                about_btnActionPerformed(evt);
            }
        });
        add(about_btn);
        about_btn.setBounds(1005, 95, 145, 47);

        faqs_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BSKM PHOTOS/BUTTONS/ABTU.png"))); // NOI18N
        faqs_btn.setBorderPainted(false);
        faqs_btn.setContentAreaFilled(false);
        faqs_btn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/BSKM PHOTOS/BUTTONS/FAQC.png"))); // NOI18N
        faqs_btn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/BSKM PHOTOS/BUTTONS/FAQC.png"))); // NOI18N
        faqs_btn.setSelected(true);
        faqs_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faqs_btnActionPerformed(evt);
            }
        });
        add(faqs_btn);
        faqs_btn.setBounds(1173, 95, 101, 47);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG'S/History_completed.png"))); // NOI18N
        add(bg);
        bg.setBounds(0, 0, 1300, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelled_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelled_btnActionPerformed
       frame.setContentPane(new History_cancelled(frame));
       frame.revalidate();
    }//GEN-LAST:event_cancelled_btnActionPerformed

    private void bck_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bck_btnActionPerformed
        frame.setContentPane(new E_Dashboard(frame));
        frame.revalidate();
    }//GEN-LAST:event_bck_btnActionPerformed

    private void faqs_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faqs_btnActionPerformed
       
    }//GEN-LAST:event_faqs_btnActionPerformed

    private void about_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_btnActionPerformed

    }//GEN-LAST:event_about_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton about_btn;
    private javax.swing.JButton bck_btn;
    private javax.swing.JLabel bg;
    private javax.swing.JButton cancelled_btn;
    private javax.swing.JTable completed;
    private javax.swing.JButton faqs_btn;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
