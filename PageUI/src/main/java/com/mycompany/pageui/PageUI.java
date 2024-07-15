/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pageui;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





public class PageUI {
    
    public static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            String url = "jdbc:mysql://localhost:3306/java_user_database";
            String user = "root";
            String password = "";

            try {
                Driver driver = new Driver();
                DriverManager.registerDriver(driver);
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi berhasil");

            } catch (SQLException ex) {
                System.out.println("Koneksi gagal: " + ex.getMessage());
            }
        }
        return conn;
    }



    public static void main(String[] args) {
        
        getConnection();

        loginPage loginPageFrame = new loginPage();
        loginPageFrame.setVisible(true);
        loginPageFrame.pack(); 
        loginPageFrame.setLocationRelativeTo(null);
    }
}
