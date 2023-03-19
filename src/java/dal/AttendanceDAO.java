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
import model.Attendance;

/**
 *
 * @author User
 */
public class AttendanceDAO extends DBContextMySQL {

    public List<Attendance> getByClassAndSchedule(int class_id, int schedule_id) {
        String sql = "select * from attendance where class_id_att=? and schedule_id_att=?";
        List<Attendance> result = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, class_id);
            st.setInt(2, schedule_id);
            ResultSet rs = st.executeQuery();
            ClassDAO cd = new ClassDAO();
            scheduleDAO sd = new scheduleDAO();
            while (rs.next()) {
                Attendance x = new Attendance(cd.getClassById(rs.getInt(1)), cd.getUserById(rs.getInt(2)), sd.getScheduleById(rs.getInt(3)), rs.getString(4), rs.getString(5));
                result.add(x);
            }
        } catch (SQLException e) {
        }
        return result;
    }

    public Attendance getByKey(int class_id, int schedule_id, int trainee_id) {
        String sql = "select * from attendance where class_id_att=? and schedule_id_att=? and trainee_id_att=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, class_id);
            st.setInt(2, schedule_id);
            st.setInt(3, trainee_id);
            ResultSet rs = st.executeQuery();
            ClassDAO cd = new ClassDAO();
            scheduleDAO sd = new scheduleDAO();
            while (rs.next()) {
                Attendance x = new Attendance(cd.getClassById(rs.getInt(1)), cd.getUserById(rs.getInt(2)), sd.getScheduleById(rs.getInt(3)), rs.getString(4), rs.getString(5));
                return x;
            }
        } catch (SQLException e) {
        }
        return null;
    }
    
    public void updateAttendance(Attendance x){
        String sql= "update attendance set status=?, comment=? where class_id_att=? and schedule_id_att=? and trainee_id_att=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,x.getStatus());
            st.setString(2, x.getComment());
            st.setInt(3, x.getClass_id().getClass_id());
            st.setInt(4,x.getSchedule_id().getSchedule_id());
            st.setInt(5, x.getTrainee_id().getId());
            st.executeUpdate();
        } catch (SQLException e){
            
        }
    }
    
    public void createAttendance(Attendance x){
        String sql= "insert into attendance (class_id_att,schedule_id_att,trainee_id_att,status,comment) value (?,?,?,?,?)";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,x.getClass_id().getClass_id());
            st.setInt(2, x.getSchedule_id().getSchedule_id());
            st.setInt(3, x.getTrainee_id().getId());
            st.setString(4, x.getStatus());
            st.setString(5, x.getComment());
            st.executeUpdate();
        } catch (SQLException e){            
        }
    }

}
