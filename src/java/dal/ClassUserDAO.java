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
import model.Class;

/**
 *
 * @author User
 */
public class ClassUserDAO extends DBContextMySQL{
    public List<ClassUser> getClassUserByClassId(int id){
        List<ClassUser> result= new ArrayList<>();
        String sql = "select * from class_user where class_user_id_fk=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            settingDAO c = new settingDAO();
            ClassDAO cd= new ClassDAO();
            userDAO ud= new userDAO();
            while (rs.next()) {
                ClassUser x= new ClassUser(cd.getClassById(rs.getInt(1)),cd.getUserById(rs.getInt(2)), rs.getInt(3),rs.getDate(4), rs.getString(5),rs.getString(6), rs.getString(7));
                result.add(x);
            }
        } catch (SQLException e) {
        }
        return result;
    }
    
    public List<Class> getClassByTraineeId(int id){
        List<Class> result= new ArrayList<>();
        String sql="select * from class_user where user_user_id_fk=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            ClassDAO cd= new ClassDAO();
            while(rs.next()){
                Class x= cd.getClassById(rs.getInt(1));
                result.add(x);
            }
        }catch(SQLException e){            
        }
        return result;                
    }
    
    public static void main(String[] args){
        ClassUserDAO cd = new ClassUserDAO();
        List<Class> x= cd.getClassByTraineeId(293);
        for (int i=0; i<x.size(); i++){
            System.out.println(x.get(i).getClass_code());
        }
    }
}
