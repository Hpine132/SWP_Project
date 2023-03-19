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
import model.Assignment;
import model.Setting;
import model.Subject;

/**
 *
 * @author Admin
 */
public class assignmentDAO extends DBContextMySQL {

    public List<Assignment> getSettingWithPagging(int page, int pageSzie) {
        List<Assignment> listAssignment = new ArrayList<>();
        String sql = "select * from assignment limit ? offset ?";
        SubjectDAO subjectDAO = new SubjectDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageSzie);
            st.setInt(2, (page - 1) * pageSzie);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Subject s = subjectDAO.getSubjectByIdForAssList(rs.getInt(2));
                Assignment a = new Assignment(rs.getInt(1), s, rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                listAssignment.add(a);
            }
        } catch (SQLException ex) {
        }
        return listAssignment;
    }

    public List<Assignment> getSettingWithPaggingSort(int page, int pageSzie, String type) {
        List<Assignment> listAssignment = new ArrayList<>();
        SubjectDAO subjectDAO = new SubjectDAO();
        String sql = "select * from assignment order by " + type + " limit ? offset ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageSzie);
            st.setInt(2, (page - 1) * pageSzie);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Subject s = subjectDAO.getSubjectByIdForAssList(rs.getInt(2));
                Assignment a = new Assignment(rs.getInt(1), s, rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                listAssignment.add(a);
            }
        } catch (SQLException ex) {

        }
        return listAssignment;
    }

    public int getTotalAssignment() {
        List<Assignment> listAssignment = new ArrayList<>();
        String sql = "select * from Assignment ";
        SubjectDAO subjectDAO = new SubjectDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Subject s = subjectDAO.getSubjectByIdForAssList(rs.getInt(2));
                Assignment a = new Assignment(rs.getInt(1), s, rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                listAssignment.add(a);
            }
        } catch (SQLException ex) {

        }
        return listAssignment.size();
    }

    public List<Assignment> getAllAssignment() {
        List<Assignment> listAssignment = new ArrayList<>();
        String sql = "select * from Assignment ";
        SubjectDAO subjectDAO = new SubjectDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Subject s = subjectDAO.getSubjectByIdForAssList(rs.getInt(2));
                Assignment a = new Assignment(rs.getInt(1), s, rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                listAssignment.add(a);
            }
        } catch (SQLException ex) {

        }
        return listAssignment;
    }

    public List<Assignment> getAssignmentListByTittle(int page, int pageSzie, String tittle) {
        List<Assignment> listAssignment = new ArrayList<>();
        String sql = "select * from assignment where tittle like ? limit ? offset ?";
        SubjectDAO subjectDAO = new SubjectDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + tittle + "%");
            st.setInt(2, pageSzie);
            st.setInt(3, (page - 1) * pageSzie);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Subject s = subjectDAO.getSubjectByIdForAssList(rs.getInt(2));
                Assignment a = new Assignment(rs.getInt(1), s, rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                listAssignment.add(a);
            }
        } catch (SQLException ex) {

        }
        return listAssignment;
    }

    public int getTotalAssignmentListByTittle(String tittle) {
        String sql = "select * from assignment where tittle like ?";
        int a = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + tittle + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                a++;
            }
        } catch (SQLException ex) {

        }
        return a;
    }

    public List<Assignment> getAssignmentListByTittleSort(int page, int pageSzie, String tittle, String type) {
        List<Assignment> listAssignment = new ArrayList<>();
        SubjectDAO subjectDAO = new SubjectDAO();
        String sql = "select * from assignment where tittle like ? order by " + type + " limit ? offset ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + tittle + "%");
            st.setInt(2, pageSzie);
            st.setInt(3, (page - 1) * pageSzie);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Subject s = subjectDAO.getSubjectByIdForAssList(rs.getInt(2));
                Assignment a = new Assignment(rs.getInt(1), s, rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                listAssignment.add(a);
            }
        } catch (SQLException ex) {

        }
        return listAssignment;
    }

    public Assignment getAssignmentById(int id) {
        String sql = "select * from assignment where ass_id = ?";
        SubjectDAO subjectDAO = new SubjectDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Subject s = subjectDAO.getSubjectByIdForAssList(rs.getInt(2));
                Assignment a = new Assignment(rs.getInt(1), s, rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                return a;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public List<Assignment> getAssignmentBySubId(int id) {
        List<Assignment> listAssignment = new ArrayList<>();
        String sql = "select * from assignment where subject_id_ass = ?";
        SubjectDAO subjectDAO = new SubjectDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Subject s = subjectDAO.getSubjectByIdForAssList(rs.getInt(2));
                Assignment a = new Assignment(rs.getInt(1), s, rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                listAssignment.add(a);
            }
            return listAssignment;
        } catch (SQLException ex) {
        }
        return null;
    }

    public void updateAssignment(int id, String tittle, String assbody, double evalweight, int status, int teamwork, int ongoing) {
        String sql = "UPDATE assignment\n"
                + "SET tittle = ? , `ass_body` =  ? , `eval_weight` =  ?, status = ?,`is_team_work` = ?,`is_ongoing` = ? \n"
                + " WHERE `ass_id` = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tittle);
            st.setString(2, assbody);
            st.setDouble(3, evalweight);
            st.setInt(4, status);
            st.setInt(5, teamwork);
            st.setInt(6, ongoing);
            st.setInt(7, id);
            st.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public void updateSetting(int id_raw, int i) {

        String sql = "UPDATE assignment\n"
                + "SET status = ? \n"
                + "WHERE ass_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, i);
            st.setInt(2, id_raw);
            st.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public List<Assignment> getAssignmentWithFilter(int subjectId, int status) {
        List<Assignment> listAssignment = new ArrayList<>();
        SubjectDAO subjectDAO = new SubjectDAO();

        if (subjectId != -1 && status != -1) {
            String sql = "select * from assignment where subject_id_ass = ? and status = ?";
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, subjectId);
                st.setInt(2, status);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    Subject s = subjectDAO.getSubjectByIdForAssList(rs.getInt(2));
                    Assignment a = new Assignment(rs.getInt(1), s, rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                    listAssignment.add(a);
                }
            } catch (SQLException ex) {

            }
        }
        if (subjectId == -1 && status != -1) {
            String sql = "select * from assignment where status = ? ";
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, status);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    Subject s = subjectDAO.getSubjectByIdForAssList(rs.getInt(2));
                    Assignment a = new Assignment(rs.getInt(1), s, rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                    listAssignment.add(a);
                }
            } catch (SQLException ex) {

            }
        }
        if (subjectId != -1 && status == -1) {
            String sql = "select * from assignment where subject_id_ass = ? ";
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, subjectId);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    Subject s = subjectDAO.getSubjectByIdForAssList(rs.getInt(2));
                    Assignment a = new Assignment(rs.getInt(1), s, rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                    listAssignment.add(a);
                }
            } catch (SQLException ex) {

            }
        }
        return listAssignment;
    }

    public void InsertAssignment(int subjectId, String tittle,String assBody,double eval,int teamWork,int ongoing,int status) {

        String sql = "INSERT INTO `swp391`.`assignment`\n"
                + "(`subject_id_ass`,\n"
                + "`tittle`,\n"
                + "`ass_body`,\n"
                + "`eval_weight`,\n"
                + "`is_team_work`,\n"
                + "`is_ongoing`,\n"
                + "`status`)\n"
                + "VALUES\n"
                + "(?,?,?,?,?,?,?);";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, subjectId);
            st.setString(2, tittle);
            st.setString(3, assBody);
            st.setDouble(4, eval);
            st.setInt(5, teamWork);
            st.setInt(6, ongoing);
            st.setInt(7, status);
            st.executeUpdate();
        } catch (SQLException ex) {

        }
    }

}
