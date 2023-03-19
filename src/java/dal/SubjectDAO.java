/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Subject;

/**
 *
 * @author Admin
 */
public class SubjectDAO extends DBContextMySQL{
    public Subject getSubjectByIdForAssList(int id) {
        String sql = "select * from subject where subject_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Subject s = new Subject(rs.getInt(1), rs.getString(2), rs.getString(3));
                return s;
            }
        } catch (SQLException ex) {

        }
        return null;
    }
    
    public List<Subject> getSubjectList() {
        List<Subject> listSubject = new ArrayList<>();
        String sql = "select * from subject ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);          
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Subject s = new  Subject(rs.getInt(1), rs.getString(2), rs.getString(3));              
                listSubject.add(s);
            }
        } catch (SQLException ex) {

        }
        return listSubject;
    }
    
    public List<Subject> testDB() {
        String sql = "select * from swp391.subject where subject_id = ?";
        List<Subject> result = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, 1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Subject s = new Subject(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7));
                result.add(s);
            }
        } catch (SQLException ex) {

        }
        return result;
    }

    public List<Subject> getSubjectByManagerId(int searchValue, String sortBy, String sortType, int pageNumber) {
        String sql = "";
        if (sortBy != null && !sortBy.equals("")) {
            if (sortBy.equals("manager_id")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM swp391.subject WHERE manager_id = ? ORDER BY manager_id desc LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM swp391.subject WHERE manager_id = ? ORDER BY manager_id asc LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("subject_id")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM swp391.subject WHERE manager_id = ? ORDER BY subject_id desc LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM swp391.subject WHERE manager_id = ? ORDER BY subject_id asc LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("expert_id")) {
                if (sortType.equals("asc")) {
                    sql = "SELECT * FROM swp391.subject WHERE manager_id = ? ORDER BY expert_id asc LIMIT 5 OFFSET ?";
                } else if (sortType.equals("desc")) {
                    sql = "SELECT * FROM swp391.subject WHERE manager_id = ? ORDER BY expert_id desc LIMIT 5 OFFSET ?";
                }
            }
        } else {
            sql = "SELECT * FROM swp391.subject where manager_id = ? LIMIT 5 OFFSET ?";
        }
        List<Subject> result = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, searchValue);
            st.setInt(2, pageNumber * 5 - 5);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Subject s = new Subject(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7));
                result.add(s);
            }
        } catch (SQLException ex) {
        }
        return result;
    }

    public List<Subject> getSubjectByExpertId(int searchValue, String sortBy, String sortType, int pageNumber) {
        String sql = "";
        if (sortBy != null && !sortBy.equals("")) {
            if (sortBy.equals("manager_id")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM swp391.subject WHERE expert_id = ? ORDER BY manager_id desc LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM swp391.subject WHERE expert_id = ? ORDER BY manager_id asc LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("subject_id")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM swp391.subject WHERE expert_id = ? ORDER BY subject_id desc LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM swp391.subject WHERE expert_id = ? ORDER BY subject_id asc LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("expert_id")) {
                if (sortType.equals("asc")) {
                    sql = "SELECT * FROM swp391.subject WHERE expert_id = ? ORDER BY expert_id asc LIMIT 5 OFFSET ?";
                } else if (sortType.equals("desc")) {
                    sql = "SELECT * FROM swp391.subject WHERE expert_id = ? ORDER BY expert_id desc LIMIT 5 OFFSET ?";
                }
            }
        } else {
            sql = "SELECT * FROM swp391.subject WHERE expert_id = ? LIMIT 5 OFFSET ?";
        }
        List<Subject> result = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, searchValue);
            st.setInt(2, pageNumber * 5 - 5);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Subject s = new Subject(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7));
                result.add(s);
            }
        } catch (SQLException ex) {
        }
        return result;
    }

