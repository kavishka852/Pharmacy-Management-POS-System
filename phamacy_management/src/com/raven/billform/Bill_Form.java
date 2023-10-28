/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.billform;


import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author fradd
 */
public class Bill_Form extends javax.swing.JPanel {
    
    private JPopupMenu menu;
    private PanelSearch search;
    private DefaultTableModel tableModel;
    public String globalPrice;
    public String item = "";
    public int pstates = 0;
    List<String> itemId = new ArrayList<>();
    List<Integer> itemAmounts = new ArrayList<>();

    /**
     * Creates new form Bill_Form
     */
    
    
    public Bill_Form() {
        connectToDatabase();
        initComponents();
        //tableDark.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        setOpaque(false);
        menu = new JPopupMenu();
        search = new PanelSearch();
        menu.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        menu.add(search);
        menu.setFocusable(false);
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{"ID", "Name", "qun", "Price", "action"});
        tableDark.setModel(tableModel);
        search.addEventClick(new EventClick() {
            @Override
            public void itemClick(DataSearch data) {
                menu.setVisible(false);
                //txtSearch.setText(data.getText());
                //addStory(data.getText());
                String pro = data.getText();
                PreparedStatement p;
                try {
                    p = con.prepareStatement("select * From medicine where mname = '"+pro+"'");
                    ResultSet r = p.executeQuery();
                    while (r.next()) {
                        String mid = r.getString(2);
                        String name = r.getString(3);
                        String price = r.getString(4);
                        String quantity = "1";
                        TotalPrice.price = price;
                        TableActionEvent event = new TableActionEvent(){       
                            @Override
                            public void onDelete(int row) {
                                if (tableDark.isEditing()) {
                                    tableDark.getCellEditor().stopCellEditing();
                                }
                                DefaultTableModel model = (DefaultTableModel) tableDark.getModel();
                                model.removeRow(row);
                            }
                             
                        };
                        tableDark.getColumnModel().getColumn(2).setCellEditor(new QtyCellEditor());
                        tableDark.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
                            @Override
                            public Component getTableCellRendererComponent(JTable tableDark, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                                super.getTableCellRendererComponent(tableDark, value, isSelected, hasFocus, row, column);
                                setHorizontalAlignment(SwingConstants.CENTER);
                                return this;
                            }
                        });
                        tableDark.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
                        tableDark.getColumnModel().getColumn(4).setCellEditor(new TableActioncellEditor(event));
                        tableModel.addRow(new Object[]{mid, name, quantity, price});
                    }
                    r.close();
                    p.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Bill_Form.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Click Item : " + data.getText());
            }

            @Override
            public void itemRemove(Component com, DataSearch data) {
                search.remove(com);
                removeHistory(data.getText());
                menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
                if (search.getItemSize() == 0) {
                    menu.setVisible(false);
                }
                System.out.println("Remove Item : " + data.getText());
            }
        });
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        lblbal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtcradit = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        roundPanel2 = new com.raven.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDark = new com.raven.form.TableDark();
        btnaddtobill = new com.raven.swing.ButtonMenu();
        roundPanel3 = new com.raven.swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        roundPanel4 = new com.raven.swing.RoundPanel();
        btnpay = new javax.swing.JButton();
        btnprint = new javax.swing.JButton();
        btnpay1 = new javax.swing.JButton();
        roundPanel5 = new com.raven.swing.RoundPanel();
        txtSearch = new swing.MyTextField();

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pay");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Balance");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Rs:");

        lbltotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbltotal.setForeground(new java.awt.Color(255, 255, 255));
        lbltotal.setText("0");

        lblbal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblbal.setForeground(new java.awt.Color(255, 255, 255));
        lblbal.setText("0");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Rs:");

        txtcradit.setBackground(new java.awt.Color(102, 102, 102));
        txtcradit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtcradit.setForeground(new java.awt.Color(255, 255, 255));
        txtcradit.setText("0");
        txtcradit.setBorder(null);
        txtcradit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcraditActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Rs");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblbal))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbltotal))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcradit, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lbltotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcradit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(13, 13, 13)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblbal)))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));

        tableDark.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "name", "qun", "Price", "action", "dump"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDark.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tableDark.setRowHeight(40);
        jScrollPane1.setViewportView(tableDark);
        if (tableDark.getColumnModel().getColumnCount() > 0) {
            tableDark.getColumnModel().getColumn(5).setMinWidth(0);
            tableDark.getColumnModel().getColumn(5).setPreferredWidth(0);
            tableDark.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        btnaddtobill.setBackground(new java.awt.Color(0, 0, 0));
        btnaddtobill.setForeground(new java.awt.Color(14, 246, 204));
        btnaddtobill.setText("Add to Bill");
        btnaddtobill.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnaddtobill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnaddtobill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddtobillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                    .addComponent(btnaddtobill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnaddtobill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        roundPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jTextArea.setEditable(false);
        jTextArea.setColumns(20);
        jTextArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea.setRows(5);
        jScrollPane2.setViewportView(jTextArea);

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        roundPanel4.setBackground(new java.awt.Color(51, 51, 51));

        btnpay.setBackground(new java.awt.Color(0, 102, 102));
        btnpay.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnpay.setForeground(new java.awt.Color(255, 255, 255));
        btnpay.setText("Pay");
        btnpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpayActionPerformed(evt);
            }
        });

        btnprint.setBackground(new java.awt.Color(255, 0, 51));
        btnprint.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnprint.setForeground(new java.awt.Color(255, 255, 255));
        btnprint.setText("Print");
        btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintActionPerformed(evt);
            }
        });

        btnpay1.setBackground(new java.awt.Color(102, 102, 102));
        btnpay1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnpay1.setForeground(new java.awt.Color(255, 255, 255));
        btnpay1.setText("Clear");
        btnpay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpay1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnpay, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnprint, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnpay1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnpay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnpay1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnprint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        roundPanel5.setBackground(new java.awt.Color(51, 51, 51));

        txtSearch.setBackground(new java.awt.Color(153, 153, 153));
        txtSearch.setToolTipText("");
        txtSearch.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/billform/search.png"))); // NOI18N
        txtSearch.setSelectionColor(new java.awt.Color(51, 51, 51));
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel5Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtcraditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcraditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcraditActionPerformed

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        if (search.getItemSize() > 0) {
            menu.show(txtSearch, 0, txtSearch.getHeight());
            search.clearSelected();
        }
        //System.out.println("gg");
    }//GEN-LAST:event_txtSearchMouseClicked

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            search.keyUp();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            search.keyDown();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = search.getSelectedText();
            txtSearch.setText(text);
            menu.setVisible(false);
        }
        //System.out.println("hh");
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN && evt.getKeyCode() != KeyEvent.VK_ENTER) {
            String text = txtSearch.getText().trim().toLowerCase();
            search.setData(search(text));
            if (search.getItemSize() > 0) {
                //  * 2 top and bot border
                menu.show(txtSearch, 0, txtSearch.getHeight());
                menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
            } else {
                menu.setVisible(false);
            }
        }
        //System.out.println("ii");
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpayActionPerformed
        // TODO add your handling code here:
        String total = lbltotal.getText();
        String pay = txtcradit.getText();
        
        
        if(Double.valueOf(pay)==0) {
            JOptionPane.showMessageDialog(null, "Please Enter Price on pay field");
        }
        else if(Double.valueOf(pay)<Double.valueOf(total)) {
            JOptionPane.showMessageDialog(null, "Please Enter Valid Price on pay field");
        }
        else{
            double bal = Double.valueOf(pay) - Double.valueOf(total);
            int S = sendbill();
            if (S==1){
                
                
                lblbal.setText(String.valueOf(bal));
        
                jTextArea.setText(jTextArea.getText() + "********************************************************************\n");
                jTextArea.setText(jTextArea.getText() + "\t"+"\t"+"Subtotal :" +"\t"+"Rs"+total + "\n");
                jTextArea.setText(jTextArea.getText() + "\t"+"\t"+"Pay :"+"\t"+"Rs"+pay + "\n");
                jTextArea.setText(jTextArea.getText() + "\t"+"\t"+"Balance :"+"\t"+"Rs"+bal + "\n");
                jTextArea.setText(jTextArea.getText() + "\n");
                jTextArea.setText(jTextArea.getText() + "********************************************************************\n");
                jTextArea.setText(jTextArea.getText() + "                         THANK YOU COME AGAIN                       \n");
                jTextArea.setText(jTextArea.getText() + "               © 2023 UNREALLABS. All rights reserved               \n");
                JOptionPane.showMessageDialog(null, "Successful");
                pstates = 1;
                }
            else if(S==0){
               JOptionPane.showMessageDialog(null, "Somthing Went Wrong try Again");
                }
            else {
               JOptionPane.showMessageDialog(null, "System Error");
                }
        }
        
    }//GEN-LAST:event_btnpayActionPerformed

    private void btnpay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpay1ActionPerformed
        // TODO add your handling code here:
        jTextArea.setText("");
        DefaultTableModel model = (DefaultTableModel) tableDark.getModel();
        model.setRowCount(0);
        lblbal.setText("");
        lbltotal.setText("");
        txtSearch.setText("");
        txtcradit.setText("");
    }//GEN-LAST:event_btnpay1ActionPerformed

    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed
        // TODO add your handling code here:
        
        if(pstates==1) {
            try 
                  {
            jTextArea.print();
                  } 
        catch (PrinterException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Somthing Went Wrong Check your Printer");
        }  
        }else{
            JOptionPane.showMessageDialog(null, "Empty Bill");
        }
        
    }//GEN-LAST:event_btnprintActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnaddtobillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddtobillActionPerformed
        // TODO add your handling code here:
        bill();
    }//GEN-LAST:event_btnaddtobillActionPerformed

    public void bill() {
    
    double tot = 0.0;
    int invoid = 0;
    //String item = "";
    Date currentDate = new Date();
    String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(currentDate);

    try{
        PreparedStatement p = con.prepareStatement("SELECT id from invoice ORDER BY id DESC LIMIT 1;");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                invoid = Integer.parseInt(r.getString(1)) + 1;
            }
            r.close();
            p.close();
    DefaultTableModel model = (DefaultTableModel) tableDark.getModel();

                          
                      jTextArea.setText("                   Osudinu Aurveda Pharmacy                        \n");
    jTextArea.setText(jTextArea.getText() + "\n");
    jTextArea.setText(jTextArea.getText() + "\n");
    
    jTextArea.setText(jTextArea.getText() + "No 75/1/I, \n");
    jTextArea.setText(jTextArea.getText() + "Mallehewa, \n");
    jTextArea.setText(jTextArea.getText() + "Kaleliya \n");
    jTextArea.setText(jTextArea.getText() + "072 0439309 \n");
    jTextArea.setText(jTextArea.getText() + "*******************************************************************\n");
    
    jTextArea.setText(jTextArea.getText() + "Invoice No "+invoid+"\n");
    jTextArea.setText(jTextArea.getText() + "Date "+formattedDate+"\n");
    
    jTextArea.setText(jTextArea.getText() + "\n");
    jTextArea.setText(jTextArea.getText() + "\n");
    
    //Heading
    jTextArea.setText(jTextArea.getText() + "Product" + "\t" + "Amount" + "\t" + "Price" + "\n");

    double total = 0.0;
    for (int i = 0; i < model.getRowCount(); i++) {
        String pname = model.getValueAt(i, 1).toString();
        tot = Double.parseDouble(model.getValueAt(i, 3).toString());
        String price = model.getValueAt(i, 3).toString();
        String amount = model.getValueAt(i, 2).toString();
        String tepitem = model.getValueAt(i, 1).toString();
        int qun = Integer.parseInt(model.getValueAt(i, 2).toString());///to store List
        String mid = model.getValueAt(i, 0).toString();
        //itemId.add(mid);
        //itemAmounts.add(qun);

        total = total + tot;

        jTextArea.setText(jTextArea.getText() + pname + "\t" + amount + "\t" + price + "\n");
        //item = item + "( " + tepitem +" X"+ amount+ " ) ";
    }

    lbltotal.setText(String.valueOf(total));
    jTextArea.setText(jTextArea.getText() + "\n");
    } catch (SQLException e){
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Somthing Went Wrong try Again");
    }
    
}
    
    public int sendbill(){
        int S = 0;
        DefaultTableModel model = (DefaultTableModel) tableDark.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
                    int qun = Integer.parseInt(model.getValueAt(i, 2).toString());///to store List
                    String mid = model.getValueAt(i, 0).toString();
                    String tepitem = model.getValueAt(i, 1).toString();
                    itemId.add(mid);
                    itemAmounts.add(qun);
                    item = item + "( " + tepitem +" X"+ qun+ " ) ";
                }
        
        try {
            Date currentDate = new Date();
            String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentDate);
            String total = lbltotal.getText();
            String pay = txtcradit.getText();
            PreparedStatement p = con.prepareStatement("INSERT INTO invoice (date, item_list, total, pay) VALUES ('"+formattedDate+"', '"+item+"', '"+total+"', '"+pay+"')");
            //p.setString(1, text);
            p.execute();
            p.close();
            
            for (int i = 0; i < itemId.size(); i++) {
                 String itemID = itemId.get(i);
                 int itemAmount = itemAmounts.get(i);
                 p = con.prepareStatement("Update medicine SET quantity = quantity - '"+itemAmount+"' WHERE mid ='"+itemID+"'");
                 p.execute();
                 p.close();
                 System.out.println("run");
            }
            
            //JOptionPane.showMessageDialog(null, "Successful");
            S = 1;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Somthing Went Wrong try Again");
            S = 0;
        }
        return S;
    }
    
    private List<DataSearch> search(String search) {
        List<DataSearch> list = new ArrayList<>();
        try {
            PreparedStatement p = con.prepareStatement("select DISTINCT mname, coalesce((select StoryID from story where mname=StoryName limit 1),'') as Story from medicine where mname like ? order by Story DESC, mname limit 7");
            p.setString(1, "%" + search + "%");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String text = r.getString(1);
                boolean story = !r.getString(2).equals("");
                list.add(new DataSearch(text, story));
            }
            r.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    private void removeHistory(String text) {
        try {
            PreparedStatement p = con.prepareStatement("delete from story where StoryName=? limit 1");
            p.setString(1, text);
            p.execute();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private Connection con;
    
    private void connectToDatabase() {
        try {
            String server = "localhost";
            String port = "3306"; //  Default 3306
            String database = "pharmacy";
            String user = "root";
            String pass = "";
            con = java.sql.DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/" + database, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void addStory(String text) {
        try {
            boolean add = true;
            PreparedStatement p = con.prepareStatement("select StoryID from story where StoryName=? limit 1");
            p.setString(1, text);
            ResultSet r = p.executeQuery();
            if (r.first()) {
                add = false;
            }
            r.close();
            p.close();
            if (add) {
                p = con.prepareStatement("insert into story (StoryName) values (?)");
                p.setString(1, text);
                p.execute();
                p.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println("jj");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.ButtonMenu btnaddtobill;
    private javax.swing.JButton btnpay;
    private javax.swing.JButton btnpay1;
    private javax.swing.JButton btnprint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JLabel lblbal;
    private javax.swing.JLabel lbltotal;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.RoundPanel roundPanel3;
    private com.raven.swing.RoundPanel roundPanel4;
    private com.raven.swing.RoundPanel roundPanel5;
    private com.raven.form.TableDark tableDark;
    private swing.MyTextField txtSearch;
    private javax.swing.JTextField txtcradit;
    // End of variables declaration//GEN-END:variables

}
