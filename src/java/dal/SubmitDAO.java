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
import model.Milestone;
import model.Team;

/**
 *
 * @author Admin
 */
public class SubmitDAO extends DBContextMySQL {

    public List<Milestone> getMilestoneSubmit() {
        List<Milestone> listMilestone = new ArrayList<>();
        String sql = "select distinct milestone_id_su_fk from submit";
        milestoneDAO mileDAO = new milestoneDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Milestone m = mileDAO.getMilestoneById(rs.getInt(1));
                listMilestone.add(m);
            }
        } catch (SQLException ex) {
        }
        return listMilestone;
    }

    public List<Team> getTeamByMilesStoneId(int Id) {
        List<Team> listTeam = new ArrayList<>();
        String sql = "select * from submit where milestone_id_su_fk =?";
        TeamDAO teamDAO = new TeamDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, Id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Team t = teamDAO.getTeamById(rs.getInt(4));
                listTeam.add(t);
            }
        } catch (SQLException ex) {
        }
        return listTeam;
    }

    public void insertTeamAndMilestone(List<Team> listTeam, int milesoneId) {

        String sql = "INSERT INTO `swp391`.`submit`\n"
                + "(\n"
                + "`milestone_id_su_fk`,\n"
                + "`class_id_su_fk`,\n"
                + "`team_id_su_fk`,\n"
                + "`status`)\n"
                + "VALUES\n"
                + "(?,?,?,?);";
        for (int i = 0; i < listTeam.size(); i++) {
            try {
              PreparedStatement  st = connection.prepareStatement(sql);
                st.setInt(1, milesoneId);
                st.setInt(2, listTeam.get(i).getClassId().getClass_id());
                st.setInt(3, listTeam.get(i).getTeamId());
                st.setInt(4, 1);
                st.executeUpdate();
            } catch (SQLException ex) {
            }
        }
    }

    public List<Team> getAllTeamByClassIdAndMilestone(int milestoneId, int classId) {
        String sql = "SELECT * FROM swp391.submit where milestone_id_su_fk = ? and class_id_su_fk = ?";
        List<Team> listTeam = new ArrayList<>();
        TeamDAO teamDAO = new TeamDAO();
        try {
            PreparedStatement  st = connection.prepareStatement(sql);
            st.setInt(1, milestoneId);
            st.setInt(2, classId);
          ResultSet   rs = st.executeQuery();
            while (rs.next()) {
                Team t = teamDAO.getTeamById(rs.getInt(4));               
                listTeam.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listTeam;
    }
    
}
