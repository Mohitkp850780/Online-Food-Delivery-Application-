/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yumxpress.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author AMAN JHA
 */
public class DBConnection {
     private static Connection conn;
     static
     { 
          try
        {
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//Aman:1521/xe","yumxpress","foodie");
            JOptionPane.showMessageDialog(null,"Connected successfully to the DB");
        }catch(SQLException ex){
               JOptionPane.showMessageDialog(null,"cannot connect to the DB"); 
                ex.printStackTrace();
        }
        
     }
     public static Connection getConnection()
     {
         return conn;
     }
     public static void closeConnection()
     {
         try
         {
             conn.close();
             JOptionPane.showMessageDialog(null,"DisConnected successfully to the DB");
         }
          catch(SQLException ex)
        {
               JOptionPane.showMessageDialog(null,"cannot disconnect with the DB"); 
                ex.printStackTrace();
        }
        
         
         
     }
     
    
    
}
