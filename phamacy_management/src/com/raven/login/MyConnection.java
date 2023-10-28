
package com.raven.login;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Inoth
 */
public class MyConnection {
     public static Connection getConnection(){
     
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "");
               
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }

    static Connection getCon() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
