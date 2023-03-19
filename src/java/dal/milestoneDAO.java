package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Milestone;

public class milestoneDAO extends DBContextMySQL {


    public Milestone updateMilestone(int milestone_id, Date from_date, Date to_date, String title, String ass_body, String description, int status) {
        String strUpdate = "UPDATE swp391.milestone \n"
                + "SET from_date = ?,\n"
                + "to_date = ?,\n"
                + "tittle = ?,\n"
                + "ass_body = ?,\n"
                + "description = ?,\n"
                + "status = ?\n"
                + "where (milestone_id = ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(strUpdate);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ps.setInt(7, milestone_id);
            ps.setDate(1, java.sql.Date.valueOf(dateFormat.format(from_date)));
            ps.setDate(2, java.sql.Date.valueOf(dateFormat.format(to_date)));
            ps.setString(3, title);
            ps.setString(4, ass_body);
            ps.setString(5, description);
            ps.setInt(6, status);
            ps.executeUpdate();
            System.out.println("Update success!");
            Milestone m = getMilestoneById(milestone_id);
            return new Milestone(milestone_id, m.getAssId(), m.getAssId(), from_date, to_date, title, ass_body, description, title);
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
        return null;
    }

    public void newMilestone(int assId,int classId, Date from_date, Date to_date, String title, String ass_body, String description, int status) {
        String strUpdate = "INSERT INTO swp391.milestone (ass_id_mil, class_id_mil, from_date, to_date, tittle, ass_body, description, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement ps = connection.prepareStatement(strUpdate);
            ps.setInt(1, assId);
            ps.setInt(2, classId);
            ps.setDate(3, java.sql.Date.valueOf(dateFormat.format(from_date)));
            ps.setDate(4, java.sql.Date.valueOf(dateFormat.format(to_date)));
            ps.setString(5, title);
            ps.setString(6, ass_body);
            ps.setString(7, description);
            ps.setInt(8, status);
            ps.executeUpdate();
            System.out.println("Update success!");
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
    }
    
    public Milestone getMilestoneById(int id) {
        String sql = "select * from milestone where milestone_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String status = "";
                if (rs.getInt(9)==0) {
                    status = "Pending";
                } 
                if (rs.getInt(9)==1) {
                    status = "In progress";
                } 
                if (rs.getInt(9)==2) {
                    status = "Closed";
                }
                Milestone mile = new Milestone(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDate(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        status);
                return mile;
            }
        } catch (SQLException ex) {
             System.out.println("error:" + ex.getMessage());
        }
        return null;
    }
    
    public List<Milestone> getSettingWithPagging(int page, int pageSzie) {
        List<Milestone> listMilestone = new ArrayList<Milestone>();
        String sql = "select * from swp391.milestone limit ? offset ?";
        assignmentDAO ass = new assignmentDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageSzie);
            st.setInt(2, (page - 1) * pageSzie);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String status = "";
                if (rs.getInt(9)==0) {
                    status = "Pending";
                } 
                if (rs.getInt(9)==1) {
                    status = "In progress";
                } 
                if (rs.getInt(9)==2) {
                    status = "Closed";
                }
                Milestone mile = new Milestone(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDate(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        status);
                listMilestone.add(mile);
            }
        } catch (SQLException ex) {
        }
        return listMilestone;
    }

    public List<Milestone> getAll() {
        List<Milestone> listMilestone = new ArrayList<Milestone>();
        String sql = "select * from swp391.milestone";
        assignmentDAO ass = new assignmentDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String status = "";
                if (rs.getInt(9)==0) {
                    status = "Pending";
                } 
                if (rs.getInt(9)==1) {
                    status = "In progress";
                } 
                if (rs.getInt(9)==2) {
                    status = "Closed";
                }
                Milestone mile = new Milestone(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDate(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        status);
                listMilestone.add(mile);
            }
        } catch (SQLException ex) {
        }
        return listMilestone;
    }
    
    public int getTotalMilestone() {
        String sql = "select * from swp391.milestone;";
        int count = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                count++;
            }
            return count;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return count;
    }

    public List<Milestone> getSettingWithPaggingSort(int page, int pageSzie, String type) {
        List<Milestone> listMilestone = new ArrayList<Milestone>();
        String sql = "select * from milestone order by " + type + " limit ? offset ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageSzie);
            st.setInt(2, (page - 1) * pageSzie);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String status = "";
                if (rs.getInt(9)==0) {
                    status = "Pending";
                } 
                if (rs.getInt(9)==1) {
                    status = "In progress";
                } 
                if (rs.getInt(9)==2) {
                    status = "Closed";
                }
                Milestone mile = new Milestone(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDate(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        status);
                listMilestone.add(mile);
            }
        } catch (SQLException ex) {

        }
        return listMilestone;
    }

    public static void main(String[] args) {
        milestoneDAO m = new milestoneDAO();
        List<Milestone> list = new ArrayList<>();
        Date date1, date2;
        try {
                     date1=new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01");  
                date2=new SimpleDateFormat("yyyy-MM-dd").parse("2022-10-13"); 
                m.updateMilestone(4, date1, date2, "hihi", " ", " ", 0);
                System.out.println(date2);
        } catch (Exception e) {
        }
        
        
    }
}
