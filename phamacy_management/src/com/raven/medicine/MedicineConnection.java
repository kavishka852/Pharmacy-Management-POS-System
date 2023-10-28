/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.medicine;

import com.raven.login.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Inoth
 */
public class MedicineConnection {
     public static Connection getConnection() {
    Connection con = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/pharmacy", "root", "");
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
   
      return con;
  }
}
