/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author duyng
 */
public class DBContextMySQL {
    protected Connection connection;

    public DBContextMySQL() {
        try {
            String user = "root";
            String password = "admin";
            String url = "jdbc:mysql://localhost:3306/swp391";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
        }
    }
}
