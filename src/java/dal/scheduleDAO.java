/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Schedule;

/**
 *
 * @author nguye
 */
public class scheduleDAO extends DBContextMySQL {

    public List<Schedule> getSettingWithPagging(int page, int pageSzie) {
        List<Schedule> schedule = new ArrayList<Schedule>();
        String sql = "select * from swp391.schedule limit ? offset ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageSzie);
            st.setInt(2, (page - 1) * pageSzie);
            ResultSet rs = st.executeQuery();
            scheduleDAO sa = new scheduleDAO();
            while (rs.next()) {
                Schedule s = new Schedule(rs.getInt(1),
                        rs.getDate(5),
                        rs.getTime(6),
                        rs.getTime(7),
                        rs.getInt(8),
                        sa.getClassbyId(rs.getInt(2)),
                        sa.getSlotbyId(rs.getInt(3)),
                        sa.getRoombyId(rs.getInt(4))
                );
                schedule.add(s);
            }
        } catch (SQLException ex) {
        }
        return schedule;
    }

    public List<Schedule> getSettingWithPaggingSort(int page, int pageSzie, String type) {
        List<Schedule> list = new ArrayList<Schedule>();
        String sql = "select * from swp391.schedule order by " + type + " limit ? offset ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageSzie);
            st.setInt(2, (page - 1) * pageSzie);
            ResultSet rs = st.executeQuery();
            scheduleDAO sa = new scheduleDAO();
            while (rs.next()) {
                Schedule s = new Schedule(rs.getInt(1),
                        rs.getDate(5),
                        rs.getTime(6),
                        rs.getTime(7),
                        rs.getInt(8),
                        sa.getClassbyId(rs.getInt(2)),
                        sa.getSlotbyId(rs.getInt(3)),
                        sa.getRoombyId(rs.getInt(4))
                );
                list.add(s);
            }
        } catch (SQLException ex) {

        }
        return list;
    }

    public int getTotalSchedule() {
        int count = 0;
        String sql = "select * from swp391.schedule ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                count++;
            }
            return count;
        } catch (SQLException ex) {

        }
        return count;
    }

    public void updateStatus(int id, int status) {
        String sql = "update swp391.schedule set status=? where schedule_id=? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, status);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public int getTotalScheduleListByClass(String name) {
        String sql = "SELECT * FROM swp391.schedule s \n"
                + "inner join swp391.class c on c.class_id=s.class_id_schedule \n"
                + "where c.class_code like ?";
        int count =0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                count++;
            }
        } catch (SQLException ex) {
        }

        return count;
    }

    public int[] getClassIdByCode(String code) {
        String sql1 = "select * from class where class_code like ?";
        int[] a = new int[100];
        int i = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql1);
            st.setString(1, "%" + code + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                a[i] = rs.getInt(1);
                i++;
            }
        } catch (SQLException ex) {
        }
        return a;
    }

    public List<Schedule> getScheduleListByClassSort(int page, int pageSzie, String code, String type) {
        List<Schedule> list = new ArrayList<>();
        String sql = "SELECT * FROM swp391.schedule s \n"
                + "inner join swp391.class c on c.class_id=s.class_id_schedule \n"
                + "where c.class_code like ? order by " + type + " limit ? offset ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, code);
            st.setInt(2, pageSzie);
            st.setInt(3, (page - 1) * pageSzie);
            ResultSet rs = st.executeQuery();
            scheduleDAO sa = new scheduleDAO();
            while (rs.next()) {
                Schedule s = new Schedule(rs.getInt(1),
                        rs.getDate(5),
                        rs.getTime(6),
                        rs.getTime(7),
                        rs.getInt(8),
                        sa.getClassbyId(rs.getInt(2)),
                        sa.getSlotbyId(rs.getInt(3)),
                        sa.getRoombyId(rs.getInt(4)));
                list.add(s);
            }
        } catch (SQLException ex) {
        }

        return list;
    }

    public List<Schedule> getScheduleListByClass(int page, int pageSzie, String code) {
        List<Schedule> list = new ArrayList<Schedule>();
        String sql = "SELECT * FROM swp391.schedule s \n"
                + "inner join swp391.class c on c.class_id=s.class_id_schedule \n"
                + "where c.class_code like ? limit ? offset ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, code);
            st.setInt(2, pageSzie);
            st.setInt(3, (page - 1) * pageSzie);
            ResultSet rs = st.executeQuery();
            scheduleDAO sa = new scheduleDAO();
            while (rs.next()) {
                Schedule s = new Schedule(rs.getInt(1),
                        rs.getDate(5),
                        rs.getTime(6),
                        rs.getTime(7),
                        rs.getInt(8),
                        sa.getClassbyId(rs.getInt(2)),
                        sa.getSlotbyId(rs.getInt(3)),
                        sa.getRoombyId(rs.getInt(4)));
                list.add(s);
                System.out.println("done");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return list;
    }

    public String getClassbyId(int id) {
        String a = "";
        String sql1 = "select * from class where class_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql1);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                a = rs.getString(2);
            }
        } catch (SQLException ex) {
        }
        return a;
    }

    public int getClassbySId(int id) {
        int a = 0;
        String sql1 = "select * from schedule where schedule_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql1);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                a = rs.getInt(2);
            }
        } catch (SQLException ex) {
        }
        return a;
    }

    public String getRoombyId(int id) {
        String a = "";
        String sql1 = "select * from class_setting where type_id_fk = 13 and setting_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql1);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                a = rs.getString(4);
            }
        } catch (SQLException ex) {
        }
        return a;
    }

    public String getSlotbyId(int id) {
        String a = "";
        String sql1 = "select * from class_setting where type_id_fk = 14 and setting_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql1);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                a = rs.getString(4);
            }
        } catch (SQLException ex) {
        }
        return a;
    }

    public void newSchedule(int classId, int slotId, int roomId, Date date, Time from_time, Time to_time, int status) {
        String sql = "INSERT INTO `swp391`.`schedule` ( `class_id_schedule`, `slot_id_schedule`, `room_id_schedule`, `training_date`, `from_time`, `to_time`, `status`) VALUES ( ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, classId);
            ps.setInt(2, slotId);
            ps.setInt(3, roomId);
            ps.setDate(4, date);
            ps.setTime(5, from_time);
            ps.setTime(6, to_time);
            ps.setInt(7, status);
            ps.executeUpdate();
            System.out.println("Update success!");
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
    }

    public List<Schedule> getScheduleOfClass(int id) {
        String sql = "select * from schedule where class_id_schedule=? order by training_date asc";
        List<Schedule> result = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Schedule x = new Schedule(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getTime(6), rs.getTime(7), rs.getInt(8));

                result.add(x);
            }
        } catch (SQLException e) {
        }
        return result;
    }

    public Schedule getScheduleById(int id) {
        String sql = "select * from schedule where schedule_id=? order by training_date asc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Schedule x = new Schedule(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getTime(6), rs.getTime(7), rs.getInt(8));
                return x;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public Schedule getScheduleById2(int id) {
        String sql = "select * from schedule where schedule_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            scheduleDAO sa = new scheduleDAO();
            while (rs.next()) {
                Schedule s = new Schedule(rs.getInt(1),
                        rs.getDate(5),
                        rs.getTime(6),
                        rs.getTime(7),
                        rs.getInt(8),
                        sa.getClassbyId(rs.getInt(2)),
                        sa.getSlotbyId(rs.getInt(3)),
                        sa.getRoombyId(rs.getInt(4))
                );
                return s;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void updateSchedule(int id, int classId, int slotId, int roomId, Date date, Time from_time, Time to_time, int status) {
        String strUpdate = "UPDATE swp391.schedule \n"
                + "SET class_id_schedule = ?,\n"
                + "slot_id_schedule = ?,\n"
                + "room_id_schedule = ?,\n"
                + "training_date = ?,\n"
                + "from_time = ?,\n"
                + "to_time = ?,\n"
                + "status = ?\n"
                + "where (schedule_id = ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(strUpdate);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ps.setInt(7, status);
            ps.setDate(4, java.sql.Date.valueOf(dateFormat.format(date)));
            ps.setInt(1, classId);
            ps.setInt(2, slotId);
            ps.setInt(3, roomId);
            ps.setTime(5, from_time);
            ps.setTime(6, to_time);
            ps.setInt(8, id);
            ps.executeUpdate();
            System.out.println("Update success!");
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        scheduleDAO s = new scheduleDAO();
        int a = s.getTotalScheduleListByClass("%IA%");
        System.out.println(a);
    }
}