//    public List<Subject> getSubjectByStatus(int searchValue, String sortBy, String sortType, int pageNumber) {
//        String sql = "";
//        if (sortBy != null && !sortBy.equals("")) {
//            if (sortBy.equals("manager_id")) {
//                if (sortType.equals("desc")) {
//                    sql = "SELECT * FROM swp391.subject WHERE status = ? ORDER BY manager_id desc LIMIT 5 OFFSET ?";
//                } else if (sortType.equals("asc")) {
//                    sql = "SELECT * FROM swp391.subject WHERE status = ? ORDER BY manager_id asc LIMIT 5 OFFSET ?";
//                }
//            }
//            if (sortBy.equals("subject_id")) {
//                if (sortType.equals("desc")) {
//                    sql = "SELECT * FROM swp391.subject WHERE status = ? ORDER BY subject_id desc LIMIT 5 OFFSET ?";
//                } else if (sortType.equals("asc")) {
//                    sql = "SELECT * FROM swp391.subject WHERE status = ? ORDER BY subject_id asc LIMIT 5 OFFSET ?";
//                }
//            }
//            if (sortBy.equals("expert_id")) {
//                if (sortType.equals("asc")) {
//                    sql = "SELECT * FROM swp391.subject WHERE status = ? ORDER BY expert_id asc LIMIT 5 OFFSET ?";
//                } else if (sortType.equals("desc")) {
//                    sql = "SELECT * FROM swp391.subject WHERE status = ? ORDER BY expert_id desc LIMIT 5 OFFSET ?";
//                }
//            }
//        } else {
//            sql = "SELECT * FROM swp391.subject WHERE status = ? LIMIT 5 OFFSET ?";
//        }
//        List<Subject> result = new ArrayList<>();
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, searchValue);
//            st.setInt(2, pageNumber * 5 - 5);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                Subject s = new Subject(rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getInt(4),
//                        rs.getInt(5),
//                        rs.getString(6),
//                        rs.getString(7));
//                result.add(s);
//            }
//        } catch (SQLException ex) {
//        }
//        return result;
//    }

    public List<Subject> getSubject(String sortBy, String sortType, int pageNumber) {
        String sql = "";
        if (sortBy != null && !sortBy.equals("")) {
            if (sortBy.equals("manager_id")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM swp391.subject ORDER BY manager_id desc LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM swp391.subject ORDER BY manager_id asc LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("subject_id")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM swp391.subject ORDER BY subject_id desc LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM swp391.subject ORDER BY subject_id asc LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("expert_id")) {
                if (sortType.equals("asc")) {
                    sql = "SELECT * FROM swp391.subject ORDER BY expert_id asc LIMIT 5 OFFSET ?";
                } else if (sortType.equals("desc")) {
                    sql = "SELECT * FROM swp391.subject ORDER BY expert_id desc LIMIT 5 OFFSET ?";
                }
            }
        } else {
            sql = "SELECT * FROM swp391.subject LIMIT 5 OFFSET ?";
        }
        List<Subject> result = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageNumber * 5 - 5);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Subject s = new Subject(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7));
                result.add(s);
            }
        } catch (SQLException ex) {
        }
        return result;
    }

    public int countByManagerId(int value) {
        int count = 0;
        String sql = "select count(*) as numberRecord from swp391.subject where manager_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, value);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
        }
        double result = (double) count / 5;
        return (int) Math.ceil(result);
    }

    public int countByExpertId(int value) {
        int count = 0;
        String sql = "select count(*) as numberRecord from swp391.subject WHERE expert_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, value);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
        }
        double result = (double) count / 5;
        return (int) Math.ceil(result);
    }

    public int count() {
        int count = 0;
        String sql = "select count(*) as numberRecord from swp391.subject";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
        }
        double result = (double) count / 5;
        return (int) Math.ceil(result);
    }

    public Subject getSubjectById(int id) {
        String sql = "select * from swp391.subject where subject_id = ?";
        Subject result = new Subject();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                result = new Subject(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        } catch (SQLException ex) {
        }
        return result;
    }
    
    
    
    
    
    public void updateSubject(int id, String subject_code, String subject_name, int manager_id, int expert_id, String status, String description ){
        String sql="update subject set subject_code=?, subject_name=?, manager_id=?, expert_id=?, status=?, description=? where subject_id=? ";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, subject_code);
            st.setString(2, subject_name);
            st.setInt(3, manager_id);
            st.setInt(4, expert_id);
            st.setString(5, status);
            st.setString(6, description);
            st.setInt(7,id);
            st.executeUpdate();
        }catch(SQLException ex){            
        }
    }
}
