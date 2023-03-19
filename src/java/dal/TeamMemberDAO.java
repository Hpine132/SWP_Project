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
import java.util.List;
import model.Team;
import model.TeamMember;
import model.User;

/**
 *
 * @author Admin
 */
public class TeamMemberDAO extends DBContextMySQL {

    public List<TeamMember> getTeamMemBerByTeamId(int id) {
        String sql = "SELECT * FROM swp391.team_member where team_id_tm = ?";
        List<TeamMember> listTeamMember = new ArrayList<>();
        TeamDAO teamDAO = new TeamDAO();
        userDAO userDAO = new userDAO();
        Connection conn = connection;
        try {
           PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
           ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Team t = teamDAO.getTeamById(rs.getInt(1));
                User u = userDAO.getUserById(rs.getInt(2));
                TeamMember tm = new TeamMember(t, u, rs.getInt(3), rs.getInt(4));
                listTeamMember.add(tm);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return listTeamMember;
    }

    public void UpdateTeamInDatabase(List<TeamMember> listTeamMember) {
        String sql = "INSERT INTO `swp391`.`team_member`\n"
                + "(`team_id_tm`,\n"
                + "`user_id_tm`,\n"
                + "`is_leader`,\n"
                + "`is_active`)\n"
                + "VALUES\n"
                + "(?,?,?,?);";
        Connection conn = connection;
        for (int i = 0; i < listTeamMember.size(); i++) {
            try {
               PreparedStatement st = conn.prepareStatement(sql);
                st.setInt(1, listTeamMember.get(i).getTeamId().getTeamId());
                st.setInt(2, listTeamMember.get(i).getUserId().getId());
                st.setInt(3, listTeamMember.get(i).getIsLeadder());
                st.setInt(4, listTeamMember.get(i).getIsActive());
                st.executeUpdate();
            } catch (SQLException ex) {
            }
        }
    }
    

}
