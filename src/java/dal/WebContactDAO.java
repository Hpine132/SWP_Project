/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.WebContact;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class WebContactDAO extends DBContextMySQL {

    public List<WebContact> testDB() {
        String sql = "select * from web_contact where contact_id=?";
        List<WebContact> result = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, 1);
            //st.setInt(2, 1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                WebContact x = new WebContact(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8));
                result.add(x);
            }
        } catch (SQLException ex) {

        }
        return result;
    }

    public List<WebContact> getContactByCategoryId(int searchValue, String sortBy, String sortType, int pageNumber) {
        String sql = "";
        if (sortBy != null &&!sortBy.equals("")) {
            if (sortBy.equals("category_id")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM web_contact WHERE category_id=? ORDER BY category_id desc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM web_contact WHERE category_id=? ORDER BY category_id asc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("contact_id")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM web_contact WHERE category_id=? ORDER BY contact_id desc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM web_contact WHERE category_id=? ORDER BY contact_id asc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("supporter_id")) {
                if (sortType.equals("asc")) {
                    sql = "SELECT * FROM web_contact WHERE category_id=? ORDER BY supporter_id asc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("desc")) {
                    sql = "SELECT * FROM web_contact WHERE category_id=? ORDER BY supporter_id desc  LIMIT 5 OFFSET ?";
                }
            }

        } else {
            sql = "SELECT * FROM web_contact WHERE category_id=? LIMIT 5 OFFSET ?";
        }
        List<WebContact> result = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            //st.setString(1, searchBy);
            st.setInt(1, searchValue);
            st.setInt(2, pageNumber * 5 - 5);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                WebContact x = new WebContact(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8));
                result.add(x);
            }
        } catch (SQLException ex) {
        }
        return result;

    }

    public List<WebContact> getContactBySupporterId(int searchValue, String sortBy, String sortType, int pageNumber) {
        String sql = "";
        if (sortBy != null&&!sortBy.equals("")) {

            if (sortBy.equals("category_id")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM web_contact WHERE supporter_id=? ORDER BY category_id desc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM web_contact WHERE supporter_id=? ORDER BY category_id asc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("contact_id")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM web_contact WHERE supporter_id=? ORDER BY contact_id desc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM web_contact WHERE supporter_id=? ORDER BY contact_id asc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("supporter_id")) {
                if (sortType.equals("asc")) {
                    sql = "SELECT * FROM web_contact WHERE supporter_id=? ORDER BY supporter_id asc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("desc")) {
                    sql = "SELECT * FROM web_contact WHERE supporter_id=? ORDER BY supporter_id desc  LIMIT 5 OFFSET ?";
                }
            }

        } else {
            sql = "SELECT * FROM web_contact WHERE supporter_id=?  LIMIT 5 OFFSET ?";
        }
        List<WebContact> result = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            //st.setString(1, searchBy);
            st.setInt(1, searchValue);
            st.setInt(2, pageNumber * 5 - 5);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                WebContact x = new WebContact(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8));
                result.add(x);
            }
        } catch (SQLException ex) {
        }
        return result;

    }

    public List<WebContact> getContact(String sortBy, String sortType, int pageNumber) {
        String sql = "";
        if (sortBy != null&&!sortBy.equals("")) {
            if (sortBy.equals("category_id")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM web_contact ORDER BY category_id desc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM web_contact ORDER BY category_id asc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("contact_id")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM web_contact ORDER BY contact_id desc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM web_contact ORDER BY contact_id asc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("supporter_id")) {
                if (sortType.equals("asc")) {
                    sql = "SELECT * FROM web_contact ORDER BY supporter_id asc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("desc")) {
                    sql = "SELECT * FROM web_contact ORDER BY supporter_id desc  LIMIT 5 OFFSET ?";
                }
            }
        } else {
            sql = "SELECT * FROM web_contact LIMIT 5 OFFSET ?";
        }
        List<WebContact> result = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageNumber * 5 - 5);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                WebContact x = new WebContact(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8));
                result.add(x);
            }
        } catch (SQLException ex) {
        }
        return result;
    }
    
    public int countByCategoryId(int value){
        int count=0;
        String sql="select count(*) as numberRecord from web_contact where category_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,value);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                count=rs.getInt(1);
            }
        } catch (SQLException ex) {
        }
        double result=(double)count/5;
        return (int)Math.ceil(result);
    }
    
    public int countBySupporterId(int value){
        int count=0;
        String sql="select count(*) as numberRecord from web_contact where supporter_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,value);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                count=rs.getInt(1);
            }
        } catch (SQLException ex) {
        }
        double result=(double)count/5;
        return (int)Math.ceil(result);
    }
    
    public int count(){
        int count=0;
        String sql="select count(*) as numberRecord from web_contact";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                count=rs.getInt(1);
            }
        } catch (SQLException ex) {
        }
        double result=(double)count/5;
        //return (int)Math.ceil(result);
        return (int)Math.ceil(result);
    }
    
    public WebContact getContactById(int id){
        String sql="select * from web_contact where contact_id=?";
        WebContact result=new WebContact();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                result=new WebContact(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8));
            }
        } catch (SQLException ex) {
        }
        return result;
    }
    
    public void updateContact(int contact_id, int category_id, int supporter_id,  String response){
        String sql="update web_contact set category_id=?, supporter_id=?, response=? where contact_id=? ";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, category_id);
            st.setInt(2, supporter_id);
            st.setString(3, response);
            st.setInt(4, contact_id);
            st.executeUpdate();
        }catch(SQLException ex){            
        }
    }
    
}
