package com.raven.form;

import com.mysql.cj.protocol.Resultset;
import com.raven.chart.ModelChart;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class Form_1 extends javax.swing.JPanel {
    private double today_invoices ;
    private double today_price ;

    public Form_1() {
        initComponents();
        setOpaque(false);
        init();
        setincometable();
        loadexpier();
        loadlowstock();
        revinew();
        recenttbl();
    }

    Resultset rs;
    private void init() {
        //chart.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
        //chart.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
        //chart.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
        //chart.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
        //chart.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
        //chart.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
        //chart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
        //chart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
        //chart.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
        //chart.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        //chart.start();
        //lineChart.addLegend("Income", new Color(186, 37, 37), new Color(241, 100, 120));
        //lineChart.addData(new ModelChart("January", new double[]{20, 200, 80, 89}));
        //lineChart.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
        //lineChart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
        //lineChart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
        //lineChart.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
        //lineChart.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        //lineChart.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        //lineChart.start();
    }
    
    private void recenttbl() {
            String url = "jdbc:mysql://localhost:3306/pharmacy";
            String user = "root";
            String pass = "";
            
            try {
            Connection con = java.sql.DriverManager.getConnection(url, user, pass);
            PreparedStatement p = con.prepareStatement("SELECT * From invoice LIMIT 10");
            ResultSet r = p.executeQuery();
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Invoice ID");
            model.addColumn("Total");
            
            while (r.next()) {
                String nid = r.getString("id");
                String ntot = r.getString("total");
                model.addRow(new Object[]{nid, ntot});
            }
            tableDark3.setModel(model);
            r.close();
            p.close();
            } catch (SQLException e) {
            e.printStackTrace();
            }
    }
    
    private void setincometable(){
            String url = "jdbc:mysql://localhost:3306/pharmacy";
            String user = "root";
            String pass = "";
            
            try {
            Connection con = java.sql.DriverManager.getConnection(url, user, pass);
            PreparedStatement p = con.prepareStatement("SELECT MONTH(date) AS month, YEAR(date) AS year, SUM(total) AS total_income FROM invoice WHERE YEAR(date) = YEAR(CURDATE()) GROUP BY MONTH(date), YEAR(date) ORDER BY YEAR(date), MONTH(date);");
            ResultSet r = p.executeQuery();
            lineChart.addLegend("Income", new Color(186, 37, 37), new Color(241, 100, 120));
            while (r.next()) {
                String total = r.getString("total_income");
                double Income = Double.parseDouble(total);
                String month = r.getString("month");
                if (month.equals("1")){
                    lineChart.addData(new ModelChart("January", new double[]{Income, 200, 80, 89}));
                } else if(month.equals("2")) {
                lineChart.addData(new ModelChart("February", new double[]{Income, 200, 80, 89}));
                } else if(month.equals("3")) {
                lineChart.addData(new ModelChart("March", new double[]{Income, 200, 80, 89}));
                } else if(month.equals("4")) {
                lineChart.addData(new ModelChart("April", new double[]{Income, 200, 80, 89}));
                } else if(month.equals("5")) {
                lineChart.addData(new ModelChart("May", new double[]{Income, 200, 80, 89}));
                } else if(month.equals("6")) {
                lineChart.addData(new ModelChart("June", new double[]{Income, 200, 80, 89}));
                } else if(month.equals("7")) {
                lineChart.addData(new ModelChart("July", new double[]{Income, 200, 80, 89}));
                } else if(month.equals("8")) {
                lineChart.addData(new ModelChart("August", new double[]{Income, 200, 80, 89}));
                } else if(month.equals("9")) {
                lineChart.addData(new ModelChart("September", new double[]{Income, 200, 80, 89}));
                } else if(month.equals("10")) {
                lineChart.addData(new ModelChart("October", new double[]{Income, 200, 80, 89}));
                } else if(month.equals("11")) {
                lineChart.addData(new ModelChart("November", new double[]{Income, 200, 80, 89}));
                } else if(month.equals("12")) {
                lineChart.addData(new ModelChart("December", new double[]{Income, 200, 80, 89}));
                }
            }
            lineChart.start();
            r.close();
            p.close();
            }catch (SQLException e) {
            e.printStackTrace();
            }
    }
    
    private void revinew(){
            String url = "jdbc:mysql://localhost:3306/pharmacy";
            String user = "root";
            String pass = "";
        try {
            Connection con = java.sql.DriverManager.getConnection(url, user, pass);
            PreparedStatement p = con.prepareStatement("SELECT SUM(total) AS total_price FROM invoice WHERE DATE(date) = CURDATE();");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String total_price = r.getString("total_price");
                if (total_price == null) {
                    today_price=0.0;
                   lbltodayre.setText("Rs 0");
                } else {
                  lbltodayre.setText("Rs "+total_price);
                   today_price=Double.parseDouble(total_price);
                }
            }
            p.close();
            p = con.prepareStatement("SELECT SUM(total) AS total_price FROM invoice WHERE WEEK(date) = WEEK(CURDATE() - INTERVAL 7 DAY) AND YEAR(date) = YEAR(CURDATE() - INTERVAL 7 DAY);");
            r = p.executeQuery();
            while (r.next()) {
                double lw_price = Double.parseDouble(r.getString("total_price"));
                System.out.println(lw_price);
                if(lw_price == 0.0){
                    //lw_price=0.0;
                    lbltrf.setText("No data yet");
                }else {
                 double percentage_difference = ((today_price - lw_price) / lw_price) * 100;
                if (percentage_difference > 0 && percentage_difference < 100) {
                    //Double.toString(percentage_difference);
                   lbltrf.setText(String.format("%.2f%%", percentage_difference)+" vs last week");
                   lbltrf.setForeground(Color.GREEN);
                } else if (percentage_difference < 0 && percentage_difference > -100) {
                  lbltrf.setText(String.format("%.2f%%", percentage_difference)+" vs last week");
                   lbltrf.setForeground(Color.RED);
                }else {
                    lbltrf.setText("No data yet");
                }}
            }p.close();
            p = con.prepareStatement("SELECT SUM(total) AS total_price FROM invoice WHERE WEEK(date) = WEEK(CURDATE()) AND YEAR(date) = YEAR(CURDATE());");
            r = p.executeQuery();
            while (r.next()) {
                String total_price = r.getString("total_price");
                if (total_price == null) {
                   lblweekre.setText("Rs 0");
                } else {
                  lblweekre.setText("Rs "+total_price);
                }
            }p.close();
            p = con.prepareStatement("SELECT COUNT(*) AS total_invoices FROM invoice WHERE WEEK(date) = WEEK(CURDATE()) AND YEAR(date) = YEAR(CURDATE());");
            r = p.executeQuery();
            while (r.next()) {
                String total_invo = r.getString("total_invoices");
                if (total_invo == null) {
                   lblweeksales.setText("0");
                } else {
                  lblweeksales.setText(total_invo);
                }
            }p.close();
            p = con.prepareStatement("SELECT COUNT(*) AS total_invoices FROM invoice WHERE DATE(date) = CURDATE();");
            r = p.executeQuery();
            while (r.next()) {
                String total_invo = r.getString("total_invoices");
                if (total_invo == null) {
                    today_invoices=0.0;
                   lbltodaysales.setText("0");
                } else {
                  lbltodaysales.setText(total_invo);
                  today_invoices=Double.parseDouble(total_invo);
                }
            }p.close();
            p = con.prepareStatement("SELECT COUNT(*) AS last_week_invoices FROM invoice WHERE WEEK(date) = WEEK(CURDATE() - INTERVAL 7 DAY) AND YEAR(date) = YEAR(CURDATE() - INTERVAL 7 DAY);");
            r = p.executeQuery();
            while (r.next()) {
                double lw_invo = Double.parseDouble(r.getString("last_week_invoices"));
                 double percentage_difference = ((today_invoices - lw_invo) / lw_invo) * 100;
                        //System.out.println(percentage_difference);
                if (percentage_difference > 0 && percentage_difference < 100) {
                    //Double.toString(percentage_difference);
                   jLabel15.setText(String.format("%.2f%%", percentage_difference)+" vs last week");
                   jLabel15.setForeground(Color.GREEN);
                } else if (percentage_difference < 0 && percentage_difference > -100) {
                  jLabel15.setText(String.format("%.2f%%", percentage_difference)+" vs last week");
                   jLabel15.setForeground(Color.RED);
                }else {
                    jLabel15.setText("No data yet");
                }
            }p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void loadexpier() {
        String url = "jdbc:mysql://localhost:3306/pharmacy";
        String user = "root";
        String password = "";

        String query = "SELECT mid, mname, quantity, expdate FROM medicine WHERE expdate BETWEEN NOW() AND DATE_ADD(NOW(), INTERVAL 1 MONTH)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("MEDICINE ID");
            model.addColumn("MEDICINE NAME");
            model.addColumn("QUANTITY");
            model.addColumn("Exp Date");

            while (resultSet.next()) {
                String mid = resultSet.getString("mid");
                String mname = resultSet.getString("mname");
                String quantity = resultSet.getString("quantity");
                String expdate = resultSet.getString("expdate");
                model.addRow(new Object[]{mid, mname, quantity, expdate});
            }
            tableDark1.setModel(model);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    

}
    
    private void loadlowstock() {
        String url = "jdbc:mysql://localhost:3306/pharmacy";
        String user = "root";
        String password = "";
        String st = (String) stcombox.getSelectedItem();
        //System.out.println(st);
        String query = "SELECT * FROM medicine WHERE CAST(quantity AS UNSIGNED) < '"+st+"';";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("MED ID");
            model.addColumn("MED NAME");
            model.addColumn("QUN");
            model.addColumn("MANUFACTURE");
            model.addColumn("Price per dos");

            while (resultSet.next()) {
                String mid = resultSet.getString("mid");
                String mname = resultSet.getString("mname");
                String quantity = resultSet.getString("quantity");
                String manu = resultSet.getString("manufacturer");
                String pric = resultSet.getString("price");
                System.out.println(pric);
                model.addRow(new Object[]{mid, mname, quantity, manu, pric});
            }
            tableDark2.setModel(model);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
System.out.println("Vada vada");
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        jLabel2 = new javax.swing.JLabel();
        roundPanel7 = new com.raven.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        lblweekre = new javax.swing.JLabel();
        lblwrf = new javax.swing.JLabel();
        roundPanel8 = new com.raven.swing.RoundPanel();
        jLabel7 = new javax.swing.JLabel();
        lblweeksales = new javax.swing.JLabel();
        lblwsf = new javax.swing.JLabel();
        roundPanel9 = new com.raven.swing.RoundPanel();
        jLabel10 = new javax.swing.JLabel();
        lbltodayre = new javax.swing.JLabel();
        lbltrf = new javax.swing.JLabel();
        roundPanel10 = new com.raven.swing.RoundPanel();
        jLabel13 = new javax.swing.JLabel();
        lbltodaysales = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        roundPanel2 = new com.raven.swing.RoundPanel();
        roundPanel4 = new com.raven.swing.RoundPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableDark1 = new com.raven.form.TableDark();
        jLabel5 = new javax.swing.JLabel();
        roundPanel5 = new com.raven.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDark2 = new com.raven.form.TableDark();
        jLabel6 = new javax.swing.JLabel();
        stcombox = new javax.swing.JComboBox<>();
        roundPanel6 = new com.raven.swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDark3 = new com.raven.form.TableDark();
        roundPanel3 = new com.raven.swing.RoundPanel();
        lineChart = new com.raven.chart.LineChart();

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(220, 220, 220));
        jLabel2.setText("Report");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        roundPanel7.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("This week Revenue");

        lblweekre.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblweekre.setForeground(new java.awt.Color(255, 255, 255));
        lblweekre.setText("Rs 2323");

        lblwrf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblwrf.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout roundPanel7Layout = new javax.swing.GroupLayout(roundPanel7);
        roundPanel7.setLayout(roundPanel7Layout);
        roundPanel7Layout.setHorizontalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblweekre)
                    .addComponent(lblwrf))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel7Layout.setVerticalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(lblweekre)
                .addGap(2, 2, 2)
                .addComponent(lblwrf)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel8.setBackground(new java.awt.Color(102, 102, 102));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("This week Sales");

        lblweeksales.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblweeksales.setForeground(new java.awt.Color(255, 255, 255));
        lblweeksales.setText("Rs 2323");

        lblwsf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblwsf.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout roundPanel8Layout = new javax.swing.GroupLayout(roundPanel8);
        roundPanel8.setLayout(roundPanel8Layout);
        roundPanel8Layout.setHorizontalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(lblweeksales)
                    .addComponent(lblwsf))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel8Layout.setVerticalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel8Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addComponent(lblweeksales)
                .addGap(1, 1, 1)
                .addComponent(lblwsf)
                .addContainerGap())
        );

        roundPanel9.setBackground(new java.awt.Color(102, 102, 102));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Today's Revenue");

        lbltodayre.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbltodayre.setForeground(new java.awt.Color(255, 255, 255));
        lbltodayre.setText("Rs 2323");

        lbltrf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbltrf.setForeground(new java.awt.Color(204, 204, 204));
        lbltrf.setText("2.34% vs. last week");

        javax.swing.GroupLayout roundPanel9Layout = new javax.swing.GroupLayout(roundPanel9);
        roundPanel9.setLayout(roundPanel9Layout);
        roundPanel9Layout.setHorizontalGroup(
            roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(lbltodayre)
                    .addComponent(lbltrf))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel9Layout.setVerticalGroup(
            roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(1, 1, 1)
                .addComponent(lbltodayre)
                .addGap(2, 2, 2)
                .addComponent(lbltrf)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel10.setBackground(new java.awt.Color(102, 102, 102));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Today's Sales");

        lbltodaysales.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbltodaysales.setForeground(new java.awt.Color(255, 255, 255));
        lbltodaysales.setText("Rs 2323");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("2.34% vs. last week");

        javax.swing.GroupLayout roundPanel10Layout = new javax.swing.GroupLayout(roundPanel10);
        roundPanel10.setLayout(roundPanel10Layout);
        roundPanel10Layout.setHorizontalGroup(
            roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(lbltodaysales)
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel10Layout.setVerticalGroup(
            roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(1, 1, 1)
                .addComponent(lbltodaysales)
                .addGap(2, 2, 2)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roundPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roundPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roundPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roundPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));

        roundPanel4.setBackground(new java.awt.Color(0, 0, 0));

        tableDark1.setBackground(new java.awt.Color(51, 51, 51));
        tableDark1.setModel(new javax.swing.table.DefaultTableModel(
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
        tableDark1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tableDark1.setRowHeight(40);
        jScrollPane3.setViewportView(tableDark1);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Expire Soon...");

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel5.setBackground(new java.awt.Color(0, 0, 0));

        tableDark2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableDark2);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("Low Stock");

        stcombox.setBackground(new java.awt.Color(51, 51, 51));
        stcombox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        stcombox.setForeground(new java.awt.Color(255, 255, 255));
        stcombox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10 (Default)", "20", "50", "100" }));
        stcombox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stcomboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                    .addGroup(roundPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stcombox, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(stcombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel6.setBackground(new java.awt.Color(0, 0, 0));

        tableDark3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableDark3);

        javax.swing.GroupLayout roundPanel6Layout = new javax.swing.GroupLayout(roundPanel6);
        roundPanel6.setLayout(roundPanel6Layout);
        roundPanel6Layout.setHorizontalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        roundPanel6Layout.setVerticalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel3.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lineChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void stcomboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stcomboxActionPerformed
        // TODO add your handling code here:
        loadlowstock();
    }//GEN-LAST:event_stcomboxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbltodayre;
    private javax.swing.JLabel lbltodaysales;
    private javax.swing.JLabel lbltrf;
    private javax.swing.JLabel lblweekre;
    private javax.swing.JLabel lblweeksales;
    private javax.swing.JLabel lblwrf;
    private javax.swing.JLabel lblwsf;
    private com.raven.chart.LineChart lineChart;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel10;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.RoundPanel roundPanel3;
    private com.raven.swing.RoundPanel roundPanel4;
    private com.raven.swing.RoundPanel roundPanel5;
    private com.raven.swing.RoundPanel roundPanel6;
    private com.raven.swing.RoundPanel roundPanel7;
    private com.raven.swing.RoundPanel roundPanel8;
    private com.raven.swing.RoundPanel roundPanel9;
    private javax.swing.JComboBox<String> stcombox;
    private com.raven.form.TableDark tableDark1;
    private com.raven.form.TableDark tableDark2;
    private com.raven.form.TableDark tableDark3;
    // End of variables declaration//GEN-END:variables
}
