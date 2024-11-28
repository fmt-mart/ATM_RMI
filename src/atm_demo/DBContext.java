/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class DBContext {

    public Connection getConnection() {
        // URL kết nối tới SQL Server
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyTaiKhoan;user=sa;password=123456;encrypt=true;trustServerCertificate=true";

        Connection conn = null;
        try {
            // Tải driver JDBC cho SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Tạo kết nối tới SQL Server
            conn = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
        }
        return conn;
    }
    
    public static void main(String[] args) {
        DBContext conn = new DBContext();
        System.out.println("Dang nhap thanh cong: " + conn.getConnection());
    }
}
