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
import model.Class;
import model.User;

/**
 *
 * @author User
 */
public class ClassDAO extends DBContextMySQL {

    public Class getClassById(int id) {
        String sql = "select * from class where class_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            settingDAO c = new settingDAO();
            while (rs.next()) {
                Class x = new Class(rs.getInt(1), rs.getString(2), rs.getInt(3), getUserById(rs.getInt(4)), c.getSettingById(rs.getInt(5)), rs.getString(6), rs.getString(7));
                return x;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public Class getClassByCode(String code) {
        String sql = "select * from class where class_code like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, code);
            ResultSet rs = st.executeQuery();
            settingDAO c = new settingDAO();
            while (rs.next()) {
                Class x = new Class(rs.getInt(1), rs.getString(2), rs.getInt(3), getUserById(rs.getInt(4)), c.getSettingById(rs.getInt(5)), rs.getString(6), rs.getString(7));
                return x;
            }
        } catch (SQLException e) {
        }
        return null;
    }
    
    public User getUserById(int id) {
        String sql = "select * from swp391.user where user_id=?";
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

    public List<User> getUserByRole(int roleId) {
        List<User> result = new ArrayList<>();
        String sql = "SELECT * FROM swp391.user as U join user_role as R on U.user_id=R.user_id_FK where R.user_setting=?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, roleId);
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
                result.add(s);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }

    public List<Class> getClass(int page, String sortBy, String sortType) {
        String sql = "";
        if (sortBy != null && !sortBy.equals("")) {
            if (sortBy.equals("code")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class ORDER BY class_code desc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class ORDER BY class_code asc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("term")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class ORDER BY term_id desc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class ORDER BY term_id asc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("trainer")) {
                if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class ORDER BY trainer_id asc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class ORDER BY trainer_id desc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("status")) {
                if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class ORDER BY status asc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class ORDER BY status desc  LIMIT 5 OFFSET ?";
                }
            }

        } else {
            sql = "SELECT * FROM class LIMIT 5 OFFSET ?";
        }
        List<Class> result = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            //st.setString(1, searchBy);
            st.setInt(1, page * 5 - 5);
            ResultSet rs = st.executeQuery();
            settingDAO c = new settingDAO();
            while (rs.next()) {
                Class x = new Class(rs.getInt(1), rs.getString(2), rs.getInt(3), getUserById(rs.getInt(4)), c.getSettingById(rs.getInt(5)), rs.getString(6), rs.getString(7));
                result.add(x);
            }
        } catch (SQLException ex) {
        }
        return result;
    }

