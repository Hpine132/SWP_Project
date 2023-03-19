/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Team;
import model.User;

/**
 *
 * @author Admin
 */
public class TeamDAO extends DBContextMySQL {

    public void UpdateTeamInDatabase(List<Team> listTeam) {
        String sql = "INSERT INTO `swp391`.`team`\n"
                + "(`class_id_team`,\n"
                + "`team_code`,\n"
                + "`topic_name`,\n"
                + "`status`,\n"
                + "`description`)\n"
                + "VALUES\n"
                + "(?,?,?,?,?);";
        Connection conn = connection;
        for (int i = 0; i < listTeam.size(); i++) {
            try {
              PreparedStatement  st = conn.prepareStatement(sql);
                st.setInt(1, listTeam.get(i).getClassId().getClass_id());
                st.setString(2, listTeam.get(i).getTeamCode());
                st.setString(3, listTeam.get(i).getTopicName());
                st.setInt(4, listTeam.get(i).getStatus());
                st.setString(5, "team");
                st.executeUpdate();
            } catch (SQLException ex) {
            }
        }
    }

    public Team getTeamById(int id) {
        String sql = "SELECT * FROM swp391.team where team_id = ?";
        ClassDAO classDAO = new ClassDAO();
        try {
           PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
           ResultSet rs = st.executeQuery();
            while (rs.next()) {
                model.Class c = classDAO.getClassById(rs.getInt(2));
                Team t = new Team(rs.getInt(1), c, rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
                return t;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public List<Team> getAllTeamByClassIdAndTopicName(int id, String name) {
        String sql = "SELECT * FROM swp391.team where class_id_team = ? and topic_name = ?";
        List<Team> listTeam = new ArrayList<>();
        ClassDAO classDAO = new ClassDAO();
        Connection conn = connection;
        try {
            PreparedStatement  st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, name);
          ResultSet   rs = st.executeQuery();
            while (rs.next()) {
                model.Class c = classDAO.getClassById(rs.getInt(2));
                Team t = new Team(rs.getInt(1), c, rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
                listTeam.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listTeam;
    }

    public void DeleteTeamInDatabase(List<Team> listTeam, String topic) {
        String sql = "DELETE FROM `swp391`.`team`\n"
                + "WHERE class_id_team= ? and topic_name=?";
        for (int i = 0; i < listTeam.size(); i++) {
            try {
              PreparedStatement  st = connection.prepareStatement(sql);
                st.setInt(1, listTeam.get(i).getClassId().getClass_id());
                st.setString(2, listTeam.get(i).getTeamCode());
                st.setString(3, listTeam.get(i).getTopicName());
                st.setInt(4, listTeam.get(i).getStatus());
                st.executeUpdate();
            } catch (SQLException ex) {
            }
        }
    }

    public void UpdateTeam(String TopicName, int status, String description,int id) {
        String sql = "UPDATE `swp391`.`team`\n"
                + "SET\n"
                + "`topic_name` = ?,\n"
                + "`status` = ?,\n"
                + "`description` = ?\n"
                + "WHERE `team_id` = ?;";
        Connection conn = connection;
        try {
          PreparedStatement  st = conn.prepareStatement(sql);
            st.setString(1, TopicName);
            st.setInt(2, status);
            st.setString(3, description);
            st.setInt(4, id);
            st.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public List<Team> getListTeamHaveNewId(int size) {
        String sql = "SELECT * FROM swp391.team order by team_id desc limit ?";
        List<Team> listTeam = new ArrayList<>();
        ClassDAO classDAO = new ClassDAO();
        Connection conn = connection;
        try {
            PreparedStatement  st = conn.prepareStatement(sql);
            st.setInt(1, size);
          ResultSet   rs = st.executeQuery();
            while (rs.next()) {
                model.Class c = classDAO.getClassById(rs.getInt(2));
                Team t = new Team(rs.getInt(1), c, rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
                listTeam.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        Collections.sort(listTeam);
        return listTeam;
    }
}
