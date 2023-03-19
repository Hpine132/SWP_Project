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
import model.EvalCriteria;
import model.Milestone;

/**
 *
 * @author Admin
 */
public class evalCriteriaDAO extends DBContextMySQL {

    public List<EvalCriteria> getEvalCriteriaWithPagging(int page, int pageSzie) {
        List<EvalCriteria> listEvalCriteria = new ArrayList<>();
        assignmentDAO assignmentDAO = new assignmentDAO();
        milestoneDAO milesstoneDAO = new milestoneDAO();
        String sql = "select * from eval_criteria limit ? offset ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageSzie);
            st.setInt(2, (page - 1) * pageSzie);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Assignment a = assignmentDAO.getAssignmentById(rs.getInt(2));
                Milestone m = milesstoneDAO.getMilestoneById(rs.getInt(3));
                EvalCriteria e = new EvalCriteria(rs.getInt(1), a, m, rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
                listEvalCriteria.add(e);
            }
        } catch (SQLException ex) {
        }
        return listEvalCriteria;
    }

    public int getTotalEvalCriteria() {
        List<EvalCriteria> listEvalCriteria = new ArrayList<>();
        assignmentDAO assignmentDAO = new assignmentDAO();
        milestoneDAO milesstoneDAO = new milestoneDAO();
        String sql = "select * from eval_criteria ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Assignment a = assignmentDAO.getAssignmentById(rs.getInt(2));
                Milestone m = milesstoneDAO.getMilestoneById(rs.getInt(3));
                EvalCriteria e = new EvalCriteria(rs.getInt(1), a, m, rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
                listEvalCriteria.add(e);
            }
        } catch (SQLException ex) {

        }
        return listEvalCriteria.size();
    }

    public List<EvalCriteria> getSettingWithPaggingSort(int page, int pageSzie, String type) {
        List<EvalCriteria> listEvalCriteria = new ArrayList<>();
        assignmentDAO assignmentDAO = new assignmentDAO();
        milestoneDAO milesstoneDAO = new milestoneDAO();
        String sql = "select * from eval_criteria order by " + type + " limit ? offset ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageSzie);
            st.setInt(2, (page - 1) * pageSzie);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Assignment a = assignmentDAO.getAssignmentById(rs.getInt(2));
                Milestone m = milesstoneDAO.getMilestoneById(rs.getInt(3));
                EvalCriteria e = new EvalCriteria(rs.getInt(1), a, m, rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
                listEvalCriteria.add(e);
            }
        } catch (SQLException ex) {

        }
        return listEvalCriteria;
    }

    public int getTotalEvalCriteriaListByCriteriaName(String CriteriaName) {
        String sql = "select * from eval_criteria where criteria_name like ?";
        int a = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + CriteriaName + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                a++;
            }
        } catch (SQLException ex) {

        }
        return a;
    }

    public List<EvalCriteria> getEvalCriteriaListByNameSort(int page, int pageSzie, String tittle, String type) {
        List<EvalCriteria> listEvalCriteria = new ArrayList<>();
        assignmentDAO assignmentDAO = new assignmentDAO();
        milestoneDAO milesstoneDAO = new milestoneDAO();
        String sql = "select * from eval_criteria where criteria_name like ? order by " + type + " limit ? offset ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + tittle + "%");
            st.setInt(2, pageSzie);
            st.setInt(3, (page - 1) * pageSzie);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Assignment a = assignmentDAO.getAssignmentById(rs.getInt(2));
                Milestone m = milesstoneDAO.getMilestoneById(rs.getInt(3));
                EvalCriteria e = new EvalCriteria(rs.getInt(1), a, m, rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
                listEvalCriteria.add(e);
            }
        } catch (SQLException ex) {

        }
        return listEvalCriteria;
    }

    public List<EvalCriteria> getEvalCriteriaListByName(int page, int pageSzie, String tittle) {
        List<EvalCriteria> listEvalCriteria = new ArrayList<>();
        assignmentDAO assignmentDAO = new assignmentDAO();
        milestoneDAO milesstoneDAO = new milestoneDAO();
        String sql = "select * from eval_criteria where criteria_name like ? limit ? offset ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + tittle + "%");
            st.setInt(2, pageSzie);
            st.setInt(3, (page - 1) * pageSzie);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Assignment a = assignmentDAO.getAssignmentById(rs.getInt(2));
                Milestone m = milesstoneDAO.getMilestoneById(rs.getInt(3));
                EvalCriteria e = new EvalCriteria(rs.getInt(1), a, m, rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
                listEvalCriteria.add(e);
            }
        } catch (SQLException ex) {

        }
        return listEvalCriteria;
    }

    public static void main(String[] args) {
        evalCriteriaDAO c = new evalCriteriaDAO();
        c.getEvalCriteriaListByName(1, 5, "se");
        System.out.println(c.getEvalCriteriaListByName(1, 5, "se").get(1).getAss_id().getTittle());
    }

    public List<EvalCriteria> getEvalCriteriaWithFilter(int assignmentId, int status) {
        List<EvalCriteria> listEvalCriteria = new ArrayList<>();
        assignmentDAO assignmentDAO = new assignmentDAO();
        milestoneDAO milesstoneDAO = new milestoneDAO();
        if (status != -1 && assignmentId != -1) {
            String sql = "select * from eval_criteria where `ass_id_cri` = ? and status = ? ";
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, assignmentId);
                st.setInt(2, status);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    Assignment a = assignmentDAO.getAssignmentById(rs.getInt(2));
                    Milestone m = milesstoneDAO.getMilestoneById(rs.getInt(3));
                    EvalCriteria e = new EvalCriteria(rs.getInt(1), a, m, rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
                    listEvalCriteria.add(e);
                }
            } catch (SQLException ex) {

            }
        }
        return listEvalCriteria;
    }

    public void updateSetting(int id_raw, int i) {
        String sql = "UPDATE eval_criteria\n"
                + "SET status = ? \n"
                + "WHERE criteria_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, i);
            st.setInt(2, id_raw);
            st.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public void InsertEvalcriteria(int assId, String criteriaName, int teamEval, double eval, int maxloc, int status, String desc) {

        String sql = "INSERT INTO `swp391`.`eval_criteria`\n"
                + "(`ass_id_cri`,\n"
                + "`criteria_name`,\n"
                + "`is_team_eval`,\n"
                + "`eval_weight`,\n"
                + "`max_loc`,\n"
                + "`status`,\n"
                + "`description`)\n"
                + "VALUES\n"
                + "(?,?,?,?,?,?,?);";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, assId);
            st.setString(2, criteriaName);
            st.setInt(3, teamEval);
            st.setDouble(4, eval);
            st.setInt(5, maxloc);
            st.setInt(6, status);
            st.setString(7, desc);
            st.executeUpdate();
        } catch (SQLException ex) {

        }
    }
}
