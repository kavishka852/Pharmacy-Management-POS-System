/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.login;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Inoth
 */
public class allemp extends javax.swing.JPanel {

    /**
     * Creates new form allemp
     */
    public allemp() {
       initComponents();
        loadData();
        
    }
    
    
    
    
    
private void loadData() {
        String url = "jdbc:mysql://localhost:3306/pharmacy";
        String user = "root";
        String password = "";

        String query = "SELECT u_fname, u_uname, u_bdate, u_address, u_type FROM user";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("First Name");
            model.addColumn("Username");
           // model.addColumn("Password"); // Added 'Password' column 
            model.addColumn("Birth Date");
            model.addColumn("Address");
            model.addColumn("Type");

            while (resultSet.next()) {
                String fname = resultSet.getString("u_fname");
                String uname = resultSet.getString("u_uname");
               // String upass = resultSet.getString("u_pass"); // Added 'u_pass'
                String bdate = resultSet.getString("u_bdate");
                String address = resultSet.getString("u_address");
                String type = resultSet.getString("u_type");

                model.addRow(new Object[]{fname, uname, bdate, address, type});
            }

            jTable1.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    

}
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        roundPanel1 = new com.raven.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        roundPanel2 = new com.raven.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        roundPanel3 = new com.raven.swing.RoundPanel();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        roundPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Employers Details");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        roundPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(102, 102, 102));
        jTable1.setRowHeight(50);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setBackground(new java.awt.Color(14, 246, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("DELETE");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jButton1)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow != -1) {
        // Retrieve the data from the selected row
        String usernameToDelete = (String) jTable1.getValueAt(selectedRow, 1);
        // Assuming the first column contains the username, you may adjust this based on your table structure

        // Implement your database delete function here, replace 'deleteFromDatabase' with your actual delete operation
        boolean deleteSuccessful = deleteFromDatabase(usernameToDelete);

        if (deleteSuccessful) {
            // If deletion was successful, update the JTable by removing the selected row
            ((DefaultTableModel) jTable1.getModel()).removeRow(selectedRow);
            // Assuming you are using DefaultTableModel, adjust this if you use a custom TableModel
        } else {
            // Handle the case where deletion failed, show an error message or take appropriate action
           // ((DefaultTableModel) jTable1.getModel()).removeRow(selectedRow);
            System.out.println("Failed to delete the user: " + usernameToDelete);
        }
    }
}

// Replace this method with your actual database delete logic
private boolean deleteFromDatabase(String usernameToDelete) {
    
    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
    
    

    String url = "jdbc:mysql://localhost:3306/pharmacy"; // Replace with your database URL
    String user = "root"; // Replace with your database username
    String password = ""; // Replace with your database password

    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "unreallabs", "Fraddy20010128")) {
        
        
        String query = "DELETE FROM user WHERE u_uname = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, usernameToDelete);
            
        
            int rowsAffected = preparedStatement.executeUpdate();
            
            
            return rowsAffected > 0;
        }
        
    } catch (SQLException e) {
       
        e.printStackTrace();
        return false;
    }
    
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.RoundPanel roundPanel3;
    // End of variables declaration//GEN-END:variables
}
