/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Validate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class userDAO extends DBContextMySQL {

    public User Login(String email, String password) {
        String sql = "select * from user where email = ? and password = ?";
        Validate v = new Validate();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, v.SHA256(password));
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User s = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)
                );
                return s;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public User getUser(String email) {
        String sql = "select * from swp391.user where email = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User s = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)
                );
                return s;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public User updateProfile(String email, String name, String address, String company, String position, String mobile, String avatar) {
        String strUpdate = "UPDATE swp391.user \n"
                + "SET full_name = ?,\n"
                + "mobile = ?,\n"
                + "address = ?,\n"
                + "avatar_url = ?,\n"
                + "company = ?,\n"
                + "position = ?\n"
                + "where (email = ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(strUpdate);
            ps.setString(1, name);
            ps.setString(2, mobile);
            ps.setString(3, address);
            ps.setString(4, avatar);
            ps.setString(5, company);
            ps.setString(6, position);
            ps.setString(7, email);
            User u = new userDAO().getUser(email);
            ps.executeUpdate();
            System.out.println("Update success!");
            return new User(u.getId(), name, u.getEmail(), u.getPass(), mobile, address, avatar, company, position, u.getStatus(), u.getNote());
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
        return null;
    }
    
    public void register(String email, String name, String pass) {
        String strUpdate = "INSERT INTO swp391.user (full_name, email, password) VALUES (?, ?, ?);";
        Validate v = new Validate();
        try {
            PreparedStatement ps = connection.prepareStatement(strUpdate);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, v.SHA256(pass));
            User u = new userDAO().getUser(email);
            ps.executeUpdate();
            System.out.println("Update success!");
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
    }
    
     public void ChangPassword(String pass, int id) {
        String sql = "UPDATE user\n"
                + "SET password = ? \n"
                + "WHERE user_id= ? ";
        Validate v = new Validate();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, v.SHA256(pass));
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException ex) {

        }
    }
     
    public User getUserById(int id) {
        String sql = "select * from swp391.user where user_id = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User s = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)
                );
                return s;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
     
     public static void main(String[] args) {
        userDAO u = new userDAO();
        u.register("hehe", "hoa", "12351");
    }
}
