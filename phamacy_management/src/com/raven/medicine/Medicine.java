 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.medicine;


//import com.raven.login.MyConnection;
import com.raven.medicine.MedicineConnection;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.*;
//import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.sql.Date;
import java.sql.Connection;
import java.sql.Types;
import java.time.format.DateTimeFormatter;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public final class Medicine extends javax.swing.JPanel {

      Connection con;
    PreparedStatement pst;
    ResultSet rs; 
    
public Medicine() {
        initComponents();
        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        setOpaque(false);
        loadData1();
        FillCombo();
      
          LocalDate currentDate = LocalDate.now();
        jDateChooser2.getJCalendar().setMinSelectableDate(Date.valueOf(currentDate));

    }
public  void FillCombo() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy" ,"root", "");
            String  Query = " SELECT name FROM `manufacturer`";
            Statement st = con.createStatement();
            pst = con.prepareStatement(Query);
            rs = st.executeQuery(Query);
            
            while(rs.next()){
                jComboBox1.addItem(rs.getString("name"));
            }   } catch (SQLException ex) {
            Logger.getLogger(Medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();;
                pst.close();;
                rs.close();;
            } catch (SQLException ex) {
                Logger.getLogger(Medicine.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
}

    private boolean isIdExists(String id) {
        String url = "jdbc:mysql://localhost:3306/pharmacy";
        String user = "root";
        String password = "";

        String query = "SELECT COUNT(*) AS count FROM `medicine` WHERE mid = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
public void hi()
{ loadData1();
}
     public void loadData1() {
        String url = "jdbc:mysql://localhost:3306/pharmacy";
        String user = "root";
        String password = "";

        String query = "SELECT mid, mname, price, quantity, dosage, purchus, dtype, dweight, expdate, manufacturer FROM `medicine`";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("MEDICINE ID");
            model.addColumn("MEDICINE NAME");
            model.addColumn("PRICE");
            model.addColumn("QUANTITY");
            model.addColumn("DOSAGE FORMS");
            model.addColumn("PURCHDATE");
            model.addColumn("DOSAGE TYPE");
            model.addColumn("DOSAGE WEIGHTS");
            model.addColumn("EXPDATE");
            model.addColumn("MANUFACTURER");

            while (resultSet.next()) {
                String mid = resultSet.getString("mid");
                String mname = resultSet.getString("mname");
                String price = resultSet.getString("price");
                String quantity = resultSet.getString("quantity");
                String dosage = resultSet.getString("dosage");
                String purchus = resultSet.getString("purchus");
                String dtype = resultSet.getString("dtype");
                String dweight = resultSet.getString("dweight");
                String expdate = resultSet.getString("expdate");
                String manufacturer = resultSet.getString("manufacturer");
                model.addRow(new Object[]{mid, mname, price, quantity, dosage, purchus, dtype, dweight, expdate, manufacturer});
            }

            jTable1.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Your GUI setup and other methods would go here
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create and show your GUI here
        });
    
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField5 = new javax.swing.JTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        roundPanel3 = new com.raven.swing.RoundPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        roundPanel2 = new com.raven.swing.RoundPanel();
        roundPanel4 = new com.raven.swing.RoundPanel();
        jLabel9 = new javax.swing.JLabel();
        roundPanel5 = new com.raven.swing.RoundPanel();
        jTextField6 = new javax.swing.JTextField();
        roundPanel6 = new com.raven.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(14, 246, 204));
        jLabel1.setText("MANAGE MEDICINE");

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MEDICINE ID");

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MEDICINE NAME");

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PRICE");

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DOSAGE WEIGHTS");

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("QUANTITY");

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("EXPDATE");

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("MANUFACTURER");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("DOSAGE FORMS");

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-", "Tablets", "Capsules", "Syrups", "Creams", "Ointments", "Gels", "Powder", "Patches", "Decoctions" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(51, 51, 51));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DOSAGE TYPE");

        jComboBox3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select-", "mg", "g", "ml" }));

        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jDateChooser2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap(188, Short.MAX_VALUE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(43, 43, 43)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3)
                    .addComponent(jTextField2)
                    .addComponent(jTextField1)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106))
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel2))
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        roundPanel3.setBackground(new java.awt.Color(58, 79, 80));

        jButton2.setBackground(new java.awt.Color(14, 246, 204));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(14, 246, 204));
        jButton3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton3.setText("DELETE");
        jButton3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(14, 246, 204));
        jButton4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton4.setText("CLEAR");
        jButton4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(14, 246, 204));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton1.setText("ADD");
        jButton1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
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
                .addGap(180, 180, 180)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel2.setPreferredSize(new java.awt.Dimension(780, 66));

        roundPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("MEDICINES LIST");

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        roundPanel5.setBackground(new java.awt.Color(58, 79, 80));

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel6.setBackground(new java.awt.Color(0, 0, 0));

        jTable1.setBackground(new java.awt.Color(223, 248, 243));
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 153, 153));
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
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setRowHeight(40);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout roundPanel6Layout = new javax.swing.GroupLayout(roundPanel6);
        roundPanel6.setLayout(roundPanel6Layout);
        roundPanel6Layout.setHorizontalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        roundPanel6Layout.setVerticalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addComponent(roundPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String mid = jTextField1.getText();
String name = jTextField2.getText();
String price = jTextField3.getText();
String quantity = jTextField4.getText();
String cho = jComboBox2.getSelectedItem().toString();
String dtype = jComboBox3.getSelectedItem().toString();
String dweight = jTextField5.getText();
String expdateText = ((JTextField) jDateChooser2.getDateEditor().getUiComponent()).getText();
String manufacturer = jComboBox1.getSelectedItem().toString();

if (isIdExists(mid)) {
    JOptionPane.showMessageDialog(null, "Medicine with ID " + mid + " already exists.", "WARNING MESSAGE", JOptionPane.INFORMATION_MESSAGE);
    return;
}

if (name.isEmpty() || price.isEmpty() || quantity.isEmpty() || manufacturer.isEmpty() || cho.isEmpty() || dtype.isEmpty() || dweight.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Please fill all fields.", "WARNING MESSAGE", JOptionPane.INFORMATION_MESSAGE);
} else if (!isNumeric(dweight)) {
    JOptionPane.showMessageDialog(null, "Weight must be a valid numeric value.", "WARNING MESSAGE", JOptionPane.INFORMATION_MESSAGE);
}  else if (cho.equals("-Select-") || dtype.equals("-Select-")) {
    JOptionPane.showMessageDialog(null, "Please select a valid choice and type.", "WARNING MESSAGE", JOptionPane.INFORMATION_MESSAGE);
} else if (!isNumeric(price) || !isNumeric(quantity) || !isNumeric(dweight)) {
    JOptionPane.showMessageDialog(null, "Please provide valid numeric values for price, quantity, and weight.", "WARNING MESSAGE", JOptionPane.INFORMATION_MESSAGE);
}
 else {
    try {
        Connection con = MedicineConnection.getConnection();
        String query = "INSERT INTO `medicine`(`mid`,`mname`, `price`, `quantity`, `dosage`, `purchus`, `dtype`, `dweight`, `expdate`, `manufacturer`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, mid);
        ps.setString(2, name);
        ps.setString(3, price);
        ps.setString(4, quantity);
        ps.setString(5, cho);
        LocalDate today = LocalDate.now();
        ps.setDate(6, Date.valueOf(today));
        ps.setString(7, dtype);
        ps.setString(8, dweight);

        if (!expdateText.isEmpty()) {
           LocalDate expDate = LocalDate.parse(expdateText, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        ps.setDate(9, Date.valueOf(expDate));
        } else {
            ps.setNull(9, Types.DATE);
        }

        ps.setString(10, manufacturer);

        int row_count = ps.executeUpdate();
        if (row_count > 0) {
            JOptionPane.showMessageDialog(null, "Added", "Add", JOptionPane.INFORMATION_MESSAGE);
            new Medicine().setVisible(true);
           loadData1();

            jTextField1.setText(""); // Clear the ID field
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
            jComboBox1.setSelectedIndex(0);
            jComboBox2.setSelectedIndex(0);
            jComboBox3.setSelectedIndex(0);
            jDateChooser2.setDate(null);
        }
        
        ps.close();
        con.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
   // loadData();
}

   
    }//GEN-LAST:event_jButton1ActionPerformed
   public static boolean isNumeric(String str) {
    if (str == null) {
        return false;
    }
    try {
        Double.parseDouble(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

    
    
    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
       
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel tblModel = (DefaultTableModel)jTable1.getModel();
        
        String tblid = tblModel.getValueAt(jTable1.getSelectedRow(), 0).toString();
        String tblname = tblModel.getValueAt(jTable1.getSelectedRow(), 1).toString();
        String tblprice = tblModel.getValueAt(jTable1.getSelectedRow(), 2).toString();
        String tblqty = tblModel.getValueAt(jTable1.getSelectedRow(), 3).toString();
        String tblwei = tblModel.getValueAt(jTable1.getSelectedRow(), 7).toString();
        
        jTextField1.setText(tblid);
        jTextField2.setText(tblname);
        jTextField3.setText(tblprice);
        jTextField4.setText(tblqty);
        jTextField5.setText(tblwei);
        
        
        String tbldos = tblModel.getValueAt(jTable1.getSelectedRow() , 9).toString();
        for(int i = 0; i < jComboBox1.getItemCount(); i++){
            if(jComboBox1.getItemAt(i).toString().equalsIgnoreCase(tbldos)){
                jComboBox1.setSelectedIndex(i);
            }
        }
        
        String tbldosty = tblModel.getValueAt(jTable1.getSelectedRow() , 4).toString();
        for(int i = 0; i < jComboBox2.getItemCount(); i++){
            if(jComboBox2.getItemAt(i).toString().equalsIgnoreCase(tbldosty)){
                jComboBox2.setSelectedIndex(i);
            }
        }
        
        String tbldoswe = tblModel.getValueAt(jTable1.getSelectedRow() , 6).toString();
        for(int i = 0; i < jComboBox3.getItemCount(); i++){
            if(jComboBox3.getItemAt(i).toString().equalsIgnoreCase(tbldoswe)){
                jComboBox3.setSelectedIndex(i);
            }
        }
        String tbldate = tblModel.getValueAt(jTable1.getSelectedRow(), 8).toString();
        try {
            if (!tbldate.isEmpty()) {
                java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tbldate);
                jDateChooser2.setDate(date);
            } else {
                jDateChooser2.setDate(null);
            }
        } catch (ParseException ex) {
            Logger.getLogger(Medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    

   
    
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   String mid = jTextField1.getText();
    String name = jTextField2.getText();
    String price = jTextField3.getText();
    String qty = jTextField4.getText();
    String dosa = jComboBox2.getSelectedItem().toString();
    String dosat = jComboBox3.getSelectedItem().toString();
    String weight = jTextField5.getText();

    // Get the selected date from the JDateChooser and convert it to java.sql.Date
    java.util.Date selectedDate = jDateChooser2.getDate();
    java.sql.Date expd = (selectedDate != null) ? new java.sql.Date(selectedDate.getTime()) : null;

    String manu = jComboBox1.getSelectedItem().toString();

    // Validate fields before updating
   if (name.isEmpty() || price.isEmpty() || qty.isEmpty() || manu.isEmpty() || dosa.isEmpty() || dosat.isEmpty() || weight.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Please fill all fields.", "WARNING MESSAGE", JOptionPane.INFORMATION_MESSAGE);
} else if (!isNumeric(weight)) {
    JOptionPane.showMessageDialog(null, "Weight must be a valid numeric value.", "WARNING MESSAGE", JOptionPane.INFORMATION_MESSAGE);
}  else if (dosa.equals("-Select-") || dosat.equals("-Select-")) {
        JOptionPane.showMessageDialog(null, "Please select a valid choice and type.", "WARNING MESSAGE", JOptionPane.INFORMATION_MESSAGE);
    } else if (!isNumeric(price) || !isNumeric(qty) || !isNumeric(weight)) {
        JOptionPane.showMessageDialog(null, "Please provide valid numeric values for price, quantity, and weight.", "WARNING MESSAGE", JOptionPane.INFORMATION_MESSAGE);
    } else {
        try {
            Connection con = MedicineConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement("UPDATE medicine SET mname=?, price=?, quantity= quantity + ?, dosage=?, dtype=?, dweight=?, expdate=?, manufacturer=? WHERE mid=?");
            pstmt.setString(1, name);
            pstmt.setString(2, price);
            pstmt.setString(3, qty);
            pstmt.setString(4, dosa);
            pstmt.setString(5, dosat);
            pstmt.setString(6, weight);
            pstmt.setDate(7, expd);
            pstmt.setString(8, manu);
            pstmt.setString(9, mid); // Set the mid for the WHERE clause

            int row_count = pstmt.executeUpdate();
            if (row_count > 0) {
                JOptionPane.showMessageDialog(null, "Updated", "Update", JOptionPane.INFORMATION_MESSAGE);
                new Medicine().setVisible(true);

                // Clear fields
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");

                // Clear combo boxes
                jComboBox1.setSelectedIndex(0);
                jComboBox2.setSelectedIndex(0);
                jComboBox3.setSelectedIndex(0);

                // Clear JDateChooser
                jDateChooser2.setDate(null);

                loadData1();
            }
            pstmt.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
}
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField5.setText("");

    // Clear combo boxes
    jComboBox1.setSelectedIndex(0);
    jComboBox2.setSelectedIndex(0);
    jComboBox3.setSelectedIndex(0);

    // Clear JDateChooser
    jDateChooser2.setDate(null);
    
     new Medicine().setVisible(true);
           loadData1();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       int row = jTable1.getSelectedRow();
    if (row == -1) {
        JOptionPane.showMessageDialog(null, "Please select a row to delete.", "Delete Error", JOptionPane.ERROR_MESSAGE);
        return; // Stop the delete operation if no row is selected
    }

    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String id = jTable1.getValueAt(row, 0).toString();
        try {
            Connection con = MedicineConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM medicine WHERE mid=?");
            pstmt.setString(1, id);
            int row_count = pstmt.executeUpdate();
            if (row_count > 0) {
                JOptionPane.showMessageDialog(null, "Record Deleted Successfully", "Delete", JOptionPane.INFORMATION_MESSAGE);
                  jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField5.setText("");

    // Clear combo boxes
    jComboBox1.setSelectedIndex(0);
    jComboBox2.setSelectedIndex(0);
    jComboBox3.setSelectedIndex(0);
                new Medicine().setVisible(true);
                 loadData1();
            }
            pstmt.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
   // loadData();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        String searchString = jTextField6.getText();
       search(searchString);
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    DefaultTableModel model = null;
    public void search(String str){
        model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        jTable1.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.RoundPanel roundPanel3;
    private com.raven.swing.RoundPanel roundPanel4;
    private com.raven.swing.RoundPanel roundPanel5;
    private com.raven.swing.RoundPanel roundPanel6;
    // End of variables declaration//GEN-END:variables
}