    public List<Class> getClassByCode(int page, String searchValue, String sortBy, String sortType) {
        String sql = "";
        if (sortBy != null && !sortBy.equals("")) {
            if (sortBy.equals("code")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class WHERE class_code like ? ORDER BY class_code desc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class WHERE class_code like ? ORDER BY class_code asc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("term")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class WHERE class_code like ? ORDER BY term_id desc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class WHERE class_code like ? ORDER BY term_id asc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("trainer")) {
                if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class WHERE class_code like ? ORDER BY trainer_id asc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class WHERE class_code like ? ORDER BY trainer_id desc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("status")) {
                if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class WHERE class_code like ? ORDER BY status asc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class WHERE class_code like ? ORDER BY status desc  LIMIT 5 OFFSET ?";
                }
            }

        } else {
            sql = "SELECT * FROM class WHERE class_code like ? LIMIT 5 OFFSET ?";
        }
        List<Class> result = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            //st.setString(1, searchBy);
            st.setString(1, "%" + searchValue + "%");
            st.setInt(2, page * 5 - 5);
            ResultSet rs = st.executeQuery();
            settingDAO c = new settingDAO();
            while (rs.next()) {
                Class x = new Class(rs.getInt(1), rs.getString(2), rs.getInt(3), getUserById(rs.getInt(4)), c.getSettingById(rs.getInt(5)), rs.getString(6), rs.getString(7));
                result.add(x);
            }
        } catch (SQLException ex) {
        }
        return result;
    }

    public List<Class> getClassFilterByStatus(int page, String searchBy, String searchValue, String sortBy, String sortType, String filter) {
        String sql = "";
        List<Class> result = new ArrayList<>();
        if (searchValue != null && !searchValue.equals("")) {
            if (sortBy != null && !sortBy.equals("")) {
                if (sortBy.equals("code")) {
                    if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and status = ? ORDER BY class_code desc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and status = ? ORDER BY class_code asc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("term")) {
                    if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and status = ? ORDER BY term_id desc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and status = ? ORDER BY term_id asc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("trainer")) {
                    if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and status = ? ORDER BY trainer_id asc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and status = ? ORDER BY trainer_id desc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("status")) {
                    if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and status = ? ORDER BY status asc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and status = ? ORDER BY status desc  LIMIT 5 OFFSET ?";
                    }
                }

            } else {
                sql = "SELECT * FROM class WHERE class_code like ? and status = ? LIMIT 5 OFFSET ?";
            }
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, "%" + searchValue + "%");
                st.setString(2, filter);
                st.setInt(3, page * 5 - 5);
                ResultSet rs = st.executeQuery();
                settingDAO c = new settingDAO();
                while (rs.next()) {
                    Class x = new Class(rs.getInt(1), rs.getString(2), rs.getInt(3), getUserById(rs.getInt(4)), c.getSettingById(rs.getInt(5)), rs.getString(6), rs.getString(7));
                    result.add(x);
                }
            } catch (SQLException ex) {
            }

        } else {
            if (sortBy != null && !sortBy.equals("")) {
                if (sortBy.equals("code")) {
                    if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE  status = ? ORDER BY class_code desc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE  status = ? ORDER BY class_code asc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("term")) {
                    if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE  status = ? ORDER BY term_id desc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE  status = ? ORDER BY term_id asc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("trainer")) {
                    if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE  status = ? ORDER BY trainer_id asc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE  status = ? ORDER BY trainer_id desc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("status")) {
                    if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE  status = ? ORDER BY status asc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE  status = ? ORDER BY status desc  LIMIT 5 OFFSET ?";
                    }
                }

            } else {
                sql = "SELECT * FROM class WHERE status=? LIMIT 5 OFFSET ?";
            }
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, filter);
                st.setInt(2, page * 5 - 5);
                ResultSet rs = st.executeQuery();
                settingDAO c = new settingDAO();
                while (rs.next()) {
                    Class x = new Class(rs.getInt(1), rs.getString(2), rs.getInt(3), getUserById(rs.getInt(4)), c.getSettingById(rs.getInt(5)), rs.getString(6), rs.getString(7));
                    result.add(x);
                }
            } catch (SQLException ex) {
            }
        }
        return result;
    }

    public List<Class> getClassFilterByTrainer(int page, String searchBy, String searchValue, String sortBy, String sortType, int filter) {
        String sql = "";
        List<Class> result = new ArrayList<>();
        if (searchValue != null && !searchValue.equals("")) {
            if (sortBy != null && !sortBy.equals("")) {
                if (sortBy.equals("code")) {
                    if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and trainer_id = ? ORDER BY class_code desc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and trainer_id = ? ORDER BY class_code asc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("term")) {
                    if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and trainer_id = ? ORDER BY term_id desc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and trainer_id = ? ORDER BY term_id asc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("trainer")) {
                    if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and trainer_id = ? ORDER BY trainer_id asc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and trainer_id = ? ORDER BY trainer_id desc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("status")) {
                    if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and trainer_id = ? ORDER BY status asc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and trainer_id = ? ORDER BY status desc  LIMIT 5 OFFSET ?";
                    }
                }

            } else {
                sql = "SELECT * FROM class WHERE class_code like ? and trainer_id = ? LIMIT 5 OFFSET ?";
            }
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, "%" + searchValue + "%");
                st.setInt(2, filter);
                st.setInt(3, page * 5 - 5);
                ResultSet rs = st.executeQuery();
                settingDAO c = new settingDAO();
                while (rs.next()) {
                    Class x = new Class(rs.getInt(1), rs.getString(2), rs.getInt(3), getUserById(rs.getInt(4)), c.getSettingById(rs.getInt(5)), rs.getString(6), rs.getString(7));
                    result.add(x);
                }
            } catch (SQLException ex) {
            }

        } else {
            if (sortBy != null && !sortBy.equals("")) {
                if (sortBy.equals("code")) {
                    if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE  trainer_id = ? ORDER BY class_code desc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE  trainer_id = ? ORDER BY class_code asc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("term")) {
                    if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE  trainer_id = ? ORDER BY term_id desc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE  trainer_id = ? ORDER BY term_id asc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("trainer")) {
                    if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE  trainer_id = ? ORDER BY trainer_id asc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE  trainer_id = ? ORDER BY trainer_id desc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("status")) {
                    if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE  trainer_id = ? ORDER BY status asc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE  trainer_id = ? ORDER BY status desc  LIMIT 5 OFFSET ?";
                    }
                }

            } else {
                sql = "SELECT * FROM class WHERE trainer_id=? LIMIT 5 OFFSET ?";
            }
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, filter);
                st.setInt(2, page * 5 - 5);
                ResultSet rs = st.executeQuery();
                settingDAO c = new settingDAO();
                while (rs.next()) {
                    Class x = new Class(rs.getInt(1), rs.getString(2), rs.getInt(3), getUserById(rs.getInt(4)), c.getSettingById(rs.getInt(5)), rs.getString(6), rs.getString(7));
                    result.add(x);
                }
            } catch (SQLException ex) {
            }
        }
        return result;
    }

    public List<Class> getClassFilterByTerm(int page, String searchBy, String searchValue, String sortBy, String sortType, int filter) {
        String sql = "";
        List<Class> result = new ArrayList<>();
        if (searchValue != null && !searchValue.equals("")) {
            if (sortBy != null && !sortBy.equals("")) {
                if (sortBy.equals("code")) {
                    if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and term_id = ? ORDER BY class_code desc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and term_id = ? ORDER BY class_code asc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("term")) {
                    if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and term_id = ? ORDER BY term_id desc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and term_id = ? ORDER BY term_id asc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("trainer")) {
                    if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and term_id = ? ORDER BY trainer_id asc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and term_id = ? ORDER BY trainer_id desc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("status")) {
                    if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and term_id = ? ORDER BY status asc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE class_code like ? and term_id = ? ORDER BY status desc  LIMIT 5 OFFSET ?";
                    }
                }

            } else {
                sql = "SELECT * FROM class WHERE class_code like ? and term_id = ? LIMIT 5 OFFSET ?";
            }
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, "%" + searchValue + "%");
                st.setInt(2, filter);
                st.setInt(3, page * 5 - 5);
                ResultSet rs = st.executeQuery();
                settingDAO c = new settingDAO();
                while (rs.next()) {
                    Class x = new Class(rs.getInt(1), rs.getString(2), rs.getInt(3), getUserById(rs.getInt(4)), c.getSettingById(rs.getInt(5)), rs.getString(6), rs.getString(7));
                    result.add(x);
                }
            } catch (SQLException ex) {
            }

        } else {
            if (sortBy != null && !sortBy.equals("")) {
                if (sortBy.equals("code")) {
                    if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE  term_id = ? ORDER BY class_code desc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE  term_id = ? ORDER BY class_code asc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("term")) {
                    if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE  term_id = ? ORDER BY term_id desc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE  term_id = ? ORDER BY term_id asc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("trainer")) {
                    if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE  term_id = ? ORDER BY trainer_id asc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE  term_id = ? ORDER BY trainer_id desc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("status")) {
                    if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class WHERE  term_id = ? ORDER BY status asc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class WHERE  term_id = ? ORDER BY status desc  LIMIT 5 OFFSET ?";
                    }
                }

            } else {
                sql = "SELECT * FROM class WHERE term_id = ? LIMIT 5 OFFSET ?";
            }
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, filter);
                st.setInt(2, page * 5 - 5);
                ResultSet rs = st.executeQuery();
                settingDAO c = new settingDAO();
                while (rs.next()) {
                    Class x = new Class(rs.getInt(1), rs.getString(2), rs.getInt(3), getUserById(rs.getInt(4)), c.getSettingById(rs.getInt(5)), rs.getString(6), rs.getString(7));
                    result.add(x);
                }
            } catch (SQLException ex) {
            }
        }
        return result;
    }

    public int count() {
        int count = 0;
        String sql = "select count(*) as numberRecord from class";
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

    public int countSearch(String searchBy, String value) {
        int count = 0;
        String sql = "select count(*) as numberRecord from class where class_code like ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + value + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
        }
        double result = (double) count / 5;
        return (int) Math.ceil(result);
    }

    public int countFilterTrainer(int value, String searchBy, String searchValue, int filter) {
        int count = 0;
        String sql = "";
        if (searchBy != null && !searchBy.equals("")) {
            sql = "select count(*) as numberRecord from class where class_code like ? and trainer_id=? ";
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, "%" + searchValue + "%");
                st.setInt(2, filter);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    count = rs.getInt(1);
                }
            } catch (SQLException ex) {
            }
            double result = (double) count / 5;
            return (int) Math.ceil(result);
        } else {
            sql = "select count(*) as numberRecord from class where trainer_id=?";
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, filter);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    count = rs.getInt(1);
                }
            } catch (SQLException ex) {
            }
            double result = (double) count / 5;
            return (int) Math.ceil(result);
        }
    }
    
    public int countFilterTerm(int value, String searchBy, String searchValue, int filter) {
        int count = 0;
        String sql = "";
        if (searchBy != null && !searchBy.equals("")) {
            sql = "select count(*) as numberRecord from class where class_code like ? and term_id=? ";
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, "%" + searchValue + "%");
                st.setInt(2, filter);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    count = rs.getInt(1);
                }
            } catch (SQLException ex) {
            }
            double result = (double) count / 5;
            return (int) Math.ceil(result);
        } else {
            sql = "select count(*) as numberRecord from class where term_id=?";
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, filter);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    count = rs.getInt(1);
                }
            } catch (SQLException ex) {
            }
            double result = (double) count / 5;
            return (int) Math.ceil(result);
        }
    }
    
    public int countFilterStatus(int value, String searchBy, String searchValue, String filter) {
        int count = 0;
        String sql = "";
        if (searchBy != null && !searchBy.equals("")) {
            sql = "select count(*) as numberRecord from class where class_code like ? and status=? ";
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, "%" + searchValue + "%");
                st.setString(2, filter);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    count = rs.getInt(1);
                }
            } catch (SQLException ex) {
            }
            double result = (double) count / 5;
            return (int) Math.ceil(result);
        } else {
            sql = "select count(*) as numberRecord from class where status=?";
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, filter);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    count = rs.getInt(1);
                }
            } catch (SQLException ex) {
            }
            double result = (double) count / 5;
            return (int) Math.ceil(result);
        }
    }
    
    public void updateStatus(int id, String status){
        String sql="update class set status=? where class_id=? ";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, status);
            st.setInt(2, id);
            st.executeUpdate();
        }catch(SQLException ex){            
        }
    }
    
    public void updateClass(String classCode, int trainerId, int termId, String status, String description, int id){
        String sql="update class set class_code=?, trainer_id=?, term_id=?, status=?, description=? where class_id=? ";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, classCode);
            st.setInt(2, trainerId);
            st.setInt(3, termId);
            st.setString(4, status);
            st.setString(5, description);
            st.setInt(6, id);
            st.executeUpdate();
        }catch(SQLException ex){            
        }
    }        
    
    public List<Class> getAllClass() {
        List<Class> list = new ArrayList<>();
        String sql = "select * from class where class_code not like ''";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            settingDAO c = new settingDAO();
            while (rs.next()) {
                Class x = new Class(rs.getInt(1), rs.getString(2), rs.getInt(3), getUserById(rs.getInt(4)), c.getSettingById(rs.getInt(5)), rs.getString(6), rs.getString(7));
                list.add(x);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    public List<Class> getClassByTrainerId(int id) {
        List<Class> result = new ArrayList<>();
        String sql = "select * from class where trainer_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            settingDAO c = new settingDAO();
            while (rs.next()) {
                Class x = new Class(rs.getInt(1), rs.getString(2), rs.getInt(3), getUserById(rs.getInt(4)), c.getSettingById(rs.getInt(5)), rs.getString(6), rs.getString(7));
                result.add(x);
            }
        } catch (SQLException e) {
        }
        return result;
    }
}
