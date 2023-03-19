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
import model.ClassUser;
import model.Team;
import model.User;

/**
 *
 * @author Admin
 */
public class NewTeamsDAO extends DBContextMySQL {

    public List<ClassUser> getAllClassUserByClassId(int id) {
        List<ClassUser> listClassUser = new ArrayList<>();
        String sql = "SELECT * FROM swp391.class_user where class_user_id_fk = ?";
        userDAO userDAO = new userDAO();
        ClassDAO classDAO = new ClassDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                model.Class c = classDAO.getClassById(rs.getInt(1));
                User u = userDAO.getUserById(rs.getInt(2));
                ClassUser cu = new ClassUser(c, u, rs.getInt(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
                listClassUser.add(cu);
            }
        } catch (SQLException ex) {
        }
        return listClassUser;
    }

   
    
   
}
