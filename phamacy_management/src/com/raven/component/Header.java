package com.raven.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

public class Header extends javax.swing.JPanel {

    public Header() {
        initComponents();
        setOpaque(false);
        setBackground(new Color(51, 51, 51));
        Timer timer = new Timer(1000, e -> {
            Date currentDate = new Date();
            String formattedDate = new SimpleDateFormat("yyyy-MM-dd     HH:mm:ss").format(currentDate);
            lbltime.setText(formattedDate);
        });
        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lbltime = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setBackground(new java.awt.Color(25, 25, 25));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/closebtn.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbltime.setBackground(new java.awt.Color(51, 51, 51));
        lbltime.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbltime.setForeground(new java.awt.Color(255, 255, 255));
        lbltime.setText("Time");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(14, 246, 204));
        jLabel1.setText("Osudinu Pharmacy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltime, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbltime))
                    .addComponent(jLabel1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        Area area = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        area.add(new Area(new Rectangle2D.Double(0, 20, getWidth(), getHeight())));
        g2.fill(area);
        g2.dispose();
        super.paint(grphcs);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbltime;
    // End of variables declaration//GEN-END:variables
}
